# Ejemplo 4: Validando datos de entrada en Java y control de excepciones

En este ejemplo, aprenderemos a validar los datos de entrada en Java y a controlar las excepciones que pueden ocurrir
durante la ejecución de un programa. La validación de datos de entrada es una parte importante del desarrollo de
software, ya que ayuda a garantizar que los datos proporcionados por el usuario sean correctos y válidos. El control de
excepciones, por otro lado, nos permite manejar situaciones inesperadas que pueden ocurrir durante la ejecución de un
programa.

## Validación de datos de entrada

La validación de datos de entrada es un proceso que consiste en verificar que los datos proporcionados por el usuario
cumplen con ciertas condiciones o restricciones. Esto puede incluir la verificación de la longitud de una cadena, el
rango de un número, el formato de una dirección de correo electrónico, etc.

En Java, podemos validar los datos de entrada utilizando expresiones regulares, métodos de validación personalizados o
bibliotecas de validación como `Apache Commons Validator` o `Hibernate Validator`.

### Ejemplo de validación de datos de entrada

Supongamos que queremos validar un número entero proporcionado por el usuario para asegurarnos de que esté en el rango
de `1` a `100`. Podemos hacerlo de la siguiente manera:

```java
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog("Introduce un número entre 1 y 100:");
        int number = Integer.parseInt(input);

        if (number < 1 || number > 100) {
            JOptionPane.showMessageDialog(null, "El número debe estar entre 1 y 100.");
        } else {
            JOptionPane.showMessageDialog(null, "Número válido: " + number);
        }
    }
}
```

En este ejemplo, utilizamos el método `showInputDialog` de la clase `JOptionPane` para solicitar al usuario que
introduzca un número. Luego, convertimos la entrada del usuario a un número entero utilizando el método
`parseInt` de la clase `Integer`. Finalmente, verificamos si el número está en el rango de `1` a `100` y mostramos
un mensaje apropiado al usuario.

## Control de excepciones

El control de excepciones es un mecanismo que nos permite manejar situaciones excepcionales que pueden ocurrir durante
la ejecución de un programa. Las excepciones pueden ser causadas por errores de programación, condiciones imprevistas o
situaciones fuera del control del programador.

En Java, las excepciones se manejan utilizando bloques `try-catch` o `throws` en los métodos que pueden lanzar una
excepción. Esto nos permite capturar y manejar las excepciones de forma adecuada, evitando que el programa se detenga
de forma abrupta.

### Ejemplo de control de excepciones

Si tomamos el ejemplo anterior y queremos manejar la excepción que se produce cuando el usuario introduce un valor no
numérico, podemos hacerlo de la siguiente manera:

```java
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        try {
            String input = JOptionPane.showInputDialog("Introduce un número entre 1 y 100:");
            int number = Integer.parseInt(input);

            if (number < 1 || number > 100) {
                JOptionPane.showMessageDialog(null, "El número debe estar entre 1 y 100.");
            } else {
                JOptionPane.showMessageDialog(null, "Número válido: " + number);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Introduce un número válido.");
        }
    }
}
```

En este ejemplo, hemos envuelto el código que convierte la entrada del usuario a un número entero en un bloque `try`
y hemos añadido un bloque `catch` para capturar la excepción `NumberFormatException` que se produce cuando el usuario
introduce un valor no numérico. Si se produce esta excepción, mostramos un mensaje de error al usuario.

## Creando una excepción personalizada para la validación

En algunos casos, puede ser útil crear una excepción personalizada para manejar situaciones específicas que no se
pueden manejar con las excepciones estándar de Java. Por ejemplo, podríamos crear una excepción personalizada para
manejar la validación de datos de entrada.

### Ejemplo de excepción personalizada para la validación

Supongamos que queremos crear una excepción personalizada llamada `InvalidNumberException` para manejar la validación
de números enteros. Podemos hacerlo de la siguiente manera:

1. Primer paso: Crear la excepción personalizada.

```java
public class InvalidNumberException extends Exception {

    public InvalidNumberException(String message) {
        super(message);
    }
}
```

2. Segundo paso: Utilizar la excepción personalizada en el código.

```java
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        try {
            String input = JOptionPane.showInputDialog("Introduce un número entre 1 y 100:");
            int number = Integer.parseInt(input);

            if (number < 1 || number > 100) {
                throw new InvalidNumberException("El número debe estar entre 1 y 100.");
            } else {
                JOptionPane.showMessageDialog(null, "Número válido: " + number);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Introduce un número válido.");
        } catch (InvalidNumberException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
```

En este ejemplo, hemos creado una excepción personalizada llamada `InvalidNumberException` que extiende la clase
`Exception` de Java. Luego, hemos lanzado esta excepción cuando el número introducido por el usuario no está en el
rango de `1` a `100`. Si se produce esta excepción, mostramos un mensaje de error al usuario.

## Conclusión

En este ejemplo, hemos aprendido a validar los datos de entrada en Java y a controlar las excepciones que pueden ocurrir
durante la ejecución de un programa. La validación de datos de entrada es esencial para garantizar la integridad de los
datos proporcionados por el usuario, mientras que el control de excepciones nos permite manejar situaciones
excepcionales de forma adecuada. Al utilizar estos mecanismos, podemos mejorar la robustez y fiabilidad de nuestros
programas Java.