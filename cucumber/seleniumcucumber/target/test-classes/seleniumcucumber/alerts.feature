Feature: Test the alerts

  Scenario Outline: Delete a customer from the database
    Given I am on Guru site
    When I enter a customer id "<customer>"
    Then An alert will appears
    And The alert should shows "Do you really want to delete this Customer?"
    And I perform the action "<action>"

    Examples:
    | customer | action |
    | Brew     | OK     |
    | John     | CANCEL |
