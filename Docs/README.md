# REFACTORING
En esta práctica toca aplicar los refactorings correspondientes para adaptar la implementación actual de la calculadora al siguiente esquema.

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica7/Images/Esquema_pracitca7.png" width="1000" title="decorador">
</p>

NOTA: tanto CardiovascularMetrics, como MetabolicMetrics, son interfaces

<a name="refactoring1"> </a>
## refactoring1 << enum >> Gender 
  - **Bad smells:**  [obsesión primitiva (Primitive Obsession)](https://refactoring.guru/smells/primitive-obsession))
  - **El refactorings aplicados para resolverlo:** Remplazar dato del tipo valor por un enum (Replace Data Value with Object)
  - **tipo o categoría de refactorización:** Refactorización de clases (Class Refactoring)
  - **Descripción:** Se implemento el enumerado Gender, y se cambió en todo el programa la existencia de char genero por Gender género, lo cual resulto también un cambio en el llamado y funcionamiento de la calculadora, donde antes se llamaba con un 'h' ahora debe ser llamada con un Gender.MALE, así mismo se eliminó un if de la calculadora que comprobaba el valor char que era introducido (devolviera un mensaje si recibía una letra diferente a 'h' o 'm'), Además de que se eliminaron 2 test, ya no tiene sentido la posibilidad de tener un error al introducir un genero para la calculadora.   
  - **Número de cambios:** Si consideramos cambios manuales como aquellos que tuve que realizar en Visual studio para cambiar todas las ocurrencias 'h' por Gender.MALE y lo mismo en caso de 'w', diría que aproximadamente unas 20 a 25 lineas, de las cuales la mitad serán eliminar ifs innecesarios y test que ya no son útiles.
  
<a name="refactoring2"> </a>
## Refactoring2 << interface >> Person
  - **Bad smells:** Larga lista de parámetros de entrada (long list of parameters)
  - **El refactorings aplicados para resolverlo:** Remplazar los parámetros por un objeto.
  - **tipo o categoría de refactorización:** Refactorización de clases (Class Refactoring)
  - **Descripción:** En esta ocasión se creo un objeto Person (y a su vez una implementación del mismo persona_pac) en el cúal tendrá todos los datos necesarios para ejecutar la calculadora, evitando tener que movilizar los 4 datos entre las distintas clases. 
  - **Número de cambios:** En esta ocasión el refactoring no automatizo tantos cambios como en el apartado anterior, aproximadamente más de 100 lineas de código habrán sido modificadas entre la creación de persona, adaptar los cambios y modificar los test.
  
<a name="refactoring3"> </a>
## Refactoring3 << interface >> CardiovascularMetrics 
  - **Bad smells:** Large class
  - **El refactorings aplicados para resolverlo:** Segregación de interfaz (segregation Interface)
  - **tipo o categoría de refactorización:** Refactorización de clases (Class Refactoring)
  - **Descripción:**
  - **Número de cambios:** 
 
  
<a name="refactoring4"> </a>
## Refactoring4 << interface >> MetabolicMetrics 
  - **Bad smells:** 
  - **El refactorings aplicados para resolverlo:**
  - **tipo o categoría de refactorización:**
  - **Descripción:**
  - **Número de cambios:**
