Feature: Add to Cart and Remove Cart Functionality

  Background: When User login to saucedemo site

  Scenario: Add a Product to Cart
    Given I am on the product page
    When I click the Add to Cart button
    Then the cart quantity should increase by 1
    And the product should be displayed in the cart summary

  Scenario: Remove a Product from Cart
    Given I am on the product page
    When I have a product in my cart
    When I click the Remove button for that product
    Then the product should be removed from the cart
    And the cart quantity should decrease by 0

  Scenario: Add Multiple Products to Cart and Remove Them
    Given I am on the product page
    When I add multiple products to the cart
    Then the cart quantity should reflect the total number of added products
    When I remove all products from the cart
    Then the cart should be empty

  Scenario: Click on "Add to Cart" Icon and Navigate to Cart
    Given I am on the product page
    When I have a product in my cart
    When I click the Add to Cart icon in the header
    Then I should be redirected to the cart page
    And the product should be displayed in the cart with the correct quantity and price