Feature: Login to saucedemo site

  @Smoke
  Scenario: User logs in successfully
    When the user enters valid username "problem_user"
    And the user enters valid password "secret_sauce"
    Then the user clicks the login button

  Scenario: User login with valid username and invalid password
    When the user enters valid username "standard_user"
    And the user enters invalid password "secret_"
    And the user clicks the login button
    Then an error message is displayed on the screen


  Scenario: User login with invalid username and valid password
    When the user enters invalid username "standard_"
    And the user enters valid password "secret_sauce"
    And the user clicks the login button
    Then an error message is displayed on the screen


  Scenario Outline: User login with invalid credentials
    When the user enters invalid username "<userName>"
    And the user enters invalid password "<passWord>"
    And the user clicks the login button
    Then an error message is displayed on the screen

    Examples:
      | userName     | passWord    |
      | standard_use | secret_sauc |
      | standard_    | secret_sau  |
      | standar_use  | secret_     |
