Feature: Prueba

  @pruebaStepDef
  Scenario Outline: Prueba de StepDef
    When hare un post con los datos de usuario: "<usuario>", nombres: "<nombres>", apellidos: "<apellidos>"

    Examples:
      | usuario  | nombres | apellidos |
      | jbenites | jean    | benites   |