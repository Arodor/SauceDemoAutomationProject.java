package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @Step("Check if checkout page is loaded")
    public boolean isCheckoutPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText().equals("Checkout: Your Information") && 
               getCurrentUrl().contains("checkout-step-one.html");
    }

    @Step("Fill checkout information")
    public CheckoutPage fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        clearAndType(firstNameField, firstName);
        clearAndType(lastNameField, lastName);
        clearAndType(postalCodeField, postalCode);
        return this;
    }

    @Step("Continue to checkout overview")
    public CheckoutOverviewPage continueToOverview() {
        clickElement(continueButton);
        return new CheckoutOverviewPage();
    }

    @Step("Get page title")
    public String getPageTitle() {
        return pageTitle.getText();
    }
}