# Actividad 3: Validando entradas de datos en Java

## Descripción

En esta actividad, deberás de crear una clase en Java que valide diferentes tipos de entradas de datos utilizando
excepciones. La clase debe incluir métodos para validar números enteros, números decimales y cadenas de texto. Si la
entrada no es válida, el método debe lanzar una excepción personalizada con un mensaje de error adecuado.

Recuerda que la entrada de datos se realizará mediante la clase **JOptionPane** de la librería **javax.swing**.

## Requisitos

1. Crea una clase llamada `InputValidator` que contenga los siguientes métodos:
    - `validateInteger()`: Válida si la entrada es un número entero. Si no lo es, lanza una excepción
      personalizada llamada `InvalidIntegerException`.
    - `validateDouble()`: Válida si la entrada es un número decimal. Si no lo es, lanza una excepción
      personalizada llamada `InvalidDoubleException`.
    - `validateString()`: Válida si la entrada es una cadena de texto que no esté vacía. Si está vacía, lanza
      una excepción personalizada llamada `InvalidStringException`.
2. Crea las clases de excepción personalizadas `InvalidIntegerException`, `InvalidDoubleException` e
   `InvalidStringException`, que extiendan de la clase `Exception`.
3. Las funciones de validación deben utilizar bloques `JOptionPane.showInputDialog` para solicitar la entrada del
   usuario. Recuerda que existen diversas maneras de personalizar los cuadros de diálogo.
4. Con las entradas obtenidas, utiliza los métodos de validación correspondientes y maneja las excepciones lanzadas
   utilizando bloques `try-catch`. Muestra mensajes de error adecuados en caso de que se lance una excepción.
5. Las funciones deberán mantener cautivo el ciclo de solicitud de entrada hasta que el usuario ingrese un
   valor válido.
6. Crea una clase `Main` con un método `main` para probar los métodos de validación de la clase `InputValidator`.
   Solicita al usuario que ingrese un número entero, un número decimal y una cadena de texto, y utiliza los métodos
   de validación para verificar las entradas.

## Ejemplo de uso

```java
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        InputValidator validator = new InputValidator();

        // Validar número entero
        int intValue = InputValidator.validateInteger();
        System.out.println("Número entero válido: " + intValue);
    }
}
```

## Entregables

Para esta actividad, debes entregar los siguientes elementos en un solo documento PDF:

1. Portada con el nombre de la actividad, tu nombre y el de tus compañeros de equipo.
    * > **Recuerda que miembro que no se encuentre en la portada no recibirá calificación.** {style="warning"}
2. El código fuente de las clases implementadas en Java. Debidamente comentado.
3. Un breve informe que describa cómo has implementado el sistema, los desafíos que has enfrentado y cómo los has
   resuelto.
4. Capturas de pantalla de las pruebas realizadas y los resultados obtenidos.

## Criterios de Evaluación

| Criterio                     | Puntuación     |
|------------------------------|----------------|
| Implementación de clases     | 30 puntos      |
| Creación de excepciones      | 20 puntos      |
| Funcionalidad del sistema    | 30 puntos      |
| Documentación y presentación | 10 puntos      |
| **Total**                    | **100 puntos** |

## Fecha de Entrega

La fecha límite para la entrega de esta actividad es el **12 de septiembre de 2025**. Asegúrate de cumplir con todos los
requisitos y entregar todos los elementos solicitados en el formato indicado.