@feature:search
Feature: Google Homepage Search

  Scenario Outline: User searches with "Google Search" button
    Given The user is on the homepage
    When The user type "<Search criteria>" into the search field
    And The user click the Google Search button
    And The user go to the search results page
    Then the first result should be "<Expected first result>"

  Examples:
  | Search criteria	        | Expected first result                  |
  | The name of the wind	| The Name of the Wind - Patrick Rothfuss|

  Scenario Outline: User searches by using the suggestions
    Given The user is on the homepage
    When The user type "<Search criteria>" into the search field
    And the suggestions list is displayed
    And The user clicks on the first suggestion in the list
    And The user go to the search results page
    Then the first result should be "<Expected first result>"

  Examples:
  | Search criteria	    | Expected first result                  |
  | The name of the w	| The Name of the Wind - Patrick Rothfuss|