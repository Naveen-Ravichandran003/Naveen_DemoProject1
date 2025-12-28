package com.acme.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    
    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
            
            // Create screenshots directory
            File screenshotsDir = new File("test-screenshots");
            screenshotsDir.mkdirs();
            
            File destFile = new File(screenshotsDir, fileName);
            FileUtils.copyFile(sourceFile, destFile);
            
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
            
            // Attach to Allure report
            attachScreenshotToAllure(sourceFile);
            
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
    
    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] attachScreenshotToAllure(File screenshot) {
        try {
            return FileUtils.readFileToByteArray(screenshot);
        } catch (IOException e) {
            System.out.println("Failed to attach screenshot to Allure: " + e.getMessage());
            return new byte[0];
        }
    }
}