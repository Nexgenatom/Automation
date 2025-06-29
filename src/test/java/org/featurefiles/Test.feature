Feature: API Testing with RestAssured and Cucumber

  Scenario Outline: Verify API response for a user
    Given i send a GET request to "/api/users/2"
    Then the response status code should be 200
    And the response body should contain <userId>
    Examples: 
      |userId|
      |2|
      |3|
      |23|