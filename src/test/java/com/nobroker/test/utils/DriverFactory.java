package com.nobroker.test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class DriverFactory {

    public static WebDriver createDriver() {
        // 1. Print all system properties to see what Java actually received
        System.out.println("==================================================");
        System.out.println("DEBUG: Received 'browser' property: [" + System.getProperty("browser") + "]");
        System.out.println("==================================================");

        // 2. Fallback to "chrome" ONLY if the property is completely null
        String browser = "firefox";
        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
            System.out.println("DEBUG: Browser was null. Defaulting to Chrome.");
        } else {
            browser = browser.trim().toLowerCase();
        }

        System.out.println("DEBUG: Final Browser Selected: " + browser);

        WebDriver driver;

        switch (browser) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                driver = new FirefoxDriver(fOptions);
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                driver = new EdgeDriver(eOptions);
                break;
            case "chrome":
            default:
                ChromeOptions cOptions = new ChromeOptions();
                driver = new ChromeDriver(cOptions);
                break;
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }
}