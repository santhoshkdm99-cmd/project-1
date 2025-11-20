@tag
Feature: E-commerce Order Placement
@tag
  Scenario Outline: Place an order successfully
    Given I open the e-commerce login page
    When I enter username <email> and password <password>
    And I add the product ADIDAS ORIGINAL to the cart
    And I proceed to checkout
    And I place the order with CV <CVV> and CardName <CardName> Country <Country>

    Examples:
      | email                       | password   | CVV  | CardName |Country |
      | hardikmohan3300@gmail.com   | 1234567Sk. | 1234 | visa      | India   |