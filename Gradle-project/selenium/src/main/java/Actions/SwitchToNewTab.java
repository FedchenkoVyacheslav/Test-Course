package Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class SwitchToNewTab {
    public static void switchTab (WebDriver driver, String appPage){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(appPage);
    }
}
