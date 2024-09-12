Feature: Place Order Flow

#  @Smoke
  Scenario: Add product to cart and place an order
    Given I am on the product page
    When User adds a product to the cart
    Then User clicks to navigate to the Your Cart page
    Then User clicks on the Checkout button
    Then User fills in the FirstName Last and ZipCode on Checkout: Your Information form
    And clicks on Continue
    Then User clicks on Finish on the Checkout: Overview page
    Then User sees the order successful message
