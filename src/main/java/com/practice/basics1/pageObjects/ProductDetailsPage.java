package com.practice.basics1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BrowserInitialization {

    public static final String addToCart = "//h5[normalize-space()='%s']/parent::div/button[2]";
    public static final String addToCartValidationMsg = "//*[contains(@class,'toast')]";
    public static final String openCart = "//*[contains(@routerlink,'cart')]";
    public static final String checkout = "//button[normalize-space()='Checkout']";

    BrowserInitialization getTest;

    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public static void addProdcutToCart(WebDriver driver, String xPath, String productName) {
        String newXpath = String.format(xPath, productName);
        clickOnElement(driver, newXpath);
    }

    public void selectProduct(String productName) throws InterruptedException {
        addProdcutToCart(driver, addToCart, productName);
        System.out.println(getTextofElement(driver, addToCartValidationMsg));
        clickOnElement(driver, openCart);
        sleep(2);
        clickOnElement(driver, checkout);

    }


}
