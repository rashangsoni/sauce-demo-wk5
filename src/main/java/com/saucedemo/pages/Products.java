package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Products extends Utility {

    @CacheLookup
    @FindBy(className = "title")
    WebElement productsText;
    //By productsText = By.className("title");
    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_item']")
    WebElement productsList;
    //By productList = By.xpath("//div[@class='inventory_item']");


    public String verifyText() {
        CustomListeners.test.log(Status.PASS, "verifyText");
        return getTextFromElement(productsText);

    }

    public int verifyProductList() {
        CustomListeners.test.log(Status.PASS, "verifyProductsList");
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        return number.size();

            /*//Verify the text “PRODUCTS”
            public void verifyProduct()
            {
                String excpectedMessage = "Products";
                String actualMessage = getTextFromElement(verifyProduct);
                Assert.assertEquals(actualMessage,excpectedMessage);
                CustomListener.test.log(Status.PASS,"Verify the text “PRODUCTS”");
            }


            public int getSize(By by) {
//        List<WebElement> number = driver.findElements(by);
//        return number.size();*/
    }
}