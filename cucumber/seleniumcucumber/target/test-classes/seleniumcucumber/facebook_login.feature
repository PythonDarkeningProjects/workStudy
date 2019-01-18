Feature: Testing Facebook Log-In

  Scenario: Facebook Log-In
    Given I am on the Facebook page
    When I put my email "some_email@gmail.com"
    And I put my password "123"
    Then The page title should start with the following "Log into Facebook"