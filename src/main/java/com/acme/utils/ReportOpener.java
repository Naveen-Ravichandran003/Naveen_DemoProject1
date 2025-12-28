package com.acme.utils;

import java.io.File;
import java.io.IOException;

public class ReportOpener {
    
    public static void openAllReports() {
        System.out.println("📊 Opening test reports automatically...");
        
        // Generate and open Allure report first
        generateAndOpenAllureReport();
        
        // Open Cucumber HTML Report
        openCucumberReport();
        
        // Open Screenshots Folder
        openScreenshotsFolder();
        
        System.out.println("✅ All available reports opened successfully!");
    }
    
    private static void openCucumberReport() {
        String htmlReport = "target/cucumber-html-reports/report.html";
        File reportFile = new File(htmlReport);
        
        if (reportFile.exists()) {
            try {
                Runtime.getRuntime().exec("cmd /c start " + htmlReport);
                System.out.println("🌐 Cucumber HTML Report: " + htmlReport);
            } catch (IOException e) {
                System.out.println("Could not open Cucumber report: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ Cucumber HTML report not found at: " + htmlReport);
        }
    }
    
    private static void openScreenshotsFolder() {
        String screenshotsDir = "test-screenshots";
        File screenshotsFolder = new File(screenshotsDir);
        
        if (screenshotsFolder.exists() && screenshotsFolder.isDirectory()) {
            try {
                Runtime.getRuntime().exec("cmd /c start explorer " + screenshotsDir);
                System.out.println("📸 Screenshots Folder: " + screenshotsDir);
            } catch (IOException e) {
                System.out.println("Could not open screenshots folder: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ Screenshots folder not found: " + screenshotsDir);
        }
    }
    
    private static void generateAndOpenAllureReport() {
        try {
            System.out.println("🔄 Generating Allure report...");
            
            // Generate Allure report using Maven
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "mvn", "allure:report");
            pb.inheritIO();
            Process process = pb.start();
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                System.out.println("✅ Allure report generated successfully");
                
                // Wait a moment for files to be written
                Thread.sleep(2000);
                
                // Open the generated Allure report
                openAllureReport();
            } else {
                System.out.println("⚠️ Allure report generation failed");
            }
            
        } catch (IOException | InterruptedException e) {
            System.out.println("⚠️ Could not generate Allure report: " + e.getMessage());
        }
    }
    
    private static void openAllureReport() {
        String allureReport = "target/site/allure-maven-plugin/index.html";
        File allureFile = new File(allureReport);
        
        if (allureFile.exists()) {
            try {
                Runtime.getRuntime().exec("cmd /c start " + allureReport);
                System.out.println("📈 Allure Report: " + allureReport);
            } catch (IOException e) {
                System.out.println("Could not open Allure report: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ Allure report not found at: " + allureReport);
        }
    }
}