package com.shopify.utilityClasses;
import com.shopify.pageObjects.LogInPage;
import org.openqa.selenium.WebDriver;

public class LoginUtil {

    public static void performLogin(WebDriver driver, String username, String password) {
        LogInPage lp = new LogInPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickLoginBtn();
    }
}
