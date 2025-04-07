# ¿Qué son los arreglos dinámicos en Java?

Los arreglos dinámicos en Java son una estructura de datos que permite almacenar un conjunto de elementos de un mismo
tipo de datos, pero a diferencia de los arreglos estáticos, los arreglos dinámicos pueden cambiar su tamaño en tiempo de
ejecución.

En Java, los arreglos dinámicos son implementados mediante la clase `ArrayList` que se encuentra en el paquete
`java.util`. Esta clase proporciona métodos para agregar, eliminar, buscar y acceder a los elementos del arreglo
dinámico.

## Declaración de un arreglo dinámico en Java

Para declarar un arreglo dinámico en Java, se utiliza la siguiente sintaxis:

```java
ArrayList<Tipo> nombre = new ArrayList<Tipo>();
```

Donde `Tipo` es el tipo de datos de los elementos que se almacenarán en el arreglo dinámico, y `nombre` es el nombre de
la variable que se utilizará para acceder al arreglo dinámico.

> **Nota:** En Java, los arreglos dinámicos solo pueden almacenar objetos, no tipos primitivos. Si se desea almacenar
> tipos primitivos, se debe utilizar la clase envoltorio correspondiente (por ejemplo, `Integer` en lugar de `int`).
> Además, se puede utilizar la notación de diamante (`<>`) para omitir la repetición del tipo de datos en la declaración
> del arreglo dinámico.
> {style="note"}

## Ejemplo de uso de un arreglo dinámico en Java

A continuación se muestra un ejemplo de cómo declarar y utilizar un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Acceder a un elemento del arreglo dinámico
        int primerNumero = numeros.get(0);
        System.out.println("Primer número: " + primerNumero);

        // Eliminar un elemento del arreglo dinámico
        numeros.remove(1);

        // Imprimir los elementos del arreglo dinámico
        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, se accede a un elemento con el método `get()`, se elimina un elemento con el
método `remove()`, y se recorren los elementos del arreglo dinámico con un bucle `for-each`.

Los arreglos dinámicos en Java son una estructura de datos muy útil para almacenar y manipular colecciones de elementos
de manera dinámica durante la ejecución de un programa.

## ¿Cuándo utilizar arreglos dinámicos en Java?

Los arreglos dinámicos en Java son ideales cuando se necesita almacenar un conjunto de elementos que puede cambiar de
tamaño durante la ejecución de un programa. Algunas situaciones comunes en las que se utilizan arreglos dinámicos son:

* Cuando se necesita almacenar una colección de elementos de un mismo tipo de datos.
* Cuando se necesita agregar, eliminar o buscar elementos de manera eficiente.
* Cuando se necesita recorrer los elementos de la colección en un orden específico.
* Cuando se necesita realizar operaciones de filtrado, mapeo o reducción sobre los elementos de la colección.
* Cuando se necesita almacenar elementos en una estructura de datos que permita duplicados y/o elementos nulos.
* Cuando se necesita almacenar elementos en una estructura de datos que permita un acceso rápido a los elementos por su
  posición.

## ¿Cuáles son las ventajas y desventajas de los arreglos dinámicos en Java?

Los arreglos dinámicos en Java tienen varias ventajas y desventajas en comparación con otros tipos de estructuras de
datos. Algunas de las ventajas de los arreglos dinámicos son:

| Ventajas de los arreglos dinámicos en Java                                                        | Desventajas de los arreglos dinámicos en Java                                                                                                    |
|---------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| Permiten almacenar un conjunto de elementos de manera dinámica.                                   | Requieren más memoria que los arreglos estáticos.                                                                                                |
| Permiten agregar, eliminar y buscar elementos de manera eficiente.                                | Pueden tener un rendimiento inferior en operaciones de inserción y eliminación en comparación con otras estructuras de datos.                    |
| Permiten recorrer los elementos de la colección en un orden específico.                           | Pueden ser menos eficientes en operaciones de búsqueda y acceso aleatorio en comparación con otras estructuras de datos.                         |
| Permiten realizar operaciones de filtrado, mapeo o reducción sobre los elementos de la colección. | Pueden ser menos eficientes en operaciones de ordenamiento en comparación con otras estructuras de datos.                                        |
| Permiten almacenar elementos duplicados y/o nulos.                                                | Pueden ser menos eficientes en operaciones de búsqueda y eliminación de elementos duplicados en comparación con otras estructuras de datos.      |
| Permiten un acceso rápido a los elementos por su posición.                                        | Pueden ser menos eficientes en operaciones de inserción y eliminación en el medio de la colección en comparación con otras estructuras de datos. |

