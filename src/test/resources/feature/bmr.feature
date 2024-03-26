@tag
Feature: Calculate Basal Metabolic Rate
  As a user of the health calculatorI want to calculate the basal metabolic rate according to the parameters entered so that I can know the resulting of this health measurement

  @tag1
  Scenario Outline: Invalid Height
    Given  I have an health calculator
    When I estimate the basal metabolic rate of an invalid Height <h>
    Then the calculator throws an exception

    Examples: 
      | h |
      |-15|
      |-1|
      | -12 |

   @tag2
  Scenario Outline: Invalid Weight
    Given  I have an health calculator
    When I estimate the basal metabolic rate of an invalid gender <g>
    Then the calculator throws an exception

    Examples: 
      | g |
      |'0'|
      |'p'|
      |'1'|

  @tag3
  Scenario Outline: Invalid Age
    Given  I have an health calculator
    When  I estimate the basal metabolic rate of a negative age <a>
    Then the calculator throws an exception

    Examples: 
      | a |
      |-9|
      |-4|
      |-97|

   @tag4
  Scenario Outline: Invalid Weight
    Given  I have an health calculator
    When I estimate the basal metabolic rate of an invalid weight <w>
    Then the calculator throws an exception

    Examples: 
      | w |
      |-12|
      |-21|
      |-5| 

	@tag6
    Scenario Outline: Given valid parameters
	    Given  I have an health calculator
		When I estimate the basal metabolic rate for the given valid parameters <w> , <h> , <g> , <a>
		Then the calculator returns a valid result <result>
		Examples: 
      | h | w  | a| g | result|
      | 170| 80 |55|'w'|'1426.5'|
      |150|21|13|'m'|'1087.5' | 
      | 167| 65|22|'m'|'1588.75'| 
      |170|80|55|'m'|'1592.5'| 