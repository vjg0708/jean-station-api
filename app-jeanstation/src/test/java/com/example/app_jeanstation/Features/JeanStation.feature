Feature: Product API Management

  Scenario: Create new Products
    Given Enter the post request url
    And Enter the product details
    When Post the product details
    And Validate the product name
    And Validate the product price

  Scenario: Get the product details
    Given Enter the get request url
    And Enter the product details
    When Get the product details
    And Validate the Status code
    And Validate the product name
    And Validate the product price

  Scenario: PUT Update the product details
    Given Enter the put request url
    And Enter Updated product details
    When Put the product details
    And Validate the Status code
    And Validate the product name
    And Validate the product price

  Scenario: PATCH Update the product details
    Given Enter the patch request url
    And Enter Updated product details
    When Patch the product details
    And Validate the Status code
    And Validate the product name
    And Validate the product price

  Scenario: Delete the product details
    Given Enter the delete request url
    When Delete the product details
    And Validate the Status code

  Scenario: Placing the order
    Given Enter the placing order request url
    And Enter the desired product details
    When Post the product details
    And Validate the Status code
    And validate the Order Status

  Scenario: Releasing the order
    Given Enter the releasing order request url
    And Enter the Order details
    And validate Release status
