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
import org.testng.Assert;

import java.time.Duration;

public class SearchSteps {

    private final ScenarioContext context;

    public SearchSteps() {
        this.context = ScenarioContext.getInstance();
    }

    // Helper method to get the driver ONLY when a step is actually executing
    private WebDriver driver() {
        return context.getDriver();
    }
    
    // Helper method to create the wait dynamically
    private WebDriverWait waitFor() {
        return new WebDriverWait(driver(), Duration.ofSeconds(15));
    }

    @When("I click on the {string} tab")
    public void iClickOnTheTab(String tabName) {
        By tabLocator = By.xpath("//div[@class='cursor-pointer text-primary-color border-0 border-b-4 border-solid border-primary-color font-bold']");
        waitFor().until(ExpectedConditions.elementToBeClickable(tabLocator)).click();
        System.out.println("Clicked on tab: " + tabName);
    }

    @And("I click on the {string} property type")
    public void iClickOnThePropertyType(String propertyType) {
        By typeLocator = By.xpath("//body/div[@id='app']/div[@class='app-wrapper ']/div[@class=' mt-5p po:mb-5.5p']/div[@class='pt-3p px-2p pb-3p tpu:h-content']/div[@class='nb__1Qq92']/div[1]/div[1]/div[1]/div[1]");
        waitFor().until(ExpectedConditions.elementToBeClickable(typeLocator)).click();
        System.out.println("Clicked on property type: " + propertyType);
    }

    @And("I select the {string} filter")
    public void iSelectTheFilter(String filterName) {
        By filterLocator = By.xpath("//div[@class='css-dvua67-singleValue nb-select__single-value']");
        
        WebElement element = waitFor().until(ExpectedConditions.presenceOfElementLocated(filterLocator));
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView(true);", element);
        
        waitFor().until(ExpectedConditions.elementToBeClickable(filterLocator)).click();
        System.out.println("Selected filter: " + filterName);
    }

    @And("I type {string} into the search locality")
    public void iTypeIntoTheSearchLocality(String locality) {
        By inputLocator = By.xpath("//input[@id='listPageSearchLocality']");
        
        WebElement inputField = waitFor().until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        inputField.clear();
        inputField.sendKeys(locality);
        
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        By firstSuggestion = By.xpath("//div[contains(@class, 'nb-select__option')]");
        try {
            waitFor().until(ExpectedConditions.elementToBeClickable(firstSuggestion)).click();
        } catch (Exception e) {
            System.out.println("No autocomplete suggestion appeared, proceeding to search.");
        }
        System.out.println("Typed locality: " + locality);
    }

    @And("I click on the search icon")
    public void iClickOnTheSearchIcon() {
        By searchIcon = By.xpath("//img[@alt='searchIcon']");
        waitFor().until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
        System.out.println("Clicked on Search Icon.");
    }

    @Then("the search results page should load")
    public void theSearchResultsPageShouldLoad() {
        waitFor().until(ExpectedConditions.urlContains("property"));
        
        String currentUrl = driver().getCurrentUrl();
        System.out.println("Search Results URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("safdarjung"), "URL does not contain the searched locality.");
    }
}