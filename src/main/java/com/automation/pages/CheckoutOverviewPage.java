package com.automation.pages;

import com.automation.utils.PauseUtil;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckoutOverviewPage {
    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    By overviewTitle = By.className("title");
    By finalItem = By.className("cart_item");
    By cancel = By.id("cancel");
    By finish = By.id("finish");

    public void validateTitleItem() {
        WaitUtils.waitForElement(driver, overviewTitle);
        driver.findElement(overviewTitle);
        driver.findElement(finalItem);
        PauseUtil.pause(1);
    }
    public void validateCancelFinish() {
        driver.findElement(cancel);
        PauseUtil.pause(1);
        driver.findElement(finish).click();
    }
}
