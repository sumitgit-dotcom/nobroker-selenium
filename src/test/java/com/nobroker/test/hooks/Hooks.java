package com.nobroker.test.hooks;

import com.nobroker.test.utils.DriverFactory;
import com.nobroker.test.utils.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    // Force it to use the Singleton
    private final ScenarioContext context = ScenarioContext.getInstance();

    @Before(order = 0)
    public void launchBrowser(Scenario scenario) {
        System.out.println("===== START: " + scenario.getName() + " =====");
        WebDriver driver = DriverFactory.createDriver();
        context.setDriver(driver); 
        System.out.println("DEBUG: Driver set in Context: " + driver);
    }

    @After(order = 0)
    public void closeBrowser(Scenario scenario) {
        WebDriver driver = context.getDriver();
        if (driver != null) {
            driver.quit();
            context.setDriver(null);
        }
        System.out.println("===== END: " + scenario.getName() + " =====");
    }
}