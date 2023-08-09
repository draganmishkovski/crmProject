package com.crm.qa.testcases.pages;

import com.crm.qa.testcases.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class LoginPage extends TestBase {



    public LoginPage() throws IOException {



        PageFactory.initElements(driver, this);


    }


    @FindBy(xpath = "//input[@name='username']")
    WebElement username;


    @FindBy(xpath = "//input[@name='password']")
    WebElement password;


    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;


    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath = "//img[@class='img-responsive']")
    WebElement crmLogo;



    public String validateLoginPageTitle() {

        return driver.getTitle();

    }


    public boolean validateLogoCrm() {

        return crmLogo.isDisplayed();
    }

    public void login(String un, String pwd) {

        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();



    }
}
