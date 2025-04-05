package com.practice.basics1.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsFiles {

    public static ExtentReports extent;
    public static ExtentSparkReporter reporter;

    public static ExtentReports getExtReport(ExtentSparkReporter val) {
        extent = new ExtentReports();
        extent.attachReporter(val);
        extent.setSystemInfo("Tester", "Rajat M");
        return extent;
    }

    public static ExtentSparkReporter getReporter() {
        String extentReportPath = System.getProperty("user.dir") + "/reports/extentReports/index.html";
        reporter= new ExtentSparkReporter(extentReportPath);
        reporter.config().setReportName("Ecommerce Web App Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        return reporter;
    }


}
