# Actividad 12: Sistema de Inventario “TechStore”

## Descripción

La empresa TechStore requiere un sistema para registrar, consultar y administrar productos.
Cada producto puede ser de un tipo distinto (por ejemplo, Laptop, Smartphone, Tablet, etc.), pero todos comparten
características básicas como nombre, precio y cantidad en inventario.

El sistema debe permitir al usuario (mediante JOptionPane) realizar operaciones como:

* Agregar productos al inventario
* Consultar productos
* Mostrar todos los productos registrados
* Buscar productos por nombre o por código
* Eliminar productos del inventario

El inventario se almacenará utilizando una tabla hash (HashMap) para búsquedas rápidas por código.

## Requerimientos

1. La aplicación debe permitir agregar productos al inventario, solicitando al usuario el nombre, precio, cantidad y
   tipo de producto.
2. La aplicación debe permitir consultar un producto por su código único.
3. La aplicación debe permitir mostrar todos los productos registrados en el inventario.
4. La aplicación debe permitir buscar productos por nombre.
5. La aplicación debe permitir eliminar productos del inventario por su código.
6. La aplicación debe utilizar la clase `HashMap` para almacenar los productos en el inventario.
7. La aplicación debe interactuar con el usuario a través de ventanas emergentes (JOptionPane).
8. La aplicación debe contar con al menos 3 tipos de productos diferentes (por ejemplo, Laptop, Smartphone, Tablet).
9. La aplicación debe contar con al menos 2 interfaces `Stockable` y `Sellable` que definan métodos relacionados con el
   inventario y la venta de productos.
    * La interfaz `Stockable` debe incluir métodos para agregar, eliminar y consultar productos en el inventario.
        * Siendo más específico, debe incluir métodos como `addStock()`, `removeStock()` y `checkStock()`.
    * La interfaz `Sellable` debe incluir métodos para calcular el precio de venta con impuestos y descuentos.
        * Siendo más específico, debe incluir métodos como `calculatePriceWithTax()` y `applyDiscount()`.
    * **Es importante destacar que no todos los productos necesitan implementar ambas interfaces; algunos pueden
      implementar solo una de ellas según sus características.**
10. La aplicación debe ser desarrollada en Java.
11. La aplicación debe estar modularizada, dividiendo la lógica del programa en clases y métodos manejables.
12. La aplicación debe de contar con una lista de productos predefinidos para facilitar las pruebas.
13. La aplicación debe estar documentada y comentada adecuadamente usando JavaDoc.

## Entregables

En un solo documento PDF, incluir los siguientes elementos:

1. Portada con datos de identificación de los miembros del equipo.
2. Código fuente de la aplicación.
    * El código fuente debe estar organizado en clases y métodos, así como modularizado, es decir, debe estar dividido
      en partes más pequeñas y manejables dentro de archivos `.java`.
3. Capturas de pantalla de la aplicación en ejecución.

## Criterios de Evaluación

| Criterio             | Descripción                                                               | Puntaje  |
|----------------------|---------------------------------------------------------------------------|----------|
| Portada              | Datos de identificación de los miembros del equipo                        | 5%       |
| Agregar productos    | Permitir agregar productos al inventario                                  | 15%      |
| Consultar productos  | Permitir consultar un producto por su código único                        | 10%      |
| Mostrar productos    | Permitir mostrar todos los productos registrados                          | 10%      |
| Buscar productos     | Permitir buscar productos por nombre                                      | 10%      |
| Eliminar productos   | Permitir eliminar productos del inventario por su código                  | 10%      |
| Uso de HashMap       | Utilizar la clase `HashMap` para almacenar los productos en el inventario | 10%      |
| Interfaces           | Implementar las interfaces `Stockable` y `Sellable` adecuadamente         | 15%      |
| Código fuente        | Código fuente de la aplicación                                            | 10%      |
| Capturas de pantalla | Capturas de pantalla de la aplicación en ejecución                        | 5%       |
| **Total**            |                                                                           | **100%** |

> **Nota:** La aplicación debe ser desarrollada en Java. No se aceptarán aplicaciones desarrolladas en otro lenguaje de
> programación.

> **Nota:** Recuerda que puedes hacer uso de las funciones de la clase Arrays de Java para trabajar con arreglos.

> Miembro del equipo que no aparece en la portada, no será evaluado.
> {style="warning"}

> Entregas fuera de la fecha límite, serán evaluadas sobre 70 puntos.
> {style="warning"}