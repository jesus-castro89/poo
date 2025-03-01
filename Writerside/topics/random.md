# Comprendiendo la clase `Random` en Java

La clase `Random` en Java es una clase predefinida que se utiliza para generar números aleatorios. Esta clase
proporciona métodos para generar números enteros, números en punto flotante y booleanos de forma aleatoria.

## ¿Cómo se utiliza la clase `Random` en Java?

Para utilizar la clase `Random` en Java, primero se debe importar la clase en el archivo Java en el que se desea
utilizarla. Luego, se crea una instancia de la clase `Random` utilizando la palabra clave `new` seguida del nombre de
la clase y los paréntesis de apertura y cierre.

```java
import java.util.Random;

public class EjemploRandom {
    public static void main(String[] args) {
        Random generadorAleatorio = new Random();
    }
}
```

En este ejemplo, se importa la clase `Random` del paquete `java.util` y se crea una instancia de la clase `Random`
llamada `generadorAleatorio`.

Una vez creada la instancia de la clase `Random`, se pueden utilizar los métodos de la clase para generar números
aleatorios. Algunos de los métodos más comunes de la clase `Random` son:

| Método               | Descripción                                                                                 |
|----------------------|---------------------------------------------------------------------------------------------|
| `nextInt()`          | Genera un número entero aleatorio.                                                          |
| `nextDouble()`       | Genera un número en punto flotante aleatorio entre 0.0 y 1.0.                               |
| `nextBoolean()`      | Genera un valor booleano aleatorio.                                                         |
| `nextGaussian()`     | Genera un número en punto flotante aleatorio con una distribución gaussiana.                |
| `nextInt(int bound)` | Genera un número entero aleatorio entre 0 (inclusive) y el límite especificado (exclusivo). |
| `nextLong()`         | Genera un número entero largo aleatorio.                                                    |
| `nextFloat()`        | Genera un número en punto flotante aleatorio.                                               |
| `setSeed(long seed)` | Establece la semilla para la generación de números aleatorios.                              |

Estos métodos permiten generar diferentes tipos de números aleatorios según las necesidades del programador.

## Ejemplo de uso de la clase `Random`

A continuación, se muestra un ejemplo de cómo utilizar la clase `Random` para generar un número entero aleatorio entre
0 y 100:

```java
import java.util.Random;

public class EjemploRandom {
    public static void main(String[] args) {
        Random generadorAleatorio = new Random();
        int numeroAleatorio = generadorAleatorio.nextInt(101); // Genera un número entre 0 y 100
        System.out.println("Número aleatorio: " + numeroAleatorio);
    }
}
```

En este ejemplo, se crea una instancia de la clase `Random` llamada `generadorAleatorio` y se utiliza el método
`nextInt(101)` para generar un número entero aleatorio entre 0 y 100. Luego, se imprime el número aleatorio generado en
la consola. Cada vez que se ejecute el programa, se generará un número aleatorio diferente.

Hay que comprender que la función `nextInt(101)` genera un número aleatorio entre 0 y 100, esto debido a que no se
incluye el 101 en el rango de números generados. Si se desea generar un número aleatorio entre 1 y 100, se debe utilizar
`nextInt(100) + 1`.

## Creemos una función para un rango de números aleatorios enteros o largos

Para generar un número aleatorio en un rango específico, se puede utilizar la siguiente función:

```java
public static int generarNumeroAleatorio(int minimo, int maximo) {
    Random generadorAleatorio = new Random();
    return generadorAleatorio.nextInt(maximo - minimo + 1) + minimo;
}
```

Esta función recibe dos parámetros `minimo` y `maximo`, que representan el rango de números en el que se desea generar
el número aleatorio. La función utiliza el método `nextInt()` de la clase `Random` para generar un número aleatorio
entre `minimo` y `maximo`, ambos inclusive.

A continuación, se muestra un ejemplo de cómo utilizar esta función para generar un número aleatorio entre 5 y 10:

```java
public class EjemploRandom {

    public static void main(String[] args) {
        int numeroAleatorio = generarNumeroAleatorio(5, 10);
        System.out.println("Número aleatorio entre 5 y 10: " + numeroAleatorio);
    }

    public static int generarNumeroAleatorio(int minimo, int maximo) {
        // Creamos la instancia de la clase Random
        Random generadorAleatorio = new Random();
        // Asignamos la semilla para generar números aleatorios basados en el tiempo actual
        generadorAleatorio.setSeed(System.currentTimeMillis());
        // Generamos un número aleatorio en el rango especificado
        return generadorAleatorio.nextInt(maximo - minimo + 1) + minimo;
    }
}
```

En este ejemplo, se utiliza la función `generarNumeroAleatorio(5, 10)` para generar un número aleatorio entre 5 y 10.

La clase `Random` en Java es una herramienta útil para generar números aleatorios en aplicaciones y juegos, y ofrece
una forma sencilla de introducir aleatoriedad en los programas.

> **Nota:** Es importante tener en cuenta que la generación de números aleatorios en computadoras no es completamente
> aleatoria, ya que se basa en algoritmos deterministas. Sin embargo, la clase `Random` proporciona una forma
> conveniente de simular la aleatoriedad en programas Java, sobre todo al utilizar semillas para generar secuencias
> pseudoaleatorias.

> **Nota:** Toma en consideración que en este ejemplo la función es estática, sin embargo, se puede adaptar para que
> sea una función de instancia si se requiere. Además, se puede modificar la semilla de la generación de números
> aleatorios para obtener secuencias diferentes. Por ejemplo, se puede utilizar `generadorAleatorio.setSeed(12345)` para
> establecer una semilla específica de generación de números aleatorios. Por lo que el código resultante sería:
> ```java
> public class EjemploRandom {
> 
>   public int generarNumeroAleatorio(int minimo, int maximo) {
> 
>       Random generadorAleatorio = new Random();
>       generadorAleatorio.setSeed(12345);
>       return generadorAleatorio.nextInt(maximo - minimo + 1) + minimo;
>   }
> 
>   public static void main(String[] args) {
> 
>       EjemploRandom ejemplo = new EjemploRandom();
>       int numeroAleatorio = ejemplo.generarNumeroAleatorio(5, 10);
>       System.out.println("Número aleatorio entre 5 y 10: " + numeroAleatorio);
>   }
> }
> ```
> En este caso, se ha modificado la función `generarNumeroAleatorio` para que sea una función de instancia y se ha
> establecido una semilla específica para la generación de números aleatorios. Al ejecutar el programa, se obtendrá el
> mismo número aleatorio cada vez, ya que la semilla es la misma. Para obtener diferentes números aleatorios, se puede
> cambiar la semilla o eliminar la línea `generadorAleatorio.setSeed(12345)`.

Por otra parte, si lo que se requiere es generar un número entero largo aleatorio, se puede utilizar la función
`nextLong()` de la clase `Random`. A continuación, se muestra un ejemplo de cómo generar un número entero largo
aleatorio dentro de un rango específico:

```java
public class EjemploRandom {

    public static void main(String[] args) {
        long numeroAleatorioLargo = generarNumeroAleatorioLargo(100000000000L, 999999999999L);
        System.out.println("Número aleatorio largo entre 100,000,000,000 y 999,999,999,999: " + numeroAleatorioLargo);
    }

    public static long generarNumeroAleatorioLargo(long minimo, long maximo) {
        Random generadorAleatorio = new Random();
        generadorAleatorio.setSeed(System.currentTimeMillis());
        return generadorAleatorio.nextLong() % (maximo - minimo + 1) + minimo;
    }
}
```