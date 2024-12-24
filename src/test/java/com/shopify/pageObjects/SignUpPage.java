package com.shopify.pageObjects;

import com.shopify.utilityClasses.BrowserUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(name = "customer[first_name]")
    WebElement firstNameField;
    public WebElement firstNameField(){
        return firstNameField;
    }

    @FindBy(name = "customer[last_name]")
    WebElement lastNameField;
    public WebElement lastNameField(){
        return lastNameField;
    }


    @FindBy(name = "customer[email]")
    WebElement emailField;
    public WebElement emailField(){
        return emailField;
    }


    @FindBy(name = "customer[password]")
    WebElement passwordField;
    public WebElement passwordField(){
        return passwordField;
    }


    @FindBy(xpath = "//input[@value='Create']")
    WebElement createBtn;
    public WebElement createBtn(){
        return createBtn;
    }

    public void setFirstName(String firstName) {
        BrowserUtil.waitForElementToBeVisible(firstNameField, this.driver);
        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        BrowserUtil.waitForElementToBeVisible(lastNameField, this.driver);
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickCreate() {
        createBtn.click();
    }

}