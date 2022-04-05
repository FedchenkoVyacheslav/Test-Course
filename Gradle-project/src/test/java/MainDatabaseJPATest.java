import java.util.Date;
import java.util.List;

public class MainDatabaseJPATest {
    protected UserService userService = new UserService();

    protected void insertOrUpdateUser(int userId, String userName, Date userBirthday) throws Exception {
        if (userService.getUserById(userId) == null) {
            User user = new User(userId, userName, userBirthday);
            System.out.println("User added: " + userService.add(user));
        } else {
            User user = new User(userId, userName, userBirthday);
            System.out.println("User updated: " + userService.update(user));
        }
    }

    protected List<User> getUserByName(String userName) {
        return userService.getUsersByName(userName);
    }

    protected boolean isDateCorrect(int userId, Date date) {
        User user = userService.getUserById(userId);
        if (user == null)
            return false;

        return user.getBirthdayDate().equals(date);
    }
}