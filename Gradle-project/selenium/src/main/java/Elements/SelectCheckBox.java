package Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectCheckBox {
    public static void checkCheckBox(WebDriver driver, String name){
        String xPath = "//label[text()='%s']";
        if(!driver.findElement(By.xpath(String.format(xPath, name)+"/preceding-sibling::div")).isSelected())
            driver.findElement(By.xpath(String.format(xPath, name))).click();
    }
}
