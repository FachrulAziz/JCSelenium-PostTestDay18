package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    private WebDriver driver;
    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
    WebElement orders;

    @FindBy(xpath="//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/a")
    WebElement product;

    @FindBy(id="color")
    WebElement menuColor;

    @FindBy(id="size")
    WebElement menuSize;

    @FindBy(xpath="//button[normalize-space()='Add to cart']")
    WebElement addCart;

//    @FindBy(xpath = "//a[@class='button wc-forward wp-element-button']")
//    WebElement viewCart;

    @FindBy(xpath = "//a[@class='button wc-forward wp-element-button']")
    WebElement txtAddToCart;

    public void cart(String color, String size){
        orders.click();
        DriverSingleton.delay(2);
        DriverSingleton.scroll(1500);
        product.click();
        DriverSingleton.scroll(700);
        Select select = new Select(menuColor);
        Select select1 = new Select(menuSize);
        select.selectByValue(color);
        select1.selectByValue(size);
        addCart.click();
        DriverSingleton.delay(3);
        System.out.println("Product Selected and Add to Cart");
    }

    public String txtAddedToCart(){
        return txtAddToCart.getText();
    }
    static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000); // delay 3 detik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
