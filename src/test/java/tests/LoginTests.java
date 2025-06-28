package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Authentication")
@Feature("User Login")
public class LoginTests extends BaseTest {

    @Test(description = "Verify successful login with valid credentials")
    @Story("Valid Login")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidLogin() {
        ProductsPage productsPage = loginPage
                .navigateToLoginPage()
                .loginWithStandardUser();

        assertThat(productsPage.isProductsPageLoaded())
                .as("Products page should be loaded after successful login")
                .isTrue();
    }

    @Test(description = "Verify error message appears with invalid credentials")
    @Story("Invalid Login")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidLogin() {
        loginPage
                .navigateToLoginPage()
                .loginWithInvalidCredentials(config.getStandardUsername(), "invalid_password");

        assertThat(loginPage.isErrorMessageDisplayed())
                .as("Error message should be displayed for invalid credentials")
                .isTrue();

        assertThat(loginPage.getErrorMessageText())
                .as("Error message should contain expected text")
                .contains("Username and password do not match");
    }

    @Test(description = "Verify error message appears with locked user")
    @Story("Locked User Login")
    @Severity(SeverityLevel.NORMAL)
    public void testLockedUserLogin() {
        loginPage
                .navigateToLoginPage()
                .loginWithInvalidCredentials(config.getLockedUsername(), config.getStandardPassword());

        assertThat(loginPage.isErrorMessageDisplayed())
                .as("Error message should be displayed for locked user")
                .isTrue();

        assertThat(loginPage.getErrorMessageText())
                .as("Error message should indicate user is locked")
                .contains("locked out");
    }

    @Test(description = "Verify error message appears with empty credentials")
    @Story("Empty Credentials")
    @Severity(SeverityLevel.MINOR)
    public void testEmptyCredentials() {
        loginPage
                .navigateToLoginPage()
                .loginWithInvalidCredentials("", "");

        assertThat(loginPage.isErrorMessageDisplayed())
                .as("Error message should be displayed for empty credentials")
                .isTrue();

        assertThat(loginPage.getErrorMessageText())
                .as("Error message should indicate username is required")
                .contains("Username is required");
    }
}