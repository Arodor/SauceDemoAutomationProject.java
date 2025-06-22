package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends LandingPage {
    private String lastBoughtItemName;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventory;
    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;
    @FindBy(xpath = "//div[@ID=\"shopping_cart_container\"]")
    private WebElement CartItemLink;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement CartitemNumberBadge;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public int GetCartItemsNumber() {
        return Integer.parseInt(CartitemNumberBadge.getText());
    }

    public void sortByPriceLowToHigh() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price (low to high)");
    }

    public boolean areItemsSortedByPriceLowToHigh() {
        List<Double> prices = new ArrayList<>();
        for (WebElement item : inventory) {
            String priceText = item.findElement(By.className("inventory_item_price")).getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void buyItem() {
        if (inventory == null || inventory.isEmpty()) {
            throw new IllegalStateException("No inventory items found on the page.");
        }
        WebElement firstItem = inventory.getFirst();
        lastBoughtItemName = firstItem.findElement(By.className("inventory_item_name")).getText();
        WebElement addToCartButton = firstItem.findElement(By.xpath(".//button[contains(text(), 'Add to cart')]"));
        addToCartButton.click();
        GoToCart();
    }

    public String getLastBoughtItemName() {
        return lastBoughtItemName;
    }

    public void GoToCart() {
        CartItemLink.click();
    }

    public WebElement getSortDropdown() {
        return sortDropdown;
    }
}