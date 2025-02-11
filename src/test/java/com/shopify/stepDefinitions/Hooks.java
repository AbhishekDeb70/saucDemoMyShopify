package com.shopify.stepDefinitions;

import com.shopify.utilityClasses.BrowserUtil;
import com.shopify.utilityClasses.ConfigReader;
import com.shopify.utilityClasses.LoginUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
public class Hooks {

    private WebDriver driver;

    @Before
    public void setupAndLogin() {
        // Initialize WebDriver
            driver = BrowserUtil.getDriver(ConfigReader.get("BROWSER"));
            driver.manage().window().maximize();
            driver.get(ConfigReader.get("BASE_URL"));
            // Perform login
            LoginUtil.performLogin(driver, ConfigReader.get("USERNAME"), ConfigReader.get("PASSWORD"));
    }

    @After
    public void closeBrowser(){
        BrowserUtil.closeDriver();
    }

    public static WebDriver getDriver() {
        return BrowserUtil.getDriver(ConfigReader.get("BROWSER"));
    }
}