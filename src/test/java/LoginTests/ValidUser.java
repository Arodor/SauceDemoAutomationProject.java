package LoginTests;

import Utility.setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidUser extends setup {


    @Test //Login Test
    public void logIn() {
        //Username Input
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        // Password Input
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        //WebElement loginBtn = driver.findElement(By.id("login-button"));
        WebElement loginBtnXpath = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBtnXpath.click();
        //Check if certain element is present
        WebElement products = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[1]"));
        Assert.assertTrue(products.isDisplayed());

    }
}
