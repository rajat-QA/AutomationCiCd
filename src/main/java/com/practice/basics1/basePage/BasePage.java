package com.practice.basics1.basePage;

import com.practice.basics1.resources.ReadCsvFile;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions a;
    public static Select s;
    public static JavascriptExecutor js;
    public static Duration time = Duration.ofSeconds(10);
    public static Logger logs = LogManager.getLogger(BasePage.class);
    public static ReadCsvFile readCsvFile;
    public static String filePath = System.getProperty("user.dir")+"/resources/testData/testDetailsData.csv";
    public static HashMap<String, String> data = getData();
    public static Alert alert;

    public static String takeScreenshot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") +"/reports/screenShots/"+ testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") +"/reports/"+ testCaseName + ".png";

    }

    public static void logging(String logType, String msg)
    {
        switch (logType) {
            case "INFO":
                logs.info(msg);
                break;
            case "FAIL":
                logs.error(msg);
                break;
        }
    }

    public static HashMap<String, String> getData() {
        try {
            readCsvFile = new ReadCsvFile();
            data = readCsvFile.getTestDataFromCsv(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


}
