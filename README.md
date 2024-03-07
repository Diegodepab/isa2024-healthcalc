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
      <li><a href="#repo">Desarrollo del repositorio</a></li>
      <li><a href="#otros">Autor, Profesor y otros detalles</a></li>
    </ol>
</details>

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/assets/91531665/5543b1f6-d4d4-40c8-8082-b84dd1e6d7fb" width="140" title="JAVA">
  &nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/assets/91531665/d91005d7-e9a4-4e30-a7c6-32468afbca66" width="140" title="GitHub">
  &nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/assets/91531665/2501b372-1fb2-46f6-b9a9-c5d67ab42d29" width="140" title="UMA">
</p>

<a name="intro"></a>
# Introducción:
Dicho repositorio forma parte de las actividades de la asignatura "Ingeniería de software Avanzada" correspondiendo a la parte practica, [Partiendo de este repositorio](https://github.com/jmhorcas/isa2024-healthcalc) se desea desarrollar una calculadora de salud cuya función sea que a través de parametros como la altura, el genero, peso y edad. Se realicen calculos como el [Peso ideal](https://www.generali.es/blog/tuasesorsalud/peso-ideal/) o [la tasa metabólica basal](https://www.tuasaude.com/es/tasa-metabolica-basal/). Para esto se pretende usar la metodología [TDD](https://old.chuidiang.org/java/herramientas/test-automaticos/tdd-test-driven-development.php) (Test Driven Development), Desarrollo Dirigido por Pruebas a través del uso de Maven para los métodos: 
* `idealWeight`: Obtiene la altura y el género como entrada, y su salida es el **peso ideal**.
* `basalMetabolicRate`: Obtiene el peso, la altura, el género y la edad como entrada, y su salida es el **metabolismo basal**.

<a name="desarrollo"></a>  
#  Desarrollo de tests:
En el capítulo ["A Self-Assessment Test"](https://informatica.cv.uma.es/pluginfile.php/594116/mod_resource/content/1/Lectura%20-%20A%20Self-Assessment%20Test.pdf) del libro ["The art of software testing"](https://malenezi.github.io/malenezi/SE401/Books/114-the-art-of-software-testing-3-edition.pdf ) de["Glenford J. Myers"](https://en.wikipedia.org/wiki/Glenford_Myers) destaca la importancia de la autoevaluación en el campo de la prueba de software. A medida que el software se vuelve más ubicuo y complejo, la prueba se vuelve tanto más difícil como más crucial. La autoevaluación nos invita a reflexionar sobre nuestro papel en garantizar que el software funcione correctamente y no cause frustración o pérdidas a los usuarios.

<a name="test_idealWeight"></a>
## Test para el método idealWeight():
- ***Test de Altura Negativa*** `testAlturaNegativaIW`:white_check_mark: Este test enfatiza el caso de obtener un valor negativo (<0) en la entrada de altura, lógicamente no existe una altura negativa y se esperaría una excepción indicando este error.
- ***Test de Altura menor a la esperada*** `testAlturaMenorPosibleIW`:white_check_mark: Este test enfatiza el caso de obtener un valor menor a la altura de un bebe recién nacido (<45cm) en la entrada de altura, el estudio de un tamaño tan pequeño no tiene sentido incluso el propio calculo para un bebe no es normal y se esperaría una excepción indicando este error (como posible uso de metros o pies).
- ***Test de Altura mayor a la esperada*** `testAlturaMayorPosibleIW`:white_check_mark: Este test enfatiza el caso de obtener un valor mayor a la altura de [el humano más alto de la historia](https://youtu.be/-_j9IJ9lCxU?si=K7ux-Bw7UV30N75H) (>272cm) en la entrada de altura, el estudio de un tamaño tan grande no tiene sentido más que curiosidad y se esperaría una excepción indicando este error (como posible desbordamiento).
- ***Test de altura problematica con la formula hombres*** `testAlturaProblemaHombresIW`:white_check_mark: Este test enfatiza el caso de obtener una altura que dentro de lo que cabe es posible pero la fórmula que sigue el peso ideal en hombres no está pensada para estos casos, pondré el tope en 110cm que da como resultado un peso ideal de 20kg (al usar alturas menores el peso ideal se vuelve ridículo o hasta negativo). En este caso se lanzara una excepción indicando que es un error de la formula.
- ***Test de altura problematica con la formula mujeres*** `testAlturaProblemaMujeresIW`:white_check_mark: Este test enfatiza el caso de obtener una altura que dentro de lo que cabe es posible pero la fórmula que sigue el peso ideal en mujeres no está pensada para estos casos, pondré el tope en 100cm que da como resultado un peso ideal de 20kg (al usar alturas menores el peso ideal se vuelve ridículo o hasta negativo). En este caso se lanzara una excepción indicando que es un error de la formula.
- ***Test de sexo erroneo*** `testGenderProblematicIW`:white_check_mark: Este test enfatiza el caso de obtener un genero distinto a ‘m’ o ‘w’, lo cual no será reconocido para el calculo del peso ideal.
- ***Test entrada de sexo correcta*** `SexCorrectIW`:white_check_mark: Este test prueba que se pueda usar w, W, m y M como posibles entradas sin dar error.
- ***Test hombre uso promedio*** `testHombrePromedioIW`:white_check_mark: Este test prueba el funcionamiento correcto en caso de uso por un hombre promedio evaluando a través de la formula en el propio test (debería devolver su peso ideal).
- ***Test mujer uso promedio*** `testMujerPromedioIW`:white_check_mark: Este test prueba el funcionamiento correcto en caso de uso por una mujer promedio evaluando a través de la formula en el propio test (debería devolver su peso ideal).
- ***Test hombre especifico*** `testHombreEspecificoIW`:white_check_mark: Este test prueba el funcionamiento correcto en caso de uso por un hombre especifico evaluando el resultado de manera manual y comparando el valor obtenido (debería devolver su peso ideal).
- ***Test mujer especifica*** `testMujerEspecificaIW`:white_check_mark: Este test prueba el funcionamiento correcto en caso de uso por una mujer especifica evaluando el resultado de manera manual y comparando el valor obtenido (debería devolver su peso ideal).
- ***Test entrada de sexo correcta*** `SexCorrectIW`:white_check_mark: Este test prueba el funcionamiento correcto en caso de uso por una mujer especifica evaluando el resultado de manera manual y comparando el valor obtenido (debería devolver su peso ideal).

<a name="test_basalMetabolicRate"></a>
## Test para el método basalMetabolicRate():
- ***Test entrada incorrecta peso*** `testPesoIncorrectoBMR`:dart: Este test enfatiza el caso de obtener un valor de peso incorrecto (solo se aceptaran valores dentro del umbral 20kg<X<650kg), se espera que en este caso se lance una excepción pidiendo al usuario revisar los datos ya que se espera un valor posible en kg.
- ***Test entrada incorrecta altura*** `testAlturaIncorrectaBMR`:dart: Este test enfatiza el caso de obtener un valor de altura incorrecto (solo se aceptaran valores dentro del umbral 40cm<X<275cm), se espera que en este caso se lance una excepción pidiendo al usuario revisar los datos ya que se espera un valor posible en cm.
- ***Test entrada incorrecta sexo*** `testSexoIncorrectoBMR`:dart: Este test enfatiza el caso de obtener un valor de sexo incorrecto (solo se aceptaran valores correspondientes a 'm' y 'w'), se espera que en este caso se lance una excepción pidiendo al usuario revisar los datos ya que se espera un valor admisible.
- ***Test entrada incorrecta edad*** `testEdadIncorrectaBMR`:dart: Este test enfatiza el caso de obtener un valor de edad incorrecto (solo se aceptaran valores dentro del umbral 0<X<100 años), se espera que en este caso se lance una excepción pidiendo al usuario revisar los datos ya que se espera un valor posible en años.
- ***Test entradas raras*** `testBMR`:dart: Este test enfatiza el caso de obtener unos valores de entradas que haga al programa devolver una salida negativa, esto es posible al combinar características como una baja estatura, bajo peso, ser mujer y de una avanzada edad.
- ***Test todo bien mujer*** `testWomanBMR`:dart: prueba el funcionamiento correcto en caso de uso por una mujer promedio (debería devolver su basalMetabolicRate).
- ***Test todo bien hombre*** `testMenBMR`:dart: prueba el funcionamiento correcto en caso de uso por un hombre promedio (debería devolver su basalMetabolicRate).

<a name="ejecucion"></a>
# Ejecución de los test:
Aqui planeo poner una captura de pantalla de todos los test aprobados

<a name="repo"> </a>
# Desarrollo del repositorio:
Aqui quiero poner el flujo del repositorio (comando gitk --all)

<a name="otros"> </a>
# Otros:
## Preparación del repositorio y modificaciones de versiones:
Se trabajo en una version de java 17.0.2 2022-01-18 LTS, por ende se modifico el pom.xml y el org.eclipse.jdt.core.prefs de la carpeta de configuraciones.
## Integrantes:
-Diego De Pablo ([User: Diegodepab](https://github.com/Diegodepab))
## Profesor:
-José Miguel Horcas ([user:jmhorcas](https://github.com/jmhorcas))
