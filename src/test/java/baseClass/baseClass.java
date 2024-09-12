package baseClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class baseClass {
    public static WebDriver driver; // Static driver accessible by other classes

    public void initializeDriver() {
        // You can add ChromeOptions if needed (headless mode, etc.)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options); // Initialize the ChromeDriver
        driver.manage().window().maximize(); // Maximize the window
    }

    // Method to quit the driver
    public void closeDriver() {
        if (driver != null) {
            driver.quit(); // Quit the browser
        }
    }

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        // Create a timestamp to differentiate between screenshots
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        // Define the destination of the screenshot
        String destination = System.getProperty("user.dir") + "/screenShots/" + screenshotName + "_" + timestamp + ".png";

        // Capture screenshot and save to file
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Save screenshot to the specified destination
            FileUtils.copyFile(src, new File(destination));
            System.out.println("Screenshot saved at: " + destination);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }

        return destination; // Return the path to the screenshot
    }
}
