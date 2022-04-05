import Actions.PrepareDriver;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

public class LoginToAdminDashboard {
    static WebDriver driver;
    String URL = "https://develop.qa.piano.io/";
    LoginPage myLoginPage;

    @Before
    public void setup(){
        driver = PrepareDriver.driverInit("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        myLoginPage = new LoginPage(driver);
    }

    @Test
    public void main(){
        myLoginPage.loginWithCredential("tim@tinypass.com", "password");
    }

    @After
    public void quit(){
        driver.quit();
    }
}
