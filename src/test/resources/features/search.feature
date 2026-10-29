Feature: NoBroker Property Search

  Scenario: Search for properties in Safdarjung Enclave
    Given I open the NoBroker website
    When I click on the "Buy" tab
    And I click on the "Flat" property type
    And I select the "Owner" filter
    And I type "Safdarjung Enclave" into the search locality
    And I click on the search icon
    Then the search results page should load