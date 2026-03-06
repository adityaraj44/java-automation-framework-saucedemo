package com.automation.pages;

import com.automation.utils.PauseUtil;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    By cartTitle = By.className("title");
    By cartItem = By.className("cart_item");
    By removeBtn = By.id("remove-sauce-labs-backpack");
    By continueShopping = By.id("continue-shopping");
    By checkoutBtn = By.id("checkout");

    public void validateCart() {
        WaitUtils.waitForElement(driver, cartTitle);
        driver.findElement(cartTitle);
        driver.findElement(cartItem);
        driver.findElement(removeBtn);
        driver.findElement(continueShopping);
    }

    public CheckoutPage goToCheckoutPage() {
        PauseUtil.pause(2);
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
