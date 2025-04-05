package com.practice.basics1;

import com.practice.basics1.basePage.EcommercePrimaryClass;
import com.practice.basics1.resources.ReadCsvFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.util.HashMap;


public class BaseTest {

    public static EcommercePrimaryClass testExecution;
    public static Logger logs = LogManager.getLogger(BaseTest.class);
    public static ReadCsvFile readCsvFile;
    public static HashMap<String, String> data;
    public static String filePath = System.getProperty("user.dir")+"/resources/testData/testDetailsData.csv";


    @BeforeMethod
    public static void loginIntoApplication() {
        String browserName =
                //         Condition                  ? if     true(pull this value)  : false(pull this value)
                System.getProperty("browser") != null ? System.getProperty("browser") : "Chrome"; // Java ternary operator (?) is used here
        testExecution = new EcommercePrimaryClass(browserName);
        logging("INFO","Browser is Initialized !!!!");

    }

    @AfterMethod
    public static void closeTheBrowserWindow() {
        testExecution.closeWindow();
        logging("INFO","Window is closed !!!!");
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
