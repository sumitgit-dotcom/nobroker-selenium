package com.nobroker.test.steps;

import com.nobroker.test.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    // Force it to use the Singleton
    private final ScenarioContext context = ScenarioContext.getInstance();

    private WebDriver driver() {
        WebDriver d = context.getDriver();
        System.out.println("DEBUG: Driver in LoginSteps is: " + d);
        return d;
    }

    private WebDriverWait waitFor() {
        return new WebDriverWait(driver(), Duration.ofSeconds(15));
    }

    @When("I click on the Login button in the header")
    public void iClickOnTheLoginButtonInTheHeader() {
        By loginBtnLocator = By.xpath("//div[@class='px-1p border-l-1 border-l-solid border-l-header-grey cursor-pointer']");
        WebElement loginBtn = waitFor().until(ExpectedConditions.presenceOfElementLocated(loginBtnLocator));
        ((JavascriptExecutor) driver()).executeScript("arguments[0].click();", loginBtn);
        System.out.println("Clicked on the Login button.");
    }

    @And("I enter the phone number {string} in the login modal")
    public void iEnterThePhoneNumberInTheLoginModal(String phoneNumber) {
        By phoneInputLocator = By.xpath("//input[@id='signUp-phoneNumber']");
        WebElement phoneInput = waitFor().until(ExpectedConditions.visibilityOfElementLocated(phoneInputLocator));
        phoneInput.sendKeys(phoneNumber);
        System.out.println("Entered phone number: " + phoneNumber);
    }

    @Then("I toggle the {string} switch off")
    public void iToggleTheSwitchOff(String switchName) {
        By toggleLocator = By.xpath("//div[@class='nb-switch-toggle xs']");
        WebElement toggle = waitFor().until(ExpectedConditions.presenceOfElementLocated(toggleLocator));
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", toggle);
        ((JavascriptExecutor) driver()).executeScript("arguments[0].click();", toggle);
        System.out.println("Toggled the switch: " + switchName);
    }
}