Feature: Test all the feature associated with POST


  Scenario: Validate API to fetch all post
    Given User hits endpoint to get posts
    When User send the get request
    Then The User should get a response with all the post

  Scenario: Validate that the user is able to search for a particular post with Post ID
    Given User hits endpoint to get posts
    When User send the post ID "1" in the request
    Then The User should get a response with the post having ID "1"

  Scenario: Validate that a user is allowed to create a POST
    Given User hits endpoint to get posts
    When User sends a POST request to create a new POST UserID 9 And Post Title "Dummy Post Title" And Post Body "Dummy Post Body"
    Then Validate that a new POST gets created with UserID 9 And Post Title "Dummy Post Title" And Post Body "Dummy Post Body"


  Scenario: Validate that the user is able to search all post submitted by a user
    Given User hits endpoint to get posts
    When User searches for all post submitted by user with userID 7
    Then Validate that all the posts submitted by the user is displayed

  Scenario: Validate that a user is able to EDIT a post

  Scenario: Validate that a user is able to DELETE a post