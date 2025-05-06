# La clase `Stream` de Java

## Introducción

La clase `Stream` de Java es parte del paquete `java.util.stream` y se utiliza para procesar secuencias de elementos de
manera funcional. Proporciona una forma eficiente y declarativa de realizar operaciones en colecciones, como filtrado,
mapeo y reducción.

## Creación de Streams

Los streams se pueden crear a partir de diferentes fuentes, como colecciones, arreglos o generadores. Aquí hay algunos
ejemplos de cómo crear streams:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Crear un stream a partir de una lista
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Stream<String> streamFromList = list.stream();

        // Crear un stream a partir de un arreglo
        String[] array = {"e", "f", "g", "h"};
        Stream<String> streamFromArray = Arrays.stream(array);

        // Crear un stream a partir de un rango de enteros
        IntStream intStream = IntStream.range(1, 10);

        // Crear un stream a partir de una función generadora
        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
    }
}
```

## Operaciones intermedias y terminales

Los streams permiten realizar operaciones intermedias y terminales. Las operaciones intermedias son perezosas y no se
ejecutan hasta que se invoca una operación terminal. Las operaciones terminales producen un resultado y finalizan el
stream. Aquí hay algunos ejemplos de operaciones intermedias y terminales:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class StreamOperations {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        // Operaciones intermedias
        Stream<String> filteredStream = list.stream()
                .filter(s -> s.startsWith("a")) // Filtrar elementos que comienzan con "a"
                .map(String::toUpperCase); // Convertir a mayúsculas

        // Operación terminal
        List<String> result = filteredStream.collect(Collectors.toList());
        System.out.println(result); // Imprime: [A]
    }
}
```

En este ejemplo, la operación `filter` es intermedia y `collect` es terminal. La operación `map` también es intermedia y
transforma cada elemento del stream. La operación `collect` recopila los elementos del stream en una lista.

## Operaciones de reducción

Las operaciones de reducción permiten combinar los elementos de un stream en un solo resultado. Algunas operaciones de
reducción comunes son `reduce`, `count`, `sum`, `average` y `max/min`. Aquí hay un ejemplo de cómo usar la operación
`reduce` para sumar los elementos de un stream:

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;

public class StreamReduction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Usar reduce para sumar los elementos
        Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);

        sum.ifPresent(System.out::println); // Imprime: 15
    }
}
```

En este ejemplo, la operación `reduce` toma dos elementos y los suma. El resultado es un `Optional` que contiene la suma
de los elementos del stream. Si el stream está vacío, el resultado será un `Optional.empty()`. En este caso, se utiliza
`ifPresent` para imprimir el resultado solo si está presente.

## Conclusión

La clase `Stream` de Java proporciona una forma poderosa y flexible de procesar colecciones de datos. Permite realizar
operaciones de manera declarativa y eficiente, utilizando un enfoque funcional. Con su capacidad para crear streams a
partir de diferentes fuentes y realizar operaciones intermedias y terminales, es una herramienta valiosa para
desarrolladores de Java. Al comprender cómo funcionan los streams y cómo utilizarlos, puedes escribir código más limpio,
mantenible y eficiente.