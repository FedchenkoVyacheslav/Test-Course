import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest{
    WebDriver driver = null;

    @Before
    public void setup(){
        System.setProperty ("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void main(){
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//img[@alt=\"Google\"]"));
    }
    @After
    public void quit(){
        driver.quit();
    }
}
