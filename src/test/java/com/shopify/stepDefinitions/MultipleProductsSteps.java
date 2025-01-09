package com.shopify.stepDefinitions;

import com.shopify.pageObjects.CartPage;
import com.shopify.pageObjects.CheckOutPage;
import com.shopify.pageObjects.HomePage;
import com.shopify.utilityClasses.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class MultipleProductsSteps {

    WebDriver driver= Hooks.getDriver();
    List<Double> selectedProductPrices;
    double calculatedTotal;
    String orderConfMsg ="Your order has been dispatched, and will arrive just as fast as the pony can get there!";


    @When("User selects multiple products")
    public void user_selects_multiple_products(){
        HomePage hp= new HomePage(driver);
        hp.clickAddToCartBackPack();
        hp.clickAddToCartBikeLight();
    }

    @And("Clicks on shopping cart button")
    public void clicks_on_shopping_cart_button(){
        HomePage hp= new HomePage(driver);
        hp.clickCartBtn();
    }

    @Then("Clicks on checkout button")
    public void clicks_on_checkout_button(){
        CartPage cp= new CartPage(driver);
        cp.clickCheckOutBtn();
    }

    @And("Enters the necessary details")
    public void enters_the_necessary_details(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        chkpg.setFirstNameField(ConfigReader.get("FIRSTNAME"));
        chkpg.setLastNameField(ConfigReader.get("LASTNAME"));
        chkpg.setPostalCode(ConfigReader.get("ZIPCODE"));
    }

    @And("Clicks on continue button")
    public void clicks_on_continue_button(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        chkpg.clickContinueBtn();
    }

    @Then("Verifies the total cart amount")
    public void verifies_the_total_cart_amount(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        selectedProductPrices = chkpg.getCartProductPrices();
        double sumOfPrices = selectedProductPrices.stream().mapToDouble(Double::doubleValue).sum();
        double tax = chkpg.getTaxAmount();
        double displayedTotal = chkpg.getDisplayedTotalPrice();
        calculatedTotal = sumOfPrices + tax;
        Assert.assertEquals(displayedTotal, calculatedTotal, "The displayed total price does not match the calculated total.");
    }

    @And("Clicks on finish button")
    public void clicks_on_finish_button(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        chkpg.clickFinishBtn();
    }

    @Then("Verifies order success message")
    public void verifies_order_success_message(){
        CheckOutPage chkpg= new CheckOutPage(driver);
        Assert.assertEquals(orderConfMsg, chkpg.getOrderSuccessMsg());
    }
}
