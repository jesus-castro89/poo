# Bloque try-catch

El bloque `try-catch` es una estructura de control que permite manejar excepciones en Java. Una excepción es un evento
que ocurre durante la ejecución de un programa y que interrumpe el flujo normal de ejecución. Las excepciones pueden ser
causadas por errores en el código, como una división por cero, un acceso a un índice fuera de los límites de un arreglo,
o una operación de entrada/salida fallida. También pueden ser causadas por condiciones externas, como la falta de
memoria o la pérdida de conexión a una base de datos.

El bloque `try-catch` se utiliza para envolver el código que puede lanzar una excepción y manejarla en caso de que
ocurra.

## Sintaxis

La sintaxis básica de un bloque `try-catch` en Java es la siguiente:

```java
try {
    // Código que puede lanzar una excepción
} catch (ExcepciónTipo1 e) {
    // Manejo de la excepción de tipo ExcepciónTipo1
} catch (ExcepciónTipo2 e) {
    // Manejo de la excepción de tipo ExcepciónTipo2
}
```

En esta sintaxis:

- El bloque `try` contiene el código que puede lanzar una excepción.
- Los bloques `catch` contienen el código que maneja la excepción en caso de que ocurra. Cada bloque `catch` maneja un
  tipo específico de excepción.
- La variable `e` es una referencia a la excepción que se ha lanzado. Se puede utilizar esta variable para obtener
  información sobre la excepción, como el mensaje de error.

## Ejemplo

A continuación se muestra un ejemplo de un bloque `try-catch` que maneja una excepción de tipo `ArithmeticException`:

```java
public class TryCatchExample {

    public static void main(String[] args) {
        try {
            int resultado = dividir(10, 0);
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int dividir(int numerador, int denominador) {
        return numerador / denominador;
    }
}
```