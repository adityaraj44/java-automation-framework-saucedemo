package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.*;
import org.testng.annotations.Test;

public class CheckoutOverviewPageTest extends BaseTest {

    @Test
    public void checkoutOverviewPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.login("standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.setAddToCart();
        inventoryPage.goToCartPage();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckoutPage();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.validateCheckoutPageAndFields("aditya","raj","560066");
        checkoutPage.checkout();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.validateTitleItem();
        checkoutOverviewPage.validateCancelFinish();
    }
}
