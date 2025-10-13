# La interface Predicate en Java

La interface `Predicate` en Java es una interfaz funcional que representa una función que toma un solo argumento y
devuelve un valor booleano. Es parte del paquete `java.util.function` y se utiliza comúnmente en operaciones de filtrado
y evaluación de condiciones.

## Definición de la interfaz Predicate

```java

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

## Descripción de la interfaz

- `T`: El tipo del argumento de entrada.
- `test(T t)`: Método abstracto que evalúa el predicado en el argumento dado y devuelve `true` o `false`.

## Uso de Predicate

La interfaz `Predicate` se utiliza principalmente en operaciones de filtrado, como en flujos (streams) y colecciones.
Aquí hay un ejemplo de cómo usar `Predicate`:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Definir un Predicate para filtrar números pares
        Predicate<Integer> isEven = number -> number % 2 == 0;

        // Usar el Predicate para filtrar la lista
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println("Números pares: " + evenNumbers);
    }
}
```

## Métodos predeterminados en Predicate

La interfaz `Predicate` también proporciona varios métodos predeterminados que permiten combinar y manipular predicados:

* `and(Predicate<? super T> other)`: Devuelve un predicado que representa la conjunción lógica (AND) de este predicado y
  otro.
* `or(Predicate<? super T> other)`: Devuelve un predicado que representa la disyunción lógica (OR) de este predicado y
  otro.
* `negate()`: Devuelve un predicado que representa la negación lógica de este predicado.
* `isEqual(Object targetRef)`: Devuelve un predicado que prueba si dos argumentos son iguales según `Objects.equals`.
* `not(Predicate<? super T> target)`: Devuelve un predicado que representa la negación lógica del predicado dado.

## Ejemplo de uso de métodos predeterminados

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDefaultMethodsExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> isGreaterThanThree = number -> number > 3;

        // Usar and para combinar predicados
        List<Integer> evenAndGreaterThanThree = numbers.stream()
                .filter(isEven.and(isGreaterThanThree))
                .collect(Collectors.toList());

        System.out.println("Números pares y mayores que tres: " + evenAndGreaterThanThree);

        // Usar or para combinar predicados
        List<Integer> evenOrGreaterThanThree = numbers.stream()
                .filter(isEven.or(isGreaterThanThree))
                .collect(Collectors.toList());

        System.out.println("Números pares o mayores que tres: " + evenOrGreaterThanThree);

        // Usar negate para invertir un predicado
        List<Integer> notEven = numbers.stream()
                .filter(isEven.negate())
                .collect(Collectors.toList());

        System.out.println("Números impares: " + notEven);
    }
}
```

## Conclusión

La interfaz `Predicate` es una herramienta poderosa en Java para trabajar con funciones que devuelven valores booleanos.
Su uso en combinación con flujos y colecciones facilita la implementación de lógica de filtrado y evaluación de
condiciones de manera concisa y legible. Los métodos predeterminados proporcionan una forma flexible de combinar y
manipular predicados según sea necesario.