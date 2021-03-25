Feature: Test Click - Scenarios 
  @PositiveTest @SmokeTest @ClickTest
  Scenario Outline: Verify the click functionality  
    Given I am present on the home page of the WebDriver University
    When I click the Click_button icon
    And I switch to the new tab
    And I click the "<n>" click element
    Then The user should get acknowledgment and pop-up with the message as "<message>"
  Examples:
  | n | message |
  | 2 | Well done for successfully using the click() method! |  
  | 2 | We can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc). |    
  | 3 | Advanced user interactions (API) has been developed to enable you to perform more complex interactions such as |
    
