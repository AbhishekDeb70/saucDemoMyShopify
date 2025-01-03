package com.shopify.pageObjects;

import com.shopify.utilityClasses.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackPackBtn;

    @FindBy(id = "shopping_cart_container")
    WebElement cartBtn;

    public void clickAddToCartBackPack(){
        BrowserUtil.waitForElementToBeVisible(addToCartBackPackBtn, this.driver);
        addToCartBackPackBtn.click();
    }

    public String getAddToCartBtnText(){
        return addToCartBackPackBtn.getText();
    }

    public void clickCartBtn(){
        cartBtn.click();
    }
}