package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends CartPage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[@class='title']")
    private WebElement checkoutTitle;

    public  void  getCheckoutTitle() {
        if (checkoutTitle.getText().equals("Checkout: Your Information"))
            System.out.println("Checkout page is displayed");
        else
            System.out.println("Checkout page is not displayed");

    }
}



