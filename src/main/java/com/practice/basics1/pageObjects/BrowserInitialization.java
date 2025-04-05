package com.practice.basics1.pageObjects;

import com.practice.basics1.basePage.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserInitialization extends BasePage {

    public BrowserInitialization(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this); // used to give knowledge of driver to page factory elements i.e. @FindBy
    }

    public static WebDriver initDriverInBrowser(String browserName) {

        ChromeOptions options;
        String headless;

        switch (browserName) {

            case "Chrome":
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                headless = System.getenv("HEADLESS_MODE");
                if ("true".equalsIgnoreCase(headless)) {
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
                break;

            case "ChromeHeadless":
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;

            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

        }

        return driver ;

    }

    public WebDriverWait webDriverWait()
    {
        wait = new WebDriverWait(driver, time);
        return wait;
    }

    public void sendKeysToElement(WebDriver driver, String xPath, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).isDisplayed();
        driver.findElement(By.xpath(xPath)).sendKeys(value);
        logging("INFO",Thread.currentThread().getStackTrace()[1].getMethodName()+ " on following locator -> "+xPath);
    }

    public List<WebElement> getElement(WebDriver driver, String xPath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).isDisplayed();
        logging("INFO",Thread.currentThread().getStackTrace()[1].getMethodName()+ " on following locator -> "+xPath);
        return driver.findElements(By.xpath(xPath));
    }

    public String getTextofElement(WebDriver driver, String xPath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).isDisplayed();
        String text = driver.findElement(By.xpath(xPath)).getText();
        logging("INFO",Thread.currentThread().getStackTrace()[1].getMethodName()+ " on following locator -> "+xPath);
        return text;
    }

    public static void clickOnElement(WebDriver driver, String xPath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).isDisplayed();
        driver.findElement(By.xpath(xPath)).click();
        logging("INFO",Thread.currentThread().getStackTrace()[1].getMethodName()+ " on following locator -> "+xPath);
    }

    public static void clickOnElementUsingJS(String xPath) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xPath)));
        logging("INFO",Thread.currentThread().getStackTrace()[1].getMethodName()+ " on following locator -> "+xPath);

    }

    public static void clickOnWebElementUsingJS(WebElement e) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", e);
        logging("INFO",Thread.currentThread().getStackTrace()[1].getMethodName()+ " on following WebElemet -> "+e);

    }

    public void sleep(int seconds) throws InterruptedException {

        Thread.sleep(1000 * seconds);
    }

    public void closeWindow()
    {
        driver.close();
    }

}
