# Actividad 2: Definición de clases y objetos

## Descripción

Lee atentamente el siguiente problema y define el diagrama de clases correspondiente, identificando las clases,
atributos, métodos y relaciones entre ellas. Así mismo, implementa las clases en Java y crea objetos para representar
las entidades del problema.

## Problema

Una tienda en línea desea gestionar su inventario de productos y las órdenes de compra realizadas por los clientes. El
sistema debe permitir registrar productos, clientes y órdenes de compra, así como realizar búsquedas y actualizaciones
en el inventario.

Toma en consideración que:

* Un producto tiene un nombre, una descripción, un precio y una cantidad en stock.
* Un cliente tiene un nombre, una dirección de correo electrónico y una lista de órdenes de compra, que no pueden ser
  más de 5.
* Una orden de compra tiene un identificador único, una lista de productos comprados que no pueden ser más de 10 y el
  total a pagar.
* El sistema debe permitir agregar nuevos productos al inventario que no pueden ser más de 100, registrar nuevos
  clientes, crear nuevas órdenes de compra, calcular el total a pagar de una orden de compra.
* El sistema debe permitir buscar productos por nombre y actualizar la cantidad en stock de un producto.

## Requisitos

1. Define el diagrama de clases que represente las entidades del problema, sus atributos, métodos y relaciones.
2. Implementa las clases en Java siguiendo el diagrama de clases definido.
3. Crea objetos para representar productos, clientes y órdenes de compra.
4. Implementa los métodos necesarios para cumplir con los requisitos del sistema.
5. Realiza pruebas para verificar que el sistema funciona correctamente. Asegúrate de probar la creación de productos,
   clientes y órdenes de compra, así como las búsquedas y actualizaciones en el inventario.
6. Documenta tu código con comentarios que expliquen la funcionalidad de cada clase, atributo y método.
7. Para entradas y salidas de datos, utiliza la clase `JOptionPane` de Java para interactuar con el usuario en todo el
   sistema.

## Entregables

Para esta actividad, debes entregar los siguientes elementos en un solo documento PDF:

1. Portada con el nombre de la actividad, tu nombre y el de tus compañeros de equipo.
    * > **Recuerda que miembro que no se encuentre en la portada no recibirá calificación.** {style="warning"}
2. El diagrama de clases que has definido.
3. El código fuente de las clases implementadas en Java. Debidamente comentado.
4. Un breve informe que describa cómo has implementado el sistema, los desafíos que has enfrentado y cómo los has
   resuelto.
5. Capturas de pantalla de las pruebas realizadas y los resultados obtenidos.

## Criterios de Evaluación

| Criterio                     | Puntuación     |
|------------------------------|----------------|
| Diagrama de clases           | 20 puntos      |
| Implementación de clases     | 30 puntos      |
| Creación de objetos          | 20 puntos      |
| Funcionalidad del sistema    | 20 puntos      |
| Documentación y presentación | 10 puntos      |
| **Total**                    | **100 puntos** |

## Fecha de Entrega

La fecha límite para la entrega de esta actividad es el **5 de septiembre de 2025**. Asegúrate de cumplir con todos los
requisitos y entregar todos los elementos solicitados en el formato indicado.

> **Recuerda que toda actividad entregada después de la fecha límite tendrá una penalización del 30% en la calificación
final.** {style="warning"}