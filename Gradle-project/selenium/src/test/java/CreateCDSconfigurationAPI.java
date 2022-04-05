import Actions.PrepareDriver;
import Actions.Sleep;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateCDSconfigurationAPI {
    static WebDriver driver;
    String URL = "https://develops1568.qa.piano.io/";
    LoginPage myLoginPage;
    List<String> confList = new ArrayList<>(Arrays.asList("Test API", "CDS", "CDStest", "This is a test configuration"));
    List<String> fieldSettings = new ArrayList<>(Arrays.asList("Text", "Custom field", "This is a test field", "Text1"));

    @Before
    public void setup() {
        driver = PrepareDriver.driverInit("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        myLoginPage = new LoginPage(driver);
    }

    @Test
    public void main() {
        myLoginPage.loginWithCredential("tim@tinypass.com", "password").
                selectApp(1).
                initExternalAPIsPagePage().
                createNewConfig().
                createExternalApiConfig(confList).
                addField(fieldSettings).
                backToApiList().
                getApiConf(confList.get(0)).
                checkProps(confList);
        Sleep.init(3000);
    }

    @After
    public void quit() {
        driver.quit();
    }
}
