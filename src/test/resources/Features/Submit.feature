Feature: As an Automation tester,
  I want to perform actions and validation of submitorder

  Scenario Outline: Validate the submit functionality

    Given Login as a user "<RowNumber>"
    And Select for Books
    And Add Book to the Cart
    And Click on CheckOut "<RowNumber>"
    And Validate the CheckOut details "<RowNumber>"
    And Validate the shipping method
    And Validate the payment method "<RowNumber>"


    Examples:
      | RowNumber |
      |  1 |