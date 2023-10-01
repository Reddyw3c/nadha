

Feature: HRMS
 
  @login
  Scenario: login
  
    Given User in login page
    When User enter username "nareshit"
    And user enter password "nareshit"
    And user clicks the login button
    Then user should be logged in successfully
    

  
