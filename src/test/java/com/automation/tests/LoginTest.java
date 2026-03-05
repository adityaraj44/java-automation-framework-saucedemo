package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.login("standard_user","secret_sauce");
        System.out.println("Logged in successfully");
    }
}
