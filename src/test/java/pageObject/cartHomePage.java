package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartHomePage {

    WebDriver driver;

    public cartHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    @CacheLookup
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    @CacheLookup
    WebElement removeFromCart;

    @FindBy(xpath = "//*[@class='shopping_cart_badge']")
    @CacheLookup
    WebElement addCartValue;

    @FindBy(xpath = "//*[@class=\"shopping_cart_link\"]")
    @CacheLookup
    WebElement naviagteToCart;

    @FindBy(xpath = "//*[@class='shopping_cart_container']")
    @CacheLookup
    WebElement productEmpty;

    public void clickOnAddToCart() {
        addToCart.click();
    }

    public void clickOnRemoveCart() {
        removeFromCart.click();
    }

    public void getAddCartValue(String value) {
        addCartValue.getText().equals(value);
    }

    public void navigateToCartLink() {
        naviagteToCart.click();
    }

    public boolean checkAddedProduct() {
        return addCartValue.isDisplayed();
    }

    public boolean productEmptyCart() {
        return productEmpty.isDisplayed();
    }

    public void getCurrentUrl(String url) {
        driver.getCurrentUrl().equals(url);
    }
}
