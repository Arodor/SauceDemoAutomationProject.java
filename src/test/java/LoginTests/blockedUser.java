package LoginTests;
import Pages.LandingPage;
import Utility.setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class blockedUser extends setup {


    @Test //Login Test
    public void logInBlockedUser()  {
        //Username Input
        LandingPage login = new LandingPage(driver);
        login.logInCredentials(username,password);
        //Check if certain element is present
        WebElement products = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertTrue(products.isDisplayed());
    }
}
