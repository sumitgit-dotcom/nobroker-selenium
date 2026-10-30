package com.nobroker.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        // YOU MUST INCLUDE BOTH THE STEPS AND HOOKS PACKAGES HERE
        glue = {"com.nobroker.test.steps", "com.nobroker.test.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}