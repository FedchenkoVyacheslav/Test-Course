package Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    static WebDriverWait wait;
    public static void selectElement (WebDriver driver, String xPath){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }
    public static void selectElements (WebDriver driver, String xPath){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xPath)));
    }
}
