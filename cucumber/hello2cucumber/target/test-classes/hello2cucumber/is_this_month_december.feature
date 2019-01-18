@important
Feature: Is this month December?
  Everybody want to know when it's December

  Scenario Outline: This month is or not is December
    Given This month is "<month>"
    When The folks ask if this month is December
    Then I have to said "<answer>"

    Examples:
      | month    | answer          |
      | january  | nope            |
      | february | nope            |
      | december | merrychristmas |