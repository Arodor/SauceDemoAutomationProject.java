package LoginTests;

import Pages.LandingPage;
import Utility.setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompleteOrder extends setup {


    @Test //Login Test
    public void logIn() {

        //Username Input
        LandingPage login = new LandingPage(driver);
        login.logInCredentials(username, password);
        WebElement products = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[1]"));
        Assert.assertTrue(products.isDisplayed());

    }
}
