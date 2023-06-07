package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddCart {
    static WebDriver driver;
    static CartPage cartPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        cartPage = new CartPage();
    }
    @AfterClass
    public void closeBrowser(){
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void addToCart(){
        cartPage.cart("Black","M");
        Assert.assertEquals(cartPage.txtAddedToCart(),"View cart");
    }
}
