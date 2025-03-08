# Creando un validador genérico en Java

Hemos visto que cuando solicitamos datos mediante `JOptionPane`, estos se devuelven como cadenas de texto, lo que puede
ser un problema si necesitamos trabajar con tipos de datos específicos, como enteros o números de punto flotante. Para
solucionar este problema, podemos crear un validador genérico que convierta las cadenas de texto en el tipo de dato
deseado.

## ¿Qué es un validador genérico?

Un validador genérico es una clase que permite validar y convertir valores de un tipo de dato a otro de forma genérica.
En el caso de Java, podemos crear un validador genérico que convierta cadenas de texto en valores enteros, números de
punto flotante, etc. Y en caso de que la conversión no sea posible, se puede lanzar una excepción o devolver un valor
predeterminado.

## Creando un validador genérico

Para crear un validador genérico en Java, podemos utilizar una clase que cuente con métodos estáticos para validar y
convertir valores de un tipo de dato a otro.

```java
public class Validator {
    
}
```

Una vez creado el esqueleto de la clase `Validator`, podemos agregar métodos estáticos para validar y convertir valores
de un tipo de dato a otro. Así que analicemos cómo podemos implementar un validador genérico en Java.

En primer lugar, podemos detectar dos maneras de usar la función `JOptionPane.showInputDialog`:

1. Solicitar un valor y convertirlo a un tipo de dato específico.
2. Selección de un valor de una lista de opciones.
3. Solicitar un valor y validar que cumpla con ciertas condiciones.
4. Solicitar un valor y validar que cumpla con ciertas condiciones, y convertirlo a un tipo de dato específico.

### Solicitar un valor y convertirlo a un tipo de dato específico

Para el primer caso, podemos crear un método que reciba un mensaje y un tipo de dato genérico, y devuelva el valor
convertido al tipo de dato deseado.

```java
    public static <T> T validate(Class<T> type, String inputMessage, String errorMessage, String windowTitle) {
        
        String input;
        boolean valid = false;
        T result = null;
        while (!valid) {
            try {
                input = JOptionPane.showInputDialog(null, inputMessage, windowTitle,
                        JOptionPane.QUESTION_MESSAGE);
                if (input == null || input.isEmpty())
                    throw new IllegalArgumentException();
                result = switch (type.getName()) {
                    case "java.lang.String" -> (T) input;
                    case "java.lang.Integer" -> (T) Integer.valueOf(input);
                    case "java.lang.Double" -> (T) Double.valueOf(input);
                    case "java.lang.Float" -> (T) Float.valueOf(input);
                    case "java.lang.Long" -> (T) Long.valueOf(input);
                    case "java.lang.Short" -> (T) Short.valueOf(input);
                    case "java.lang.Byte" -> (T) Byte.valueOf(input);
                    case "java.lang.Boolean" -> (T) Boolean.valueOf(input);
                    case "java.lang.Character" -> (T) Character.valueOf(input.charAt(0));
                    default -> throw new IllegalArgumentException();
                };
                valid = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errorMessage, windowTitle, JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }
```

Analicemos el método `validate`:

- Recibe como parámetros el tipo de dato genérico `T`, un mensaje de entrada, un mensaje de error y un título de
  ventana.
- Declara una variable `input` para almacenar el valor introducido por el usuario.
- Declara una variable `valid` para controlar si el valor introducido es válido.
- Declara una variable `result` para almacenar el valor convertido al tipo de dato deseado.
- Inicia un bucle `while` que se ejecuta mientras el valor introducido no sea válido.
- Dentro del bucle, se intenta obtener el valor introducido por el usuario mediante `JOptionPane.showInputDialog`.
- Si el valor introducido es nulo o vacío, se lanza una excepción.
- Se utiliza una expresión `switch` para convertir el valor introducido al tipo de dato deseado.
- Si la conversión es exitosa, se asigna el valor a la variable `result` y se establece `valid` a `true`.
- Si ocurre un error durante la conversión, se muestra un mensaje de error mediante `JOptionPane.showMessageDialog`.
- El método devuelve el valor convertido al tipo de dato deseado.
- En caso de que el valor introducido no sea válido, el bucle se repite hasta que se introduzca un valor válido.

Con este método, podemos validar y convertir valores de un tipo de dato a otro de forma genérica. Por ejemplo, podemos
solicitar un valor entero de la siguiente manera:

