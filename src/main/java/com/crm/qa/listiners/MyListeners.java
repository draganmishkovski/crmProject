package com.crm.qa.listiners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.qa.testcases.base.TestBase;
import com.crm.qa.testcases.util.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners extends TestBase implements ITestListener {
    ExtentReports extentReport;
    ExtentTest extentTest;


    @Override
    public void onStart(ITestContext context) {

        extentReport = ExtentReporter.generateExtentReport();
    }


    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extentTest = extentReport.createTest(testName);
        extentTest.log(Status.INFO,testName + "Started executing");

        //System.out.println(testName + "Started executing");

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String testName = result.getName();
        extentTest.log(Status.PASS,testName + "got successfully executed");

        //System.out.println(testName + "got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();
        System.out.println("Screenshot taken ");


        try {
            WebDriver driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result.getThrowable());
        System.out.println(testName + "got failed");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.SKIP,testName + "got skipped");


        //System.out.println(testName + "got skipped");
       // System.out.println(result.getThrowable());
    }


    @Override
    public void onFinish(ITestContext context) {

        extentReport.flush();
       // System.out.println("Finish execution");

    }
}
