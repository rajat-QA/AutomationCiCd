package com.practice.basics1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrdersDetailsPage extends BrowserInitialization {

    public static final String countrySelection = "//input[contains(@placeholder,'Country')]";
    public static final String selectCountry = "//section[contains(@class,'results')]/button[normalize-space()='%s']";
    public static final String selectMonth = "//select[1]";
    public static final String selectDay = "//select[2]";
    public static final String getOrderId = "//label[@class='ng-star-inserted']";
    public static String orderID;

    BrowserInitialization getTest;

    public OrdersDetailsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public static void moveToElementAndClickAction(WebDriver driver, String xPath) {
        a = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).isDisplayed();
        a.moveToElement(driver.findElement(By.xpath(xPath))).click().build().perform();

    }

    public void selectCCardExpiryDate(WebDriver driver, String Month, String day) throws InterruptedException {

        sleep(2);
        s = new Select(driver.findElement(By.xpath(selectMonth)));
        s.selectByVisibleText(Month);
        sleep(2);
        s = new Select(driver.findElement(By.xpath(selectDay)));
        s.selectByVisibleText(day);
    }

    public static void clickButtonName(WebDriver driver, String buttonName) {
        String btnNm = "//a[normalize-space()='" + buttonName + "']";
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(btnNm)));

    }

    public String captureOrderID(WebDriver driver) {
        orderID = getTextofElement(driver, getOrderId);
        orderID = orderID.replace("|", "").trim();
        System.out.println("Following is Order ID => " + orderID);
        return orderID;
    }

    public String fillOrderDetails(String countryNameInitials, String CountryName, String ccExpMonth, String ccExpday) throws InterruptedException
    {
        sendKeysToElement(driver, countrySelection, countryNameInitials);
        sleep(2);
        moveToElementAndClickAction(driver, String.format(selectCountry, CountryName));
        selectCCardExpiryDate(driver, ccExpMonth, ccExpday);
        clickButtonName(driver, "Place Order");
        String ordId = captureOrderID(driver);
        return ordId;
    }



}
