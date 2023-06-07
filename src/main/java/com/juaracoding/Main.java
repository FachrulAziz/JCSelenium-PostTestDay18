package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {

        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");
        DriverSingleton.scroll(500);

        LoginPage loginPage = new LoginPage();
        loginPage.login("fachrulaziz95","vegazr4362");


        CartPage cartPage = new CartPage();
        cartPage.cart("Black", "M");
        String a = cartPage.txtAddedToCart();
        System.out.println(a);

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkout("Fachrul","Aziz","ID","Taman Kirana Surya","JB","Tangerang","17510","089999999","Fachrulfac@gmail.com");
        String b = checkoutPage.validCheck();
        System.out.println(b);
        DriverSingleton.closeObjectInstance();
    }
}
