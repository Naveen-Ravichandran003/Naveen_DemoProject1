package com.acme.runners;

import com.acme.utils.ReportOpener;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.acme.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-html-reports/report.html",
                "json:target/cucumber-json-reports/Cucumber.json",
                "junit:target/cucumber-xml-reports/Cucumber.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)
public class TestRunner {
    
    @AfterClass
    public static void openReportsAfterAllTests() {
        try {
            // Wait for all reports to be generated
            Thread.sleep(3000);
            
            System.out.println("\n" + "=".repeat(50));
            System.out.println("ALL TEST SCENARIOS COMPLETED");
            System.out.println("=".repeat(50));
            
            // Open all reports automatically
            ReportOpener.openAllReports();
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Report opening interrupted: " + e.getMessage());
        }
    }
}