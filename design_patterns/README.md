# Design_patterns

1.  **Aplicar el patrón Singular** a la aplicación de la calculadora, de forma que solo se permita tener una
instancia de la calculadora. Probar la calculadora mediante su Main y su interfaz gráfica. Dibuje el
diagrama de clases UML con la aplicación del patrón en su calculadora.

Se implemento correctamente el patrón singular siendo probada mediante su main y la interfaz grafica, además de crearse unos nuevos test capaces de comprobar en todo momento si en futuros cambios el patrón sigue funcionando como es de esperar.

### Diagrama despúes de la aplicación del patrón **singular**:
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica6/design_patterns/Singleton_Imagen.png" width="600" title="Singleton">
</p>

<a name="adapter"> </a>

2.  En el Hospital Costa del Sol de Marbella se han interesado por nuestra calculadora de salud y la quieren
integrar en su sistema informático. Para ello nos han dado la siguiente interfaz HealthHospital. Aplique
el patrón de diseño más adecuado para proporcionarles el servicio al Hospital reutilizando la calculadora
que ya tiene implementada sin tener que volver a implementar los métodos.



**El patrón Adapter** permite que objetos con interfaces incompatibles colaboren entre sí. Cumpliendo lo exigido.

### Diagrama despúes de la aplicación del patrón **adapter**:
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica6/design_patterns/Adapter_Imagen.png" width="600" title="Adapter">
</p>

<a name="proxy"> </a>

3. También nos han pedido que se lleve un registro de las veces que se utiliza la
calculadora en su sistema informático, **almacenando los datos de los pacientes** de
forma anónima, y permitiendo obtener la media de los valores introducidos y
calculados por la calculadora de todos los pacientes. Para ello, nos han dado la
siguiente interfaz HealthStats. Aplique el patrón de diseño más adecuado
reutilizando la calculadora que ya tiene implementada.

En este caso se necesita registrar el uso de la calculadora sin modificar su código existente. Además, se requiere almacenar los datos de los pacientes de forma anónima y obtener métricas de uso, como la media de los valores introducidos y calculados. Para esto se puede implementar un **Proxy de Registro** que intercepte las llamadas a la calculadora y registre la información relevante, como el paciente, los valores introducidos y los resultados calculados. El proxy puede utilizar un registrador para almacenar los datos de forma anónima y proporcionar métodos para obtener métricas de uso.

### Diagrama despúes de la aplicación del patrón **proxy**:
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica6/design_patterns/Proxy_Imagen.png" width="600" title="proxy">
</p>

<a name="decorator"> </a>

4.  Al hospital de la Costa del Sol acuden multitud de pacientes extranjeros, por lo que los celadores del
hospital nos han pedido disponer de dos versiones de la calculadora: una versión europea (que acepte
la altura en metros y el peso en gramos) y otra americana (que acepte la altura en pies y el peso en
libras). Por otra parte, la calculadora debe mostrar por pantalla un mensaje preciso con la información
de la operación “BMR” cada vez que se invoca. Por ejemplo, mostrando el mensaje: “La persona con
altura 1.83 metros y 78 Kg tiene un BMR de 23.29.” Dicho mensaje deberá aparecer en los dos idiomas
(español e inglés) independientemente de si se usa la calculadora europea o americana.
Recuerde que 1 kg = 2,20462 libras

En el caso de la calculadora de salud, se necesitan dos versiones de la calculadora: una europea y una americana. Además, se debe mostrar un mensaje con la información de la operación "BMR" en ambos idiomas. **Se pueden crear dos clases decoradoras**, una para convertir las unidades de medida a formato europeo y otra para convertirlas a formato americano. Además, se puede crear una clase decoradora para mostrar el mensaje "BMR" en ambos idiomas. Estas clases decoradoras se pueden envolver una a una alrededor de la instancia original de la calculadora para agregar la funcionalidad deseada.

### Diagrama despúes de la aplicación del patrón **Decorador**:
<p align="center">
  <img src="https://github.com/Diegodepab/isa2024-healthcalc/blob/practica6/design_patterns/Decorador_Imagen.png" width="600" title="decorador">
</p>