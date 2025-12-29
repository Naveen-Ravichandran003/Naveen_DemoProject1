package com.acme.utils;

import java.io.File;
import java.io.IOException;

public class ReportGenerator {
    
    public static void main(String[] args) {
        System.out.println("🚀 Starting report generation...");
        generateAllReports();
    }
    
    public static void generateAllReports() {
        System.out.println("📊 Generating all test reports...");
        
        // Generate Allure HTML report
        generateAllureReport();
        
        // Open all available reports
        ReportOpener.openAllReports();
        
        // Display report summary
        displayReportSummary();
    }
    
    private static void generateAllureReport() {
        try {
            System.out.println("🔄 Generating Allure HTML report...");
            
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "mvn", "allure:report");
            pb.inheritIO();
            Process process = pb.start();
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                System.out.println("✅ Allure HTML report generated successfully");
            } else {
                System.out.println("⚠️ Allure report generation failed");
            }
            
        } catch (IOException | InterruptedException e) {
            System.out.println("⚠️ Could not generate Allure report: " + e.getMessage());
        }
    }
    
    private static void displayReportSummary() {
        System.out.println("\n========================================");
        System.out.println("📊 TEST REPORT SUMMARY");
        System.out.println("========================================");
        
        checkReportFile("🌐 Cucumber HTML", "target/cucumber-html-reports/report.html");
        checkReportFile("📈 Allure HTML", "target/site/allure-maven-plugin/index.html");
        checkReportFile("📊 Cucumber JSON", "target/cucumber-json-reports/Cucumber.json");
        checkReportFile("📄 Cucumber XML", "target/cucumber-xml-reports/Cucumber.xml");
        checkDirectory("📸 Screenshots", "test-screenshots");
        
        System.out.println("========================================");
    }
    
    private static void checkReportFile(String reportName, String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("✅ " + reportName + ": " + filePath);
        } else {
            System.out.println("❌ " + reportName + ": Not found");
        }
    }
    
    private static void checkDirectory(String dirName, String dirPath) {
        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            int fileCount = files != null ? files.length : 0;
            System.out.println("✅ " + dirName + ": " + fileCount + " files in " + dirPath);
        } else {
            System.out.println("❌ " + dirName + ": Directory not found");
        }
    }
}