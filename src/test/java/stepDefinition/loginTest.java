package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.logInPage;
import baseClass.baseClass;

public class loginTest extends baseClass {
    logInPage lp = new logInPage(driver);
    private String errorMessage = "Epic sadface: Username and password do not match any user in this service";

    @When("the user enters valid username {string}")
    public void the_user_enters_valid_username(String string) {
        lp.setUserName(string);
    }

    @When("the user enters valid password {string}")
    public void the_user_enters_valid_password(String string) {
        lp.setPassWord(string);
    }

    @Then("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        lp.clickOnLogIn();
    }

    @When("the user enters invalid password {string}")
    public void the_user_enters_invalid_password(String string) {
        lp.setPassWord(string);
    }

    @Then("an error message is displayed on the screen")
    public void an_error_message_is_displayed_on_the_screen() {
        lp.checkErrorPage(errorMessage);
    }

    @When("the user enters invalid username {string}")
    public void the_user_enters_invalid_username(String string) {
        lp.setUserName(string);
    }

}
