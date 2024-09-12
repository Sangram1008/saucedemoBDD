import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class login {

    WebDriver driver = new ChromeDriver();

    public void open() {
        driver.get("https://www.saucedemo.com/");


        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        WebElement text = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
        System.out.println(text.getText() + " " + "text.getText()");

    }

    public static void main(String []args){
        login lp = new login();
        lp.open();
    }
}
