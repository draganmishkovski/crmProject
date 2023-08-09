package com.crm.qa.testcases.base;


import com.crm.qa.testcases.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase  {

   public static WebDriver driver;
    public static Properties prop;





    public TestBase() {


        try {
            prop = new Properties();

            FileInputStream ip = new FileInputStream("C:\\Users\\DRAGAN22\\IdeaProjects\\CRMProject\\src\\main\\java\\com\\crm\\qa\\testcases\\config\\config.properties");

            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
        public static void initialization () {

            String browserName = prop.getProperty("browser");

            if (browserName.equals("chrome")) {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equals("firefox")) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }



            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));


        }


    }