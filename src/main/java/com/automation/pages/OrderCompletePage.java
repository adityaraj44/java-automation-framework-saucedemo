package com.automation.pages;

import com.automation.utils.PauseUtil;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class OrderCompletePage extends BasePage {

    public OrderCompletePage(WebDriver driver) {
        super(driver);
    }

    By completeMsg = By.className("complete-header");
    By backToHome = By.id("back-to-products");
    By home = By.id("inventory_container");

    public void successValidate() {
        WaitUtils.waitForElement(driver, completeMsg);
        driver.findElement(completeMsg);
    }

    public void goToHome() {
        PauseUtil.pause(2);
        driver.findElement(backToHome).click();
    }

    public InventoryPage validateHome() {
        WaitUtils.waitForElement(driver, home);
        PauseUtil.pause(2);
        driver.findElement(home);
        return new InventoryPage(driver);
    }
}
