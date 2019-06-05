@feature:search
Feature: Google Homepage Search


  @Manual
  Scenario Outline: Application shows correct result
    Given The user is on the homepage
    And The user type "<Search criteria>" into the search field
    And The user click the Google Search button
    When The user clicks the first result
    Then The user should see the "<Expected page>" page

    Examples:
      | Search criteria	        | Expected page                |
      | The name of the wind	| Patrick Rothfuss - The Books |


