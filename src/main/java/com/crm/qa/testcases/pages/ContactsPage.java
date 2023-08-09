package com.crm.qa.testcases.pages;

import com.crm.qa.testcases.base.TestBase;
import com.crm.qa.testcases.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    TestUtil testUtil;

    public ContactsPage() {

        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;


    @FindBy(xpath = "//select[@name='title']")
    WebElement selectTitle;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement fistNameField;


    @FindBy(xpath = "//input[@name='surname']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@name='client_lookup']")
    WebElement companyName;


    @FindBy(xpath = "//input[@value='Save']")

    WebElement saveBtn;

    public boolean verifyContactLabel() {
        return contactsLabel.isDisplayed();


    }


    public  void selectContactsByName(String name){

        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']" +
                "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }



    public void createNewContact(String title,String ftName,String ltName,String comp){

        Select select =new Select(selectTitle);

        select.selectByVisibleText(title);

        fistNameField.sendKeys(ftName);
        lastNameField.sendKeys(ltName);
        companyName.sendKeys(comp);
        saveBtn.click();







    }
}
