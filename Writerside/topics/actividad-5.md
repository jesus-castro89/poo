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