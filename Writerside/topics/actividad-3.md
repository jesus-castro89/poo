# Actividad 3: Sistema de Gestión de un Cine

## Descripción

Eres el desarrollador de un sistema para un cine. Debes crear un programa que permita gestionar películas, salas y
boletos. Las películas tienen un género (acción, comedia, drama, etc.) y una duración. Las salas tienen un número y una
capacidad. Los clientes pueden comprar boletos para una película en una sala específica. El sistema debe validar los
datos de entrada y mostrar un menú interactivo usando `JOptionPane`.

## Requerimientos

1. Crear las clases `Movie`, `Room` y `Ticket` con los atributos y métodos necesarios para representar las entidades
   del sistema.
2. Crear el tipo enumerado `Genre` con los siguientes valores:
    - Acción
    - Comedia
    - Drama
    - Terror
    - Ciencia Ficción
    - Animación
    - Aventura
    - Documental
    - Musical
    - Romance
    - Suspenso
3. Crear una clase `CinemaSystem` con un método `menu()` que muestre un menú interactivo con las siguientes opciones:
    - Agregar película
    - Comprar boleto
    - Listar películas
    - Listar salas
    - Listar salas con asientos disponibles
    - Listar recaudación total
    - Listar recaudación por sala
    - Listar recaudación por película por sala
    - Salir
4. Implementar la lógica necesaria para que el sistema permita agregar películas, tomando en cuenta que se podrán
   agregar varias películas con el mismo nombre pero género y duración diferentes. Y que no se permitirán agregar más de
   20 películas.
    * Toma en cuenta que la recaudación total se calcula sumando el precio de los boletos vendidos.
    * Toma en cuenta que se puede asignar una película a más de una sala.
5. Implementar la lógica necesaria para que el sistema permita comprar boletos, tomando en cuenta que se podrán comprar
   boletos para una película en una sala específica, siempre y cuando haya asientos disponibles. Y que no se permitirán
   comprar más de 50 boletos por sala.
    * Toma en cuenta que el precio de los boletos se calcula con base en la duración de la película y el género de la
      misma.
    * El precio base es de 50.00 y se le suma 10.00 por cada hora adicional de duración y el costo adicional por
      el género.
    * De tal forma que la fórmula para calcular el precio de un boleto es la siguiente:
    * ```tex
      PrecioBoleto = 50.00 + 10.00 * (HoraAdicional) + CostoGénero
      ```
6. Implementar la lógica necesaria para que el sistema permita listar las películas, las salas y las salas con asientos
   disponibles.
7. Implementar la lógica necesaria para solo mostrar al momento de comprar boletos, las salas con asientos disponibles y
   con una película asignada.
8. Validar los datos de entrada para evitar errores y mostrar mensajes de error en caso de que ocurran.
9. Probar el sistema con diferentes casos de uso para verificar su correcto funcionamiento.

## Entregables

1. Código fuente de la solución en un archivo comprimido.
2. Documentación del programa que incluya:
    - Diagrama de clases.
    - Código fuente con comentarios JavaDoc.
    - Ejemplos de ejecución del programa.
3. Portada con datos de identificación de los miembros del equipo.

La tabla de precios por género es la siguiente:

| Género          | Costo Adicional |
|-----------------|-----------------|
| Acción          | 5.00            |
| Comedia         | 3.00            |
| Drama           | 4.00            |
| Terror          | 6.00            |
| Ciencia Ficción | 5.00            |
| Animación       | 3.00            |
| Aventura        | 4.00            |
| Documental      | 2.00            |
| Musical         | 3.00            |
| Romance         | 4.00            |
| Suspenso        | 5.00            |

## Criterios de Evaluación

| Criterio                           | Descripción                                                                                         | Puntaje |
|------------------------------------|-----------------------------------------------------------------------------------------------------|---------|
| Portada                            | Incluye los datos de identificación de los miembros del equipo.                                     | 5%      |
| Diagrama de Clases                 | Representa las clases y sus relaciones de manera clara y concisa.                                   | 10%     |
| Modularidad del Código             | El código está organizado en clases y archivos diferentes, además de contar con métodos coherentes. | 10%     |
| Implementación de Clases y Objetos | Las clases y objetos están correctamente implementados.                                             | 10%     |
| Implementación de Menú de Opciones | El menú de opciones permite al usuario realizar las acciones.                                       | 15%     |
| Implementación de Lógica           | La lógica del sistema permite agregar películas, comprar boletos y mostrar información.             | 20%     |
| Validación de Entrada del Usuario  | Se valida la entrada del usuario para evitar errores.                                               | 15%     |
| Pruebas del Sistema                | Se realizan pruebas con diferentes casos de uso para verificar el funcionamiento del sistema.       | 15%     |
| Total                              |                                                                                                     | 100%    |

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

Lunes 24 de marzo de 2025, 11:59 p.m. (medianoche)

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos.**
> {style="warning"}