Feature:consume API web
  Scenario: API health end-point
    Given the API is running
    When I check the aplication status
      | name |email |gender|status|
      | Cosista|s@gmail222.com| Male|Active|
    Then The API should return
    |name|
    |Cosista|