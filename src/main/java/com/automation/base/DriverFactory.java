package com.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        if(driver.get() == null) {
            String browser = ConfigReader.get("browser");
            if(browser.equalsIgnoreCase(browser)) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);

                options.setExperimentalOption("prefs", prefs);

                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                driver.set(new ChromeDriver(options));
                driver.get().manage().window().maximize();
            } else {
                throw new RuntimeException("Browser not supported: " + browser);
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
