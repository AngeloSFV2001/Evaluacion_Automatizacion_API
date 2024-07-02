Feature: World

  @pruebaWorld
  Scenario: Prueba Servicio

    When ejecuto servicio Word
    Then valido el codigo de respuesta 200
    And valido el contenido

