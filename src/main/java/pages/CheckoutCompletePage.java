package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    @FindBy(className = "complete-text")
    private WebElement completeText;

    @Step("Check if checkout complete page is loaded")
    public boolean isCheckoutCompletePageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(completeHeader));
        return getCurrentUrl().contains("checkout-complete.html");
    }

    @Step("Get completion message")
    public String getCompletionMessage() {
        return completeHeader.getText();
    }

    @Step("Get completion description")
    public String getCompletionDescription() {
        return completeText.getText();
    }
}