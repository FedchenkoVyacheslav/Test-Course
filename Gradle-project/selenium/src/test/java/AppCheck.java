import Actions.PrepareDriver;
import Actions.Screenshot;
import Pages.AdminPage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class AppCheck {
    static WebDriver driver;
    String URL = "https://develops1568.qa.piano.io/";
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
    public void main() throws InterruptedException{
        myLoginPage.loginWithCredential("tim@tinypass.com", "password").
                getAppInfo(driver, 5).
                printNumberOfApps().
                switchTab().
                searchApp(AdminPage.getAppID(driver, 5)).
                printNumberOfApps().
                linkCheck(AdminPage.appsList(driver).size());
        Screenshot.takeScreenshot(driver);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
