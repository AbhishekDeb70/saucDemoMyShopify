package com.shopify.pageObjects;

import com.shopify.utilityClasses.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackPackBtn;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addToCartBikeLightBtn;

    @FindBy(id = "shopping_cart_container")
    WebElement cartBtn;

    @FindBy(css = "[data-test='product-sort-container']")
    WebElement sortBtn;

   @FindBy(css = "[value='hilo']")
   WebElement filterHighToLow;

    @FindBy(css = ".inventory_item_price")
    List<WebElement> productPrices;

    public void clickAddToCartBackPack(){
        BrowserUtil.waitForElementToBeVisible(addToCartBackPackBtn, this.driver);
        addToCartBackPackBtn.click();
    }

    public void clickAddToCartBikeLight(){
        addToCartBikeLightBtn.click();
    }

    public String getAddToCartBtnText(){
        return addToCartBackPackBtn.getText();
    }

    public void clickCartBtn(){
        cartBtn.click();
    }

    public void clickSortBtn(){
        BrowserUtil.waitForElementToBeVisible(sortBtn, this.driver);
        sortBtn.click();
    }

    public void selectFilterHighToLow(){
        BrowserUtil.waitForElementToBeVisible(filterHighToLow, this.driver);
        filterHighToLow.click();
    }

    public List<Double> getAllProductPrices(){
        return productPrices
                .stream()
                .map(priceElement->Double.parseDouble(priceElement.getText().replace("$", "")))
                .collect(Collectors.toList());
    }
}