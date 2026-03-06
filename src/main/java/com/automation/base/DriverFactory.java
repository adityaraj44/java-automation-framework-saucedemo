package com.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        if(driver.get() == null) {
            String browser = ConfigReader.get("browser");
            if(browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);

                options.setExperimentalOption("prefs", prefs);

                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                String execution = ConfigReader.get("execution");

                if(execution.equalsIgnoreCase("remote")) {

                    try {
                        driver.set(new RemoteWebDriver(
                                new URL("http://localhost:4444/wd/hub"),
                                options
                        ));
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to connect to Selenium Grid", e);
                    }

                } else {
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                }
                driver.get().manage().window().maximize();
            } else {
                throw new RuntimeException("Browser not supported: " + browser);
            }

        }
        return driver.get();
    }

    public static void quitDriver() {
        if(driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
