package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private WebDriver driver;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventory;
    @FindBy(className = "product_sort_container")
    private static WebElement sortDropdown;
    @FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private static  WebElement AddToCart;
    @FindBy (xpath = "//a[@class='shopping_cart_link']")
    private WebElement CartItemNumber;

    public ProductPage (WebDriver driver){
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }


 public int GetCartItemsNumber (){
  return Integer.parseInt(CartItemNumber.getText());

 }
    public  void sortByPriceLowToHigh() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price (low to high)");


    }
    public void buyItem(){
        WebElement firstItem = inventory.getFirst();
        WebElement addToCartButton = firstItem.findElement(By.xpath(".//button[contains(text(), 'Add to cart')]"));
        addToCartButton.click();
    }


}

