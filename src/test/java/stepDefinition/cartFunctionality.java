package stepDefinition;

import baseClass.baseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.cartHomePage;
import pageObject.logInPage;

import java.util.List;

public class cartFunctionality extends baseClass {

    logInPage lp = new logInPage(driver);

    cartHomePage cp = new cartHomePage(driver);

    private String addCartPageUrl = "https://www.saucedemo.com/cart.html";

    private final String pirceValueText = "$29.99";

    @Given("I am on the product page")
    public void i_am_on_the_product_page() {
        lp.setUserName("problem_user");
        lp.setPassWord("secret_sauce");
        lp.clickOnLogIn();
    }

    @When("I click the Add to Cart button")
    public void i_click_the_add_to_cart_button() {
        cp.clickOnAddToCart();
    }

    @Then("the cart quantity should increase by 1")
    public void the_cart_quantity_should_increase_by() {
        cp.getAddCartValue("1");
    }

    @Then("the product should be displayed in the cart summary")
    public void the_product_should_be_displayed_in_the_cart_summary() {
        cp.checkAddedProduct();
    }

    @When("I have a product in my cart")
    public void i_have_a_product_in_my_cart() {
        cp.clickOnAddToCart();
        cp.getAddCartValue("1");
    }

    @When("I click the Remove button for that product")
    public void i_click_the_remove_button_for_that_product() {
        cp.clickOnRemoveCart();
    }

    @Then("the product should be removed from the cart")
    public void the_product_should_be_removed_from_the_cart() {
        cp.clickOnRemoveCart();
    }

    @Then("the cart quantity should decrease by 0")
    public void the_cart_quantity_should_decrease_by() {
        cp.productEmptyCart();
    }

    @When("I add multiple products to the cart")
    public void i_add_multiple_products_to_the_cart() {
        List<WebElement> addMultipleProduct = driver.findElements(By.xpath("//*[text()='Add to cart']"));

        for (WebElement product : addMultipleProduct) {
            product.click();
        }
    }

    @Then("the cart quantity should reflect the total number of added products")
    public void the_cart_quantity_should_reflect_the_total_number_of_added_products() {
        cp.getAddCartValue("6");
    }

    @When("I remove all products from the cart")
    public void i_remove_all_products_from_the_cart() {
        List<WebElement> removeAllProducts = driver.findElements(By.xpath("//*[text()='Remove']"));

        for (WebElement removeAllProduct : removeAllProducts) {
            removeAllProduct.click();
        }
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        cp.productEmptyCart();
    }

    @When("I click the Add to Cart icon in the header")
    public void i_click_the_add_to_cart_icon_in_the_header() {
        cp.navigateToCartLink();
    }

    @Then("I should be redirected to the cart page")
    public void i_should_be_redirected_to_the_cart_page() {
        driver.getCurrentUrl().equals(addCartPageUrl);
    }

    @Then("the product should be displayed in the cart with the correct quantity and price")
    public void the_product_should_be_displayed_in_the_cart_with_the_correct_quantity_and_price() {
        WebElement getQty = driver.findElement(By.xpath("//*[@class=\"cart_quantity\"]"));
        getQty.getText().equals("1");
        WebElement getPrice = driver.findElement(By.xpath("//*[@class='inventory_item_price']"));
        getPrice.getText().equals(pirceValueText);
    }
}
