package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;


public class CartPageTest extends BaseTest {

    @Test
    public void cartPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.login("standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.setAddToCart();
        inventoryPage.goToCartPage();

        CartPage cartPage = new CartPage(driver);
        cartPage.validateTitle();
        cartPage.validateCartItem();
        cartPage.validateItems();
        cartPage.goToCheckoutPage();
    }


}
