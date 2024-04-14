# Imagenes practica
Esto vendría a ser un resumen más detallado del prototipo y de la interfaz final del proyecto

## Prototipo
En este caso el prototipo termino generandome la idea de poder aprovechar las funcionalidades de window builder para hacer más intuitivo el programa, en este caso termine creando **2 pantallas para el prototipo**, la primera es cuando queremos obtener el peso ideal, donde solo se necesitan los campos de altura y género, para esto solo mostraremos en la pantalla estas opciones a rellenar:

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Pantalla_para_Ideal_Weightpng.png" width="600" title="IW_proto">
</p>

Y la segunda es cuando el usuario quiere usar la calculadora para calcular la tasa metabolica, en donde además de la altura y el género también el usuario deberá introducir el peso y la edad:

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Pantalla_para_basal_metabolic_rate.png" width="600" title="MB_proto">
</p>

Siendo muy útil para tener una idea clara de que herramientas quieres usar y que funcionalidades quieres en tu programa, en este caso este prototipo nos ahorra tener que explicar mediante labels o asumir que el usuario sabrá que el peso ideal solo necesita 2 campos.


##  Interfaz gráfica de usuario para la calculadora de salud

A continuación una imagen de el programa apenas se inicia, resaltando que no sé ha elegido que deseas calcular inicialmente, en este punto se muestran todos los campos y se puede ir rellenando los datos del paciente no obstante se dan varias señales como que al inicio del todo estan las opciones del método sin elegir, un mensaje de que debe seleccionar modo y más. Igual en caso de darle a calcular se puede decidir si tratar como si selecciono un modo o lanzar la excepción programada por falta de inputs.

<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Implementacion_vista_vacio.png" width="800" title="inic">
</p>

siguiendo la linea de los hechos un ejemplo de como se vería ir rellenando la opción de peso ideal, solo los 2 campos necesarios y el botón calcular indicando que el resultado será en kg: 
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Implementacion_vista_Ideal_Weight.png" width="800" title="imple_peso">
</p>

Y por último el caso donde se desea calcular la tasa metabolica, se muestrá todos los campos a rellenar y se cambian las unidades:
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica4/Images/Implementacion_vista_metabolic_rate.png" width="800" title="imple_metabolic">
</p>
Vemos que para cada caso se ajusta mostrando solamente los campos que puede meter el usuario dependiendo de la función que desea y que se actualiza las unidades y el valor de resultado dependiendo del método llamado.