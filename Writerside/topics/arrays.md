# La clase `Arrays`

## Descripción

En Java, la clase `Arrays` es una clase de utilidad que proporciona métodos estáticos para trabajar con arreglos. Esta
clase no puede ser instanciada, ya que todos sus métodos son estáticos. Algunos de los métodos más comunes que
proporciona
son:

### Ordenamiento `sort()`

El método `sort()` se utiliza para ordenar un arreglo de elementos. Este método ordena los elementos en orden ascendente
utilizando el orden natural de los elementos o un comparador personalizado.

```java
int[] numeros = {5, 3, 8, 2, 1, 4};
Arrays.

sort(numeros);
System.out.

println(Arrays.toString(numeros)); // [1, 2, 3, 4, 5, 8]
```

Existen otras variantes del método `sort()` que permiten ordenar un rango específico de elementos o un arreglo de
objetos que son los siguientes:

| Firma del método                                                            | Descripción                                                                                                                   |
|-----------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| `void sort(int[] a)`                                                        | Ordena el arreglo especificado de enteros en orden ascendente.                                                                |
| `void sort(int[] a, int fromIndex, int toIndex)`                            | Ordena el rango especificado de elementos en el arreglo de enteros en orden ascendente.                                       |
| `void sort(Object[] a)`                                                     | Ordena el arreglo especificado de objetos en orden ascendente.                                                                |
| `void sort(Object[] a, int fromIndex, int toIndex)`                         | Ordena el rango especificado de elementos en el arreglo de objetos en orden ascendente.                                       |
| `<T> void sort(T[] a, Comparator<? super T> c)`                             | Ordena el arreglo especificado de objetos en orden ascendente utilizando el comparador especificado.                          |
| `<T> void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)` | Ordena el rango especificado de elementos en el arreglo de objetos en orden ascendente utilizando el comparador especificado. |

#### Ejemplo de uso de `sort()`

```java
import java.util.Collections;

String[] nombres1 = {"Juan", "Pedro", "María", "Ana", "Carlos"};
Arrays.

sort(nombres);
System.out.

println(Arrays.toString(nombres)); // [Ana, Carlos, Juan, María, Pedro]

String[] nombres2 = {"Juan", "Pedro", "María", "Ana", "Carlos"};
Arrays.

sort(nombres, 1,4);
System.out.

println(Arrays.toString(nombres)); // [Juan, Ana, María, Pedro, Carlos]

String[] nombres3 = {"Juan", "Pedro", "María", "Ana", "Carlos"};
Arrays.

sort(nombres, Collections.reverseOrder());
        System.out.

println(Arrays.toString(nombres)); // [Pedro, María, Juan, Carlos, Ana]

String[] nombres4 = {"Juan", "Pedro", "María", "Ana", "Carlos"};
Arrays.

sort(nombres, 1,4,Collections.reverseOrder());
        System.out.

println(Arrays.toString(nombres)); // [Juan, Pedro, María, Ana, Carlos]
```

### Búsqueda binaria `binarySearch()`

El método `binarySearch()` se utiliza para buscar un elemento en un arreglo ordenado. Este método devuelve el índice del
elemento buscado si se encuentra en el arreglo, de lo contrario, devuelve un valor negativo.

```java
int[] numeros = {1, 2, 3, 4, 5, 8};
int indice = Arrays.binarySearch(numeros, 3);
System.out.

println(indice); // 2
```

Existen otras variantes del método `binarySearch()` que permiten buscar un rango específico de elementos o un arreglo de
objetos que son los siguientes:

| Firma del método                                                                          | Descripción                                                                                                                                                                                              |
|-------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `int binarySearch(int[] a, int key)`                                                      | Busca la clave especificada en el arreglo de enteros. Devuelve el índice de la clave si se encuentra, de lo contrario, un valor negativo.                                                                |
| `int binarySearch(int[] a, int fromIndex, int toIndex, int key)`                          | Busca la clave especificada en el rango de elementos en el arreglo de enteros. Devuelve el índice de la clave si se encuentra, de lo contrario, un valor negativo.                                       |
| `int binarySearch(Object[] a, Object key)`                                                | Busca la clave especificada en el arreglo de objetos. Devuelve el índice de la clave si se encuentra, de lo contrario, un valor negativo.                                                                |
| `int binarySearch(Object[] a, int fromIndex, int toIndex, Object key)`                    | Busca la clave especificada en el rango de elementos en el arreglo de objetos. Devuelve el índice de la clave si se encuentra, de lo contrario, un valor negativo.                                       |
| `<T> int binarySearch(T[] a, T key, Comparator<? super T> c)`                             | Busca la clave especificada en el arreglo de objetos utilizando el comparador especificado. Devuelve el índice de la clave si se encuentra, de lo contrario, un valor negativo.                          |
| `<T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)` | Busca la clave especificada en el rango de elementos en el arreglo de objetos utilizando el comparador especificado. Devuelve el índice de la clave si se encuentra, de lo contrario, un valor negativo. |

### Comparación de arreglos `equals()`

El método `equals()` se utiliza para comparar dos arreglos de elementos. Este método devuelve `true` si los arreglos son
iguales, es decir, si tienen la misma longitud y los mismos elementos en el mismo orden, de lo contrario, devuelve
`false`.

```java
int[] numeros1 = {1, 2, 3, 4, 5};
int[] numeros2 = {1, 2, 3, 4, 5};
System.out.println(Arrays.equals(numeros1, numeros2)); // true
```

### Conversión a cadena `toString()`

El método `toString()` se utiliza para convertir un arreglo de elementos en una cadena de texto. Este método devuelve una
cadena que representa los elementos del arreglo.

```java
int[] numeros = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(numeros)); // [1, 2, 3, 4, 5]
```

### Rellenado de arreglos `fill()`

El método `fill()` se utiliza para rellenar un arreglo de elementos con un valor específico. Este método asigna el valor
especificado a todos los elementos del arreglo.

```java
int[] numeros = new int[5];
Arrays.fill(numeros, 0);
System.out.println(Arrays.toString(numeros)); // [0, 0, 0, 0, 0]
```

### Copia de arreglos `copyOf()`

El método `copyOf()` se utiliza para copiar un arreglo de elementos en un nuevo arreglo con una longitud específica. Este
método devuelve un nuevo arreglo que contiene los elementos copiados del arreglo original.

```java
int[] numeros1 = {1, 2, 3, 4, 5};
int[] numeros2 = Arrays.copyOf(numeros1, 3);
System.out.println(Arrays.toString(numeros2)); // [1, 2, 3]
```

### Comparación de arreglos `deepEquals()`

El método `deepEquals()` se utiliza para comparar dos arreglos multidimensionales de elementos. Este método devuelve `true`
si los arreglos son iguales, es decir, si tienen la misma longitud y los mismos elementos en el mismo orden, de lo
contrario, devuelve `false`.