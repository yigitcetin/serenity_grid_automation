Feature: Login With Invalid Credentials

  Scenario: Try to login with wrong password
    Given Yigit, an existing customer navigates to application home page
    When he click login button
    Then he writes his "valid" email address
    Then he writes his "invalid" password
    Then he click submit button
    And he should see invalid credentials error message

  Scenario: Try to login with wrong format email format
    Given Yigit, an existing customer navigates to application home page
    When he click login button
    Then he writes his "invalid" email address
    Then he writes his "valid" password
    Then he click submit button
    And he should see wrong email format error message
