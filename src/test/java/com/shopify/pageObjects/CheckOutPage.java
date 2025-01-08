package com.shopify.pageObjects;

import com.shopify.utilityClasses.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckOutPage {

    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(css = "[class='inventory_item_price']")
    WebElement totalLabel;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(css = "[class='complete-text']")
    WebElement orderSuccessMsg;

    @FindBy(css = "[class='inventory_item_price']")
    List<WebElement> productPrices;

    @FindBy(css = "[class='summary_tax_label']")
    WebElement taxAmount;

    @FindBy(css = "[class='summary_total_label']")
    WebElement totalPrice;

    public void setFirstNameField(String firstName){
        BrowserUtil.waitForElementToBeVisible(firstNameField, this.driver);
        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName){
        BrowserUtil.waitForElementToBeVisible(lastNameField, this.driver);
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setPostalCode(String postalCode){
        BrowserUtil.waitForElementToBeVisible(postalCodeField, this.driver);
        postalCodeField.click();
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }

    public String getTotalPrice() {
        BrowserUtil.waitForElementToBeVisible(totalLabel, this.driver);
        return totalLabel.getText();
    }

    public void clickFinishBtn(){
        finishBtn.click();
    }

    public String getOrderSuccessMsg() {
        BrowserUtil.waitForElementToBeVisible(orderSuccessMsg, this.driver);
        return orderSuccessMsg.getText();
    }

    public List<Double> getCartProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            prices.add(Double.parseDouble(priceElement.getText().replace("$", "").trim()));
        }
        return prices;
    }

    public double getTaxAmount() {
        return Double.parseDouble(taxAmount.getText().replace("Tax: $", "").trim());
    }

    public double getDisplayedTotalPrice() {
        return Double.parseDouble(totalPrice.getText().replace("Total: $", "").trim());
    }

}
