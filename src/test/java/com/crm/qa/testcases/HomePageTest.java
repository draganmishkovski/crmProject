package com.crm.qa.testcases;

import com.crm.qa.testcases.base.TestBase;
import com.crm.qa.testcases.pages.ContactsPage;
import com.crm.qa.testcases.pages.HomePage;
import com.crm.qa.testcases.pages.LoginPage;
import com.crm.qa.testcases.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {
    TestUtil testUtil;
    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;

    public HomePageTest() {

        super();

    }

    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage = new HomePage();
    }


    @Test
    public void verifyHomePageTitle() {


        String homePageTitle = homePage.verifyHomePageTitle();

        Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not match");
    }


    @Test
    public void verifyUserNameLabelTxt() {

        testUtil.switchToFrame();

        Assert.assertTrue(homePage.verifyCorrectUserName());

    }

    @Test
    public void contactLinkTest() {

        testUtil.switchToFrame();
        contactsPage = homePage.clickOnOnContactsLink();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }


}
