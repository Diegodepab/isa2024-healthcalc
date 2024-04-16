# isa2024-healtcalc
Se desea desarrollar una calculadora que permita estimar varios parámetros de salud de una persona, como su peso ideal, su tasa metabólica basal, entre otras funciones. Se recomienda usar la **Tabla de contenido** para visualizar las practicas por separado.

<details>
  <summary>Tabla de Contenido</summary>
  <ol>
    <li><a href="#practica1">Practica1</a>
      <ol> <li><a href="#intro">Introducción practica1</a></li>
        <li><a href="#desarrollo">Desarrollo de tests</a></li>
        <li><a href="#test_idealWeight">Test idealWeight</a></li>
        <li><a href="#test_basalMetabolicRate">Test basalMetabolicRate</a></li>
        <li><a href="#ejecucion">Ejecución de los test</a></li>
        <li><a href="#repo">Desarrollo del repositorio practica1</a></li></ol> </li>
    <li><a href="#practica2">Practica2</a></li>
      <ol> <li><a href="#intro2">Introducción practica2</a>
        <li><a href="#diagrama">Diagrama de casos:</a></li>
        <li><a href="#caso_uso">especificación del caso de uso</a></li></ol> </li>
    <li><a href="#practica3">Practica3</a></li>
      <ol> <li><a href="#intro3">Introducción practica3</a>
      <li><a href="#Historiapeso">User Story:  Cálculo del peso ideal de un persona:</a></li>
              <ol> <li><a href="#crit_acep1">Criterios de aceptación</a></li></ol> </li>
      <li><a href="#Historibasal">User Story:  Cálculo de la tasa metabólica basal de una persona:</a></li>
              <ol> <li><a href="#crit_acep2">Criterios de aceptación</a></li></ol></li></ol> </li>
    <li><a href="#practica4">Practica4</a></li>
      <ol> <li><a href="#intro4">Introducción practica4</a>
        <li><a href="#prototipo"> Prototipo (Mockup):</a></li>
        <li><a href="#interfaz">interfaz</a></li></ol> </li>
    <li><a href="#otros">Autor, Profesor y otros detalles</a></a>
    </ol>
</details>

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/assets/91531665/5543b1f6-d4d4-40c8-8082-b84dd1e6d7fb" width="140" title="JAVA">
  &nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/assets/91531665/d91005d7-e9a4-4e30-a7c6-32468afbca66" width="140" title="GitHub">
  &nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/assets/91531665/2501b372-1fb2-46f6-b9a9-c5d67ab42d29" width="140" title="UMA">
</p>

---
# Práctica 1 
<a name="practica1"></a>

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

<a name="test_basalMetabolicRate"></a>
## Test para el método basalMetabolicRate():
- ***Test entrada incorrecta peso*** `testPesoIncorrectoBMR`:dart: Este test enfatiza el caso de obtener un valor de peso incorrecto (solo se aceptaran valores dentro del umbral 20kg<X<650kg), se espera que en este caso se lance una excepción pidiendo al usuario revisar los datos ya que se espera un valor posible en kg.
- ***Test entrada incorrecta altura*** `testAlturaIncorrectaBMR`:dart: Este test enfatiza el caso de obtener un valor de altura incorrecto (solo se aceptaran valores dentro del umbral 40cm<X<275cm), se espera que en este caso se lance una excepción pidiendo al usuario revisar los datos ya que se espera un valor posible en cm.
- ***Test entrada incorrecta sexo*** `testSexoIncorrectoBMR`:dart: Este test enfatiza el caso de obtener un valor de sexo incorrecto (solo se aceptaran valores correspondientes a 'm' y 'w'), se espera que en este caso se lance una excepción pidiendo al usuario revisar los datos ya que se espera un valor admisible.
- ***Test entrada incorrecta edad*** `testEdadIncorrectaBMR`:dart: Este test enfatiza el caso de obtener un valor de edad incorrecto (solo se aceptaran valores dentro del umbral 0<X<100 años), se espera que en este caso se lance una excepción pidiendo al usuario revisar los datos ya que se espera un valor posible en años.
- ***Test entradas raras*** `testValoresRarosBMR`:dart: Este test enfatiza el caso de obtener unos valores de entradas que haga al programa devolver una salida negativa, esto es posible al combinar características como una baja estatura, bajo peso, ser mujer y de una avanzada edad.

