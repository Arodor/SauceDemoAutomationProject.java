package LoginTests;

import Pages.LandingPage;
import Pages.ProductPage;
import Utility.setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class buyCheapestItem extends setup {



    @Test
    public void buyCheapestItem ()  {

        LandingPage BuyCheapest = new LandingPage(driver);
        ProductPage products = new ProductPage(driver);
        BuyCheapest.logInCredentials(username,password);
        products.sortByPriceLowToHigh();
        products.buyItem();
        Assert.assertEquals(products.GetCartItemsNumber(),1);
        Assert.assertTrue(products.getSortDropdown().isDisplayed(),"The dropdown menu could not be located");





    }
}
