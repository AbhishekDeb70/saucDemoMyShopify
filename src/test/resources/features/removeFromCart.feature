Feature: RemoveFromCart

  Scenario: User can remove product from cart

    When User selects the product
    And Clicks on the Cart button
    Then User removes the product from cart
    And Clicks on ContinueShopping button
    Then Verifies presence of Add to Cart button on the same product