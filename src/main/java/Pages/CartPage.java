package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends ProductPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement cartItemName;
    @FindBy (id="checkout")
    WebElement checkoutButton;


    public String getCartItemName() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(cartItemName));
        return cartItemName.getText();
    }

    public void GotoCheckout() {
        checkoutButton.click();
    }
}
