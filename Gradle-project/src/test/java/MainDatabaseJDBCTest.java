import org.junit.After;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class MainDatabaseJDBCTest {

    protected Connection dbConnection;

    private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/qa_edu?serverTimezone=UTC";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "password";

    protected void createUserTableIfDoesNotExist() {
        try {
            dbConnection = getDBConnection();
            DatabaseMetaData databaseMetaData = dbConnection.getMetaData();
            ResultSet tables = databaseMetaData.getTables(null, null, "db_user",null);
            if (!tables.next()) {
                createUserTable();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    protected Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    protected int insertOrUpdateUser(int userId, String userName, Date userBirthday) throws SQLException, ParseException {
        ResultSet resultSet = getNumberOfUsersWithId(userId);

        String sqlQuery;
        PreparedStatement preparedStatement;
        if (resultSet != null && resultSet.next() && resultSet.getInt(1) > 0) {
            sqlQuery = "UPDATE db_user SET name = ?, birthday_date = ? WHERE user_id = ?";
            preparedStatement = dbConnection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setDate(2, new java.sql.Date(userBirthday.getTime()));
            preparedStatement.setInt(3, userId);
        } else {
            sqlQuery = "INSERT INTO db_user (user_id, birthday_date, name) VALUES (?, ?, ?)";
            preparedStatement = dbConnection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, userId);
            preparedStatement.setDate(2, new java.sql.Date(userBirthday.getTime()));
            preparedStatement.setString(3, userName);
        }

        System.out.println(
                String.format(
                        "SQL query '%s...' executed!",
                        sqlQuery.substring(0, sqlQuery.indexOf(" "))
                )
        );
        return preparedStatement.executeUpdate();
    }

    protected ResultSet getUserByName(String userName) {
        String selectFromTableSQL = String.format(
                "SELECT * FROM db_user WHERE name like '%%%s%%'",
                userName
        );
        return executeSqlQuery(selectFromTableSQL);
    }

    protected ResultSet createUserTable() throws SQLException {
        String createTableSQL = "CREATE TABLE db_user("
                + "user_id INT(5) NOT NULL, "
                + "birthday_date DATE NOT NULL, "
                + "name VARCHAR(20) NOT NULL, "
                + "PRIMARY KEY (user_id) "
                + ")";
        return executeSqlQuery(createTableSQL);
    }

    protected ResultSet dropUserTable() throws SQLException {
        String dropTableSQL = "DROP TABLE db_user";
        return executeSqlQuery(dropTableSQL);
    }

    protected ResultSet executeSqlQuery(String sqlQuery) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            System.out.println(
                    String.format(
                            "SQL query '%s...' executed!",
                            sqlQuery.substring(0, sqlQuery.indexOf(" "))
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    protected ResultSet getNumberOfUsersWithId(int userId) {
        String countUserWithId = String.format("SELECT COUNT(*) FROM db_user WHERE user_id = %d", userId);
        return executeSqlQuery(countUserWithId);
    }

    protected boolean isDateCorrect(int userId, Date date) throws SQLException {
        String birthdayDateFromDb = String.format("SELECT birthday_date FROM db_user WHERE user_id = %d", userId);
        ResultSet resultSet = executeSqlQuery(birthdayDateFromDb);

        if (resultSet != null && resultSet.next() && resultSet.getDate(1) != null) {
            LocalDate expectedDate = new java.sql.Date(date.getTime()).toLocalDate();
            LocalDate actualDate = resultSet.getDate(1).toLocalDate();
            return expectedDate.equals(actualDate);
        }

        return false;
    }

    @After
    public void purge() throws SQLException {
        dbConnection.close();
    }
}