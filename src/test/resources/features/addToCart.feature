Feature: AddToCart

  Scenario Outline: User adds item to cart and checkout

    Given User launches the browser
    When User opens URL
    And User enters email and password
    And Clicks on Login
    Then User selects a product
    And Clicks on Cart button
    Then User clicks on Checkout
    And Enters the firstName lastName and postalCode
    And Clicks on continue
    Then Verifies the total amount and clicks on finish
    Then Verifies the order success message
    And Close browser
