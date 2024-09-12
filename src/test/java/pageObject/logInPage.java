package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logInPage {

    WebDriver driver;

    // Constructor that takes WebDriver as an argument
    public logInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Ensure this is called with the correct driver
    }

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passWord;

    @FindBy(id = "login-button")
    WebElement logInBtn;

    @FindBy(className = "login_logo")
    WebElement logText;

    @FindBy(className = "error-button")
    WebElement errorTextElement;

    public void setUserName(String userNameValue) {
        userName.sendKeys(userNameValue);  // Ensure this element is not null
    }

    public void setPassWord(String passWordValue) {
        passWord.sendKeys(passWordValue);
    }

    public void clickOnLogIn() {
        logInBtn.click();
    }

    public void checkErrorPage(String errorMsg) {
        String actualError = errorTextElement.getText();
        actualError.equals(errorMsg);
    }
}
