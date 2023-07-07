Feature: As a customer, I want to search a specific item

  Scenario: search for stainless work table
    Given I am on the webstauranstore homepage
    When I search for the product "stainless work table"
    Then I should see the search results
    And I verify that all product titles contain the keyword "Table"
    And Add the last of found items to Cart
    Then Empty the Cart