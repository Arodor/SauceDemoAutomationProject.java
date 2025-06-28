package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    private String lastAddedItemName;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @Step("Check if products page is loaded")
    public boolean isProductsPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return isElementDisplayed(sortDropdown) && getCurrentUrl().contains("inventory.html");
    }

    @Step("Sort products by price (low to high)")
    public ProductsPage sortByPriceLowToHigh() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price (low to high)");
        return this;
    }

    @Step("Sort products by price (high to low)")
    public ProductsPage sortByPriceHighToLow() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price (high to low)");
        return this;
    }

    @Step("Sort products by name (A to Z)")
    public ProductsPage sortByNameAtoZ() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A to Z)");
        return this;
    }

    @Step("Sort products by name (Z to A)")
    public ProductsPage sortByNameZtoA() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (Z to A)");
        return this;
    }

    @Step("Verify items are sorted by price (low to high)")
    public boolean areItemsSortedByPriceLowToHigh() {
        List<Double> prices = getProductPrices();
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Step("Add first item to cart")
    public ProductsPage addFirstItemToCart() {
        if (inventoryItems.isEmpty()) {
            throw new IllegalStateException("No inventory items found on the page.");
        }
        
        WebElement firstItem = inventoryItems.get(0);
        lastAddedItemName = firstItem.findElement(By.className("inventory_item_name")).getText();
        WebElement addToCartButton = firstItem.findElement(By.xpath(".//button[contains(text(), 'Add to cart')]"));
        clickElement(addToCartButton);
        return this;
    }

    @Step("Add item to cart by name: {itemName}")
    public ProductsPage addItemToCartByName(String itemName) {
        for (WebElement item : inventoryItems) {
            String currentItemName = item.findElement(By.className("inventory_item_name")).getText();
            if (currentItemName.equals(itemName)) {
                WebElement addToCartButton = item.findElement(By.xpath(".//button[contains(text(), 'Add to cart')]"));
                clickElement(addToCartButton);
                lastAddedItemName = itemName;
                break;
            }
        }
        return this;
    }

    @Step("Get cart items count")
    public int getCartItemsCount() {
        if (!isElementDisplayed(cartBadge)) {
            return 0;
        }
        return Integer.parseInt(cartBadge.getText());
    }

    @Step("Navigate to cart")
    public CartPage goToCart() {
        clickElement(cartLink);
        return new CartPage();
    }

    @Step("Get last added item name")
    public String getLastAddedItemName() {
        return lastAddedItemName;
    }

    @Step("Get all product names")
    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement item : inventoryItems) {
            names.add(item.findElement(By.className("inventory_item_name")).getText());
        }
        return names;
    }

    @Step("Get all product prices")
    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement item : inventoryItems) {
            String priceText = item.findElement(By.className("inventory_item_price")).getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }

    @Step("Get products count")
    public int getProductsCount() {
        return inventoryItems.size();
    }
}