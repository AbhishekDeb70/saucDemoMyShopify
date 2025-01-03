Feature: AddToCart

  Scenario: User adds item to cart and checkout

    When User selects a product
    And Clicks on Cart button
    Then User clicks on Checkout
    And Enters the firstName lastName and postalCode
    And Clicks on continue
    Then Verifies the total amount and clicks on finish
    Then Verifies the order success message