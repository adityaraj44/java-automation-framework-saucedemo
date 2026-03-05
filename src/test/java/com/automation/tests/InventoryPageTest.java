package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest{
    @Test
    public void inventoryPageTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.login("standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.validateHeader();
        inventoryPage.validateTitle();
        inventoryPage.validateProductList();
        inventoryPage.setAddToCart();
        inventoryPage.removeFromCartFromInventoryPage();
        inventoryPage.setAddToCart();
        System.out.println("Header and Title are validated successfully");
    }
}
