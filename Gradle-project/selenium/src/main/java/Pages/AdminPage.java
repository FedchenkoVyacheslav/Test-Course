package Pages;
import Actions.ExecuteJS;
import Actions.Sleep;
import Actions.SwitchToNewTab;
import Elements.HeaderLinks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class AdminPage {
    private final WebDriver driver;

    public AdminPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='query']") private WebElement searchInput;

    public AdminPage searchApp (String aid) throws InterruptedException {
        searchInput.sendKeys(aid);
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        if(getAppID(driver, appsList(driver).size()).equals(aid))
        System.out.println("Found application matches selected one.");
        else System.out.println("Error! The search didn't return the selected application");
        return this;
    }

    public AdminPage selectApp (int appNumber) {
        getApp(driver,appNumber).click();
        return this;
    }

    public static List<WebElement> appsList(WebDriver driver) {
        return driver.findElements(By.xpath("//div[contains(@class, 'pn-table--applications')]/div[contains(@class, 'pn-table__hoverable-row-wrapper')]"));
    }

    public static WebElement getApp(WebDriver driver, int appNumber) {
        List<WebElement> apps = appsList(driver);
        List<WebElement> appLinks = new ArrayList<WebElement>();
        for (WebElement app:apps) {
            WebElement appLink = app.findElement(By.xpath(".//button[contains(@class, 'pn-link')]"));
            appLinks.add(appLink);
        }
        return appLinks.get(appNumber - 1);
    }

    public AdminPage getAppInfo(WebDriver driver, int appNumber) {
        List<WebElement> apps = appsList(driver);
        List<WebElement> appNames = new ArrayList<WebElement>();
        List<WebElement> appIDs = new ArrayList<WebElement>();
        List<WebElement> appNums = new ArrayList<WebElement>();
        for (WebElement app:apps) {
            WebElement appName = app.findElement(By.xpath(".//div[@class='app-name']/span"));
            WebElement appID = app.findElement(By.xpath(".//div[contains(@class, 'app-type')]/span[1]"));
            WebElement appNum = app.findElement(By.xpath(".//div[contains(@class, 'app-type')]/span[2]"));
            appNames.add(appName);
            appIDs.add(appID);
            appNums.add(appNum);
        }
        String appInfo = "Application name is: " + appNames.get(appNumber - 1).getText() +
                "\nApplication ID is :" + appIDs.get(appNumber - 1).getText() +
                "\nApplication number is: " + appNums.get(appNumber - 1).getText();
        ExecuteJS.alert(driver, appInfo);
        Sleep.init(3000);
        driver.switchTo().alert().accept();
        return this;
    }

    public static String getAppID(WebDriver driver, int appNumber) {
        List<WebElement> apps = appsList(driver);
        List<WebElement> appIDs = new ArrayList<WebElement>();
        for (WebElement app:apps) {
            WebElement appID = app.findElement(By.xpath(".//div[contains(@class, 'app-type')]/span[1]"));
            appIDs.add(appID);
        }
        return appIDs.get(appNumber - 1).getText();
    }

    public AdminPage printNumberOfApps() {
        System.out.println("Number of apps per page - " + appsList(driver).size());
        return this;
    }

    public AdminPage switchTab(){
        String appPage = driver.getCurrentUrl();
        SwitchToNewTab.switchTab(driver, appPage);
        return new AdminPage(driver);
    }

    public AdminPage linkCheck(int appNumber){
        if(AdminPage.getApp(driver,appNumber).isEnabled())
            System.out.println("The link is available to go to the application page");
        else
            System.out.println("Error! Link unavailable");
        return this;
    }

    public UserMiningPage initUserMining (){
        HeaderLinks.selectLink(driver,"Users", "Mine users");
        return new UserMiningPage(driver);
    }

    public InternalPage initInternalPage (){
        HeaderLinks.selectLink(driver,"Reports", "Internal");
        return new InternalPage(driver);
    }

    public ExternalAPIsPage initExternalAPIsPagePage (){
        HeaderLinks.selectLink(driver,"Manage", "External APIs");
        return new ExternalAPIsPage(driver);
    }
}
