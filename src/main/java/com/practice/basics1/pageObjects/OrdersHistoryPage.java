package com.practice.basics1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrdersHistoryPage extends BrowserInitialization {

    BrowserInitialization getTest;

    public OrdersHistoryPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public static final String ordersPage = "//button[contains(@routerlink,'myorders')]";
    public static final String columnCount = "//thead/tr/th";
    public static final String rowCount = "//tbody/tr";
    public static final String validateID = "//div[@class='col-text -main']";

    public static WebElement colmTitle(WebDriver driver, int i) {
        return driver.findElement(By.xpath("//thead/tr/th[" + i + "]"));
    }

    public static WebElement rowValue(WebDriver driver, int i) {
        return driver.findElement(By.xpath("//tbody/tr[" + i + "]/th"));
    }

    public static WebElement viewBtn(WebDriver driver, int i) {
        return driver.findElement(By.xpath("//tbody/tr[" + i + "]/td/button[normalize-space()='View']"));
    }


    public String viewAndAssertOrderDetails(String orderID) throws InterruptedException {


        clickOnElementUsingJS(ordersPage);

        for (int i = 1; i <= getElement(driver, columnCount).size(); i++) {
            int k = 0;
            for (int j = 1; j <= getElement(driver , rowCount).size(); j++) {
                if (colmTitle(driver, i).getText().equalsIgnoreCase("Order Id")) {
                    if (rowValue(driver, j).getText().equalsIgnoreCase(orderID)) {
                        k++;
                        clickOnWebElementUsingJS(viewBtn(driver, j));
                        break;
                    }
                }
            }
            if (k > 0) {
                break;
            }
        }

        return getTextofElement(driver, validateID);

    }


}
