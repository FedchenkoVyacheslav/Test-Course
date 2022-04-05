import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SalesSumOutput {
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
                initInternalPage().
                getSum().
                checkSumAfterReload();
    }

    @After
    public void quit(){
        driver.quit();
    }
}
