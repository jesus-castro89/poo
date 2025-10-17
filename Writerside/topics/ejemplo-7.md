# Ejemplo 7: La Agencia de Renta de Vehículos

## Descripción

Una pequeña empresa, RentQuick, alquila vehículos (cars, motorcycles, trucks). Necesitan un módulo que permita:

* Registrar vehículos y clientes.
* Crear alquileres validando datos del cliente y la disponibilidad del vehículo.
* Calcular el precio final según reglas específicas por tipo de vehículo (polimorfismo).
* Calcular costo de seguro por día (cada vehículo lo calcula de forma distinta).
* Manejar errores (cliente menor de edad, licencia vencida, matrícula inválida, vehículo no disponible, rangos de fecha
  inválidos).

Piensa en el sistema como la ventanilla de un local de renta: distintos vehículos comparten comportamiento básico (rent,
return, price calculation), pero cada tipo tiene su propia forma de calcular precio y requisitos.

> La herencia es como un menú base (Platillo base) y las subclases son variantes (con salsa picante, sin sal). El
> restaurante (aplicación) trata los platillos de forma genérica (polimorfismo) pero el cocinero aplica variaciones (
> sobrecarga).
> {style="note"}

## Diagrama de Clases

![e7_uml.png](e7_uml.png) {style="block"}

## Desarrollo

### Paso 1: Definir excepciones personalizadas

Cuando algo sale mal (edad inválida, vehículo ocupado, datos erróneos), queremos lanzar una excepción clara.
Creamos dos clases:

![e7_ex1.png](e7_ex1.png){style="block"}

![e7_ex2.png](e7_ex2.png){style="block"}

![e7_i3.png](e7_i3.png){style="block"}

![e7_i4.png](e7_i4.png){style="block"}

> En lugar de usar RuntimeException, usamos checked exceptions (heredan de Exception), obligando al programador a
> tratarlas con try...catch. Esto mejora la robustez del código.
> {style="note"}

### Paso 2: Crear la clase `Client`

Recuerda que de aquí en adelante haremos uso de nuestra clase `InputHandler` como librería para manejar entradas y
validaciones.

![e7_cl.png](e7_cl.png){style="block"}

### Paso 3: Interfaces `Rentable` y `Insurable`

Definimos dos interfaces para los comportamientos comunes de los vehículos:

![e7_i1.png](e7_i1.png){style="block"}

![e7_i2.png](e7_i2.png){style="block"}

### Paso 4: Clase abstracta `Vehicle`

![e7_vabs.png](e7_vabs.png){style="block"}

### Paso 5: Clases concretas de vehículos

![e7_car.png](e7_car.png){style="block"}

![e7_motorcycle.png](e7_motorcycle.png){style="block"}

![e7_truck.png](e7_truck.png){style="block"}

> Cada subclase personaliza el cálculo del precio total.
> Esto es polimorfismo dinámico: el programa llama a calculateRentalPrice() sin saber qué tipo de vehículo es, pero se
> ejecuta el comportamiento adecuado.
> {style="note"}

### Paso 6: Clase `Rental`

![e7_rental.png](e7_rental.png){style="block"}

## Desafío Extra

1. Implementa una clase `RentalService` que maneje la lista de vehículos y clientes, y permita buscar vehículos
   disponibles.
2. Añade un menú interactivo usando `JOptionPane` para registrar clientes, vehículos y crear alquileres.
3. Implementa persistencia básica (guardar y cargar datos) usando archivos de texto o serialización.
4. Añade más tipos de vehículos (bicicletas, scooters) con sus propias reglas de alquiler.
5. Implementa descuentos por alquileres largos o clientes frecuentes.
6. Añade validaciones adicionales (por ejemplo, evitar que un cliente tenga más de 3 alquileres activos).
7. Crea reportes de ingresos mensuales y vehículos más alquilados.