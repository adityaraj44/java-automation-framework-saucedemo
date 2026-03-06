package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.*;
import org.testng.annotations.Test;

public class CheckoutOverviewPageTest extends BaseTest {

    @Test
    public void checkoutOverviewPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.login("standard_user","secret_sauce").setAddToCart()
                .goToCartPage().goToCheckoutPage().validateCheckoutPageAndFields("aditya","raj","560066").checkout();
    }
}
