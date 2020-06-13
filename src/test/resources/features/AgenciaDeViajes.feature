#Author: pacho0323@hotmail.com

@tag
Feature: Agencia de viajes
  Yo como usuario 
  quiero buscar la tarifa economica en diferentes destinos

  @tag1
  Scenario Outline: Buscar tarifa mas economica
    Given que el usuario se encuentre en la pagina web
    When realice la busqueda con los datos solicitados
    | <LOCATION> | <MES INICIO> | <ANO INICIO> | <DIA INICIO> | <MES FIN> | <ANO FIN> | <DIA FIN> | <ROOMS> |	<ADULTS>	| <CHILDREN> | 
    And buscara el precio mas economico
    | <DIA INICIO> | <MES INICIO> | <ANO INICIO> | <DIA FIN> | <MES FIN> | <ANO FIN> |
    Then valide el precio Total
    
Examples:
    | ID | LOCATION | MES INICIO | ANO INICIO | DIA INICIO | MES FIN |ANO FIN | DIA FIN | ROOMS |	ADULTS | CHILDREN |
      ##@externaldata@./src/test/resources/datadriven/AgenciaDeViajes.xlsx@Datos@1
   |1   |San Francisco   |SEPTEMBER   |2020   |25   |OCTOBER   |2020   |8   |1   |1   |0|
