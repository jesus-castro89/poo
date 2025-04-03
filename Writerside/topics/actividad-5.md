# Actividad 5: La feria de productos

## Descripción

Se ha organizado una feria de productos en la que se han inscrito varios expositores. Cada expositor tiene un nombre, un
número de stand y una lista de productos que va a exponer. Los productos tienen un nombre, un precio y una cantidad
disponible.

Así mismo los productos pueden ser: `Frescos`, `Congelados` o `Enlatados`. Los productos frescos tienen una fecha de
caducidad, los productos congelados tienen una temperatura de congelación y los productos enlatados tienen una fecha de
envasado. Todos los productos tienen un código de barras.

Así mismo los productos congelados pueden ser tanto `Por Aire` como `Por Agua`. Los productos por aire tienen una
temperatura de congelación y una composición de aire(proporción de oxígeno, nitrógeno y dióxido de carbono). Los
productos por agua tienen una temperatura de congelación y una salinidad.

Todos los productos pueden ser `Nacionales` e `Importados`. Los productos nacionales tienen un código de identificación
nacional y los productos importados tienen un código de identificación y validación por un organismo internacional que
contiene dicho dato de identificación, además del nombre del organismo.

Tome en consideración que los organismos existen en una lista inmutable, es decir, no se pueden agregar ni eliminar.

Deberás definir las nacionalidades posibles de los productos.

## Requerimientos

* El sistema debe permitir registrar un expositor con su respectiva información.
* El sistema debe permitir registrar un producto con su respectiva información.
* El sistema debe permitir relacionar un producto con un expositor.
* El sistema debe permitir listar los productos de un expositor.
* El sistema debe permitir listar los expositores de un producto.
* El sistema debe permitir listar los productos de un tipo específico.
* El sistema debe permitir listar los productos de un tipo específico y nacionalidad.
* El sistema debe permitir listar los productos de un tipo específico y origen.

## Critrerios de evaluación

| Criterio                             | Descripción                                                                             | Puntaje |
|--------------------------------------|-----------------------------------------------------------------------------------------|---------|
| Portada                              | El archivo contiene una portada con los datos del equipo.                               | 5%      |
| Código                               | El código cumple con los requisitos solicitados.                                        | 50%     |
| Documentación                        | El código contiene comentarios que facilitan su comprensión. Incluye Diagrama de clases | 10%     |
| Pruebas                              | El código contiene pruebas que demuestran su correcto funcionamiento.                   | 10%     |
| Capturas de pantalla                 | Se anexan capturas de pantalla de las pruebas realizadas.                               | 5%      |
| Uso de clases abstractas y concretas | Se utilizan clases abstractas y concretas para la implementación de los productos.      | 10%     |
| Modularidad                          | El código está modularizado.                                                            | 10%     |
| Total                                |                                                                                         | 100%    |

> **La evaluación se realizará con base en los criterios establecidos en la rúbrica. Se considerará la claridad,
> organización, comentarios y estilo del código, así como la calidad de la documentación. Además, se tomará en cuenta
> el cumplimiento de los requerimientos y la funcionalidad del programa.**
> {style="note"}

> Deberás anexar por separado las capturas de pantalla de las pruebas realizadas junto a la portada del código fuente.
> Mismo que debera estar en un archivo comprimido y con los archivos `.java` correspondientes.
> {style="warning"}

> **Actividad entregada en lenguaje distinto a Java o sin el uso de clases y objetos, así como de modularidad, no será
> evaluada.**
> {style="warning"}

## Fecha de Entrega

Lunes 7 de abril de 2025, 11:59 p.m. (medianoche)

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos.**
> {style="warning"}