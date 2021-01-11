Feature: Login With Valid Credentials

  Scenario: Login with valid credentials
    Given Yigit, an existing customer navigates to application home page
    When he click login button
    Then he writes his "valid" email address
    Then he writes his "valid" password
    Then he click submit button
    Then he should redirect to home page
    And he should see his "test001 User" under account button
