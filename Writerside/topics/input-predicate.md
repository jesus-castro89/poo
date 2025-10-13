# Agregando `Predicate` a `InputHandler`

Para mejorar la flexibilidad y reutilización de nuestro código, podemos agregar un método que acepte un `Predicate<T>`
para validar entradas genéricas. Esto nos permitirá definir reglas de validación personalizadas sin necesidad de crear
múltiples métodos específicos.

Así mismo para ampliar la funcionalidad de la clase `InputHandler`, podemos modificar la función `getInput` para que
pueda validar el tipo de dato `LocalDate` y `LocalDateTime`.

Para ello, modificamos la función existente y añadimos el siguiente método a la clase `InputHandler`:

```java
import java.util.function.Predicate;
import javax.swing.JOptionPane;

public class InputHandler {

    // Otros métodos existentes...

    public static <T> T getInput(String prompt, T type) {

        String input = getInput(prompt);
        T output;
        try {
            if (input == null || input.isEmpty())
                throw new InvalidInputException("La entrada no puede estar vacía.");
            output = switch (type.getClass().getSimpleName()) {
                case "Integer" -> (T) Integer.valueOf(input);
                case "Double" -> (T) Double.valueOf(input);
                case "Float" -> (T) Float.valueOf(input);
                case "Long" -> (T) Long.valueOf(input);
                case "Short" -> (T) Short.valueOf(input);
                case "Byte" -> (T) Byte.valueOf(input);
                case "Boolean" -> (T) Boolean.valueOf(input);
                case "String" -> (T) input;
                // Nuevos casos para LocalDateTime y LocalDate
                case "LocalDate" -> (T) LocalDate.parse(input);
                case "LocalDateTime" -> (T) LocalDateTime.parse(input);
                default -> null;
            };
        } catch (InvalidInputException e) {
            showMessage("Error: Entrada Invalida", "Entrada de Datos", JOptionPane.ERROR_MESSAGE);
            return getInput(prompt, type);
        }
        return output;
    }

    public static <T> T getInput(String prompt, Predicate<T> predicate, String errorMessage, T type) {

        T input = getInput(prompt, type);
        if (!predicate.test(input)) {
            showMessage("Error: " + errorMessage, "Entrada de Datos", JOptionPane.ERROR_MESSAGE);
            return getInput(prompt, predicate, errorMessage, type);
        }
        return input;
    }
}
```

### Explicación del método

- **Parámetros**:
    - `String prompt`: El mensaje que se muestra al usuario para solicitar la entrada.
    - `Predicate<T> predicate`: Una función que define la regla de validación para la entrada.
    - `String errorMessage`: El mensaje de error que se muestra si la validación falla.
    - `T type`: Un valor de tipo T que ayuda a determinar el tipo de entrada esperada (por ejemplo, Integer, Double,
      String, etc.).

- **Funcionamiento**:
    1. Llama al método `getInput(prompt, type)` para obtener la entrada del usuario.
    2. Usa el `predicate` para validar la entrada.
    3. Si la validación falla, muestra un mensaje de error y vuelve a solicitar la entrada.
    4. Si la validación es exitosa, devuelve la entrada.

### Ejemplo de uso

```java
import java.util.function.Predicate;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Ejemplo 1: Validar que un número entero sea positivo
        Predicate<Integer> isPositive = num -> num > 0;
        Integer positiveNumber = InputHandler.getInput(
                "Ingrese un número entero positivo:",
                isPositive,
                "El número debe ser positivo.",
                0
        );
        System.out.println("Número positivo ingresado: " + positiveNumber);

        // Ejemplo 2: Validar que una cadena no esté vacía
        Predicate<String> isNotEmpty = str -> str != null && !str.trim().isEmpty();
        String nonEmptyString = InputHandler.getInput(
                "Ingrese una cadena no vacía:",
                isNotEmpty,
                "La cadena no puede estar vacía.",
                ""
        );
        System.out.println("Cadena ingresada: " + nonEmptyString);

        // Ejemplo 3: Validar que una fecha esté en el pasado
        Predicate<LocalDate> isPastDate = date -> date.isBefore(LocalDate.now());
        LocalDate pastDate = InputHandler.getInput(
                "Ingrese una fecha en formato YYYY-MM-DD (debe ser en el pasado):",
                isPastDate,
                "La fecha debe estar en el pasado.",
                LocalDate.now()
        );
        System.out.println("Fecha ingresada: " + pastDate);
    }
}
```

### Beneficios

- **Flexibilidad**: Puedes definir cualquier regla de validación sin necesidad de crear nuevos métodos.
- **Reutilización**: El mismo método puede manejar diferentes tipos de datos y validaciones.
- **Claridad**: El uso de `Predicate` hace que las reglas de validación sean explícitas y fáciles de entender.
- **Mantenimiento**: Si necesitas cambiar una regla de validación, solo tienes que modificar el `Predicate`
  correspondiente sin tocar la lógica de entrada.