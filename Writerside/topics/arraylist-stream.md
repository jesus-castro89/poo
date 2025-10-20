# ArrayList como Stream en Java

Dentro de Java, un `ArrayList` es una estructura de datos dinámica que puede crecer y reducirse según sea necesario. A
partir de Java 8, se introdujo la API de Streams, que permite procesar colecciones de manera funcional y declarativa. A
continuación, se muestra cómo utilizar un `ArrayList` como un Stream.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListStreamExample {
    public static void main(String[] args) {
        // Crear un ArrayList y agregar elementos
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eve");

        // Usar Stream para filtrar y transformar los datos
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A") || name.startsWith("C")) // Filtrar nombres que empiezan con A o C
                .map(String::toUpperCase) // Convertir a mayúsculas
                .collect(Collectors.toList()); // Recoger los resultados en una nueva lista

        // Imprimir los nombres filtrados y transformados
        filteredNames.forEach(System.out::println);
    }
}
```

### Notas Importantes

* `stream()` convierte el `ArrayList` en un Stream.
* `filter()` aplica una condición para filtrar elementos.
* `map()` transforma cada elemento del Stream.
* `collect(Collectors.toList())` recoge los resultados en una nueva lista.

> Si no necesitas una nueva lista, puedes encadenar más operaciones o usar `forEach()` directamente en el Stream.
> Por ejemplo:
> ```java
> names.stream()
>       .filter(name -> name.startsWith("A") || 
>       name.startsWith("C"))
>       .map(String::toUpperCase)
>       .forEach(System.out::println);
> ```
> Esto imprimirá los resultados directamente sin crear una lista intermedia.
> {style="note"}

### Salida Esperada

```
ALICE
CHARLIE
```

## Otras funciones de Stream

Además de `filter()` y `map()`, los Streams en Java ofrecen muchas otras operaciones útiles, como:

| Operación     | Descripción                                                     |
|---------------|-----------------------------------------------------------------|
| `forEach()`   | Itera sobre cada elemento del Stream.                           |
| `sorted()`    | Ordena los elementos del Stream.                                |
| `distinct()`  | Elimina elementos duplicados.                                   |
| `reduce()`    | Combina los elementos del Stream en un solo valor.              | 
| `limit()`     | Limita el número de elementos en el Stream.                     |
| `skip()`      | Omite un número específico de elementos.                        |
| `count()`     | Cuenta el número de elementos en el Stream.                     |
| `anyMatch()`  | Verifica si algún elemento cumple una condición.                |
| `allMatch()`  | Verifica si todos los elementos cumplen una condición.          |
| `noneMatch()` | Verifica si ningún elemento cumple una condición.               |
| `peek()`      | Permite realizar una acción intermedia sin modificar el Stream. |
| `toList()`    | Convierte el Stream de nuevo a una lista.                       |

Estas operaciones permiten un procesamiento de datos más eficiente y legible en comparación con los bucles
tradicionales.

## Conclusión

El uso de `ArrayList` como Stream en Java facilita el procesamiento de colecciones de datos de manera funcional y
declarativa. La API de Streams proporciona una variedad de operaciones que permiten filtrar, transformar y manipular
datos de forma eficiente.