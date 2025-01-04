package com.shopify.stepDefinitions;

import com.shopify.pageObjects.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SortFunctionalitySteps {

    WebDriver driver = Hooks.getDriver();
    String expectedHighestAmt = "$49.99";

    @When("User clicks on Sorting menu")
    public void user_clicks_on_sorting_menu(){
        HomePage hp= new HomePage(driver);
        hp.clickSortBtn();
    }

    @And("Sets the price from High to Low")
    public void sets_price_from_high_to_low(){
        HomePage hp= new HomePage(driver);
        hp.selectFilterHighToLow();
    }

    @Then("Verifies the price of the costliest product")
    public void verifies_price_of_the_costliest_product(){
        HomePage hp= new HomePage(driver);
        Assert.assertEquals(hp.verifyHighestAmt(), expectedHighestAmt);
    }
}
