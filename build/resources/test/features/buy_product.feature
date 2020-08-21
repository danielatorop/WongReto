Feature:Search products with different categories

  Scenario: Find Meat Products
    Given that the wong page is open
    When the actor search and chooses the product
      | type product |name product|
      | Carnes  |Asado de Tira Sin Hueso Wong Premium x kg|
    Then the actor must validate the product chosen for the purchase
      |name product result|
      |Asado de Tira Sin Hueso Wong Premium x kg|