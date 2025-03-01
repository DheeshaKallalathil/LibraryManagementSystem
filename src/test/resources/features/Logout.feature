Feature: Logout


Scenario Outline: User is logged out
  Given the user is on the Login page
  When the user enters username "<username>" and password "<password>"
  And clicks on the login button
  Then the user should be redirected to the home page
  When the user clicks the Logout button
  Then the user is logged out but remains on the home page

  Examples:
| username       | password        |
| admin1         | securePassword  |