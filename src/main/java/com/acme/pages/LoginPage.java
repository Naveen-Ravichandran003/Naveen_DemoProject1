package com.acme.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit'], input[type='submit'], .btn-login, button:contains('Log in'), button:contains('Login')")
    private WebElement loginButton;

    @FindBy(css = ".alert, .error-message, [class*='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        } catch (Exception e) {
            System.out.println("Login button not found with primary selector, trying alternative...");
            // Try alternative selectors
            try {
                WebElement altButton = driver.findElement(org.openqa.selenium.By.xpath("//button[contains(text(),'Log') or contains(text(),'LOGIN')]"));
                altButton.click();
            } catch (Exception ex) {
                System.out.println("Could not find login button: " + ex.getMessage());
                throw ex;
            }
        }
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}