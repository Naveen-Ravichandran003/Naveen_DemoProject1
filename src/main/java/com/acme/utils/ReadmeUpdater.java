package com.acme.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReadmeUpdater {
    
    private static final String README_PATH = "README.md";
    
    public static void updateReportLinks() {
        try {
            Path readmePath = Paths.get(README_PATH);
            if (!Files.exists(readmePath)) {
                System.out.println("⚠️ README.md not found");
                return;
            }
            
            String content = Files.readString(readmePath);
            String updatedContent = updateReportSections(content);
            
            Files.writeString(readmePath, updatedContent);
            System.out.println("✅ README.md updated with latest report links");
            
        } catch (IOException e) {
            System.out.println("❌ Failed to update README.md: " + e.getMessage());
        }
    }
    
    private static String updateReportSections(String content) {
        // Update Cucumber Report link
        content = content.replaceAll(
            "- \\*\\*Cucumber Report\\*\\*: \\[View Report\\]\\([^)]+\\)",
            "- **Cucumber Report**: [View Report](target/cucumber-html-reports/report.html)"
        );
        
        // Update TestNG Report link  
        content = content.replaceAll(
            "- \\*\\*TestNG Report\\*\\*: \\[View Report\\]\\([^)]+\\)",
            "- **TestNG Report**: [View Report](target/testng-html-report.html)"
        );
        
        return content;
    }
}