package com.acme.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initializeDriver(String browserName) {
        // Quit existing driver if any
        if (driver.get() != null) {
            quitDriver();
        }
        
        ChromeOptions options = new ChromeOptions();
        
        // Add stability options for Java 25
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-blink-features=AutomationControlled");
        
        // Add experimental options with correct syntax
        java.util.Map<String, Object> prefs = new java.util.HashMap<>();
        prefs.put("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", java.util.Arrays.asList("enable-automation"));
        
        // Check for headless mode
        String headless = System.getProperty("headless", "false");
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
        }
        
        try {
            WebDriver webDriver;
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + browserName);
            }
            
            driver.set(webDriver);
            
            if (!"true".equalsIgnoreCase(headless)) {
                driver.get().manage().window().maximize();
            }
            
            // Set timeouts
            driver.get().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
            driver.get().manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));
            
        } catch (Exception e) {
            System.out.println("Error initializing driver: " + e.getMessage());
            throw e;
        }
    }

    public static void quitDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            try {
                webDriver.quit();
            } catch (Exception e) {
                System.out.println("Error quitting driver: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}