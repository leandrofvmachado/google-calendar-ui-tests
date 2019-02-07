Feature: Notes

  Scenario: Create a single note
    Given The user in the notes screen
    And The notes are in List View
    When The user starts a new note
    And  Assign "Test" to title
    And Assign "Test" to description
    Then The note is created

  Scenario: Archive a note
    Given The user in the notes screen
    And The notes are in List View
    And The last created note has the title "Test"
    When The user archives the note
    Then The note is archived
