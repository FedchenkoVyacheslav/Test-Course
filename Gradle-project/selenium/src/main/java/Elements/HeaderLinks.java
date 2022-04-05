package Elements;
import Actions.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HeaderLinks {
    public static void selectLink (WebDriver driver, String headerElement, String listLink) {
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[contains(@class, 'nav-right')]/li/a[contains(@class, 'menu-item')]"));
        for (WebElement headerLink:headerLinks) {
            if(headerLink.getText().equals(headerElement)) headerLink.click();
        }
        Wait.selectElement(driver,"//a[text()='" + listLink + "']");
        driver.findElement(By.xpath("//a[text()='" + listLink + "']")).click();
    }
}
