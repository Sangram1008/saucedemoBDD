package stepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.cartHomePage;
import pageObject.logInPage;
import baseClass.baseClass;

import java.time.Duration;


public class placeOrder extends baseClass {

    logInPage lp = new logInPage(driver);
    cartHomePage cp = new cartHomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private String thankYouText = "Thank you for your order!";
    private String orderPlacedText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

//    @Given("I am on the product page")
//    public void i_am_on_the_product_page() {
//        lp.setUserName("problem_user");
//        lp.setPassWord("secret_sauce");
//        lp.clickOnLogIn();
//    }

    @When("User adds a product to the cart")
    public void user_adds_a_product_to_the_cart() {
        cp.clickOnAddToCart();
    }

    @Then("User clicks to navigate to the Your Cart page")
    public void user_clicks_to_navigate_to_the_your_cart_page() {
        cp.navigateToCartLink();
    }

    @Then("User clicks on the Checkout button")
    public void user_clicks_on_the_checkout_button() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("User fills in the FirstName Last and ZipCode on Checkout: Your Information form")
    public void user_fills_in_the_first_name_last_and_zip_code_on_checkout_your_information_form() {

        WebElement enterFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        enterFirstName.clear();
        enterFirstName.sendKeys("Sangram");

        WebElement enterLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
        enterLastName.clear();
        enterLastName.sendKeys("Magdum");

        WebElement zipCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='postal-code']")));
        zipCode.clear();
        zipCode.sendKeys("4123123");

    }

    @Then("clicks on Continue")
    public void clicks_on_continue() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
        baseClass.takeScreenshot(driver, "Information Form");
    }

    @Then("User clicks on Finish on the Checkout: Overview page")
    public void user_clicks_on_finish_on_the_checkout_overview_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"finish\"]"))).click();
    }

    @Then("User sees the order successful message")
    public void user_sees_the_order_successful_message() {
        WebElement thankYou = driver.findElement(By.xpath("//*[@class='complete-header'])"));
        thankYou.getText().equals(thankYouText);

        WebElement orderPlace = driver.findElement(By.xpath("//*[@class='complete-text']"));
        orderPlace.getText().equals(orderPlacedText);
    }
}
