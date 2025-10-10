# Actividad 9: Extendiendo la Agencia de Vehículos

Para esta actividad, tomaremos como base el ejemplo de la Agencia de Vehículos que hemos desarrollado previamente en el
ejemplo 7. El objetivo es ampliar la funcionalidad del sistema y practicar conceptos avanzados de programación en Java,
como el manejo de excepciones personalizadas, la carga de recursos externos y la organización del código en paquetes.

## Paso 1: Crear la estructura de directorios

Para esta actividad, crearemos la siguiente estructura de directorios:

```
mi_proyecto
├── src
│   ├── app
│   │   ├── entities
│   │   │   └── (todas las clases de entidades, como Vehiculo, Auto, Moto, etc.)
│   │   ├── exceptions
│   │   │   └── DuplicateVehicleException.java
|   |   |   └── (otras excepciones personalizadas del sistema)
│   │   ├── enums
│   │   │   └── OptionsMenu.java
│   │   ├── generics
│   │   │   └── Garage.java
│   │   ├── utils
│   │   │   └── VehicleUtils.java
│   │   └── Main.java
└── lib
    └── mi_libreria.jar
```

- `src`: Contendrá el código fuente de nuestras clases Java.
    * Dentro de `src`, crearemos varios paquetes para organizar mejor nuestro código:
        - `entities`: Contendrá todas las clases de entidades, como `Vehiculo`, `Auto`, `Moto`, etc.
        - `exceptions`: Contendrá excepciones personalizadas, como `DuplicateVehicleException`.
        - `enums`: Contendrá enumeraciones, como `OptionsMenu`.
        - `generics`: Contendrá clases genéricas, como `Garage`.
        - `utils`: Contendrá clases utilitarias, como `VehicleUtils`.
        - `Main.java`: El punto de entrada de la aplicación.
- `lib`: Contendrá cualquier librería externa que necesitemos, como un archivo JAR.

## Paso 2: Crear las clases Java

Recuerda que la estructura general de nuestro proyecto ya está definida en el ejemplo 7. Ahora, añadiremos nuevas
funcionalidades para conseguir los desafios propuestos.

1. Implementa una clase `RentalService` que maneje la lista de vehículos y clientes, y permita buscar vehículos
   disponibles.
2. Añade un menú interactivo usando `JOptionPane` para registrar clientes, vehículos y crear alquileres.
    * Para ello usa la clase génerica `Garage<T>` para manejar las cocheras que ofrecen el servicio de alquiler.
3. Añade más tipos de vehículos.
    * Por ejemplo, `Bicicleta` con atributo `tipo` (montaña, carretera).
    * Recuerda que deberás de generar al menos 2 tipos de vehículos nuevos.
4. Implementa descuentos por alquileres largos o clientes frecuentes.
    * Por ejemplo, un 10% de descuento si el alquiler es por más de 7 días.
    * En este caso, deberás implementar un Enum `DiscountType` para manejar los diferentes tipos de descuentos y sus
      porcentajes para facilitar la gestión de descuentos en el sistema.
5. Añade validaciones adicionales.
    * Deberás agregar las siguientes validaciones:
        - No permitir registrar un vehículo con matrícula duplicada.
        - No permitir que un cliente tenga más de 3 vehículos alquilados simultáneamente.

## Paso 3: Compilar y ejecutar el proyecto

## Entregables

En un solo documento PDF, incluye lo siguiente:

* Portada con los siguientes datos:
    * Nombre del curso
    * Nombre de la actividad
    * Nombre de los integrantes del equipo
* Código fuente de todas las clases implementadas.
* Capturas de pantalla que muestren la estructura de directorios, la configuración del proyecto para generar el JAR, y
  la inclusión del JAR en otro proyecto.
* Breve reflexión (máximo 200 palabras) sobre los desafíos encontrados durante la implementación y cómo lo superarón.

> Actividades entregadas posteriores a la fecha límite serán consideradas con una calificación máxima de 70/100.
> {style="warning"}

> Integrante que no aparezca en la portada no será considerado en la evaluación de la actividad.
> {style="warning"}

## Criterios de Evaluación

| Criterio                  | Descripción                                                   | Peso     |
|---------------------------|---------------------------------------------------------------|----------|
| Portada                   | Datos de identificación de los miembros del equipo            | 5%       |
| Estructura de Directorios | Implementación correcta de la estructura de directorios       | 20%      |
| Clases Java               | Implementación correcta de las clases con sus funcionalidades | 30%      |
| Archivo JAR               | Correcta configuración y generación del archivo JAR           | 20%      |
| Funcionalidades Nuevas    | Implementación de las nuevas funcionalidades solicitadas      | 25%      |
| Total                     |                                                               | **100%** |