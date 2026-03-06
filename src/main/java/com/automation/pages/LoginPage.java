package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.PauseUtil;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    public void openWebsite() {
        driver.get(ConfigReader.get("url"));
    }
    public InventoryPage login(String user, String pass) {
        WaitUtils.waitForElement(driver, username);
        PauseUtil.pause(2);
        driver.findElement(username).sendKeys(user);
        WaitUtils.waitForElement(driver, password);
        PauseUtil.pause(2);
        driver.findElement(password).sendKeys(pass);
        PauseUtil.pause(2);
        driver.findElement(loginButton).click();

        return new InventoryPage(driver);
    }
}
