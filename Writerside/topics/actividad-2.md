# Actividad 2: Sistema de Gestión de una Cafetería

## Descripción

Eres el desarrollador de un sistema para una cafetería. Debes crear un programa que permita gestionar pedidos de bebidas
y postres. Las bebidas tienen un tipo (café, té, jugo, chocolate) y un tamaño (pequeño, mediano, grande).

Cada bebida tiene un precio base y el precio final se calcula sumando el costo de la bebida más el costo del tamaño.

```tex
PrecioFinal = PrecioBase + CostoTamaño
```

Los de las bebidas son los siguientes:

| Tipo      | Precio Base |
|-----------|-------------|
| Café      | 15.50       |
| Té        | 10.00       |
| Jugo      | 12.00       |
| Chocolate | 20.00       |

Los costos de los tamaños son los siguientes:

| Tamaño  | Costo |
|---------|-------|
| Pequeño | 0.00  |
| Mediano | 5.50  |
| Grande  | 8.00  |

Los postres tienen un tipo (pastel, galleta, helado) y un sabor (vainilla, chocolate, fresa). Cada postre tiene un
precio base. El precio final de un postre es el precio base más un costo adicional que depende del sabor.

```tex
PrecioFinal = PrecioBase + CostoSabor
```

Los precios base de los postres son los siguientes:

| Tipo    | Precio Base |
|---------|-------------|
| Pastel  | 25.00       |
| Galleta | 5.00        |
| Helado  | 15.00       |

Los costos de los sabores son los siguientes:

| Sabor     | Costo |
|-----------|-------|
| Vainilla  | 0.00  |
| Chocolate | 8.00  |
| Fresa     | 5.00  |

El programa debe permitir al usuario realizar las siguientes acciones:

1. Agregar una bebida al pedido.
2. Agregar un postre al pedido.
3. Ver el resumen del pedido.
4. Pagar el pedido
5. Salir del programa.

El resumen del pedido debe mostrar la lista de bebidas y postres agregados con sus precios finales, así como el total
a pagar.

Por ejemplo, si el usuario agrega un café grande, un jugo mediano, un pastel de chocolate y una galleta de fresa, el
resumen del pedido sería el siguiente:

```
Resumen del Pedido
------------------
Bebidas:
- Café Grande: $23.50
- Jugo Mediano: $17.50  
Postres:
- Pastel de Chocolate: $33.00
- Galleta de Fresa: $10.00
------------------
Total a Pagar: $84.00
```

## Requerimientos

1. Crea un programa que permita gestionar pedidos de bebidas y postres en una cafetería en Java.
2. Utiliza clases, objetos y tipos enumerados para representar las bebidas y postres.
3. Implementa un menú de opciones que permita al usuario realizar las acciones mencionadas.
4. Utiliza JOptionPane para mostrar mensajes y leer la entrada del usuario.
5. Utiliza un ciclo para permitir al usuario agregar múltiples bebidas y postres al pedido.
6. Se debe tomar en cuenta que el máximo de bebidas y postres que se pueden agregar al pedido es de 10.
7. Se deberán mostrar mensajes de error si el usuario intenta agregar más de 10 bebidas o postres al pedido.
8. Se deberá mostrar un mensaje de confirmación antes de salir del programa.
9. Se deberá validar la entrada del usuario para que solo pueda ingresar opciones válidas del menú.
10. Se deberá mostrar un mensaje de error si el usuario ingresa una opción inválida.
11. Se deberá mostrar un mensaje de error si el usuario intenta pagar el pedido sin haber agregado al menos una bebida
    y un postre.

## Entregables

1. Código fuente de la solución en un archivo comprimido.
2. Documentación del programa que incluya:
    - Diagrama de clases.
    - Código fuente con comentarios JavaDoc.
    - Ejemplos de ejecución del programa.
3. Portada con datos de identificación de los miembros del equipo.

## Criterios de Evaluación

| Criterio                           | Descripción                                                                                         | Puntaje  |
|------------------------------------|-----------------------------------------------------------------------------------------------------|----------|
| Portada                            | Incluye los datos de identificación de los miembros del equipo.                                     | 5%       |
| Diagrama de Clases                 | Representa las clases y sus relaciones de manera clara y concisa.                                   | 10%      |
| Modularidad del Código             | El código está organizado en clases y archivos diferentes, además de contar con métodos coherentes. | 10%      |
| Implementación de Clases y Objetos | Las clases y objetos están correctamente implementados.                                             | 10%      |
| Implementación de Menú de Opciones | El menú de opciones permite al usuario realizar las acciones.                                       | 15%      |
| Implementación de Ciclo de Pedido  | El ciclo de pedido permite agregar múltiples bebidas y postres.                                     | 15%      |
| Validación de Entrada del Usuario  | Se valida la entrada del usuario para evitar errores.                                               | 15%      |
| Documentación del Programa         | Incluye JavaDoc, portada y evidencias de ejecución.                                                 | 25%      |
| **Total**                          |                                                                                                     | **100%** |

> **La evaluación se realizará con base en los criterios establecidos en la rúbrica. Se considerará la claridad,
> organización, comentarios y estilo del código, así como la calidad de la documentación. Además, se tomará en cuenta
> el cumplimiento de los requerimientos y la funcionalidad del programa.**
> {style="note"}

> **Actividad entregada en lenguaje distinto a Java o sin el uso de clases y objetos, así como de modularidad, no será
> evaluada.**
> {style="warning"}

## Fecha de Entrega

Viernes 14 de marzo de 2025, 11:59 p.m. (medianoche)

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos.**
> {style="warning"}