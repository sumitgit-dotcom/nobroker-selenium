Feature: NoBroker Homepage

  Scenario: Load the NoBroker home page
    Given I open the NoBroker website
    Then the current URL should contain "nobroker.in"