package com.shopify.pageObjects;

import com.shopify.utilityClasses.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    WebDriver driver;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public void setUserName(String userName) {
        BrowserUtil.waitForElementToBeVisible(userNameField, this.driver);
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(userName);
    }

    public void setPassword(String password) {
        BrowserUtil.waitForElementToBeVisible(passwordField, this.driver);
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginButton.click();
    }
}
