package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
public class GridTest {
    public static void main(String[] args) {
        // Set the URL of the Selenium Grid Hub
        String hubUrl = "http://172.26.208.1:4444/wd/hub";

        // Set DesiredCapabilities (you can specify browser type, version, etc.)
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformName", "Windows 10");// Change to "firefox", "safari", etc. as needed
      try {
            // Initialize RemoteWebDriver with the Grid Hub URL and DesiredCapabilities
            WebDriver driver = new RemoteWebDriver(new URL(hubUrl), capabilities);

            // Navigate to a website
            driver.get("http://www.google.com");

            // Print the page title
            System.out.println("Page title is: " + driver.getTitle());

            // Quit the driver
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
