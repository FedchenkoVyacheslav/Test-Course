import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class JDBCTest extends MainDatabaseJDBCTest {
    @Before
    public void init() {
        createUserTableIfDoesNotExist();
    }

    @Test
    public void runTest() throws SQLException, IOException, ParseException {
        int userId = 1;
        String userName = "Tom Anderson";
        Date userBirthday = new Date(705488102000L);

        int affectedRecordsNumber = insertOrUpdateUser(userId, userName, userBirthday);
        if (affectedRecordsNumber > 0) {
            System.out.println("User successfully added or updated!");
        } else {
            throw new IOException();
        }

        ResultSet userInfoSet = getUserByName(userName);
        System.out.println("-------------------");
        while (userInfoSet.next()){
            System.out.println(String.format(
                    "User info:\n - id: %d\n - name: %s\n - birthday: %s",
                    userInfoSet.getInt(1),
                    userInfoSet.getString(2),
                    userInfoSet.getString(3)
            ));
            System.out.println("-------------------");
            assert isDateCorrect(userId, userBirthday) : "Date is incorrect";
        }
    }

    @After
    public void finalize() throws SQLException {
        try {
            dropUserTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}