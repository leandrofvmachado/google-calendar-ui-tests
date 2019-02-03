Feature: Notes

  Scenario Outline: Create a single note
    Given The user in the notes screen
    And The notes are in List View
    When The user starts a new note
    And  Assign <title> to title
    And Assign <body> to description
    Then The note is created

    Examples:
      | title | body |
      | Test  | Test |

  Scenario: Archive a note
    Given The user in the notes screen
    And The notes are in List View
    And The last created note has the title "Test"
    When The user archives the note
    Then The note is archived