En resumen, los arreglos dinámicos en Java son una estructura de datos versátil y flexible que permite almacenar y
manipular colecciones de elementos de manera dinámica. Sin embargo, es importante tener en cuenta las ventajas y
desventajas de los arreglos dinámicos al elegir la estructura de datos más adecuada para un problema específico.

## ¿Cómo agregar elementos a un arreglo dinámico en Java?

Para agregar elementos a un arreglo dinámico en Java, se utiliza el método `add()` de la clase `ArrayList`. Este método
permite agregar un elemento al final del arreglo dinámico. A continuación se muestra un ejemplo de cómo agregar
elementos
a un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de cadenas
        ArrayList<String> nombres = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Charlie");

        // Imprimir los elementos del arreglo dinámico
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de cadenas utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se recorren los elementos del arreglo dinámico con un bucle `for-each`.

Esta función se encuentra sobrecargada, por lo que también se puede agregar un elemento en una posición específica
utilizando u otros casos como se muestra a continuación:

| Método `add()` en la clase `ArrayList`               | Descripción                                                                                               |
|------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| `add(E elemento)`                                    | Agrega el elemento especificado al final del arreglo dinámico.                                            |
| `add(int índice, E elemento)`                        | Agrega el elemento especificado en la posición especificada del arreglo dinámico.                         |
| `add(Collection<? extends E> elementos)`             | Agrega todos los elementos de la colección especificada al final del arreglo dinámico.                    |
| `add(int índice, Collection<? extends E> elementos)` | Agrega todos los elementos de la colección especificada en la posición especificada del arreglo dinámico. |

En el caso de los modos en los que se requiere el índice de inserción, si el índice es mayor al tamaño del arreglo se
lanzará una excepción de tipo `IndexOutOfBoundsException`.

### Agregar elementos al inicio o final de un arreglo dinámico en Java