- ***Test entrada de TODOS los sexos*** `SexCorrectoBMR`:dart: Este test comprueba que la calculadora admite la entrada de sexos como w, W, m y M.
- ***Test mujer promedio*** `testWomanBMR`:dart: prueba el funcionamiento correcto en caso de uso por una mujer promedio (debería devolver su basalMetabolicRate).
- ***Test hombre promedio*** `testMenBMR`:dart: prueba el funcionamiento correcto en caso de uso por un hombre promedio (debería devolver su basalMetabolicRate).
- ***Test mujer Externa*** `testWomanExternaBMR`:dart: prueba el funcionamiento correcto en caso de uso por una mujer pero esta vez se testea a partir de un resultado calculado fuera del propio entorno.
- ***Test hombre Externo*** `testMenExternoBMR`:dart: prueba el funcionamiento correcto en caso de uso por un hombre pero esta vez se testea a partir de un resultado calculado fuera del propio entorno.

<a name="ejecucion"></a>
# Ejecución de los test:
A continuación una captura de todos los test pasados, para obtener más información se puede entrar en la carpeta de images donde se encuentran las fotos en mejor calidad y más detalladas, los test fueron pasados y cumplen con todos los objetivos planeados inicialmente. He implementado 21 test en total, algunos parametrizados.
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/main/Images/TODOS_los_test.png" width="400" title="TODOS_LOS_TEST">
</p>

<a name="repo"> </a>
# Desarrollo del repositorio:
Durante el laboratorio, se utilizo `git` para trabajar de manera cómoda, eficiente y segura, pudiendo publicar continuamente los avances del proyecto, metodología muy útil para tener una mayor perspectiva de la linealidad del proyecto y poder retroceder en caso de equivocaciones. A través del comando gitk --all podemos ver la evolución de este repositorio resaltando los comentarios de cada avance. 
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/main/Images/gitk__all.png" width="800" title="Resumen_Git">
</p>

Como se puede observar en esta ocasión es un proyecto muy simple sin una necesidad real de implementar multiples ramas o trabajar con compañeros, no obstante trabajar con `GitHub` fue una practica muy útil para marcar un rumbo en el proyecto. Se podría haber hecho en un número menor de commits pero quise desarrollar el README.md a la vez que iba avanzando en las clases y test por separado.

---
    
