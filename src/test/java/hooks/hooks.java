package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import baseClass.baseClass;
import java.time.Duration;


public class hooks extends baseClass {

    @Before
    public void setUp() {
        initializeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("In After Method");
        }
    }
}