Para agregar elementos al inicio o final de un arreglo dinámico en Java, se pueden utilizar los métodos
`addFirst(Object o)` y `addLast(Object o)`. A continuación se muestra un ejemplo de cómo agregar elementos al inicio o
final de un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al inicio del arreglo dinámico
        numeros.addFirst(5);
        numeros.addFirst(3);

        // Agregar elementos al final del arreglo dinámico
        numeros.addLast(7);
        numeros.addLast(9);

        // Imprimir los elementos del arreglo dinámico
        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }
}
```

> **Nota:** En cualquier caso de agregación de elementos, si el arreglo dinámico no tiene suficiente capacidad para
> almacenar los nuevos elementos, se redimensionará automáticamente para acomodar los nuevos elementos. Así mismo si el
> índice de inserción se encuentra ocupado, los elementos posteriores se desplazarán una posición hacia adelante.

## ¿Cómo eliminar elementos de un arreglo dinámico en Java?

Para eliminar elementos de un arreglo dinámico en Java, se utiliza el método `remove()` de la clase `ArrayList`. Este
método permite eliminar un elemento por su valor o por su posición en el arreglo dinámico. A continuación se muestra un
ejemplo de cómo eliminar elementos de un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Eliminar un elemento del arreglo dinámico por su valor
        numeros.remove(Integer.valueOf(20));

        // Eliminar un elemento del arreglo dinámico por su posición
        numeros.remove(0);

        // Imprimir los elementos del arreglo dinámico
        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, se eliminan elementos por su valor o por su posición con el método `remove()`,
y se recorren los elementos del arreglo dinámico con un bucle `for-each`.

Esta función se encuentra sobrecargada, por lo que también se puede eliminar un elemento en una posición específica
utilizando u otros casos como se muestra a continuación:

| Método `remove()` en la clase `ArrayList`  | Descripción                                                                             |
|--------------------------------------------|-----------------------------------------------------------------------------------------|
| `remove(int índice)`                       | Elimina el elemento en la posición especificada del arreglo dinámico.                   |
| `remove(Object objeto)`                    | Elimina la primera ocurrencia del objeto especificado en el arreglo dinámico.           |
| `removeAll(Collection<?> elementos)`       | Elimina todos los elementos de la colección especificada del arreglo dinámico.          |
| `removeIf(Predicate<? super E> condición)` | Elimina todos los elementos que cumplen la condición especificada del arreglo dinámico. |
| `clear()`                                  | Elimina todos los elementos del arreglo dinámico.                                       |

En el caso de los modos en los que se requiere el índice de eliminación, si el índice es mayor o igual al tamaño del
arreglo se lanzará una excepción de tipo `IndexOutOfBoundsException`. Por otro lado, en el caso de los modos en los que
se requiere un objeto, si el objeto no se encuentra en el arreglo no se realizará ninguna acción.

> **Nota:** En el caso de los métodos `removeAll()` y `removeIf()`, si no se encuentra ningún elemento que cumpla con
> la condición especificada, no se realizará ninguna acción. Por otro lado, al eliminar un índice en concreto, los
> elementos posteriores se desplazarán una posición hacia atrás.

## ¿Cómo buscar elementos en un arreglo dinámico en Java?

Para buscar elementos en un arreglo dinámico en Java, se utiliza el método `contains()` de la clase `ArrayList`. Este
método permite determinar si un elemento está presente en el arreglo dinámico. A continuación se muestra un ejemplo de
cómo buscar elementos en un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de cadenas
        ArrayList<String> nombres = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Charlie");

        // Buscar un elemento en el arreglo dinámico
        boolean contieneBob = nombres.contains("Bob");
        System.out.println("¿Contiene a Bob? " + contieneBob);
    }
}
```

En este ejemplo, se declara un arreglo dinámico de cadenas utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se busca un elemento en el arreglo dinámico con el método `contains()`.
El método `contains()` devuelve `true` si el elemento está presente en el arreglo dinámico, y `false` en caso contrario.

## ¿Cómo acceder a elementos de un arreglo dinámico en Java?

Para acceder a elementos de un arreglo dinámico en Java, se utiliza el método `get()` de la clase `ArrayList`. Este
método permite obtener el elemento en una posición específica del arreglo dinámico. A continuación se muestra un
ejemplo de cómo acceder a elementos de un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Acceder a un elemento del arreglo dinámico
        int segundoNumero = numeros.get(1);
        System.out.println("Segundo número: " + segundoNumero);
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se accede a un elemento en una posición específica del arreglo dinámico con
el método `get()`. El método `get()` devuelve el elemento en la posición especificada del arreglo dinámico.

### Acceder al primer y último elemento de un arreglo dinámico en Java

Para acceder al primer y último elemento de un arreglo dinámico en Java, se puede utilizar el método `getFirst()` y
`getLast()`. A continuación se muestra un ejemplo de cómo acceder al primer y último elemento de un arreglo dinámico en
Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Acceder al primer y último elemento del arreglo dinámico
        int primerNumero = numeros.getFirst();
        int ultimoNumero = numeros.getLast();

        System.out.println("Primer número: " + primerNumero);
        System.out.println("Último número: " + ultimoNumero);
    }
}
```

### ¿Qué sucede si se intenta acceder a una posición inválida en un arreglo dinámico en Java?

Si se intenta acceder a una posición inválida en un arreglo dinámico en Java, se lanzará una excepción de tipo
`IndexOutOfBoundsException`. Esta excepción indica que se ha intentado acceder a una posición fuera del rango válido del
arreglo dinámico.

Por ejemplo, si se intenta acceder a un elemento en una posición mayor o igual al tamaño del arreglo dinámico, se
lanzará una excepción de tipo `IndexOutOfBoundsException`. A continuación se muestra un ejemplo de cómo manejar esta
excepción en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        try {
            // Acceder a un elemento fuera del rango del arreglo dinámico
            int numeroInvalido = numeros.get(3);
            System.out.println("Número inválido: " + numeroInvalido);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de rango");
        }
    }
}
```

