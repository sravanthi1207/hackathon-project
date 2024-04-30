Feature: Valid Inputs

  @smoke
  Scenario Outline: Validation of Form with valid inputs
    Given the user successfully navigating to the Giftcard page
    Then the user selects Birthday/Aniversary occasion
    And user enters the amount "5000" in amount section and selects valid inputs
    Then user clicks next button
    And user enters the valid "<row_index>" from excel in the form
    Then user clicks the submit button
    Then user checks the confirmdetails page is visible

    Examples: 
      | row_index |
      |         2 |

  @regression
  Scenario Outline: Validation of Form with invalid Mail
    Given the user successfully navigating to the Giftcard page
    Then the user selects Birthday/Aniversary occasion
    And user enters the amount "5000" in amount section and selects valid inputs
    Then user clicks next button
    And user enters the invalid "<row_index>" from excel in the form
    Then user clicks the submit button
    Then user checks the confirmdetails page is visible

    Examples: 
      | row_index |
      |         1 |

  @regression
  Scenario Outline: Validation of Form with invalid name
    Given the user successfully navigating to the Giftcard page
    Then the user selects Birthday/Aniversary occasion
    And user enters the amount "5000" in amount section and selects valid inputs
    Then user clicks next button
    And user enters the invalid "<row_index>" from excel in the form
    Then user clicks the submit button
    Then user checks the confirmdetails page is visible

    Examples: 
      | row_index |
      |         3 |

  @regression
  Scenario Outline: Validation of Form with invalid mobile
    Given the user successfully navigating to the Giftcard page
    Then the user selects Birthday/Aniversary occasion
    And user enters the amount "5000" in amount section and selects valid inputs
    Then user clicks next button
    And user enters the invalid "<row_index>" from excel in the form
    Then user clicks the submit button
    Then user checks the confirmdetails page is visible

    Examples: 
      | row_index |
      |         4 |
