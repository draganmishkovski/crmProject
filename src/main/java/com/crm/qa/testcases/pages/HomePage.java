package com.crm.qa.testcases.pages;

import com.crm.qa.testcases.base.TestBase;
import com.crm.qa.testcases.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    TestUtil testUtil;

    public HomePage() {

        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//td[contains(text(),'User: Dejan Dejanovski')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")

    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")

    WebElement newContactLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;


    public boolean verifyCorrectUserName() {

        return userNameLabel.isDisplayed();

    }


    public String verifyHomePageTitle() {

        return driver.getTitle();

    }


    public TasksPage clickOnTasksLink() {

        tasksLink.click();
        return new TasksPage();
    }

    public DealsPage clickOnDealsLink() {

        dealsLink.click();

        return new DealsPage();
    }


    public ContactsPage clickOnOnContactsLink() {


        contactsLink.click();

        return new ContactsPage();


    }


    public void clickOnNewContactLink() throws InterruptedException {


        Actions actions = new Actions(driver);

        driver.manage().window().fullscreen();
        actions.moveToElement(contactsLink).build().perform();


        newContactLink.click();
    }
}
