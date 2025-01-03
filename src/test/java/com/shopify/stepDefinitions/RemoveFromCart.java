package com.shopify.stepDefinitions;

import com.shopify.pageObjects.CartPage;
import com.shopify.pageObjects.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RemoveFromCart {

    WebDriver driver = Hooks.getDriver();
    String addToCartBtn="Add to cart";

    @When("User selects the product")
    public void user_selects_a_product(){
        HomePage hp= new HomePage(driver);
        hp.clickAddToCartBackPack();
    }

    @And("Clicks on the Cart button")
    public void clicks_on_cart_button(){
        HomePage hp= new HomePage(driver);
        hp.clickCartBtn();
    }

    @Then("User removes the product from cart")
    public void user_removes_product_from_cart(){
        CartPage cp= new CartPage(driver);
        cp.clickRemoveBtn();
    }

    @And("Clicks on ContinueShopping button")
    public void clicks_on_continueShopping_button(){
        CartPage cp= new CartPage(driver);
        cp.clickContinueShoppingBtn();
    }

    @Then("Verifies presence of Add to Cart button on the same product")
    public void verifies_presence_of_addToCart_button_on_the_same_product(){
        HomePage hp= new HomePage(driver);
        Assert.assertEquals(hp.getAddToCartBtnText(), addToCartBtn, "Error unmatch");
    }

}