package com.practice.basics1;


import com.practice.testComponents.eComDataProvider;
import org.testng.annotations.*;

import java.util.HashMap;

public class StandAloneRefinedTest extends BaseTest {


    @Test(testName = "Get product details", dataProviderClass = eComDataProvider.class, dataProvider = "ecommerceData",  enabled = true, priority = 1)
    public void getTheProductDetails(HashMap<String, String> edata) throws InterruptedException {
        logging("INFO","  ******** "+ Thread.currentThread().getStackTrace()[1].getMethodName() +" ******* ");
        testExecution.landingPage().loginIntoApp(edata.get("url"), edata.get("email"), edata.get("password"));
        testExecution.productDetailsPage().selectProduct(edata.get("productName"));
    }

//    @Test(testName = "Select the product and place order", dataProviderClass = eComDataProvider.class, dataProvider = "ecommerceData", enabled = true, priority = 2)
    public void getTheOrderDetails(HashMap<String, String> edata) throws InterruptedException {
        testExecution.landingPage().loginIntoApp(edata.get("url"), edata.get("email"), edata.get("password"));
        testExecution.productDetailsPage().selectProduct(edata.get("productName"));
        testExecution.ordersDetailsPage().fillOrderDetails(edata.get("countryNameInitials"), edata.get("CountryName"), edata.get("ccExpMonth"), edata.get("ccExpday"));
    }

    //@Test(testName = "Verify the Order ID", dataProviderClass = eComDataProvider.class, dataProvider = "ecommerceData", enabled = true, priority = 3)
    public void verifyOrderID(HashMap<String, String> edata) throws InterruptedException {
        testExecution.landingPage().loginIntoApp(edata.get("url"), edata.get("email"), edata.get("password"));
        testExecution.productDetailsPage().selectProduct(edata.get("productName"));
        String orderID = testExecution.ordersDetailsPage().fillOrderDetails(edata.get("countryNameInitials"), edata.get("CountryName"), edata.get("ccExpMonth"), edata.get("ccExpday"));
        System.out.println("Following is the Order ID from History => " + testExecution.ordersHistoryPage().viewAndAssertOrderDetails(orderID));
    }

}
