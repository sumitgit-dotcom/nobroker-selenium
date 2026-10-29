package com.nobroker.test.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HomePageSteps {
	
    private WebDriver driver;

    @Before
    public void setUp() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    
    @Given("I open the NoBroker website")
    public void iOpenTheNoBrokerWebsite() {
        driver.get("https://www.nobroker.in/");
    }
    
    @Then("the current URL should contain {string}")
    public void theCurrentUrlShouldContain(String expectedUrlPart) {
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrlPart),
                "URL does not contain: " + expectedUrlPart + " | Actual: " + actualUrl);
    }
    
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
