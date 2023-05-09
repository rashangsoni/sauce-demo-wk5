package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {



    // First change to turn the framework in Page factory project model
    @CacheLookup
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;


   /* By userNameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");*/

    public void enterUserName(String username ){
       sendTextToElement(usernameField,username);
        CustomListeners.test.log(Status.PASS, " Entre UserName" + username);
    }

    public void enterpassword(String password){
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);

    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }


}