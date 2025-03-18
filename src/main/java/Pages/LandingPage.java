package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LandingPage {
    protected WebDriver driver;
    @FindBy(id = "user-name")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void logInCredentials(String username, String pass) {

        userNameInput.clear();
        userNameInput.sendKeys(username);
        password.clear();
        password.sendKeys(pass);
        loginButton.click();

    }

}




