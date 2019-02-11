Feature: List

  Scenario: Create a list
    Given The user in the notes screen
    And The notes are in List View
    When The user starts a new list
    And Assign "Test" to title
    And Assign the following items to the list
      |first_item|second_item|third_item|
      |test1|test2|test3|
    And Removes the last one
    Then The note list is created with the correct items

