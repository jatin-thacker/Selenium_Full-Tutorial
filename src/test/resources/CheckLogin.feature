Feature: Login Functionality - Positive Scenarios
  @PositiveTest @SmokeTest @LoginTest
  Scenario Outline: Verify the functionality of login page 
    Given I am present on the home page of the WebDriver University
    When I click the login button
    And I switch to the new tab
    And Enter the "<u>" as username and "<p>" as password
    Then The user should get a pop-up
  Examples:
  | u | p |
  | number1 | hello |  
  | number2 | development |
    
    
  
    