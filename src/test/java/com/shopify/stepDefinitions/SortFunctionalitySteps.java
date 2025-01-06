package com.shopify.stepDefinitions;

import com.shopify.pageObjects.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;

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
        double[] actualPrices = hp.getAllProductPrices();
        double[] sortedPrices = Arrays.copyOf(actualPrices, actualPrices.length);
        Arrays.sort(sortedPrices);
        for (int i = 0; i < sortedPrices.length / 2; i++) {
            double temp = sortedPrices[i];
            sortedPrices[i] = sortedPrices[sortedPrices.length - i - 1];
            sortedPrices[sortedPrices.length - i - 1] = temp;
        }
        Assert.assertTrue(Arrays.equals(actualPrices, sortedPrices), "Product prices are not sorted from High to Low!");
    }
}
