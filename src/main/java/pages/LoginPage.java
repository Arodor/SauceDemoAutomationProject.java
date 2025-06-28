package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    @Step("Navigate to login page")
    public LoginPage navigateToLoginPage() {
        navigateTo(config.getBaseUrl());
        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        return this;
    }

    @Step("Login with username: {username}")
    public ProductsPage loginWith(String username, String password) {
        clearAndType(usernameField, username);
        clearAndType(passwordField, password);
        clickElement(loginButton);
        return new ProductsPage();
    }

    @Step("Login with standard user credentials")
    public ProductsPage loginWithStandardUser() {
        return loginWith(config.getStandardUsername(), config.getStandardPassword());
    }

    @Step("Attempt login with invalid credentials")
    public LoginPage loginWithInvalidCredentials(String username, String password) {
        clearAndType(usernameField, username);
        clearAndType(passwordField, password);
        clickElement(loginButton);
        return this;
    }

    @Step("Check if error message is displayed")
    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(errorMessage);
    }

    @Step("Get error message text")
    public String getErrorMessageText() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    @Step("Check if login page is loaded")
    public boolean isLoginPageLoaded() {
        return isElementDisplayed(loginLogo) && getCurrentUrl().contains("saucedemo.com");
    }
}