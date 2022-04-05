package Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectOption {
    public static void chooseOption(WebDriver driver,String option){
        String optionXpath = String.format("//select[not(@disabled='disabled')]/option[text()='%s']", option);
        driver.findElement(By.xpath(optionXpath)).click();
    }
}
