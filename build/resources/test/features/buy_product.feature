Feature:Search products with different categories

  Scenario: Find Meat Products
    Given that the wong page is open
    When the actor search and chooses the product
      | type product |name product|
      | Carnes  |Corazón de Cuadril Argentino Tierra del Fuego x kg|
    Then the actor must validate the product chosen for the purchase
      |name product result|
      |Corazón de Cuadril Argentino Tierra del Fuego x kg|