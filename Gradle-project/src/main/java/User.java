import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_user")
@NamedQuery(name = "User.getAll", query = "SELECT u from User u")
public class User {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "birthday_date")
    @Temporal(TemporalType.DATE)

    private Date birthdayDate;

    public User() {}

    public User(int userId, String name, Date birthdayDate) {
        this.userId = userId;
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", birthdayDate='" + birthdayDate + '\'' +
                '}';
    }
}