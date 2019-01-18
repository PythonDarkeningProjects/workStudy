Feature: Search with Google

  Scenario: Finding some cheese on Google
    Given I am on Google search page
    When I search for "Cheese!"
    Then The page title should start with "cheese"

