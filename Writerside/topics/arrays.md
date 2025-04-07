# La clase `Arrays` en Java

La clase `Arrays` en Java es una clase de utilidad que proporciona una serie de métodos estáticos para trabajar con
arreglos. Estos métodos incluyen operaciones como ordenar, buscar, comparar y llenar arreglos, entre otros. La clase
`Arrays` es parte del paquete `java.util` y se importa automáticamente en los programas de Java.

## Métodos comunes de la clase `Arrays`

La clase `Arrays` en Java proporciona una serie de métodos útiles para trabajar con arreglos. Algunos de los métodos más
comunes de la clase `Arrays` incluyen:

### Función de ordenamiento de arreglos `sort()`

El método `sort()` de la clase `Arrays` se utiliza para ordenar un arreglo en orden ascendente, descendente o según un
criterio específico.

Por sí misma la función se encuentra sobrecargada, es decir, existen varias versiones de la función `sort()` que
permiten ordenar arreglos de diferentes tipos de datos, como arreglos de enteros, arreglos de cadenas, arreglos de
objetos, entre otros.

Vemos estas versiones de la función `sort()` en el siguiente ejemplo:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {4, 2, 7, 1, 5, 3, 6};
        int[] numerosOrdenados = Arrays.copyOf(numeros, numeros.length);
        int[] numerosInvertidos = Arrays.copyOf(numeros, numeros.length);
        int[] numerosOrdenadosConRango = Arrays.copyOf(numeros, numeros.length);
        int[] numerosOrdenadosInvertidosConRango = Arrays.copyOf(numeros, numeros.length);
        Integer[] numerosObjeto = {4, 2, 7, 1, 5, 3, 6};
        // Ordenar el arreglo de enteros en orden ascendente
        Arrays.sort(numerosOrdenados)
        // Imprimir el arreglo ordenado
        System.out.println(Arrays.toString(numerosOrdenados));
        // Ordenar el arreglo de enteros en orden descendente
        Arrays.sort(numerosInvertidos, Collections.reverseOrder());
        // Imprimir el arreglo ordenado en orden descendente
        System.out.println(Arrays.toString(numerosInvertidos));
        // Ordenar el arreglo en un rango específico
        Arrays.sort(numerosOrdenadosConRango, 1, 4);
        // Imprimir el arreglo ordenado en un rango específico
        System.out.println(Arrays.toString(numerosOrdenadosConRango));
        // Ordenar el arreglo en un rango específico en orden descendente
        Arrays.sort(numerosOrdenadosInvertidosConRango, 1, 4, Collections.reverseOrder());
        // Imprimir el arreglo ordenado en un rango específico en orden descendente
        System.out.println(Arrays.toString(numerosOrdenadosInvertidosConRango));
        // Ordenar el arreglo con un criterio específico (primero par, luego impar)
        Arrays.sort(numerosObjeto, (a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        });
        // Imprimir el arreglo ordenado con el criterio específico
        System.out.println(Arrays.toString(numerosObjeto));
    }
}
```

En este ejemplo, se muestra cómo ordenar un arreglo de enteros en orden ascendente, descendente, en un rango específico
y con un criterio específico utilizando el método `sort()` de la clase `Arrays`.

En resumen, la función `sort()` de la clase `Arrays` es una herramienta útil para ordenar arreglos de diferentes tipos
de datos en Java. Siendo sus versiones en concreto las siguientes:

| Método `sort()`                                                            | Descripción                                                                                                                             |
|----------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| `sort(int[] a)`                                                            | Ordena el arreglo de enteros `a` en orden ascendente.                                                                                   |
| `sort(int[] a, int fromIndex, int toIndex)`                                | Ordena el arreglo de enteros `a` desde el índice `fromIndex` (inclusive) hasta el índice `toIndex` (exclusivo) en orden ascendente.     |
| `sort(int[] a, Comparator<? super Integer> c)`                             | Ordena el arreglo de enteros `a` según el comparador `c`.                                                                               |
| `sort(int[] a, int fromIndex, int toIndex, Comparator<? super Integer> c)` | Ordena el arreglo de enteros `a` desde el índice `fromIndex` (inclusive) hasta el índice `toIndex` (exclusivo) según el comparador `c`. |
| `sort(T[] a, Comparator<? super T> c)`                                     | Ordena el arreglo de objetos `a` según el comparador `c`.                                                                               |
| `sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)`         | Ordena el arreglo de objetos `a` desde el índice `fromIndex` (inclusive) hasta el índice `toIndex` (exclusivo) según el comparador `c`. |
| `sort(T[] a)`                                                              | Ordena el arreglo de objetos `a` en orden ascendente.                                                                                   |
| `sort(T[] a, int fromIndex, int toIndex)`                                  | Ordena el arreglo de objetos `a` desde el índice `fromIndex` (inclusive) hasta el índice `toIndex` (exclusivo) en orden ascendente.     |

### Función de búsqueda en arreglos `binarySearch()`

El método `binarySearch()` de la clase `Arrays` se utiliza para buscar un elemento en un arreglo ordenado. Este método
utiliza el algoritmo de búsqueda binaria para encontrar el elemento en el arreglo.

Por sí misma la función se encuentra sobrecargada, es decir, existen varias versiones de la función `binarySearch()`
que permiten buscar elementos en arreglos de diferentes tipos de datos, como arreglos de enteros, arreglos de cadenas,
arreglos de objetos, entre otros.

Vemos estas versiones de la función `binarySearch()` en el siguiente ejemplo:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Imprimir el índice del elemento 5 en el arreglo
        int indice = Arrays.binarySearch(numeros, 5);
        System.out.println("El índice del elemento 5 es: " + indice);
        // Imprimir el índice del elemento 5 en el rango del arreglo
        int indiceRango = Arrays.binarySearch(numeros, 1, 5, 5);
        System.out.println("El índice del elemento 5 en el rango del arreglo es: " + indiceRango);
        // Imprimir el índice del primer elemento par en el arreglo
        int indiceEstablecido = Arrays.binarySearch(numeros, 0, numeros.length, 0, (a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        });
        System.out.println("El índice del primer elemento par en el arreglo es: " + indiceEstablecido);
    }
}
```

