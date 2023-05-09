package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.Products;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LogInTest extends BaseTest {

    HomePage homePage = new HomePage();
    Products products = new Products();

    //Third change to turn the framework in Page factory project model
    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        products = new Products();
    }


        @Test (groups = {"sanity","regression"})
        public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

            homePage.enterUserName("standard_user");
            homePage.enterpassword( "secret_sauce");
            homePage.clickOnLoginButton();
            Thread.sleep(5000);
            String actualMessage = products.verifyText();
            String expectedMessage = "Products";
            Assert.assertEquals(expectedMessage, actualMessage);
        }

        @Test (groups = {"sanity","smoke","regression"})
        public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
            homePage.enterUserName("standard_user");
            homePage.enterpassword("secret_sauce");
            homePage.clickOnLoginButton();
            Thread.sleep(5000);
            int actualNumber = products.verifyProductList();
            int expectedNumber = 6;
            Assert.assertEquals(actualNumber, expectedNumber);
        }
    }