En este ejemplo, se intenta acceder a un elemento en la posición `3` del arreglo dinámico, que está fuera del rango
válido del arreglo. Al intentar acceder a esta posición inválida, se lanza una excepción de tipo
`IndexOutOfBoundsException` que es capturada y manejada en un bloque `try-catch`.

## ¿Cómo recorrer un arreglo dinámico en Java?

Para recorrer un arreglo dinámico en Java, se puede utilizar un bucle `for-each` o un bucle `for` convencional. A
continuación se muestra un ejemplo de cómo recorrer un arreglo dinámico en Java con un bucle `for-each`:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Recorrer los elementos del arreglo dinámico con un bucle for-each
        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se recorren los elementos del arreglo dinámico con un bucle `for-each`. El
bucle `for-each` itera sobre cada elemento del arreglo dinámico y ejecuta un bloque de código para cada elemento.

### Recorrer un arreglo dinámico en orden inverso en Java

Para recorrer un arreglo dinámico en orden inverso en Java, se puede utilizar un bucle `for` convencional con un índice
que decremente en lugar de incrementar. A continuación se muestra un ejemplo de cómo recorrer un arreglo dinámico en
orden inverso en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Recorrer los elementos del arreglo dinámico en orden inverso
        for (int i = numeros.size() - 1; i >= 0; i--) {
            int numero = numeros.get(i);
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se recorren los elementos del arreglo dinámico en orden inverso con un bucle
`for` convencional. El bucle `for` itera sobre los índices del arreglo dinámico en orden inverso y accede a cada
elemento mediante el método `get()`.

## ¿Cómo convertir un arreglo dinámico en un arreglo estático en Java?

Para convertir un arreglo dinámico en un arreglo estático en Java, se puede utilizar el método `toArray()` de la clase
`ArrayList`. Este método devuelve una copia de los elementos del arreglo dinámico en un arreglo estático del tipo
especificado. A continuación se muestra un ejemplo de cómo convertir un arreglo dinámico en un arreglo estático en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Convertir el arreglo dinámico en un arreglo estático
        Integer[] arregloEstatico = numeros.toArray(new Integer[0]);

        // Imprimir los elementos del arreglo estático
        for (int numero : arregloEstatico) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se convierte el arreglo dinámico en un arreglo estático con el método
`toArray()`. El método `toArray()` devuelve una copia de los elementos del arreglo dinámico en un arreglo estático del
tipo especificado.

> **Nota:** Al convertir un arreglo dinámico en un arreglo estático, se debe especificar el tipo del arreglo estático
> mediante un arreglo vacío del tipo deseado. Si el arreglo dinámico contiene elementos de un tipo incompatible con el
> tipo del arreglo estático, se lanzará una excepción de tipo `ArrayStoreException`.

## ¿Cómo ordenar un arreglo dinámico en Java?

Para ordenar un arreglo dinámico en Java, se puede utilizar el método `sort()`. Este método permite ordenar los
elementos del arreglo dinámico en orden ascendente o descendente. A continuación se muestra un ejemplo de cómo ordenar
un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(30);
        numeros.add(10);
        numeros.add(20);

        // Ordenar los elementos del arreglo dinámico en orden ascendente
        numeros.sort(Comparator.naturalOrder());

        // Imprimir los elementos del arreglo dinámico ordenados
        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se ordenan los elementos del arreglo dinámico en orden ascendente con el
método `sort()`. El método `sort()` ordena los elementos del arreglo dinámico utilizando el comparador especificado.

> **Nota:** El método `sort()` ordena los elementos del arreglo dinámico en lugar, es decir, modifica el arreglo
> dinámico original. Si se desea mantener el arreglo dinámico original sin modificar, se puede crear una copia del
> arreglo dinámico y ordenar la copia en su lugar.

### Ordenar un arreglo dinámico mediante comparadores personalizados en Java

Para ordenar un arreglo dinámico mediante comparadores personalizados en Java, se puede utilizar el método `sort()`
sobrecargado que acepta un comparador como argumento. Este comparador personalizado permite especificar un criterio de
ordenación personalizado para los elementos del arreglo dinámico. A continuación se muestra un ejemplo de cómo ordenar
un arreglo dinámico mediante comparadores personalizados en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de cadenas
        ArrayList<String> nombres = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Charlie");

        // Ordenar los elementos del arreglo dinámico en orden descendente
        nombres.sort(Comparator.reverseOrder());

        // Imprimir los elementos del arreglo dinámico ordenados
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de cadenas utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se ordenan los elementos del arreglo dinámico en orden descendente con el
método `sort()` y el comparador `Comparator.reverseOrder()`. El comparador `Comparator.reverseOrder()` especifica un
criterio de ordenación personalizado para los elementos del arreglo dinámico.

Por otro lado, se puede utilizar un comparador personalizado para ordenar los elementos de un arreglo dinámico en
función de una comparación específica. A continuación se muestra un ejemplo de cómo ordenar un arreglo dinámico mediante
un comparador personalizado en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de cadenas
        ArrayList<String> nombres = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Charlie");

        // Ordenar los elementos del arreglo dinámico por longitud de cadena
        nombres.sort(Comparator.comparing(String::length));

        // Imprimir los elementos del arreglo dinámico ordenados
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de cadenas utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se ordenan los elementos del arreglo dinámico por longitud de cadena con el
método `sort()` y el comparador `Comparator.comparing(String::length)`. El comparador
`Comparator.comparing(String::length)` especifica un criterio de ordenación personalizado para los elementos del arreglo
dinámico.

## ¿Cómo copiar un arreglo dinámico en Java?

Para copiar un arreglo dinámico en Java, se puede utilizar el constructor de la clase `ArrayList` que acepta otro
arreglo dinámico como argumento. Este constructor crea una copia del arreglo dinámico especificado. A continuación se
muestra un ejemplo de cómo copiar un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Copiar el arreglo dinámico en otro arreglo dinámico
        ArrayList<Integer> copiaNumeros = new ArrayList<>(numeros);

        // Imprimir los elementos del arreglo dinámico original
        System.out.println("Arreglo original:");
        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }

        // Imprimir los elementos del arreglo dinámico copiado
        System.out.println("Arreglo copiado:");
        for (int numero : copiaNumeros) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se copia el arreglo dinámico en otro arreglo dinámico con el constructor de la
