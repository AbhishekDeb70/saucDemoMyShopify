Feature: MultipleProductsToCart

  Scenario: User adds multiple products to cart and checks out

    When User selects multiple products
    And Clicks on shopping cart button
    Then Clicks on checkout button
    And Enters the necessary details
    And Clicks on continue button
    Then Verifies the total cart amount
    And Clicks on finish button
    Then Verifies order success message
