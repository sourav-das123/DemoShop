Feature: As an Automation tester,
I want to perform actions and validation of search

Scenario Outline: Validate the search functionality

  Given Register as a user "<RowNumber>"
  And Login as a user "<RowNumber>"
  And Select for Books
  And Add Book to the Cart
  Then Click Logout


  Examples:
    | RowNumber |
    |  1 |