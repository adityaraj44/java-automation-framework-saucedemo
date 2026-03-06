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
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");

       inventoryPage.validateInventoy();
       inventoryPage.setAddToCart().goToCartPage();
    }
}
