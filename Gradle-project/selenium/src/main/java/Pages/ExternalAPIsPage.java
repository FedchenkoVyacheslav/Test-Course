package Pages;
import Actions.Sleep;
import Actions.Wait;
import Elements.SelectOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExternalAPIsPage {
    private final WebDriver driver;

    public ExternalAPIsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='new-template']//span")
    private WebElement addNewConfButton;
    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleInput;
    @FindBy(xpath = "//input[@id='prodId']")
    private WebElement productIdInput;
    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement descriptionInput;
    @FindBy(xpath = "//button[@id='modal-create-button']")
    private WebElement createButton;
    @FindBy(xpath = "//button[@id='new-external-css']")
    private WebElement addConfButton;
    @FindBy(xpath = "//input[@id='title-field']")
    private WebElement fieldTitleInput;
    @FindBy(xpath = "//input[@id='name-field']")
    private WebElement fieldNameInput;
    @FindBy(xpath = "//textarea[@id='description-field']")
    private WebElement descriptionFieldInput;
    @FindBy(xpath = "//input[@id='default-field']")
    private WebElement defaultFieldInput;
    @FindBy(xpath = "//button[@id='save-btn']")
    private WebElement saveButton;
    @FindBy(xpath = "//a[@id='back-btn']")
    private WebElement backToListButton;
    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement apiDescription;

    public ExternalAPIsPage createNewConfig() {
        addNewConfButton.click();
        return this;
    }

    public void typeTitle(String title) {
        titleInput.sendKeys(title);
    }

    public void selectAPIType(String apiType) {
        SelectOption.chooseOption(driver, apiType);
    }

    public void typeProductId(String productId) {
        productIdInput.sendKeys(productId);
    }

    public void typeDescription(String description) {
        descriptionInput.sendKeys(description);
    }

    public void addConf() {
        addConfButton.click();
    }

    public void typeTitleField(String titleField) {
        fieldTitleInput.sendKeys(titleField);
    }

    public void typeNameField(String nameField) {
        fieldNameInput.sendKeys(nameField);
    }

    public void typeDescriptionField(String descriptionField) {
        descriptionFieldInput.sendKeys(descriptionField);
    }

    public void typeDefaultField(String defaultField) {
        defaultFieldInput.sendKeys(defaultField);
    }

    public ExternalAPIsPage addField(List<String> fieldSettings) {
        this.typeTitleField(fieldSettings.get(0));
        this.typeNameField(fieldSettings.get(1));
        this.typeDescriptionField(fieldSettings.get(2));
        this.typeDefaultField(fieldSettings.get(3));
        createButton.click();
        Sleep.init(1000);
        saveButton.click();
        return this;
    }

    public ExternalAPIsPage createExternalApiConfig(List<String> apiList) {
        this.typeTitle(apiList.get(0));
        this.selectAPIType(apiList.get(1));
        this.typeProductId(apiList.get(2));
        this.typeDescription(apiList.get(3));
        createButton.click();
        this.addConf();
        return this;
    }

    public ExternalAPIsPage backToApiList() {
        backToListButton.click();
        return this;
    }

    public ExternalAPIsPage getApiConf(String apiName) {
        String optionXpath = String.format("//li[@class='config-title']//h2[text()='%s']", apiName);
        driver.findElement(By.xpath(optionXpath)).click();
        return this;
    }

    public List<String> getApiConfParams() {
        List<String> apiParams = new ArrayList<>();
        Wait.selectElements(driver, "//div[@class='controls has-tooltip']//input");
        List<WebElement> listParams = driver.findElements(By.xpath("//div[@class='controls has-tooltip']//input"));
        for (WebElement element : listParams) {
            apiParams.add(element.getAttribute("value"));
        }
        apiParams.add(apiDescription.getAttribute("value"));
        return apiParams;
    }

    public ExternalAPIsPage checkProps(List<String> apiList) {
        List<String> apiParams = getApiConfParams();
        System.out.println(apiParams);
        System.out.println(apiList);
        Collections.sort(apiParams);
        Collections.sort(apiList);
        if (apiParams.equals(apiList))
            System.out.println("Saved API data is the same as entered!");
        else System.out.println("Error!");
        return this;
    }
}
