package com.shopify.stepDefinitions;

import com.shopify.pageObjects.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class SortFunctionalitySteps {

    WebDriver driver = Hooks.getDriver();

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

    @Then("Verifies the price of the product in sorted fashion")
    public void verifies_price_of_the_product_in_sorted_fashion(){
        HomePage hp= new HomePage(driver);
        List<Double> actualPrices = hp.getAllProductPrices();
        double lastPrice = actualPrices.get(0);
        for (Double price:actualPrices){
            Assert.assertTrue(lastPrice>=price);
            lastPrice=price;
        }
    }
}
