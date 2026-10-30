package com.nobroker.test.steps;

import com.nobroker.test.utils.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageSteps {

    private final ScenarioContext context = ScenarioContext.getInstance();

    private WebDriver driver() {
        return context.getDriver();
    }

    @Given("I open the NoBroker website")
    public void iOpenTheNoBrokerWebsite() {
        driver().get("https://www.nobroker.in/");
    }

    @Then("the current URL should contain {string}")
    public void theCurrentUrlShouldContain(String expectedUrlPart) {
        String actualUrl = driver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlPart));
    }
}