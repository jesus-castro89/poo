# Actividad 1: Sistema de inventario y ventas de una librería

## Descripción

Ha sido contratado por una librería para realizar un sistema para gestionar su inventario de libros que tienen en
existencia, además de gestionar las ventas realizadas. La librería tiene una lista de los libros que tienen en
existencia, tomando en cuenta lo siguiente:

* El limite de libros en la librería es de 50, mientras el total de libros en la compra no puede superar los 15.
* Cada libro tiene un título, un autor, un género y un precio.
* Cada libro tiene un identificador único (ISBN) que es un entero largo de 13 dígitos. El cual no se repite ni se
  modifica. Este identificador se genera automáticamente al agregar un libro a la lista.
* Los datos ingresados deberán ser validados, por lo que no se permitirá ingresar datos vacíos, nulos o incorrectos.
* Los géneros disponibles son: `Ficción`, `No Ficción`, `Terror`, `Fantasía`, `Ciencia Ficción`, `Romance`, `Misterio`,
  `Aventura`.
* Al listar cada libro se deberá mostrar el ISBN, título, autor, género y precio con el siguiente formato:
  `ISBN: <ISBN> | Título: <Título> | Autor: <Autor>
   Género: <Género> (Descuento: <Descuento>) | Precio: $<Precio>`
* Cada género tiene un porcentaje de descuento asociado, el cual se aplica al precio del libro al momento de calcular el
  total de la compra. Los porcentajes de descuento son los siguientes:
    * `Ficción`: 10%
    * `No Ficción`: 5%
    * `Terror`: 15%
    * `Fantasía`: 20%
    * `Ciencia Ficción`: 25%
    * `Romance`: 10%
    * `Misterio`: 15%
    * `Aventura`: 20%
* La librería tiene promociones especiales según el monto total de la compra:
    * Si el monto total de la compra es mayor o igual a $500.00, se aplica un descuento adicional del 10%.
    * Si el monto total de la compra es mayor o igual a $1000.00, se aplica un descuento adicional del 20%.
    * Si el monto total de la compra es mayor o igual a $1500.00, se aplica un descuento adicional del 30%.
    * Si el monto total de la compra es mayor o igual a $2000.00, se aplica un descuento adicional del 40%.
    * Si el monto total de la compra es mayor o igual a $2500.00, se aplica un descuento adicional del 50%.
* La librería debe permitir agregar, eliminar y modificar libros en la lista.
* La librería debe permitir realizar una compra, la cual debe mostrar el detalle de la compra y el monto total a pagar
  con los descuentos aplicados y debidamente redondeado a 2 decimales (si aplica). Además, debe mostrar el monto total
  y detalle de los descuentos aplicados.
* En resumen las opciones del menú son:
    1. Agregar libro
    2. Eliminar libro
    3. Modificar libro
    4. Abrir Compra
    5. Agregar libro a la compra
    6. Eliminar libro de la compra
    7. Realizar compra
    8. Salir

## Entregables

* Diagrama de clases UML del proyecto.
* Código fuente del proyecto.
* Captura de pantalla de la ejecución del programa con datos de prueba.