package com.practice.stepDefinition;

import com.practice.basics1.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StandAloneTestStepDefinition extends BaseTest {

    public String orderID;

    @Given("user landed on Ecommerce Page")
    public void user_landed_on_Ecommerce_Page(){
        loginIntoApplication();
    }

    @Given("user logged in wih {string} and {string} on {string}")
    public void user_logged_in_with_username_and_password_on_url(String un, String pwd, String url) throws InterruptedException {
        testExecution.landingPage().loginIntoApp(url, un, pwd);
    }

    @Then("user add the {string} to cart and checks out")
    public void user_adds_product_to_cart_and_checkout(String productName) throws InterruptedException {
        testExecution.productDetailsPage().selectProduct(productName);
        closeTheBrowserWindow();
    }

    @Then("user add the {string} to cart")
    public void user_adds_product_to_cart(String productName) throws InterruptedException {
        testExecution.productDetailsPage().selectProduct(productName);
    }

    @Then("user enters pricing details as follows {string}, {string}, {string} and {string}")
    public void user_enters_pricing_details(String countryNameInitials, String CountryName, String ccExpMonth, String ccExpday) throws InterruptedException {
        testExecution.ordersDetailsPage().fillOrderDetails(countryNameInitials, CountryName, ccExpMonth, ccExpday);
        closeTheBrowserWindow();
    }

    @Then("user enters pricing details as follows {string}, {string}, {string} and {string} and proceed")
    public void user_enters_pricing_details_and_proceed(String countryNameInitials, String CountryName, String ccExpMonth, String ccExpday) throws InterruptedException {
        orderID = testExecution.ordersDetailsPage().fillOrderDetails(countryNameInitials, CountryName, ccExpMonth, ccExpday);
    }

    @Then("user verifies Order ID")
    public void user_enters_pricing_details() throws InterruptedException {

        System.out.println("Following is the Order ID from History => " + testExecution.ordersHistoryPage().viewAndAssertOrderDetails(orderID));
        closeTheBrowserWindow();
    }

}
