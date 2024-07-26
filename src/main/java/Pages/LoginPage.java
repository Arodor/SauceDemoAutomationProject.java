package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "user-name")
    private WebElement userNameInput;
    @FindBy (id = "password")
    private WebElement password;
    @FindBy (xpath="//input[@id='login-button']")
    private WebElement loginButton;

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
