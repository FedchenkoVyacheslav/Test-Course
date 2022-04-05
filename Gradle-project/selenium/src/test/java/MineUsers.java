import Actions.Sleep;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class MineUsers {
    static WebDriver driver;
    String URL = "https://develops1568.qa.piano.io/";
    LoginPage myLoginPage;

    @Before
    public void setup(){
        driver = Actions.PrepareDriver.driverInit("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        myLoginPage = new LoginPage(driver);
    }

    @Test
    public void main(){
        myLoginPage.loginWithCredential("tim@tinypass.com", "password").
                selectApp(1).
                initUserMining().
                switchToCustomFieldTab().
                searchByField("Number", "Equals").
                searchOption("equal", "23").
                searchByField("Phone number", "Contains").
                searchOption("like", "203").
                confirmSearch();
        Sleep.init(3000);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
