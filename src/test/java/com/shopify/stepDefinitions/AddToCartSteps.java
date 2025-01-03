package com.shopify.stepDefinitions;

import com.shopify.pageObjects.CartPage;
import com.shopify.pageObjects.CheckOutPage;
import com.shopify.pageObjects.HomePage;
import com.shopify.utilityClasses.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddToCartSteps {

    WebDriver driver= Hooks.getDriver();
    String expectedAmount = "$29.99";
    String orderConfMsg ="Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    @When("User selects a product")
    public void user_selects_a_product(){
        HomePage hp= new HomePage(driver);
        hp.clickAddToCartBackPack();
    }

    @And("Clicks on Cart button")
    public void clicks_on_cart_button(){
        HomePage hp= new HomePage(driver);
        hp.clickCartBtn();
    }

    @Then("User clicks on Checkout")
    public void user_clicks_on_checkout(){
        CartPage cp= new CartPage(driver);
        cp.clickCheckOutBtn();
    }

    @And("Enters the firstName lastName and postalCode")
    public void enters_the_firstName_lastName_and_postalCode(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        chkpg.setFirstNameField(ConfigReader.get("FIRSTNAME"));
        chkpg.setLastNameField(ConfigReader.get("LASTNAME"));
        chkpg.setPostalCode(ConfigReader.get("ZIPCODE"));
    }

    @And("Clicks on continue")
    public void clicks_on_continue(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        chkpg.clickContinueBtn();
    }

    @Then("Verifies the total amount and clicks on finish")
    public void verifies_the_total_amount_and_clicks_on_finish(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        Assert.assertEquals(expectedAmount, chkpg.getTotalPrice());
        chkpg.clickFinishBtn();
    }

    @Then("Verifies the order success message")
    public void verifies_the_order_success_message(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        Assert.assertEquals(orderConfMsg, chkpg.getOrderSuccessMsg());
    }

}