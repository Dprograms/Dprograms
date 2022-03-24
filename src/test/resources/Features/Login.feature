Feature: Yahoo Application

  @Login
  Scenario: Login functionality
    Given URL of the application
    When From Credentials sheet enter "userid"  and "password".
    And click on login
    Then user get navigate to homepage

