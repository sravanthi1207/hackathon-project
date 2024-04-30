Feature: Giftcard validation with  inputs

  @regression
  Scenario: Validation of Giftcard is navigated
    Given the user successfully navigating to the Giftcard page

  @regression
  Scenario: Validation of birthday/Aniversary inGiftcard validation
    Given the user successfully navigating to the Giftcard page
    Then the user selects Birthday/Aniversary occasion

  @regression
  Scenario: Validation of Giftcard validation with valid inputs
    Given the user successfully navigating to the Giftcard page
    Then the user selects Birthday/Aniversary occasion
    And user enters the amount "5000000" in amount section and selects invalid inputs
    Then user clicks next button

  @regression
  Scenario: Validation of Giftcard validation with invalid inputs
    Given the user successfully navigating to the Giftcard page
    Then the user selects Birthday/Aniversary occasion
    Then user clicks next button

  @regression
  Scenario: Validation of Giftcard validation navigates to next page
    Given the user successfully navigating to the Giftcard page
    Then the user selects Birthday/Aniversary occasion
    And user enters the amount "5000" in amount section and selects valid inputs
    Then user clicks next button
