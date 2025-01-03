package com.shopify.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
            features = "src/test/resources/features",
            glue = {"com.shopify.stepDefinitions"},
            dryRun = false,
            plugin = {"pretty", "html:target/cucumber-reports.html" },
            monochrome = true
    )

@Listeners({AllureTestNg.class})
public class TestRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}