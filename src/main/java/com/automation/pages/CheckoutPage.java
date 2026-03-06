package com.automation.pages;

import com.automation.utils.PauseUtil;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By title = By.className("title");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueCheckout = By.id("continue");

    public CheckoutPage validateCheckoutPageAndFields(String fName, String lname, String pcode) {
        WaitUtils.waitForElement(driver, title);
        driver.findElement(title);
        driver.findElement(firstName).sendKeys(fName);

        driver.findElement(lastName).sendKeys(lname);

        driver.findElement(postalCode).sendKeys(pcode);
        return this;
    }

    public CheckoutOverviewPage checkout() {
        driver.findElement(continueCheckout).click();
        return new CheckoutOverviewPage(driver);
    }
}
