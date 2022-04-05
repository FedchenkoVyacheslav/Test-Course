import Actions.ExecuteJS;
import Actions.LogsCheck;
import Actions.Wait;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;

public class BrowserLogsCheck {
    static WebDriver driver;
    String URL = "https://develops1568.qa.piano.io/";
    String message = "Auto test console message";
    LogEntries logEntries;
    LoginPage myLoginPage;

    @Before
    public void setup(){
        driver = Actions.PrepareDriver.driverInit("chrome");
        driver.manage().window().maximize();
        driver.get(URL);
        myLoginPage = new LoginPage(driver);
    }

    @Test
    public void main(){
        myLoginPage.loginWithCredential("tim@tinypass.com", "password");
        Wait.selectElements(driver,"//div[contains(@class, 'pn-table--applications')]/div[contains(@class, 'pn-table__hoverable-row-wrapper')]");
        ExecuteJS.consoleLog(driver, message);
        LogsCheck logging = new LogsCheck(driver);
        logEntries = logging.getBrowserLogs();
        LogsCheck.checkLogs(logEntries, message);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
