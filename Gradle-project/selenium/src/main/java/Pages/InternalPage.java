package Pages;
import Actions.ExecuteJS;
import Actions.SalesSum;
import Actions.Sleep;
import Elements.Table;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternalPage {
    private final WebDriver driver;

    public InternalPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//table[@id='saveToExcel']") private WebElement table;

    public InternalPage getSum(){
        Table revenueTable = new Table(table, driver);
        System.out.println("sales amount is " + SalesSum.getSalesSum(revenueTable) + "$");
        return this;
    }

    public InternalPage checkSumAfterReload(){
        ExecuteJS.alert(driver, "Now page will be reloaded");
        Sleep.init(3000);
        ExecuteJS.alertAccept(driver);
        System.out.println("After page reload ");
        getSum();
        return this;
    }
}
