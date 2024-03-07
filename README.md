# isa2024-healtcalc
Se desea desarrollar una calculadora que permita estimar varios parámetros de salud de una persona, como su peso ideal o su tasa metabólica basal (TMB).

<details>
  <summary>Tabla de Contenido</summary>
    <ol>
      <li><a href="#intro">Introducción</a></li>
      <li><a href="#desarrollo">Desarrollo de tests</a></li>
      <li><a href="#test_idealWeight">Test idealWeight</a></li>
      <li><a href="#test_basalMetabolicRate">Test basalMetabolicRate</a></li>
      <li><a href="#ejecucion">Ejecución de los test</a></li>
      <li><a href="#commits">Desarrollo del repositorio:</a></li>
      <li><a href="#otros">Autor, Profesor y otros detalles</a></li>
    </ol>
</details>


<a name="intro"></a>
# Introducción
Dicho repositorio forma parte de las actividades de la asignatura "Ingeniería de software Avanzada" correspondiendo a la parte practica, [Partiendo de este repositorio](https://github.com/jmhorcas/isa2024-healthcalc) se desea desarrollar una calculadora de salud cuya función sea que a través de parametros como la altura, el genero, peso y edad. Se realicen calculos como el [Peso ideal](https://www.generali.es/blog/tuasesorsalud/peso-ideal/) o [la tasa metabólica basal](https://www.tuasaude.com/es/tasa-metabolica-basal/). Para esto se pretende usar la metodología [TDD](https://old.chuidiang.org/java/herramientas/test-automaticos/tdd-test-driven-development.php) (Test Driven Development), Desarrollo Dirigido por Pruebas a través del uso de Maven para los métodos: 
* `idealWeight`: Obtiene la altura y el género como entrada, y su salida es el **peso ideal**.
* `basalMetabolicRate`: Obtiene el peso, la altura, el género y la edad como entrada, y su salida es el **metabolismo basal**.

<a name="desarrollo"></a>  
#  Desarrollo de tests:
En el capítulo ["A Self-Assessment Test"](https://informatica.cv.uma.es/pluginfile.php/594116/mod_resource/content/1/Lectura%20-%20A%20Self-Assessment%20Test.pdf) del libro ["The art of software testing"](https://malenezi.github.io/malenezi/SE401/Books/114-the-art-of-software-testing-3-edition.pdf ) de["Glenford J. Myers"](https://en.wikipedia.org/wiki/Glenford_Myers) destaca la importancia de la autoevaluación en el campo de la prueba de software. A medida que el software se vuelve más ubicuo y complejo, la prueba se vuelve tanto más difícil como más crucial. La autoevaluación nos invita a reflexionar sobre nuestro papel en garantizar que el software funcione correctamente y no cause frustración o pérdidas a los usuarios.
<a name="test_idealWeight"></a>
## test para el método idealWeight:

<a name="test_basalMetabolicRate"></a>
## test para el método basalMetabolicRate:

<a name="ejecucion"></a>
# Ejecución de los test:

<a name="commits"> </a>
#Desarrollo del repositorio:

<a name="otros"> </a>
#Otros:

## Preparación del repositorio y modificaciones de versiones:
Se trabajo en una version de java 17.0.2 2022-01-18 LTS, por ende se modifico el pom.xml y el org.eclipse.jdt.core.prefs de la carpeta de configuraciones.
##Integrantes:
-Diego De Pablo ([User: Diegodepab](https://github.com/Diegodepab))
##Profesor:
-José Miguel Horcas ([user:jmhorcas](https://github.com/jmhorcas))
