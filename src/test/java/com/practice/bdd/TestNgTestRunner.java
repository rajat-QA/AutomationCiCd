package com.practice.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/com/practice/bdd",
        glue = "com.practice.stepDefinition",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@Validation"
)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setup() {
        String tags = System.getenv("CUCUMBER_TAGS");
        String plugins = System.getenv("CUCUMBER_PLUGINS");

        if (tags != null) {
            System.setProperty("cucumber.filter.tags", tags);
        }
        if (plugins != null) {
            System.setProperty("cucumber.plugin", plugins);
        }
    }

    // Following code allows parallel execution using cucumber
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

}