En este ejemplo, se muestra cómo buscar un elemento en un arreglo de enteros utilizando el método `binarySearch()` de la
clase `Arrays`. Además, se muestra cómo buscar un elemento en un rango específico del arreglo y cómo buscar un elemento
con un criterio específico utilizando el método `binarySearch()`.

En resumen, la función `binarySearch()` de la clase `Arrays` es una herramienta útil para buscar elementos en arreglos
ordenados de diferentes tipos de datos en Java. Siendo sus versiones en concreto las siguientes:

| Método `binarySearch()`                                                           | Descripción                                                                                                                                                                                                                              |
|-----------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `binarySearch(T[] a, T key)`                                                      | Busca el elemento `key` en el arreglo de enteros `a` y devuelve su índice si se encuentra, o un valor negativo si no se encuentra.                                                                                                       |
| `binarySearch(T[] a, int fromIndex, int toIndex, T key)`                          | Busca el elemento `key` en el arreglo de enteros `a` desde el índice `fromIndex` (inclusive) hasta el índice `toIndex` (exclusivo) y devuelve su índice si se encuentra, o un valor negativo si no se encuentra.                         |
| `binarySearch(T[] a, int key, Comparator<? super T> c)`                           | Busca el elemento `key` en el arreglo de enteros `a` según el comparador `c` y devuelve su índice si se encuentra, o un valor negativo si no se encuentra.                                                                               |
| `binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)` | Busca el elemento `key` en el arreglo de enteros `a` desde el índice `fromIndex` (inclusive) hasta el índice `toIndex` (exclusivo) según el comparador `c` y devuelve su índice si se encuentra, o un valor negativo si no se encuentra. |

### Función de comparación de arreglos `equals()`

El método `equals()` de la clase `Arrays` se utiliza para comparar dos arreglos y determinar si son iguales o no. Este
método compara los elementos de los arreglos uno por uno y devuelve `true` si los arreglos son iguales y `false` si no
lo son.

Veamos un ejemplo de cómo utilizar el método `equals()` de la clase `Arrays`:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros1 = {1, 2, 3, 4, 5};
        int[] numeros2 = {1, 2, 3, 4, 5};
        int[] numeros3 = {5, 4, 3, 2, 1};
        // Comparar los arreglos numeros1 y numeros2
        boolean iguales1 = Arrays.equals(numeros1, numeros2);
        System.out.println("¿Los arreglos numeros1 y numeros2 son iguales? " + iguales1);
        // Comparar los arreglos numeros1 y numeros3
        boolean iguales2 = Arrays.equals(numeros1, numeros3);
        System.out.println("¿Los arreglos numeros1 y numeros3 son iguales? " + iguales2);
    }
}
```

En este ejemplo, se muestra cómo comparar dos arreglos de enteros utilizando el método `equals()` de la clase `Arrays`.

### Función de llenado de arreglos `fill()`

El método `fill()` de la clase `Arrays` se utiliza para llenar un arreglo con un valor específico. Este método asigna el
valor especificado a todos los elementos del arreglo.

Veamos un ejemplo de cómo utilizar el método `fill()` de la clase `Arrays`:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros = new int[5];
        // Llenar el arreglo con el valor 10
        Arrays.fill(numeros, 10);
        // Imprimir el arreglo lleno
        System.out.println(Arrays.toString(numeros));
    }
}
```

