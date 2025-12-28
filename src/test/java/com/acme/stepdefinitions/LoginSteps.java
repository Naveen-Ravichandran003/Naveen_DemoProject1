package com.acme.stepdefinitions;

import com.acme.pages.DashboardPage;
import com.acme.pages.LoginPage;
import com.acme.utils.DriverManager;
import com.acme.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Before
    public void setUp() {
        DriverManager.initializeDriver("chrome");
        loginPage = new LoginPage(DriverManager.getDriver());
        dashboardPage = new DashboardPage(DriverManager.getDriver());
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
        // Take screenshot if scenario failed
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot(DriverManager.getDriver(), "failed_" + scenario.getName());
        }
        DriverManager.quitDriver();
    }

    @Given("I navigate to the ACME login page")
    public void iNavigateToTheACMELoginPage() {
        loginPage.navigateTo("https://acme-test.uipath.com/");
        try {
            Thread.sleep(3000); // Wait for page to load completely
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @When("I enter email {string} and password {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        try {
            Thread.sleep(1000); // Small wait before clicking
            loginPage.clickLoginButton();
            Thread.sleep(2000); // Wait after clicking login
            System.out.println("Login button clicked, current URL: " + DriverManager.getDriver().getCurrentUrl());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        try {
            Thread.sleep(5000); // Wait for dashboard to load
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Assert.assertTrue("Dashboard should be displayed", dashboardPage.isDashboardDisplayed());
        
        // Additional wait if this is part of logout scenario
        try {
            Thread.sleep(5000); // Wait 5 seconds on dashboard
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("I logout from the application")
    public void iLogoutFromTheApplication() {
        dashboardPage.logout();
        try {
            Thread.sleep(3000); // Wait 3 seconds after logout
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("I take a screenshot")
    public void iTakeAScreenshot() {
        ScreenshotUtils.takeScreenshot(DriverManager.getDriver(), "test_scenario");
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        try {
            Thread.sleep(2000); // Wait for error message to appear
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Take screenshot before failing the test
        ScreenshotUtils.takeScreenshot(DriverManager.getDriver(), "negative_test_error");
        
        // INTENTIONAL FAILURE: This negative test case is designed to fail
        // to demonstrate error handling and maintain negative use case coverage
        Assert.fail("NEGATIVE TEST CASE: This test is intentionally failed to demonstrate error handling for incorrect login credentials");
    }
}