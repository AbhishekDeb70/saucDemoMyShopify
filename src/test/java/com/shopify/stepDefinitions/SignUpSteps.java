package com.shopify.stepDefinitions;

import com.shopify.pageObjects.HomePage;
import com.shopify.pageObjects.SignUpPage;
import com.shopify.utilityClasses.BrowserUtil;
import com.shopify.utilityClasses.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpSteps {
     WebDriver driver;
     SignUpPage sp;
     HomePage hp;

    @Given("User launches the browser")
    public void user_launches_the_browser() {
        driver = BrowserUtil.getDriver(ConfigReader.get("BROWSER"));
        sp= new SignUpPage(driver);
        hp= new HomePage(driver);
        System.out.println(ConfigReader.get("BROWSER") + " browser launched!");
        driver.manage().window().maximize();
    }

    @When("User opens URL")
    public void user_opens_URL() {
        driver.get(ConfigReader.get("BASE_URL"));
    }

    @And("Clicks on SignUp")
    public void click_on_signUp() {
        Assert.assertTrue(hp.signUpBtn().isDisplayed());
        hp.clickSignUp();
    }

   @When("User enters the new user details")
    public void user_enters_the_new_user_details() {
        sp.setFirstName(ConfigReader.get("FIRSTNAME"));
        Assert.assertEquals(ConfigReader.get("FIRSTNAME"),sp.firstNameField().getText());
        sp.setLastName(ConfigReader.get("LASTNAME"));
        Assert.assertEquals(ConfigReader.get("LASTNAME"),sp.lastNameField().getText());
        sp.setEmail(ConfigReader.get("EMAIL"));
        Assert.assertEquals(ConfigReader.get("EMAIL"),sp.emailField().getText());
        sp.setPassword(ConfigReader.get("PASSWORD"));
        Assert.assertEquals(ConfigReader.get("PASSWORD"),sp.passwordField().getText());
    }

    @And("Clicks on Create")
    public void click_on_create() {
        Assert.assertTrue(sp.createBtn().isDisplayed());
        sp.clickCreate();
    }

    @And("Close browser")
    public void close_browser() {
        driver.quit();
    }

}