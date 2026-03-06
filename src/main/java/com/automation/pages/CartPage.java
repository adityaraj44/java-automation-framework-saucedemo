package com.automation.pages;

import com.automation.utils.PauseUtil;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartTitle = By.className("title");
    By cartItem = By.className("cart_item");
    By removeBtn = By.id("remove-sauce-labs-backpack");
    By continueShopping = By.id("continue-shopping");
    By checkoutBtn = By.id("checkout");

    public void validateTitle() {
        WaitUtils.waitForElement(driver, cartTitle);
        driver.findElement(cartTitle);
    }

    public void validateCartItem() {
        driver.findElement(cartItem);
    }

    public void validateItems() {
        driver.findElement(removeBtn);
        driver.findElement(continueShopping);
    }

    public void goToCheckoutPage() {
        PauseUtil.pause(2);
        driver.findElement(checkoutBtn).click();
    }
}
