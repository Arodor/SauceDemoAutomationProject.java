package LoginTests;
import Utility.setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BlockedUser extends setup {
    @Test //Login Test
    public void logInBlockedUser()  {
        //Username Input
        driver.manage().window().maximize();
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.clear();
        usernameInput.sendKeys("locked_out_user");
        // Password Input
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginBtn.isDisplayed());
        loginBtn.click();
        //Check if certain element is present
        WebElement products = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertTrue(products.isDisplayed());
    }
}
