package com.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream fs = new FileInputStream("src/main/resources/config.properties");
            prop.load(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
