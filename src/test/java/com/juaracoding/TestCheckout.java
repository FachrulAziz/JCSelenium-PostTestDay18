package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCheckout {
    static WebDriver driver;
    static CartPage cartPage;
    static CheckoutPage checkoutPage;
    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterClass
    public void closeBrowser() {
        DriverSingleton.delay(2);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void addToCart(){
        cartPage.cart("Black","M");
        Assert.assertEquals(cartPage.txtAddedToCart(),"View cart");
    }

    @Test(priority = 2)
    public void validCheckout(){
        checkoutPage.checkout("Fachrul","Aziz","ID","Taman Kirana Surya","JB","Tangerang","17510","089999999","Fachrulfac@gmail.com");
        Assert.assertEquals(checkoutPage.validCheck(),"Thank you. Your order has been received.");
    }
}
