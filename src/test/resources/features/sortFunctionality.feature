Feature: SortFunctionality

  Scenario: User can sort products on the basis of price

    When User clicks on Sorting menu
    And Sets the price from High to Low
    Then Verifies the price of the costliest product