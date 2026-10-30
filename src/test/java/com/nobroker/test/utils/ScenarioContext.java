package com.nobroker.test.utils;

import org.openqa.selenium.WebDriver;

public class ScenarioContext {
    private static final ScenarioContext instance = new ScenarioContext();
    private WebDriver driver;

    private ScenarioContext() {}

    public static ScenarioContext getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}