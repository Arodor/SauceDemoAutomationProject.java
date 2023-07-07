package LoginTests;

import Utility.setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProblematicUsers  extends setup {

    @Test //Login Test
    public void logIn() {
        //Username Input
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.clear();
        usernameInput.sendKeys("problem_user");
        // Password Input
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        //Check if certain element is present
        WebElement products = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[1]"));
        Assert.assertTrue(products.isDisplayed());
    }
}
