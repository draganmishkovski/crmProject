package com.crm.qa.testcases;


import com.crm.qa.testcases.base.TestBase;
import com.crm.qa.testcases.pages.HomePage;
import com.crm.qa.testcases.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTest extends TestBase {


    LoginPage loginPage;
    HomePage homePage;


    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setup() throws IOException {

        initialization();

        loginPage = new LoginPage();


    }

    @Test

    public void crmLogoImageTest() {


        loginPage.validateLogoCrm();


    }

    @Test

    public void loginTest() {

        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));


    }

    @Test

    public void loginPageTitleTest(){

      String title=loginPage.validateLoginPageTitle();

      Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");


}
    @AfterMethod
    public void tearDown()  {


        driver.quit();

    }


}