En este ejemplo, se muestra cómo llenar un arreglo de enteros con el valor `10` utilizando el método `fill()` de la
clase `Arrays`.

### Función de copia de arreglos `copyOf()` y `copyOfRange()`

El método `copyOf()` de la clase `Arrays` se utiliza para copiar un arreglo en otro arreglo de tamaño diferente. Este
método copia los elementos del arreglo original en el nuevo arreglo y rellena los elementos restantes con el valor
predeterminado del tipo de dato.

Por sí misma la función se encuentra sobrecargada, es decir, existen varias versiones de la función `copyOf()` que
permiten copiar arreglos de diferentes tipos de datos, y copiar solo una parte del arreglo original.

Veamos estas versiones de la función `copyOf()` en el siguiente ejemplo:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        // Copiar el arreglo de enteros
        int[] copiaNumeros = Arrays.copyOf(numeros, numeros.length);
        // Imprimir la copia del arreglo
        System.out.println(Arrays.toString(copiaNumeros));
        // Copiar solo una parte del arreglo de enteros
        int[] copiaNumerosRango = Arrays.copyOfRange(numeros, 1, 4);
        // Imprimir la copia del arreglo en un rango específico
        System.out.println(Arrays.toString(copiaNumerosRango));
    }
}
```

En este ejemplo, se muestra cómo copiar un arreglo de enteros y cómo copiar solo una parte del arreglo utilizando el
método `copyOf()` de la clase `Arrays`.

En resumen, la función `copyOf()` de la clase `Arrays` es una herramienta útil para copiar arreglos de diferentes tipos
de datos en Java. Siendo sus versiones en concreto las siguientes:

| Método `copyOf()`                             | Descripción                                                                                                                     |
|-----------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| `copyOf(T[] original, int newLength)`         | Copia el arreglo `original` en un nuevo arreglo de longitud `newLength`.                                                        |    
| `copyOfRange(T[] original, int from, int to)` | Copia una parte del arreglo `original` desde el índice `from` (inclusive) hasta el índice `to` (exclusivo) en un nuevo arreglo. |

### Función de conversión de arreglos a cadenas `toString()`

El método `toString()` de la clase `Arrays` se utiliza para convertir un arreglo en una cadena de texto. Este método
devuelve una representación en forma de cadena de los elementos del arreglo.

### Función de comparación de arreglos `deepEquals()`

El método `deepEquals()` de la clase `Arrays` se utiliza para comparar dos arreglos multidimensionales y determinar si
son iguales o no. Este método compara los elementos de los arreglos uno por uno y devuelve `true` si los arreglos son
iguales y `false` si no lo son.

Veamos un ejemplo de cómo utilizar el método `deepEquals()` de la clase `Arrays`:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2}, {3, 4}};
        int[][] matriz2 = {{1, 2}, {3, 4}};
        int[][] matriz3 = {{4, 3}, {2, 1}};
        // Comparar las matrices matriz1 y matriz2
        boolean iguales1 = Arrays.deepEquals(matriz1, matriz2);
        System.out.println("¿Las matrices matriz1 y matriz2 son iguales? " + iguales1);
        // Comparar las matrices matriz1 y matriz3
        boolean iguales2 = Arrays.deepEquals(matriz1, matriz3);
        System.out.println("¿Las matrices matriz1 y matriz3 son iguales? " + iguales2);
    }
}
```

En este ejemplo, se muestra cómo comparar dos arreglos multidimensionales utilizando el método `deepEquals()` de la
clase `Arrays`.

## Conclusión

La clase `Arrays` en Java proporciona una serie de métodos útiles para trabajar con arreglos de diferentes tipos de
datos. Estos métodos incluyen operaciones como ordenar, buscar, comparar, llenar, copiar y convertir arreglos, entre
otros. Al conocer y utilizar los métodos de la clase `Arrays`, los programadores pueden realizar operaciones comunes
sobre arreglos de manera eficiente y efectiva en Java.