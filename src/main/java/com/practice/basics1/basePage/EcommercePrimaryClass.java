package com.practice.basics1.basePage;

import com.practice.basics1.pageObjects.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommercePrimaryClass extends BrowserInitialization {

    LandingPage landingPage;
    ProductDetailsPage productDetailsPage;
    OrdersDetailsPage ordersDetailsPage;
    OrdersHistoryPage ordersHistoryPage;

    public EcommercePrimaryClass(String browserName)
    {
        super(initDriverInBrowser(browserName));
        wait = new WebDriverWait(driver, time);
        landingPage = new LandingPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        ordersDetailsPage = new OrdersDetailsPage(driver);
        ordersHistoryPage = new OrdersHistoryPage(driver);
    }

    public LandingPage landingPage()
    {
        return landingPage;
    }

    public ProductDetailsPage productDetailsPage()
    {
        return productDetailsPage;
    }

    public OrdersDetailsPage ordersDetailsPage()
    {
        return ordersDetailsPage;
    }

    public OrdersHistoryPage ordersHistoryPage()
    {
        return ordersHistoryPage;
    }

}
