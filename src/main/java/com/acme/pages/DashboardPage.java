package com.acme.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    @FindBy(css = "h1, .title, [class*='dashboard'], [class*='welcome']")
    private WebElement dashboardTitle;

    @FindBy(css = ".user-profile, .profile, [class*='user']")
    private WebElement userProfile;

    @FindBy(css = "button[class*='logout'], a[class*='logout'], [class*='sign-out'], [href*='logout']")
    private WebElement logoutButton;

    @FindBy(css = ".user-options, .user-menu, [class*='user-option'], [class*='profile-menu']")
    private WebElement userOptionsButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed() {
        try {
            Thread.sleep(3000); // Wait for page load
            String currentUrl = driver.getCurrentUrl();
            String pageTitle = getPageTitle();
            
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Page Title: " + pageTitle);
            
            // Check if URL changed from login page
            boolean urlChanged = !currentUrl.equals("https://acme-test.uipath.com/") && 
                               !currentUrl.contains("login");
            
            // Check if page title indicates successful login
            boolean titleIndicatesSuccess = pageTitle != null && 
                                          (!pageTitle.toLowerCase().contains("login") ||
                                           pageTitle.toLowerCase().contains("dashboard") ||
                                           pageTitle.toLowerCase().contains("home") ||
                                           pageTitle.toLowerCase().contains("welcome"));
            
            System.out.println("URL Changed: " + urlChanged);
            System.out.println("Title Indicates Success: " + titleIndicatesSuccess);
            
            return urlChanged || titleIndicatesSuccess;
        } catch (Exception e) {
            System.out.println("Error in dashboard detection: " + e.getMessage());
            return false;
        }
    }

    public String getDashboardTitle() {
        try {
            return dashboardTitle.getText();
        } catch (Exception e) {
            return getPageTitle();
        }
    }

    public void logout() {
        try {
            logoutButton.click();
        } catch (Exception e) {
            // If logout button not found, try alternative methods
            System.out.println("Logout button not found, user session will end with browser close");
        }
    }

    public void clickUserOptions() {
        try {
            userOptionsButton.click();
            Thread.sleep(1000); // Wait after clicking user options
        } catch (Exception e) {
            System.out.println("User options button not found or not clickable");
        }
    }
}