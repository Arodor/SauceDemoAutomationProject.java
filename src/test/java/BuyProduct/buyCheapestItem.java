package BuyProduct;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.ProductPage;
import Utility.setup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class buyCheapestItem extends setup {



    @Test
    public void buyCheapestItem() throws InterruptedException {
        ProductPage products = new ProductPage(driver);


        products.logInCredentials(username, password);
        products.sortByPriceLowToHigh();
        Assert.assertTrue(products.getSortDropdown().isDisplayed(), "The dropdown menu could not be located");

        products.buyItem();
        Assert.assertTrue(products.areItemsSortedByPriceLowToHigh(), "Items are not sorted by price low to high!");
        Assert.assertEquals(products.GetCartItemsNumber(), 1);

        products.GoToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemName(),
                products.getLastBoughtItemName(),
                "Item in cart does not match the bought item.");

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.GotoCheckout();
        checkout.getCheckoutTitle();
    }
}
