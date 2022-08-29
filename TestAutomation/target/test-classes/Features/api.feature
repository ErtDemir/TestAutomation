#Author: Ertuğrul Demir

Feature: feature to test API
 
  Scenario: Title of your scenario
    Given is in gorest.co.in website
    When send a get request to the endpoint users
    And get the user details that users id is 82
    Then check the gender is female and status is active