<a name="practica2"></a>
# Práctica 2
# Introducción 
<a name="intro2"></a>
Esta practica es relativamente simple, en primer lugar consiste en **Gestión de respositorio git y Github** donde se crearán las ramas correspondientes a la practica 1 y practica 2, seguida por **La realización deun diagrama de casos de uso UML para la calculadora de salud** según lo visto en el tema 2, donde se usará la calculadora de la practica 1 más 2 funciones nuevas en caso de este trabajo:
1. La primera es calcular **el índice de masa corporal (IMB).** El IMB de una persona se calcula mediante la siguiente fórmula: `BMI = mass (kg) / height^2(m) `.
2. La segunda función será la **estimación de la tasa de filtración glomerular mediante la ecuación CKD-EPI en adultos (TFG).** El [TFG](https://pubmed.ncbi.nlm.nih.gov/19414839/) de una persona se estima mediante la siguiente formula `TFG = 141 * Math.min(Creatinina sérica/kappa, 1)^alpha * Math.max(Creatinina sérica/kappa,1)^-1.209 * 0.993*Edad * Sexo * Raza`.
*  Donde  para **mujeres**, se utilizan los siguientes valores: Sexo = 1.018; alfa = -0.329; kappa = 0.7, para **hombres** se utilizan los siguientes valores: Sexo = 1; alfa = -0.411; kappa = 0.9.
*  Si eres una **persona de tez morena** (Negro) raza tiene un valor de 1.159 si eres **persona de tez clara** (blanco, caucásico, normal, etc.) tienes un valor de 1

Y para culminar la practica se especificara uno de los casos de uso. 
<a name="diagrama"></a>
# Diagrama de casos de uso:
En este diagrama se muestra con lujo de detalle todos los datos que puede introducir el usuario en los diversos casos de uso, dentro del README de doc, podrá obtener una segunda versión simplificada.
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica2/doc/Diagrama_de_casos_de_uso_Calculadora_Salud.png" width="750" title="Elaborado">
</p>

<a name="caso_uso"></a>
# Especificación de Casos de Uso: función IdealWeight.:

```
Nombre: Calcular IdealWeight.

Stakeholders y sus intereses/objetivos:
Usuario: saber su peso ideal.
Actor principal: Usuario. 

Alcance: Aplicación HealthCalc (Calculadora de Salud).
Nivel de abstracción: del tipo user-goal.
Precondición: 
-El usuario tiene que conocer los parámetros de altura y su sexo. (no puede empezar el escenario de uso si no conoce su altura o al menos conocimiento de valores que quiera introducir).
Garantias mínima: Se muestra un mensaje de error o resultado al usuario.
Garantías de éxito: El usuario obtiene un resultado correcto (su peso ideal).
Trigger: El usuario indica que quiere calcular un peso ideal (selecciona la opción de calcular Peso Ideal en el programa HealthCalc).

Escenario principal:
1.	El usuario selecciona la opción de calcular Peso Ideal en el programa.
2.	El sistema pide los parámetros (altura y sexo) al usuario. 
3.	El usuario introduce los valores de los parámetros.
4.	El sistema calcula su peso ideal.
5.	El sistema muestra en pantalla el peso ideal para los parámetros dados.

Escenario Alternativos:
3b) el usuario se equivoca al introducir algún parámetro.
3b1) El sistema muestra un error (especificando que campo tiene el error y una posible razón) y vuelve al paso 2.


#nota, en las pruebas se fue muy escrupuloso con los posibles casos, y al ponerle umbrales de valores mínimos y máximos no debería haber escenarios alternativos por parte de errores en el sistema (desbordamiento o tiempo de ejecución demasiado largo).
```
---
<a name="practica3"></a>
# Práctica 3

<p align="center">
  <img src="https://github.com/cucumber-ltd/brand/blob/master/images/png/notm/cucumber-black/cucumber-black-256.png" width="256" title="CUCUMBER">
</p>

<a name="intro3"></a>
# Introducción: 
Las **historias de usuario** son descripciones breves de las funcionalidades del sistema desde la perspectiva del usuario, explicando de manera fácil y sencilla el funcionamiento de nuestro programa. A su vez se usará Cucumber que es una herramienta para automatizar pruebas BDD (Desarrollo Guiado por el Comportamiento). Es decir pruebas que se centran en el comportamiento del sistema y utiliza lenguaje natural para definir pruebas automatizadas.

* **Objetivo:** Implementar historias de usuario y criterios de aceptación siguiendo la metodología BDD (Desarrollo Guiado por el Comportamiento), a través de Gherkin y Cucumber.
* **Componentes:**
  +  *Archivos .feature:* Contienen las implementaciones detalladas de los criterios de aceptación en Gherkin.
  +   *Archivos .java:* Contienen el código de los pasos (steps) necesarios para ejecutar estas definiciones en pruebas automatizadas.
  +   *Archivos .txt:* En el directorio ./docs/, contienen las definiciones en lenguaje natural de las historias de usuario y los criterios de aceptación, de igual manera al seguir con su lectura encontrará información en este README.md
* **Estructura:**
  +   *Historias de usuario:* Siguen la estructura "Como [user rol], Quiero [función], Para [beneficio]" para describir las necesidades y objetivos de los usuarios.
  +   *Criterios de aceptación:* Se estructuran como "Dado que/GIVEN [contexto], Cuando/WHEN [acción], Entonces/THEN [resultado esperado]" para especificar el comportamiento esperado del sistema bajo diferentes condiciones.
*  **Beneficios:**
    +   Mejora la comunicación y colaboración entre los equipos de desarrollo y producto.
    +   Promueve un enfoque en el comportamiento del sistema desde la perspectiva del usuario.
    +   Fomenta la creación de pruebas automatizadas que validan el comportamiento del sistema.
    +   Aumenta la calidad del software al detectar errores en las primeras etapas del desarrollo.

<a name="Historiapeso"> </a>
## User Story:  Cálculo del peso ideal de un persona.
A continuación el use story siguiendo la plantilla, trabaje tanto en español como en inglés esta primera parte:
```
Plantilla de historias de usuario(User Story Template):
Como usuario de la calculadora de salud (As a user of the health calculator).
Quiero calcular el peso ideal para los parámetros dados (I want to calculate the ideal weight for the given parameters)
Para poder saber el peso ideal (So that I can know the ideal weight.).
```
<a name="crit_acep1"> </a>
## Accepting Criteria:  Cálculo del peso ideal de un persona.
A continuación los criterios de aceptación, esto si lo deje en inglés por comodidad.
```
Criterios de aceptación (Accepting Criteria):
Scenario Outline: Invalid Height
Given I have an health calculator
When I estimate the ideal weight for invalid height <h>
Then the calculator throws an exception

Scenario Outline: Invalid Gender
Given I have an health calculator
When I estimate the ideal weight for an invalid gender <g>
Then the calculator throws an exception

Scenario Outline: Negative Weight Result
Given I have an health calculator
When I estimate the ideal weight for gender <g> and height <h> and gives a negative result
Then the calculator throws an exception

Scenario Outline: ideal Weight Result
Given I have an health calculator
When I estimate the ideal weight for gender <g> and height <h>
Then the calculator return a result <value>

```
<a name="Historibasal"> </a>
## User Story:  Cálculo de la tasa metabólica basal de una persona
A continuación el use story será muy parecido al caso de peso ideal porque como su nombre lo indica la idea es seguir una plantilla y un sistema que a pesar de estar en lenguaje natural el programa sea capaz de automatizar parte de los test (en mi caso tuve que hacer varias modificaciones, pero al menos te deja la base).
```
Plantilla de historias de usuario(User Story Template):
Como usuario de la calculadora de salud (As a user of the health calculator).
Quiero calcular la tasa metabólica basal para los parámetros dados (I want to calculate the basal metabolic rate for the given parameters).
Para poder saber la tasa metabólica basal(So that I can know the basal metabolic rate).
```
<a name="crit_acep2"> </a>
## Accepting Criteria:  Cálculo de la tasa metabólica basal de una persona
Para finalizar la practica 3 los criterios de aceptación refente al cálculo de la tasa metabólica basal 
```
Scenario Outline: Invalid Height
Given  I have an health calculator
When I estimate the basal metabolic rate of an invalid Height <h>
Then the calculator throws an exception

Scenario Outline: Invalid Weight
Given  I have an health calculator
When I estimate the basal metabolic rate of an invalid gender <g>
Then the calculator throws an exception

Scenario Outline: Invalid Age
Given  I have an health calculator
When  I estimate the basal metabolic rate of a negative age <a>
Then the calculator throws an exception

Scenario Outline: Invalid Weight
Given  I have an health calculator
When I estimate the basal metabolic rate of an invalid weight <w>
Then the calculator throws an exception

Scenario Outline: Given valid parameters
Given  I have an health calculator
When I estimate the basal metabolic rate for the given valid parameters <w> , <h> , <g> , <a>
Then the calculator returns a valid result <result>
```


<a name="practica4"></a>
# Práctica 4

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Implementacion_vista_metabolic_rate.png" width="300" title="implemen_basal">
</p>

<a name="intro4"></a>
# Introducción: 
**Windows Builder** es una herramienta de desarrollo de software que permite crear interfaces gráficas de usuario (GUIs) para aplicaciones Windows. Se basa en el lenguaje de programación C# y proporciona un conjunto de herramientas visuales para diseñar formularios, controles y otros elementos de la interfaz de usuario.

Windows Builder se utiliza para crear una amplia variedad de aplicaciones Windows, desde aplicaciones simples hasta aplicaciones empresariales complejas. Algunas de las aplicaciones comunes que se crean con Windows Builder incluyen:
* **Aplicaciones de escritorio** 
* **Aplicaciones web**
* **Aplicaciones móviles** 
* **Juegos**

Para poder sacar el mayor potencial a dicha herramienta es necesario destacar el **patrón Vista-Modelo** es un patrón de diseño de software que separa la lógica de la presentación de la interfaz de usuario. Esto significa que el código que controla la lógica de la aplicación está separado del código que controla la forma en que se muestra la interfaz de usuario. Esto hace que el código sea más fácil de mantener y reutilizar.
Además en esta aplicación considero que mi prioridad será la flexibilidad y eficiencia de uso (EFFICIENCY). Algunas de las técnicas usadas:
* **Utilizar un diseño flexible:** El diseño de la interfaz de usuario debe ser flexible para que pueda adaptarse a diferentes tamaños de pantalla y resoluciones. Para esto como recomendación del ([profesor](https://github.com/jmhorcas)) se trabajará con SWING y no de la librería AWT.
* **Utilizar controles reutilizables:** Los controles reutilizables son controles que se pueden utilizar en diferentes partes de la interfaz de usuario. Ayudando a ahorrar tiempo y código, en este caso se verá al dar la opción de seleccionar el modo IdealWeight muestra 2 campos (Gender y Height) mientras que si cambiamos a basal reutilizaremos esos dos campos y añadiremos otros 2 (Weight and Age).
* **Proporcionar comentarios:** Cada botón o posible acción será acompañada con un label que de una palabra clave o breve descripción del campo.

<a name="prototipo"> </a>
##  Prototipo de interfaz gráfica de usuario o mockup (boceto) para la calculadora de salud:

Un prototipo es una versión simplificada y funcional de un producto final, ya sea un software, una aplicación, una página web o incluso un dispositivo físico. Su objetivo principal es validar ideas y conceptos antes de invertir tiempo y recursos en el desarrollo completo del producto. El prototipo debería mostrar en la medida de lo posible los casos de uso (o historias de usuario).

En este caso el prototipo termino generandome la idea de poder aprovechar las funcionalidades de window builder para hacer más intuitivo el programa, en este caso termine creando **2 pantallas para el prototipo**, la primera es cuando queremos obtener el peso ideal, donde solo se necesitan los campos de altura y género, para esto solo mostraremos en la pantalla estas opciones a rellenar:

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Pantalla_para_Ideal_Weightpng.png" width="400" title="IW_proto">
</p>

Y la segunda es cuando el usuario quiere usar la calculadora para calcular la tasa metabolica, en donde además de la altura y el género también el usuario deberá introducir el peso y la edad:

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Pantalla_para_basal_metabolic_rate.png" width="400" title="MB_proto">
</p>

Siendo muy útil para tener una idea clara de que herramientas quieres usar y que funcionalidades quieres en tu programa, en este caso este prototipo nos ahorra tener que explicar mediante labels o asumir que el usuario sabrá que el peso ideal solo necesita 2 campos.

De este prototipo más adelante aprendí que usar azul de fondo y el color de letras blanco queda fatal, más adelante cuando quise leer que decía no sabía, estas burbujas eran con intención bosquejo informativo y sin intención de implementar, pero me sirvió para aprender que la letra blanca trae problemas para fondos que no sean negro.

<a name="interfaz"> </a>
##  Interfaz gráfica de usuario para la calculadora de salud

La creación de la interfaz fue mucho más sencilla sabiendo el esquema por partes que tenía pensado con el prototipo, donde habiendo llegado a la hora de montar ya tenía una clara idea de que forma obtener los valores del usuario, en esta ocasión al ser la interfaz final voy a ser más detallado y también explicando que aunque se parezca mucho al prototipo no es exactamente igual por dos principales razones, la primera siendo la falta de experiencia y la importancia de un prototipo es que muestra el contraste de lo que me imaginaba antes de probar por primera vez por mi mismo window builder, sin saber sus limitaciones ni posibilidades. Y la segunda razón relacionada con la primera es que descubri que hay cosas que se pueden hacer muy facilmente, así que cosas como cambiar según lo que quieras calcular juega un rol más importante y se dejá más claro todo.

A continuación una imagen de el programa apenas se inicia, resaltando que no sé ha elegido que deseas calcular inicialmente y esto se notifica al lado de resultado:

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Implementacion_vista_vacio.png" width="400" title="inic">
</p>

siguiendo la linea de los hechos un ejemplo de como se vería ir rellenando la opción de peso ideal: 
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Implementacion_vista_Ideal_Weight.png" width="400" title="imple_peso">
</p>

Y por último el caso donde se desea calcular la tasa metabolica:
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Implementacion_vista_metabolic_rate.png" width="400" title="imple_metabolic">
</p>
Vemos que para cada caso se ajusta mostrando solamente los campos que puede meter el usuario dependiendo de la función que desea y que se actualiza las unidades y el valor de resultado dependiendo del método llamado.

Cabe resaltar que en la carpeta images añadí esto en el README, Pero un poco más detallado y hasta teniendo el lujo de dar ciertos pleonasmo (redundancia), y con mayor tamaño. 

Para la creación del archivo Jar, exploré desde el uso de Visual Studio Code y Eclipse para generarlo automaticamente como por medio de comandos en la consola, aunque el java me ha dado errores de versiones y no me deja ejecutar mi archivo .jar ni de mis compañeros ni de ejemplos de internet, tarde en subirlo pensando que era fallo de programación pero el desinstalar y volver instalar eclipse para arreglar el problema de instalación de windows builder me esta generando errores inesperados, lamento hacer unas modificaciones los minutos posteriores a la entrega pero es que tuve que esperar la respuesta de que el archivo funcionaba.
<a name="otros"> </a>
# Otros:

## Preparación del repositorio y modificaciones de versiones:
Para esta practica he actualizado el entorno de desarrollo para poder acceder a windowBuilder que con versiones inferiores a 17 estaba dandose un error de incompatibilidad a la hora de instalar el software

## Estudiante:
-Diego De Pablo ([User: Diegodepab](https://github.com/Diegodepab))

## Profesor:
-José Miguel Horcas ([user:jmhorcas](https://github.com/jmhorcas))
