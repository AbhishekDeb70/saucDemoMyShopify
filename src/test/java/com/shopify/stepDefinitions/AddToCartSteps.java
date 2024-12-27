package com.shopify.stepDefinitions;

import com.shopify.pageObjects.CartPage;
import com.shopify.pageObjects.CheckOutPage;
import com.shopify.pageObjects.HomePage;
import com.shopify.pageObjects.LogInPage;
import com.shopify.utilityClasses.BrowserUtil;
import com.shopify.utilityClasses.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddToCartSteps {

    WebDriver driver;
    LogInPage lp;
    HomePage hp;
    CartPage cp;
    CheckOutPage chkpg;
    String expectedAmount = "$29.99";
    String orderConfMsg ="Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    @Given("User launches the browser")
    public void user_launches_the_browser() {
        driver = BrowserUtil.getDriver(ConfigReader.get("BROWSER"));
        lp= new LogInPage(driver);
        hp= new HomePage(driver);
        cp= new CartPage(driver);
        chkpg= new CheckOutPage(driver);
        System.out.println(ConfigReader.get("BROWSER") + " browser launched!");
        driver.manage().window().maximize();
    }

    @When("User opens URL")
    public void user_opens_URL() {
        driver.get(ConfigReader.get("BASE_URL"));
    }

    @And("User enters email and password")
    public void user_enters_email_and_password() {
        lp.setUserName(ConfigReader.get("USERNAME"));
        lp.setPassword(ConfigReader.get("PASSWORD"));
    }

    @And("Clicks on Login")
    public void clicks_on_login(){
        lp.clickLoginBtn();
    }

    @Then("User selects a product")
    public void user_selects_a_product(){
        hp.clickAddToCartBackPack();
    }

    @And("Clicks on Cart button")
    public void clicks_on_cart_button(){
        hp.clickCartBtn();
    }

    @Then("User clicks on Checkout")
    public void user_clicks_on_checkout(){
        cp.clickCheckOutBtn();
    }

    @And("Enters the firstName lastName and postalCode")
    public void enters_the_firstName_lastName_and_postalCode(){
        chkpg.setFirstNameField(ConfigReader.get("FIRSTNAME"));
        chkpg.setLastNameField(ConfigReader.get("LASTNAME"));
        chkpg.setPostalCode(ConfigReader.get("ZIPCODE"));
    }

    @And("Clicks on continue")
    public void clicks_on_continue(){
        chkpg.clickContinueBtn();
    }

    @Then("Verifies the total amount and clicks on finish")
    public void verifies_the_total_amount_and_clicks_on_finish(){
        Assert.assertEquals(expectedAmount, chkpg.getTotalPrice());
        chkpg.clickFinishBtn();
    }

    @Then("Verifies the order success message")
    public void verifies_the_order_success_message(){
        Assert.assertEquals(orderConfMsg, chkpg.getOrderSuccessMsg());
    }

    @And("Close browser")
    public void close_browser(){
        driver.quit();
    }

}
