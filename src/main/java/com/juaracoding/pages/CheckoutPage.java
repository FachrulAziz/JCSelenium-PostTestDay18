package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='cart-name-and-total']")
    WebElement viewCartBtn;
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward wp-element-button']")
    WebElement checkoutBtn;

    @FindBy(id = "billing_first_name")
    WebElement firstName;

    @FindBy(id = "billing_last_name")
    WebElement lastName;

    @FindBy(id = "billing_country")
    WebElement countrySelect;

    @FindBy(id = "billing_address_1")
    WebElement streetAddress;

    @FindBy(id = "billing_city")
    WebElement cityTown;

    @FindBy(id = "billing_state")
    WebElement province;

    @FindBy(id = "billing_postcode")
    WebElement postcode;

    @FindBy(id = "billing_phone")
    WebElement phoneNumber;

    @FindBy(id = "billing_email")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"terms\"]")
    WebElement checkBox;

    @FindBy(id = "place_order")
    WebElement btnOrder;

    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/div/p[1]")
    WebElement validCheckout;


    public void checkout(String fName, String lName,String country,String streetAdd,String prov,String townCity, String postCode, String phone, String mail){
        DriverSingleton.scroll(-500);
        viewCartBtn.click();
        DriverSingleton.scroll(500);
        DriverSingleton.delay(3);
        checkoutBtn.click();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        Select select = new Select(countrySelect);
        select.selectByValue(country);
        streetAddress.sendKeys(streetAdd);
        cityTown.sendKeys(townCity);
        Select select1 = new Select(province);
        select1.selectByValue(prov);
        postcode.sendKeys(postCode);
        phoneNumber.sendKeys(phone);
        DriverSingleton.scroll(200);
        email.sendKeys(mail);
        checkBox.click();
        btnOrder.click();
        DriverSingleton.delay(2);
    }

    public String validCheck(){
        return validCheckout.getText();
    }
}
