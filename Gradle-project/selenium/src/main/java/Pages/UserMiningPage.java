package Pages;
import Elements.SelectCheckBox;
import Elements.SelectOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMiningPage {
    private final WebDriver driver;

    public UserMiningPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Search by Custom Fields']") private WebElement customFieldsTab;
    @FindBy(xpath = "//div[@ng-switch-when='EQUAL']/input") private WebElement equalSearchInput;
    @FindBy(xpath = "//input[@ng-switch-when='LIKE']") private WebElement containsSearchInput;
    @FindBy(xpath = "//button//span[text()='Search']") private WebElement submitButton;

    public UserMiningPage switchToCustomFieldTab() {
        customFieldsTab.click();
        return this;
    }

    public UserMiningPage searchOption (String option, String value) {
        switch (option) {
            case "equal":
                equalSearchInput.sendKeys(value);
                break;
            case "like":
                containsSearchInput.sendKeys(value);
                break;
            default:
                System.out.println("Please select a different search option");
                break;
        }
        return this;
    }

    public SearchResultPage confirmSearch () {
        this.submitButton.click();
        return new SearchResultPage(driver);
    }

    public UserMiningPage searchByField (String searchField, String  searchOption){
        SelectCheckBox.checkCheckBox(driver, searchField);
        SelectOption.chooseOption(driver, searchOption);
        return this;
    }
}
