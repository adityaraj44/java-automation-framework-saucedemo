package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.*;
import org.testng.annotations.Test;

public class OrderCompleteTest extends BaseTest {
    @Test
    public void orderCompletePageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.login("standard_user","secret_sauce")
                .setAddToCart().goToCartPage().goToCheckoutPage()
                .validateCheckoutPageAndFields("aditya","raj","560066").checkout().validateCancelFinish();

        OrderCompletePage complete = new OrderCompletePage(driver);
        complete.successValidate();
        complete.goToHome();
        complete.validateHome().validateInventoy();


    }
}
