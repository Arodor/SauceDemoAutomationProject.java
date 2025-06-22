package LoginTests;

import Pages.LandingPage;
import Pages.ProductPage;
import Utility.setup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginInvalidCredentials extends setup {
    @Test
    public void loginToApplication() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.logInCredentials(username, "12312");


        Assert.assertTrue(
                landingPage.getErrorMessage().isDisplayed(),
                "Error message is displayed after invalid login!");
}

    }

