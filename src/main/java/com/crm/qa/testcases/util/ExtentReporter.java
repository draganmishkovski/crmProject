package com.crm.qa.testcases.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporter {

    public static ExtentReports generateExtentReport()  {

        ExtentReports extentReport = new ExtentReports();

        File extentReportFile = new File(System.getProperty("user.dir"), "\\test-output\\ExtentReport\\ExtentReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("CRM Application");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extentReport.attachReporter(sparkReporter);

        Properties configProp=new Properties();


        File configPropfile=new File(System.getProperty("user.dir"),"\\src\\main\\java\\com\\crm\\qa\\testcases\\config\\config.properties");

        try {
            FileInputStream fisConfigProp =new FileInputStream(configPropfile);
            configProp.load(fisConfigProp);
        }catch (Throwable e){
            e.printStackTrace();
        }


        extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
        extentReport.setSystemInfo("Browser Name",configProp.getProperty("browser"));
        extentReport.setSystemInfo("Email","email");
        extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
        extentReport.setSystemInfo("User name",System.getProperty("user.name"));
        extentReport.setSystemInfo("Java version",System.getProperty("java.version"));

        return extentReport;

    }
}