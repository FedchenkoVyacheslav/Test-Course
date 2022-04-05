package Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ExecuteJS {
    static JavascriptExecutor jse;
    public static void consoleLog(WebDriver driver, String message) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("console.log(arguments[0]);", message);
    }

    public static void alert (WebDriver driver, String appInfo) {
        jse = (JavascriptExecutor)driver;
        jse.executeScript("alert(arguments[0]);", appInfo);
    }

    public static void alertAccept(WebDriver driver) {
        driver.switchTo().alert().accept();
        jse = (JavascriptExecutor)driver;
        jse.executeScript("window.location.reload();");
    }
}
