Feature: Test all features associated with comments on the POST
  Scenario: Get all comments for a post
    Given User hits endpoint to get comments
    When User sends request all comments for POST "1"
    Then A list of comments is returned

  Scenario: Get all comments for a post
    Given User hits endpoint to get comments
    When User queries to get comments for post with "1"
    Then A list of comments is returned where the postID is "1"