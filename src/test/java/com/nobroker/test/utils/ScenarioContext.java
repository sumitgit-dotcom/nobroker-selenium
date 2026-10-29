package com.nobroker.test.utils;

import org.openqa.selenium.WebDriver;

public class ScenarioContext {
    // 1. Create a single shared instance of this class
    private static final ScenarioContext instance = new ScenarioContext();

    // 2. Provide a way to get that instance
    public static ScenarioContext getInstance() {
        return instance;
    }

    private WebDriver driver;

    // 3. Make the constructor private so nobody else can create a new one
    private ScenarioContext() {}

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}