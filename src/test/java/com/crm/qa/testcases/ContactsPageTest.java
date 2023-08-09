package com.crm.qa.testcases;


import com.crm.qa.testcases.base.TestBase;
import com.crm.qa.testcases.pages.HomePage;
import com.crm.qa.testcases.pages.LoginPage;
import com.crm.qa.testcases.util.TestUtil;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    com.crm.qa.testcases.pages.ContactsPage contactsPage;
    String sheetName = "contacts";




    public ContactsPageTest() {

        super();


    }

    @BeforeMethod
    public void setup() throws IOException {
        initialization();

        testUtil = new TestUtil();
        contactsPage = new com.crm.qa.testcases.pages.ContactsPage();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        testUtil.switchToFrame();

        homePage = new HomePage();

        homePage.clickOnOnContactsLink();


    }


    @Test(priority = 1)

    public void verifyContactLabel() throws IOException {


        Assert.assertTrue(contactsPage.verifyContactLabel(), "contact label is missing ");

    }

    @Test(priority = 2)

    public void selectSingleContactTest() {


        contactsPage.selectContactsByName("Beki Bekic");


    }

    @Test(priority = 3)

    public void selectMultipleContactTest() {


        contactsPage.selectContactsByName("Beki Bekic");
        contactsPage.selectContactsByName("Ceki Cekic");

    }


    @DataProvider(name = "getCRMTestData")
    public Object[][] getCRMTestData() {

        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }


    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException {


        homePage.clickOnNewContactLink();


        contactsPage.createNewContact(title, firstName, lastName, company);


    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
