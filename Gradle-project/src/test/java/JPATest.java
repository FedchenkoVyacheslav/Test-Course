import org.junit.Test;

import java.util.Date;

public class JPATest extends MainDatabaseJPATest {
    @Test
    public void runTest() throws Exception {
        int userId = 1;
        String userName = "Vyacheslav Fedchenko";
        Date userBirthday = new Date(548778600000L);

        System.out.println("-----------");
        insertOrUpdateUser(userId, userName, userBirthday);

        System.out.println("-----------");
        System.out.println("Users with name: " + userName);
        System.out.println("-----------");
        getUserByName(userName).forEach(System.out::println);

        System.out.println("-----------");
        assert isDateCorrect(userId, userBirthday) : "Date is incorrect";
    }
}