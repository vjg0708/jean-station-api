package com.example.app_jeanstation.StepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ReportHooks {

    private static ExtentReports extentReports;
    private static ExtentTest test;

    @Before(order = 0)
    public void setExtentReports(){

        if (extentReports==null){
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\harrish.vijay\\eclipse-workspace\\jean-station-api\\app-jeanstation\\target\\Extent_Reports.html");
            sparkReporter.config().setReportName("Jean-Station Report");
            sparkReporter.config().setDocumentTitle("API Test");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

        }

        System.out.println("Report setup....");
    }

    @Before(order = 1)
    public void beforeScenario(io.cucumber.java.Scenario scenario){

        System.out.println("Scenario Started : "+scenario.getName());
        test = extentReports.createTest(scenario.getName());
    }

    @After(order = 1)
    public void afterScenario(io.cucumber.java.Scenario scenario){

        if (scenario.isFailed()){
            test.fail("Scenario failed :" + scenario.getName());
        }
        else {
            test.pass("Scenario passed : "+scenario.getName());
        }
        System.out.println("Scenario finished : "+scenario.getName());
    }

    @After(order = 0)
    public void flushReport(){

        if (extentReports!=null){

            extentReports.flush();
            System.out.println("Report completed...");
        }
    }

}
