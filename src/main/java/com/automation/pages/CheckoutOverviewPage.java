package com.automation.pages;

import com.automation.utils.PauseUtil;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage{

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    By overviewTitle = By.className("title");
    By finalItem = By.className("cart_item");
    By cancel = By.id("cancel");
    By finish = By.id("finish");

    public void validateTitleItem() {
        WaitUtils.waitForElement(driver, overviewTitle);
        driver.findElement(overviewTitle);
        driver.findElement(finalItem);
    }
    public OrderCompletePage validateCancelFinish() {
        driver.findElement(cancel);
        driver.findElement(finish).click();
        return new OrderCompletePage(driver);
    }
}