clase `ArrayList`. El constructor `ArrayList(Collection<? extends E> c)` crea una copia del arreglo dinámico
especificado.

> **Nota:** Al copiar un arreglo dinámico en otro arreglo dinámico, se crea una copia superficial de los elementos del
> arreglo dinámico original. Si los elementos del arreglo dinámico son objetos mutables, los cambios realizados en los
> elementos del arreglo dinámico copiado también se reflejarán en el arreglo dinámico original.

## ¿Cómo unir dos arreglos dinámicos en Java?

Para unir dos arreglos dinámicos en Java, se puede utilizar el método `addAll()` de la clase `ArrayList`. Este método
permite agregar todos los elementos de un arreglo dinámico a otro arreglo dinámico. A continuación se muestra un
ejemplo de cómo unir dos arreglos dinámicos en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar dos arreglos dinámicos de enteros
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();

        // Agregar elementos al primer arreglo dinámico
        numeros1.add(10);
        numeros1.add(20);
        numeros1.add(30);

        // Agregar elementos al segundo arreglo dinámico
        numeros2.add(40);
        numeros2.add(50);
        numeros2.add(60);

        // Unir los dos arreglos dinámicos
        numeros1.addAll(numeros2);

        // Imprimir los elementos del arreglo dinámico resultante
        for (int numero : numeros1) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declaran dos arreglos dinámicos de enteros utilizando la clase `ArrayList`. Se agregan elementos a
