package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("E-commerce")
@Feature("End-to-End Purchase Flow")
public class EndToEndTests extends BaseTest {

    @Test(description = "Complete purchase flow from login to checkout completion")
    @Story("Complete Purchase")
    @Severity(SeverityLevel.CRITICAL)
    public void testCompletePurchaseFlow() {
        // Login
        ProductsPage productsPage = loginPage
                .navigateToLoginPage()
                .loginWithStandardUser();

        assertThat(productsPage.isProductsPageLoaded())
                .as("Should be on products page after login")
                .isTrue();

        // Sort and add cheapest item
        productsPage
                .sortByPriceLowToHigh()
                .addFirstItemToCart();

        String addedItemName = productsPage.getLastAddedItemName();

        assertThat(productsPage.getCartItemsCount())
                .as("Cart should contain one item")
                .isEqualTo(1);

        // Go to cart
        CartPage cartPage = productsPage.goToCart();

        assertThat(cartPage.isCartPageLoaded())
                .as("Should be on cart page")
                .isTrue();

        assertThat(cartPage.getFirstCartItemName())
                .as("Item in cart should match added item")
                .isEqualTo(addedItemName);

        // Proceed to checkout
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();

        assertThat(checkoutPage.isCheckoutPageLoaded())
                .as("Should be on checkout page")
                .isTrue();

        // Fill checkout information
        CheckoutOverviewPage overviewPage = checkoutPage
                .fillCheckoutInformation("John", "Doe", "12345")
                .continueToOverview();

        assertThat(overviewPage.isCheckoutOverviewPageLoaded())
                .as("Should be on checkout overview page")
                .isTrue();

        // Complete checkout
        CheckoutCompletePage completePage = overviewPage.finishCheckout();

        assertThat(completePage.isCheckoutCompletePageLoaded())
                .as("Should be on checkout complete page")
                .isTrue();

        assertThat(completePage.getCompletionMessage())
                .as("Should show order completion message")
                .contains("Thank you for your order!");
    }

    @Test(description = "Purchase cheapest item specifically")
    @Story("Buy Cheapest Item")
    @Severity(SeverityLevel.NORMAL)
    public void testBuyCheapestItem() {
        ProductsPage productsPage = loginPage
                .navigateToLoginPage()
                .loginWithStandardUser();

        // Sort by price and verify sorting
        productsPage.sortByPriceLowToHigh();
        
        assertThat(productsPage.areItemsSortedByPriceLowToHigh())
                .as("Items should be sorted by price low to high")
                .isTrue();

        // Add first (cheapest) item
        productsPage.addFirstItemToCart();
        String cheapestItemName = productsPage.getLastAddedItemName();

        // Verify cart
        CartPage cartPage = productsPage.goToCart();
        
        assertThat(cartPage.getFirstCartItemName())
                .as("Cheapest item should be in cart")
                .isEqualTo(cheapestItemName);

        // Proceed to checkout
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        
        assertThat(checkoutPage.getPageTitle())
                .as("Should be on checkout information page")
                .isEqualTo("Checkout: Your Information");
    }
}