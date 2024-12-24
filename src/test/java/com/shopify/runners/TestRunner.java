package com.shopify.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features/userSignUp.feature",
            glue = "com.shopify/stepDefinitions",
            dryRun = true,
            plugin = {"pretty", "html:target/cucumber-reports.html"},
            monochrome = true
    )
    public class TestRunner { }
