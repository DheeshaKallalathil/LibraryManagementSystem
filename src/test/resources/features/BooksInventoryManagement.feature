Feature: Books Inventory Management

  Scenario Outline: User logs in and adds a book to the inventory
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page
    When the user clicks on the Add Book button
    Then the user should be navigated to the Add Book page
    When the user enters the book details: "<title>", "<author>", "<genre>", "<isbn>", "<pub_date>", "<price>"
    And clicks on the "Add Book" button
    Then the newly added book "<title>" should be displayed on the home page

    Examples:
      | username | password        | title             | author     | genre   | isbn          | pub_date   | price  |
      | admin1   | securePassword  | The Great Gatsby  | F. Scott   | Fiction | 9780743273565 | 1925-04-10 | 10.99 |


  Scenario Outline: User edits the Book title
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page
    When the user clicks on the edit button for a specific book
    Then the user is navigated to the Edit Book Details page
    And enters a new title "<title>" in the title field
    And clicks on the Save Changes button
    Then the updated book title "<title>" is displayed on the home page


    Examples:
      | username | password        | title             |
      | admin1   | securePassword  | The Great Gatsby  |


  Scenario Outline: User logs in and adds a book to the inventory with invalid title and genre
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page
    When the user clicks on the Add Book button
    Then the user should be navigated to the Add Book page
    When the user enters the book details: "<title>", "<author>", "<genre>", "<isbn>", "<pub_date>", "<price>"
    And clicks on the "Add Book" button
    Then error message should be displayed

    Examples:
      | username | password        | title                                      | author         | genre   | isbn          | pub_date   | price |
      | admin1   | securePassword  | Harry Potter and the Order of the Phoenix  | J.K. Rowling   | Fiction | 9780743273565 | 2003-07-21 | 10.99 |
      | admin1   | securePassword  | It                                         | Stephen King   | Horror  | 9780743273565 | 2003-07-21 | 10.99 |

    # This test case will fail, as unauthorised users are able to access the books catalog and make changes
  Scenario Outline: Logged-out users cannot edit books
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page
    When the user clicks the Logout button
    Then the user is logged out but remains on the home page
    When the user tries to update a book via the edit button
    Then the user should receive an error message

    Examples:
      | username | password        |
      | admin1   | securePassword  |

  Scenario Outline: User can successfully delete a book from book list
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page
    When user clicks on the delete button
    Then the book should be removed from the list

    Examples:
      | username | password        |
      | admin1   | securePassword  |

    # Date field accepts invalid date format. Error is only shown after saving the details
  Scenario Outline: Display error for invalid date input
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page
    When the user clicks on the Add Book button
    Then the user should be navigated to the Add Book page
    When the user enters the book details: "<title>", "<author>", "<genre>", "<isbn>", "<pub_date>", "<price>"
    And clicks on the "Add Book" button
    Then the newly added book "<title>" should be displayed on the home page
    Then "Invalid Date" should be displayed in the publication date field

    Examples:
      | username | password        | title             | author     | genre   | isbn          | pub_date   | price  |
      | admin1   | securePassword  | The Great Gatsby  | F. Scott   | Fiction | 9780743273565 | 192504abc | 10.99 |

  #Assuming ISBN is not unique in this case
  Scenario Outline: Verify that duplicate ISBNs are  allowed
    Given the user is on the Login page
    When the user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page
    When the user clicks on the Add Book button
    Then the user should be navigated to the Add Book page
    When the user enters the book details: "<title>", "<author>", "<genre>", "<isbn>", "<pub_date>", "<price>"
    And clicks on the "Add Book" button
    Then the newly added book "<title>" should be displayed on the home page
    When the user clicks on the Add Book button
    Then the user should be navigated to the Add Book page
    When the user enters the book details: "<title>", "<author>", "<genre>", "<isbn>", "<pub_date>", "<price>"
    And clicks on the "Add Book" button
    Then the newly added book "<title>" should be displayed on the home page

    Examples:
      | username | password        | title             | author         | genre   | isbn          | pub_date   | price  |
      | admin1   | securePassword  | The Great Gatsby  | F. Scott       | Fiction | 9780743273565 | 192504abc | 10.99 |
      | admin1   | securePassword  | It                | Stephen King   | Fiction  | 9780743273565 | 2003-07-21 | 10.99 |
