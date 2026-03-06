package com.automation.utils;

public class PauseUtil {

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Pause interrupted: " + e.getMessage());
        }
    }
}
