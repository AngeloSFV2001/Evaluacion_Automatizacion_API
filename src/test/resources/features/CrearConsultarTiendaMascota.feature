Feature: Tienda

  @CrearyConsultaOrdenes
  Scenario Outline: Insertar y consultar una orden en la tienda
    Given la aplicacion este operativa
    And inserto los valores de ordenes con id: "<id>", petId: "<petId>", quantity: "<quantity>",shipDate: "<shipDate>", status: "<status>", complete: "<complete>"
    Then valido que la respuesta es 200
    Then valido el contenido id: "<id>", petId: "<petId>", quantity: "<quantity>"
    Examples:
      | id | petId | quantity | shipDate | status | complete |
      | 11  | 0    | 0        |2024-07-03T00:55:14.804+0000|placed|true|
      | 12  | 1    | 2        |2024-07-03T00:54:14.804+0000|placed|false|
  ##
  @ConsultaOrdenes
  Scenario Outline: Consulta orden de la tienda
    Given la aplicacion este operativa
    When consulto la orden de ID: "<id>"
    Then valido que la respuesta es 200
    Examples:
      | id |
      | 1  |
      | 2  |
