Feature: NoBroker Login and Modal

  @LoginTest
  Scenario: Verify Login Modal and Phone Number Entry
    Given I open the NoBroker website
    When I click on the Login button in the header
    And I enter the phone number "8871220199" in the login modal
    Then I toggle the "I am not a broker" switch off