Feature: Actions Page - Scenarios 
  @PositiveTest @SmokeTest @ActionsTest
  Scenario: Verify the color changing on double click functionality  
    Given I am present on the home page of the WebDriver University
    When I click the Actions button icon
    And I switch to the new tab
    And I double click the DoubleClickMe icon
    Then the color of icon should be changed
    
  @PositiveTest @SmokeTest @ActionsTest
  Scenario Outline: Verify the color changing on double click functionality  
    Given I am present on the home page of the WebDriver University
    When I click the Actions button icon
    And I switch to the new tab
    And I hover over the "<nth>" icon 
    Then the link should be visible 
    And clicking the link should give you a pop-up
    Examples:
    |nth|
    |1|
    |2|
    |3|
    
	