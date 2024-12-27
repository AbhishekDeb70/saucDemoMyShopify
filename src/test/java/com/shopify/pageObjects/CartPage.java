package com.shopify.pageObjects;

import com.shopify.utilityClasses.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    public void clickCheckOutBtn(){
        BrowserUtil.waitForElementToBeVisible(checkOutBtn, this.driver);
        checkOutBtn.click();
    }

}
