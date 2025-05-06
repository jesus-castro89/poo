# La clase `IntStream` de Java

## Introducción

La clase `IntStream` de Java es parte del paquete `java.util.stream` y se utiliza para trabajar con secuencias de
números enteros de manera funcional. Proporciona una forma eficiente y declarativa de realizar operaciones en
colecciones de enteros, como filtrado, mapeo y reducción. `IntStream` es una subclase de `Stream` que se especializa en
manejar números enteros, lo que permite evitar el autoboxing y mejorar el rendimiento al trabajar con grandes
colecciones de enteros.

## Creación de IntStreams

Los `IntStreams` se pueden crear a partir de diferentes fuentes, como arreglos, rangos o generadores. Aquí hay algunos
ejemplos de cómo crear `IntStreams`:

```java
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntStreamExample {
    public static void main(String[] args) {
        // Crear un IntStream a partir de un arreglo
        int[] array = {1, 2, 3, 4, 5};
        IntStream intStreamFromArray = Arrays.stream(array);

        // Crear un IntStream a partir de un rango de enteros
        IntStream intStreamFromRange = IntStream.range(1, 10); // Rango cerrado [1, 10)

        // Crear un IntStream a partir de una función generadora
        IntStream randomIntStream = IntStream.generate(() -> (int) (Math.random() * 100)).limit(5);
    }
}
```

## Operaciones intermedias y terminales

Los `IntStreams` permiten realizar operaciones intermedias y terminales. Las operaciones intermedias son perezosas y no
se ejecutan hasta que se invoca una operación terminal. Las operaciones terminales producen un resultado y finalizan el
stream. Aquí hay algunos ejemplos de operaciones intermedias y terminales:

```java
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args) {
        // Crear un IntStream a partir de un rango de enteros
        IntStream intStream = IntStream.range(1, 10);

        // Operaciones intermedias
        IntStream filteredStream = intStream.filter(n -> n % 2 == 0); // Filtrar números pares
        IntStream mappedStream = filteredStream.map(n -> n * 2); // Multiplicar por 2

        // Operaciones terminales
        int sum = mappedStream.sum(); // Sumar los elementos
        if (filteredStream.count() > 0) {
            filteredStream.forEach(System.out::println); // Imprimir los números pares
        } else {
            System.out.println("No hay números pares en el rango.");
        }
        System.out.println("Suma: " + sum);
    }
}
```

## Métodos comunes de IntStream

A continuación se presentan algunos métodos comunes de `IntStream`:

| Método           | Descripción                                                                      |
|------------------|----------------------------------------------------------------------------------|
| `filter`         | Filtra los elementos del stream según un predicado.                              |
| `map`            | Aplica una función a cada elemento del stream y devuelve un nuevo stream.        |   
| `flatMap`        | Aplica una función que devuelve un stream a cada elemento y aplana el resultado. |
| `distinct`       | Elimina elementos duplicados del stream.                                         |
| `sorted`         | Ordena los elementos del stream.                                                 |
| `limit`          | Limita el número de elementos en el stream.                                      |
| `skip`           | Omite un número específico de elementos en el stream.                            |
| `reduce`         | Realiza una operación de reducción en los elementos del stream.                  |
| `sum`            | Devuelve la suma de los elementos del stream.                                    |
| `average`        | Devuelve el promedio de los elementos del stream.                                |
| `max`            | Devuelve el valor máximo del stream.                                             |
| `min`            | Devuelve el valor mínimo del stream.                                             |
| `count`          | Devuelve el número de elementos en el stream.                                    |
| `forEach`        | Realiza una acción para cada elemento del stream.                                |
| `toArray`        | Convierte el stream en un arreglo.                                               |
| `collect`        | Recopila los elementos del stream en una colección.                              |
| `boxed`          | Convierte un `IntStream` en un `Stream<Integer>`.                                |
| `asDoubleStream` | Convierte un `IntStream` en un `DoubleStream`.                                   |
| `asLongStream`   | Convierte un `IntStream` en un `LongStream`.                                     |
| `toList`         | Convierte el stream en una lista.                                                |
| `toSet`          | Convierte el stream en un conjunto.                                              |
| `toMap`          | Convierte el stream en un mapa.                                                  |
| `toString`       | Devuelve una representación en cadena del stream.                                |
| `peek`           | Realiza una acción para cada elemento del stream sin modificarlo.                |
| `anyMatch`       | Verifica si algún elemento del stream cumple con un predicado.                   |
| `allMatch`       | Verifica si todos los elementos del stream cumplen con un predicado.             |
| `noneMatch`      | Verifica si ningún elemento del stream cumple con un predicado.                  |
| `findFirst`      | Devuelve el primer elemento del stream.                                          |
| `findAny`        | Devuelve cualquier elemento del stream.                                          |
| `iterator`       | Devuelve un iterador para el stream.                                             |
| `close`          | Cierra el stream y libera los recursos asociados.                                |

## Ejemplo de uso de métodos comunes

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamCommonMethods {
    public static void main(String[] args) {
        // Crear un IntStream a partir de un arreglo
        int[] array = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(array);

        // Filtrar números pares y multiplicar por 2
        List<Integer> result = intStream
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(result); // Imprime: [4, 8]
    }
}
```

En este ejemplo, se crea un `IntStream` a partir de un arreglo de enteros. Luego, se filtran los números pares y se
multiplican por 2. Finalmente, se convierten los elementos del stream en un `List<Integer>` utilizando el método
`collect` y se imprime el resultado.

## Conclusión

La clase `IntStream` de Java proporciona una forma eficiente y funcional de trabajar con secuencias de números enteros.
Permite realizar operaciones como filtrado, mapeo y reducción de manera declarativa. Con su capacidad para crear
streams a partir de diferentes fuentes y su amplia gama de métodos, `IntStream` es una herramienta poderosa para
procesar colecciones de enteros en Java. Al utilizar `IntStream`, se puede mejorar el rendimiento y la legibilidad del
código al evitar el autoboxing y trabajar directamente con tipos primitivos.