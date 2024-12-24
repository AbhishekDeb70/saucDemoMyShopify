package com.shopify.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Sign up']")
    WebElement signUpBtn;
    public WebElement signUpBtn(){
        return signUpBtn;
    }

    public void clickSignUp() {
        signUpBtn.click();
    }

}