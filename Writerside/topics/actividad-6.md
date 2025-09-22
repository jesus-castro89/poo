# Actividad 6: Calculadora de Figuras Geométricas

## Descripción

Queremos desarrollar una clase que nos ayude a calcular áreas de distintas figuras. En lugar de crear métodos con
distintos nombres (calculateSquareArea, calculateCircleArea, etc.), utilizaremos la sobrecarga de métodos.

## Requerimientos

1. Crea una clase llamada GeometryCalculator.
2. Dentro de la clase, define el método sobrecargado calculateArea() con las siguientes variantes:
    * calculateArea(double side) → Calcula el área de un cuadrado.
    * calculateArea(double base, double height) → Calcula el área de un rectángulo.
    * calculateArea(double radius, boolean isCircle) → Calcula el área de un círculo, pero solo si el parámetro isCircle
      es true.
    * calculateArea(double base, double height, boolean isTriangle) → Calcula el área de un triángulo, pero solo si
      isTriangle es true.
3. En la clase principal GeometryApp:
    * Invoca cada una de las versiones del método sobrecargado.
    * Muestra los resultados en consola.

## Entregables

En un solo documento PDF, incluye lo siguiente:

* Portada con los siguientes datos:
    * Nombre del curso
    * Nombre de la actividad
    * Nombre de los integrantes del equipo
* Código fuente de todas las clases implementadas.
* Capturas de pantalla que muestren la ejecución del programa, incluyendo el uso de todas las funcionalidades del menú.
* Breve reflexión (máximo 200 palabras) sobre los desafíos encontrados durante la implementación y cómo lo superarón.

> Actividades entregadas posteriores a la fecha límite serán consideradas con una calificación máxima de 70/100.
> {style="warning"}

> Integrante que no aparezca en la portada no será considerado en la evaluación de la actividad.
> {style="warning"}

## Criterios de Evaluación

| Criterio                 | Descripción                                                   | Peso     |
|--------------------------|---------------------------------------------------------------|----------|
| Portada                  | Datos de identificación de los miembros del equipo            | 5%       |
| Clase GeometryCalculator | Implementación correcta de la clase con métodos sobrecargados | 40%      |
| Clase GeometryApp        | Implementación correcta de la clase principal                 | 20%      |
| Resultados               | Correcta invocación y muestra de resultados en consola        | 20%      |
| Documentación            | Código comentado y documentado adecuadamente                  | 15%      |
| **Total**                |                                                               | **100%** |

> Recuerda que el uso de la clase `JOptionPane` es obligatorio para la interacción con el usuario. De lo contrario se
> considerará que no se ha cumplido con los requisitos de la actividad. Así mismo deberás manejar excepciones y validar
> entradas, de lo contrario se considerará que no se ha cumplido con los requisitos de la actividad.
> {style="warning"}        