```java
int value = Validator.validate(Integer.class, "Enter an integer:", "Invalid input. Please enter an integer.",
        "Input Dialog");
```

En este caso, el método `validate` solicitará al usuario que introduzca un valor entero y lo convertirá al tipo de dato
`Integer`. Si el usuario introduce un valor no válido, se mostrará un mensaje de error y se solicitará un nuevo valor.

### Selección de un valor de una lista de opciones

Para el segundo caso, podemos crear un método que reciba una lista de opciones y devuelva el valor seleccionado por el
usuario.

```java
    public static <T> T validate(T[] options, String inputMessage, String errorMessage, String windowTitle) {
        
        T result = null;
        boolean valid = false;
        while (!valid) {
            try {
                result = (T) JOptionPane.showInputDialog(null, inputMessage, windowTitle,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (result == null)
                    throw new IllegalArgumentException();
                valid = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errorMessage, windowTitle, JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }
```

Analicemos el método `validate`:

- Recibe como parámetros una lista de opciones genéricas, un mensaje de entrada, un mensaje de error y un título de
  ventana.
- Declara una variable `result` para almacenar el valor seleccionado por el usuario.
- Declara una variable `valid` para controlar si el valor seleccionado es válido.
- Inicia un bucle `while` que se ejecuta mientras el valor seleccionado no sea válido.
- Dentro del bucle, se intenta obtener el valor seleccionado por el usuario mediante `JOptionPane.showInputDialog`.
- Si el valor seleccionado es nulo, se lanza una excepción.
- El método devuelve el valor seleccionado por el usuario.
- En caso de que el valor seleccionado no sea válido, el bucle se repite hasta que se seleccione un valor válido.

Con este método, podemos solicitar al usuario que seleccione una opción de una lista de opciones de la siguiente manera:

```java
String[] options = { "Option 1", "Option 2", "Option 3" };
String selectedOption = Validator.validate(options, "Select an option:", "Invalid selection. Please select an option.",
        "Input Dialog");
```

En este caso, el método `validate` solicitará al usuario que seleccione una opción de la lista de opciones y devolverá
la opción seleccionada. Si el usuario no selecciona una opción válida, se mostrará un mensaje de error y se solicitará
una nueva selección.

> **Nota**: Recuerda que en el caso del arreglo de opciones, el mismo puede ser la lista de valores de un `enum`.
> Por ejemplo, si tenemos un `enum` llamado `Color` con los valores `RED`, `GREEN` y `BLUE`, podemos utilizarlo de la
> siguiente manera:
>
>   ```java
>   Color[] options = Color.values();
>   Color selectedColor = Validator.validate(options, "Select a color:", 
>        "Invalid selection. Please select a color.",
>        "Input Dialog");
>   ```
> {style="note"}

### Solicitar un valor y validar que cumpla con ciertas condiciones

Para el tercer caso, podemos crear un método que reciba un mensaje y una condición de validación, y devuelva el valor
introducido por el usuario si cumple con la condición.

```java
    public static String validate(Predicate<String> condition, String inputMessage, String errorMessage, String windowTitle) {
        
        String input;
        boolean valid = false;
        while (!valid) {
            try {
                input = JOptionPane.showInputDialog(null, inputMessage, windowTitle,
                        JOptionPane.QUESTION_MESSAGE);
                if (input == null || input.isEmpty() || !condition.test(input))
                    throw new IllegalArgumentException();
                valid = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errorMessage, windowTitle, JOptionPane.ERROR_MESSAGE);
            }
        }
        return input;
    }
```

Analicemos el método `validate`:

- Recibe como parámetros una condición de validación, un mensaje de entrada, un mensaje de error y un título de ventana.
- Declara una variable `input` para almacenar el valor introducido por el usuario.
- Declara una variable `valid` para controlar si el valor introducido cumple con la condición de validación.
- Inicia un bucle `while` que se ejecuta mientras el valor introducido no cumpla con la condición de validación.
- Dentro del bucle, se intenta obtener el valor introducido por el usuario mediante `JOptionPane.showInputDialog`.
- Si el valor introducido es nulo, vacío o no cumple con la condición de validación, se lanza una excepción.
- El método devuelve el valor introducido por el usuario si cumple con la condición de validación.
- En caso de que el valor introducido no cumpla con la condición de validación, el bucle se repite hasta que se
  introduzca un valor válido.

