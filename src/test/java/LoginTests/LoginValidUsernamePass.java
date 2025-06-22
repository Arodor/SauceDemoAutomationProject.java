package LoginTests;

import Pages.LandingPage;
import Pages.ProductPage;
import Utility.setup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginValidUsernamePass extends setup {
    @Test
    public void loginToApplication() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.logInCredentials(username, password);

        ProductPage productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.getSortDropdown().isDisplayed(), "Product Page is not displayed.");
    }
}
