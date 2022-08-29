#Author: Ertuğrul Demir
Feature: feature to test car key control


  Scenario Outline: Title of your scenario outline
    Given is in the car 
    When the driver inserts the <key> into the car and starts it
    Then the car runs

    Examples: 
      | key | 
      | 123 |
      | 234 |
      | 345 |
      | 456 |
