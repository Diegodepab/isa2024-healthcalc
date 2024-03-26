#Author: Diegodepab
@tag
#nombre del feature
Feature: Calculate Ideal Weight
I want to calculate my ideal weight based on the information I provide.
#descripcion de este feature

#Scenario: Es el caso de prueba que se va a ejecutar.
#Given: Es el estado inicial antes de la prueba. Aquí se preparan los datos de prueba.
#When: Es la acción que se va a realizar.
#Then: Es el resultado esperado de la prueba.
#Examples: Son los datos de prueba que se van a utilizar.
  @tag1
  Scenario Outline: Invalid Height
    Given I have an health calculator
    When I estimate the ideal weight for invalid height <h>
    Then the calculator throws an exception

   	Examples: 
      | h |
      |-100|
      |-1 |
      | 0 |

  @tag2
  Scenario Outline: Invalid Gender
    Given I have an health calculator
    When I estimate the ideal weight for an invalid gender <g>
    Then the calculator throws an exception

   	Examples: 
      | g |
      |'9'|
      |'w'|
      |'p'|

  @tag3
  Scenario Outline: Negative Weight Result
    Given I have an health calculator
    When I estimate the ideal weight for gender <g> and height <h> and gives a negative result
    Then the calculator throws an exception

   	Examples: 
      | g | h |
      |'m'| 80|
      |'w'| 70|
      |'m'| 46|
      |'w'| 46|

	@tag4
  Scenario Outline: ideal Weight Result
    Given I have an health calculator
    When I estimate the ideal weight for gender <g> and height <h>
    Then the calculator return a result <value>

   	Examples: 
      | g |  h | value |
      |'w'| 160| '56' |
      |'w'| 170|'62'|
      |'m'| 170|'65'|
      |'m'| 174|'68' |