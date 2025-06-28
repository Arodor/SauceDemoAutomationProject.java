package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "summary_total_label")
    private WebElement totalPrice;

    @Step("Check if checkout overview page is loaded")
    public boolean isCheckoutOverviewPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText().equals("Checkout: Overview") && 
               getCurrentUrl().contains("checkout-step-two.html");
    }

    @Step("Finish checkout")
    public CheckoutCompletePage finishCheckout() {
        clickElement(finishButton);
        return new CheckoutCompletePage();
    }

    @Step("Get total price")
    public String getTotalPrice() {
        return totalPrice.getText();
    }
}