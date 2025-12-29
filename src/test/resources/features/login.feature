Feature: Login Functionality
  As a user of the ACME application
  I want to be able to login with valid credentials
  So that I can access the dashboard

  Background:
    Given I navigate to the ACME login page

  Scenario: User login and verify dashboard
    When I enter email "test-demo@acme.com" and password "Test@1234"
    And I click the login button
    Then I should be redirected to the dashboard

  Scenario: User logout functionality
    When I enter email "test-demo@acme.com" and password "Test@1234"
    And I click the login button
    Then I should be redirected to the dashboard
    And I logout from the application

  Scenario: NEGATIVE TEST - User login with incorrect password (Intentional Failure)
    When I enter email "test-demo@acme.com" and password "WrongPassword123"
    And I click the login button
    Then I should see an error message