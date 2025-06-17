package LoginTests;

import Pages.CartPage;
import Pages.LandingPage;
import Pages.ProductPage;
import Utility.setup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class buyCheapestItem extends setup {



    @Test
    public void buyCheapestItem () throws InterruptedException {
        //LandingPage BuyCheapest = new LandingPage(driver);
        ProductPage products = new ProductPage(driver);
        products.logInCredentials(username, password);
        products.sortByPriceLowToHigh();

        products.buyItem();
        Assert.assertTrue(products.areItemsSortedByPriceLowToHigh(), "Items are not sorted by price low to high!");

        Assert.assertEquals(products.GetCartItemsNumber(), 1);
        Assert.assertTrue(products.getSortDropdown().isDisplayed(), "The dropdown menu could not be located");
        products.CartButton().click();
    }
}
