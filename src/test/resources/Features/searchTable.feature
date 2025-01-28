Feature: As a customer, I want to search a specific item

  Scenario Outline: search for stainless work table
    Given Customer is on the webstauranstore homepage
    When Customer search for the product <product>
    Then Customer should see the search results
    And Verifies that all product titles contain the keyword <keyword>
    And Customer adds the last of found items to Cart
    And Customer empty the Cart
    Then Customer should see the <emptyMessage>
    Examples:
      | product                | keyword | emptyMessage          |
      | "stainless work table" | "Table" | "Your cart is empty." |
