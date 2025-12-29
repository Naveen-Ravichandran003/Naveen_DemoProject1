package com.acme.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestNGReportGenerator {
    
    public static void generateHTMLReport(int passed, int failed, int total) {
        try {
            String reportPath = "target/testng-html-report.html";
            FileWriter writer = new FileWriter(reportPath);
            
            String htmlContent = generateHTMLContent(passed, failed, total);
            writer.write(htmlContent);
            writer.close();
            
            System.out.println("📊 TestNG HTML Report generated: " + reportPath);
            
        } catch (IOException e) {
            System.out.println("Error generating TestNG HTML report: " + e.getMessage());
        }
    }
    
    private static String generateHTMLContent(int passed, int failed, int total) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        double passRate = total > 0 ? (double) passed / total * 100 : 0;
        
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>TestNG Results</title>\n" +
                "    <style>\n" +
                "        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f5f5; }\n" +
                "        .container { max-width: 800px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }\n" +
                "        .header { text-align: center; color: #333; border-bottom: 2px solid #4CAF50; padding-bottom: 10px; }\n" +
                "        .summary { display: flex; justify-content: space-around; margin: 20px 0; }\n" +
                "        .stat-box { text-align: center; padding: 15px; border-radius: 5px; color: white; min-width: 100px; }\n" +
                "        .passed { background-color: #4CAF50; }\n" +
                "        .failed { background-color: #f44336; }\n" +
                "        .total { background-color: #2196F3; }\n" +
                "        .pass-rate { background-color: #FF9800; }\n" +
                "        .stat-number { font-size: 24px; font-weight: bold; }\n" +
                "        .stat-label { font-size: 12px; margin-top: 5px; }\n" +
                "        .timestamp { text-align: center; color: #666; margin-top: 20px; }\n" +
                "        .note { background-color: #e3f2fd; padding: 15px; border-radius: 5px; margin-top: 20px; }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class='container'>\n" +
                "        <h1 class='header'>🧪 TestNG Execution Report</h1>\n" +
                "        \n" +
                "        <div class='summary'>\n" +
                "            <div class='stat-box passed'>\n" +
                "                <div class='stat-number'>" + passed + "</div>\n" +
                "                <div class='stat-label'>PASSED</div>\n" +
                "            </div>\n" +
                "            <div class='stat-box failed'>\n" +
                "                <div class='stat-number'>" + failed + "</div>\n" +
                "                <div class='stat-label'>FAILED</div>\n" +
                "            </div>\n" +
                "            <div class='stat-box total'>\n" +
                "                <div class='stat-number'>" + total + "</div>\n" +
                "                <div class='stat-label'>TOTAL</div>\n" +
                "            </div>\n" +
                "            <div class='stat-box pass-rate'>\n" +
                "                <div class='stat-number'>" + String.format("%.1f%%", passRate) + "</div>\n" +
                "                <div class='stat-label'>PASS RATE</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        \n" +
                "        <div class='note'>\n" +
                "            <h3>📋 Test Execution Summary</h3>\n" +
                "            <p><strong>Framework:</strong> Selenium + Cucumber + TestNG</p>\n" +
                "            <p><strong>Test Suite:</strong> ACME Automation Test Suite</p>\n" +
                "            <p><strong>Execution Mode:</strong> Sequential (Single Browser)</p>\n" +
                "            <p><strong>Reports Available:</strong></p>\n" +
                "            <ul>\n" +
                "                <li>📊 Cucumber HTML Report: <code>target/cucumber-html-reports/report.html</code></li>\n" +
                "                <li>📈 Allure Report: <code>target/site/allure-maven-plugin/index.html</code></li>\n" +
                "                <li>📸 Screenshots: <code>test-screenshots/</code></li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        \n" +
                "        <div class='timestamp'>\n" +
                "            Generated on: " + timestamp + "\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}