package com.shopify.runners;

import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/test/resources/features/addToCart.feature",
            glue = {"com.shopify/stepDefinitions"},
            dryRun = true,
            plugin = {"pretty", "html:target/cucumber-reports.html"},
            monochrome = true
    )
    public class TestRunner { }
