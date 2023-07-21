
Feature: Login Functionality of the banking Application

  @Login
  Scenario: Login with valid credentials
    Given  User is on the login page
    When  User enters the valid  username and password
    Then  User is able to login into the application
