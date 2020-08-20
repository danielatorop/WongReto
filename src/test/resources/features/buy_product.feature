Feature:Search products with different categories


  Scenario: Find Meat Products
    Given that the wong page is open
    When the search and chooses the product
      | type product |name product|
      | Carnes  |Corazón de Cuadril Argentino Tierra del Fuego x kg|
    Then should validate the purchase of his product