Con este método, podemos solicitar al usuario que introduzca un valor que cumpla con ciertas condiciones de la siguiente
manera:

```java
String input = Validator.validate(s -> s.matches("\\d+"), "Enter a number:", "Invalid input. Please enter a number.",
        "Input Dialog");
```

En este caso, el método `validate` solicitará al usuario que introduzca un número y devolverá el valor introducido si
cumple con la condición de ser un número. Si el usuario introduce un valor no válido, se mostrará un mensaje de error y
se solicitará un nuevo valor.

### Solicitar un valor y validar que cumpla con ciertas condiciones, y convertirlo a un tipo de dato específico

Para el cuarto caso, podemos combinar los métodos anteriores para solicitar un valor, validar que cumpla con ciertas
condiciones y convertirlo a un tipo de dato específico.

```java
    public static <T> T validate(Class<T> type, Predicate<T> condition, String inputMessage, String errorMessage,
                                 String windowTitle) {

        boolean valid = false;
        T result = null;
        while (!valid) {
            try {
                result = validate(type, inputMessage, errorMessage, windowTitle);
                if (!condition.test(result))
                    throw new IllegalArgumentException();
                valid = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errorMessage, windowTitle, JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }
```

Analicemos el método `validate`:

* Recibe como parámetros el tipo de dato genérico `T`, una condición de validación, un mensaje de entrada, un mensaje de
  error y un título de ventana.
* Declara una variable `valid` para controlar si el valor introducido cumple con la condición de validación.
* Declara una variable `result` para almacenar el valor convertido al tipo de dato deseado.
* Inicia un bucle `while` que se ejecuta mientras el valor introducido no cumpla con la condición de validación.
* Dentro del bucle, se intenta obtener el valor introducido por el usuario mediante el método `validate` anterior.
* Si el valor introducido no cumple con la condición de validación, se lanza una excepción.
* El método devuelve el valor convertido al tipo de dato deseado si cumple con la condición de validación.
* En caso de que el valor introducido no cumpla con la condición de validación, el bucle se repite hasta que se
  introduzca un valor válido.
* Con este método, podemos solicitar al usuario que introduzca un valor que cumpla con ciertas condiciones y convertirlo
  al tipo de dato deseado de la siguiente manera:

```java
int value = Validator.validate(Integer.class, v -> v >= 0 && v <= 100, "Enter a number between 0 and 100:",
        "Invalid input. Please enter a number between 0 and 100.", "Input Dialog");
```

En este caso, el método `validate` solicitará al usuario que introduzca un número entre 0 y 100 y lo convertirá al tipo
de dato `Integer`. Si el usuario introduce un valor no válido o que no cumple con las condiciones, se mostrará un
mensaje de error y se solicitará un nuevo valor.

## Conclusión

En resumen, hemos visto cómo crear un validador genérico en Java que permite validar y convertir valores de un tipo de
dato a otro de forma genérica. Al utilizar métodos estáticos y genéricos, podemos simplificar la validación y
conversión de valores en nuestras aplicaciones de escritorio en Java. Este enfoque nos permite reutilizar el código y
manejar de manera eficiente los diferentes tipos de datos que pueden ser introducidos por el usuario.

## Descarga la librería

Puedes descargar la librería que contiene la clase `Validator` y otros métodos útiles para trabajar con `JOptionPane` en
Java desde el siguiente enlace: [Descargar JAR](https://jesus-castro89.github.io/poo/static/libs.jar).

Para poder utilizar la librería en tus proyectos de IntelliJ IDEA, sigue estos pasos:

1. Abre tu proyecto en IntelliJ IDEA.
2. Crea una carpeta llamada `libs` en la raíz del proyecto.
3. Copia el archivo JAR descargado en la carpeta `libs`.
4. Haz clic con el botón derecho del ratón sobre el nombre del proyecto en el panel de la izquierda.
5. Selecciona la opción `Open Module Settings`.
6. Haz clic en la pestaña `Libraries`.
7. Haz clic en el botón `+` y selecciona `Java`.
8. Selecciona el archivo JAR descargado en la carpeta `libs`.
9. Haz clic en `OK` para cerrar la ventana de configuración.
10. Ahora puedes importar la clase `Validator` en tus clases Java y utilizarla para validar y convertir valores de forma
    genérica.
11. ¡Disfruta de la simplicidad y eficiencia de tu nuevo validador genérico en Java!