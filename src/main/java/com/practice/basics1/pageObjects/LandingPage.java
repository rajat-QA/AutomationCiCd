package com.practice.basics1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BrowserInitialization {

    @FindBy (xpath = "//input[@type='email']")
    WebElement cred;

    public static final String creds = "//input[@type='%s']";
    public static final String loginButton = "//input[@name='login']";

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    BrowserInitialization getTest;

    public WebElement loginCredentials(WebDriver driver, String xPath, String value) {
        WebElement loginCreds = driver.findElement(By.xpath(String.format(xPath, value)));
        return loginCreds;
    }

    public void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void loginIntoApp(String url, String un, String pwd) throws InterruptedException {
//        alert = driver.switchTo().alert();
//        alert.accept();
        navigateToUrl(driver, url);
        cred.sendKeys(un);
        loginCredentials(driver, creds, "password").sendKeys(pwd);
        clickOnElement(driver, loginButton);
        sleep(2);
    }


}
