package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    private List<WebElement> cartItemNames;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @Step("Check if cart page is loaded")
    public boolean isCartPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return getCurrentUrl().contains("cart.html");
    }

    @Step("Get first cart item name")
    public String getFirstCartItemName() {
        if (cartItemNames.isEmpty()) {
            throw new IllegalStateException("No items in cart");
        }
        wait.until(ExpectedConditions.visibilityOf(cartItemNames.get(0)));
        return cartItemNames.get(0).getText();
    }

    @Step("Get cart items count")
    public int getCartItemsCount() {
        return cartItems.size();
    }

    @Step("Proceed to checkout")
    public CheckoutPage proceedToCheckout() {
        clickElement(checkoutButton);
        return new CheckoutPage();
    }

    @Step("Check if cart is empty")
    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }
}