Feature: Test Automation

  Scenario: Order T-Shirt
    Given I access the shopping website "http://automationpractice.com"
    When I fill in login name "analystanju@gmail.com" and password "Password123"
    Then The user name "Anju Singhal" is visible in the main page
    When I click on "T-shirts" tab
    And I hover on "Faded Short Sleeve T-shirts" click on Add to cart
    And I click on Proceed to checkout on the pop up window
    And I click on Proceed to checkout on SHOPPING-CART SUMMARY
    And I click on Proceed to checkout on ADDRESSES
    And I click on Terms of service then Proceed to checkout on SHIPPING window
    And I arrive at the Payment page
    And I click on the user name "Anju Singhal"
    And I click on "Order history and details" on My account page
    Then The order details are visible
    And I logout from the shopping website

  Scenario: Update Personal Information
    Given I access the shopping website "http://automationpractice.com"
    When I fill in login name "analystanju@gmail.com" and password "Password123"
    Then The user name "Anju Singhal" is visible in the main page
    And I click on the user name "Anju Singhal"
    And I click on "My personal information" on My account page
    And I update the "firstname" as "Sanju"
    And I click on Save
    Then The user name "Sanju Singhal" is visible in the main page
    And I click on the user name "Sanju Singhal"
    And I click on "My personal information" on My account page
    And I update the "firstname" as "Anju"
    And I click on Save
    Then The user name "Anju Singhal" is visible in the main page
    And I logout from the shopping website
