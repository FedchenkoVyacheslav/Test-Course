package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='email']") private WebElement emailInput;
    @FindBy(xpath = "//input[@id='password']") private WebElement passwordInput;
    @FindBy(xpath = "//a[@id='login-button']") private WebElement confirmButton;

    public void typeEmail (String email) {
        emailInput.sendKeys(email);
    }

    public void typePassword (String password) {
        passwordInput.sendKeys(password);
    }

    public AdminPage loginWithCredential (String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        confirmButton.click();
        return new AdminPage(driver);
    }
}
