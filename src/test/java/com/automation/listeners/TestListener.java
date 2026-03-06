package com.automation.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.automation.utils.ExtentManager;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}
