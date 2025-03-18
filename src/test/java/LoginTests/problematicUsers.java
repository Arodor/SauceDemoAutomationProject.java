package LoginTests;

import Utility.setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class problematicUsers extends setup {

    @Test //Login Test
    public void logIn() {
        //Username Input
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.clear();
        usernameInput.sendKeys(LockedUser);
        // Password Input
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."),
                "Error message text is incorrect");

    }
}

