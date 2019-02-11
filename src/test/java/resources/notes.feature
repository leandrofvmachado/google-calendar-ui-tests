Feature: Notes
  @Ignore
  Scenario: Create a single note
    Given The user in the notes screen
    And The notes are in List View
    When The user starts a new note
    And  Assign "Test" to title
    And Assign "Test" to description
    Then The note is created
@Ignore
  Scenario: Archive a note
    Given The user in the notes screen
    And The notes are in List View
    And The last created note has the title "Test"
    When The user archives the note
    Then The note is archived

  Scenario: Create a reminder
    Given The user in the notes screen
    And The notes are in List View
    When The user starts a new note
    And  Assign "Test" to title
    And Assign "Test" to description
    And Assign a reminder for "Tomorrow" at "Night"
    Then The note is created with a reminder