Feature: Display BookShelves

  Scenario: urbanlader Bookshelves
    Given search for bookselves
    When select kids category
    And select in stock
    And priority high to low
    Then Print the first three bookshelves

  Scenario: Living
    Given Hover mouse to living
    When sub menus should be appeared and print it
