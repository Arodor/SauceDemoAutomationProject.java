package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("E-commerce")
@Feature("Product Management")
public class ProductTests extends BaseTest {
    private ProductsPage productsPage;

    @BeforeMethod
    public void loginToApplication() {
        productsPage = loginPage
                .navigateToLoginPage()
                .loginWithStandardUser();
    }

    @Test(description = "Verify products can be sorted by price (low to high)")
    @Story("Product Sorting")
    @Severity(SeverityLevel.NORMAL)
    public void testSortProductsByPriceLowToHigh() {
        productsPage.sortByPriceLowToHigh();

        assertThat(productsPage.areItemsSortedByPriceLowToHigh())
                .as("Products should be sorted by price from low to high")
                .isTrue();
    }

    @Test(description = "Verify product can be added to cart")
    @Story("Add to Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddProductToCart() {
        String initialCartCount = String.valueOf(productsPage.getCartItemsCount());
        
        productsPage.addFirstItemToCart();

        assertThat(productsPage.getCartItemsCount())
                .as("Cart should contain one item after adding product")
                .isEqualTo(1);
    }

    @Test(description = "Verify multiple products can be added to cart")
    @Story("Add Multiple Items")
    @Severity(SeverityLevel.NORMAL)
    public void testAddMultipleProductsToCart() {
        productsPage
                .addItemToCartByName("Sauce Labs Backpack")
                .addItemToCartByName("Sauce Labs Bike Light");

        assertThat(productsPage.getCartItemsCount())
                .as("Cart should contain two items")
                .isEqualTo(2);
    }

    @Test(description = "Verify all products are displayed")
    @Story("Product Display")
    @Severity(SeverityLevel.NORMAL)
    public void testProductsAreDisplayed() {
        assertThat(productsPage.getProductsCount())
                .as("All products should be displayed")
                .isGreaterThan(0);

        assertThat(productsPage.getProductNames())
                .as("Product names should not be empty")
                .allMatch(name -> !name.trim().isEmpty());
    }
}