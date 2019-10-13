Feature:Test all features associated with Users
  Scenario: Validate that endpoint return all users currently active in the system
    Given User hits endpoint to get users
    Then User should get a valid response and list of all users