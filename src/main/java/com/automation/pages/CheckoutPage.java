package com.automation.pages;

import com.automation.utils.PauseUtil;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver=driver;
    }

    By title = By.className("title");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueCheckout = By.id("continue");

    public void validateCheckoutPageAndFields(String fName, String lname, String pcode) {
        WaitUtils.waitForElement(driver, title);
        driver.findElement(title);
        PauseUtil.pause(1);
        driver.findElement(firstName).sendKeys(fName);
        PauseUtil.pause(1);
        driver.findElement(lastName).sendKeys(lname);
        PauseUtil.pause(1);
        driver.findElement(postalCode).sendKeys(pcode);
    }

    public void checkout() {
        PauseUtil.pause(1);
        driver.findElement(continueCheckout).click();
    }
}
