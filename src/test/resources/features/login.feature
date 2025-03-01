Feature: Login

  Scenario Outline: Successful Login
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page

    Examples:
      | username       | password        |
      | admin1         | securePassword  |


  Scenario Outline: UnSuccessful Login
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should not be redirected to the home page

    Examples:
      | username       | password        |
      | admin          | securePassword  |