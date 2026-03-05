package com.automation.pages;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By inventoryPage = By.id("inventory_container");
    By inventoryHeader = By.className("app_logo");
    By title = By.className("title");
    By productList = By.className("inventory_list");
    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By removeFromCart = By.id("remove-sauce-labs-backpack");

    public void validateHeader() {
        WaitUtils.waitForElement(driver, inventoryPage);
        driver.findElement(inventoryHeader);
    }
    public void validateTitle() {
        driver.findElement(title);
    }
    public void validateProductList() {
        driver.findElement(productList);
    }
    public void setAddToCart() {
        WaitUtils.waitForElement(driver, addToCart);
        driver.findElement(addToCart).click();
    }
    public void removeFromCartFromInventoryPage() {
        driver.findElement(removeFromCart).click();
    }
}