cada arreglo dinámico con el método `add()`, y se unen los dos arreglos dinámicos con el método `addAll()`. El método
`addAll()` agrega todos los elementos del segundo arreglo dinámico al primer arreglo dinámico.

> **Nota:** Al unir dos arreglos dinámicos en Java, los elementos del segundo arreglo dinámico se agregan al final del
> primer arreglo dinámico. Si se desea insertar los elementos del segundo arreglo dinámico en una posición específica
> del primer arreglo dinámico, se puede utilizar el método `addAll(int índice, Collection<? extends E> c)`.

## ¿Cómo filtrar elementos de un arreglo dinámico en Java?

Para filtrar elementos de un arreglo dinámico en Java, se puede utilizar el método `removeIf()` de la clase `ArrayList`.
Este método permite eliminar todos los elementos que cumplen una condición específica. A continuación se muestra un
ejemplo de cómo filtrar elementos de un arreglo dinámico en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Filtrar los elementos del arreglo dinámico
        numeros.removeIf(numero -> numero > 20);

        // Imprimir los elementos del arreglo dinámico filtrado
        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se filtran los elementos del arreglo dinámico con el método `removeIf()`. El
método `removeIf()` elimina todos los elementos que cumplen la condición especificada.

> **Nota:** Al filtrar elementos de un arreglo dinámico en Java, se pueden utilizar expresiones lambda para especificar
> la condición de filtrado. La expresión lambda `numero -> numero > 20` filtra los elementos del arreglo dinámico que
> son mayores que `20`. Se pueden utilizar otras expresiones lambda para filtrar elementos en función de diferentes
> criterios.
> {style="note"}

> **Nota:** Al filtrar elementos de un arreglo dinámico en Java, los elementos que cumplen la condición de filtrado son
> eliminados del arreglo dinámico original.
> {style="warning"}

## ¿Cómo mapear elementos de un arreglo dinámico en Java?

Para mapear elementos de un arreglo dinámico en Java, se puede utilizar el método `replaceAll()` de la clase
`ArrayList`. Este método permite reemplazar todos los elementos del arreglo dinámico por los resultados de aplicar una
función de mapeo a cada elemento. A continuación se muestra un ejemplo de cómo mapear elementos de un arreglo dinámico
en Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declarar un arreglo dinámico de enteros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar elementos al arreglo dinámico
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Mapear los elementos del arreglo dinámico
        numeros.replaceAll(numero -> numero * 2);

        // Imprimir los elementos del arreglo dinámico mapeados
        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }
}
```

En este ejemplo, se declara un arreglo dinámico de enteros utilizando la clase `ArrayList`. Se agregan elementos al
arreglo dinámico con el método `add()`, y se mapean los elementos del arreglo dinámico con el método `replaceAll()`. El
método `replaceAll()` reemplaza todos los elementos del arreglo dinámico por los resultados de aplicar la función de
mapeo especificada.

> **Nota:** Al mapear elementos de un arreglo dinámico en Java, se pueden utilizar expresiones lambda para especificar
> la función de mapeo. La expresión lambda `numero -> numero * 2` mapea los elementos del arreglo dinámico multiplicando
> cada elemento por `2`. Se pueden utilizar otras expresiones lambda para mapear elementos en función de diferentes
> criterios.
> {style="note"}

## Conclusión

En resumen, los arreglos dinámicos en Java son una estructura de datos muy útil para almacenar y manipular colecciones
de elementos de manera dinámica durante la ejecución de un programa. Los arreglos dinámicos en Java permiten agregar,
eliminar, buscar, acceder, recorrer, ordenar, copiar, unir, filtrar y mapear elementos de manera eficiente.

Los arreglos dinámicos en Java son ideales cuando se necesita almacenar un conjunto de elementos que puede cambiar de
tamaño durante la ejecución de un programa. Algunas situaciones comunes en las que se utilizan arreglos dinámicos son
cuando se necesita almacenar una colección de elementos de un mismo tipo de datos, cuando se necesita agregar,
eliminar o buscar elementos de manera eficiente, cuando se necesita recorrer los elementos de la colección en un orden
específico, entre otros.