# El uso de `var` y `varargs` en Java

En Java, `var` es una característica introducida en Java 10 que permite la inferencia de tipos locales. Esto significa
que puedes declarar variables sin especificar explícitamente su tipo, y el compilador deducirá el tipo basado en el
valor asignado.

Por su parte, `varargs` (abreviatura de "variable arguments") es una característica que permite a un método aceptar un
número variable de argumentos del mismo tipo. Esto se logra utilizando tres puntos suspensivos (`...`) en la declaración
del método.

## La palabras reservada var

Para usar `var`, simplemente declara una variable con `var` en lugar de un tipo explícito. Aquí hay un ejemplo:

```java
public class VarExample {
    public static void main(String[] args) {
        var message = "Hello, World!"; // El compilador infiere que 'message' es de tipo String
        var number = 42;                // El compilador infiere que 'number' es de tipo int
        var list = List.of(1, 2, 3);    // El compilador infiere que 'list' es de tipo List<Integer>

        IO.println(message);
        IO.println(number);
        IO.println(list);
    }
}
```

Es importante notar que `var` solo puede ser utilizado para variables locales dentro de métodos, bloques o
expresiones lambda. No puede ser usado para variables de instancia, variables estáticas o parámetros de métodos, en
otras palabras, su uso está limitado al ámbito local y no se debe abusar de él para mantener la claridad del código.

Ya que el tipo es inferido por el compilador, no puedes declarar una variable con `var` sin inicializarla:

```java
var uninitialized; // Esto causará un error de compilación
```

## Varargs

Los `varargs` permiten que un método acepte un número variable de argumentos. Aquí hay un ejemplo de cómo usar
`varargs`:

```java
public class VarargsExample {
    void main() {
        printNumbers(1, 2, 3);
        printNumbers(10, 20, 30, 40, 50);
    }

    public static void printNumbers(int... numbers) {
        for (int number : numbers) {
            IO.println(number);
        }
    }
}
```

En este ejemplo, el método `printNumbers` puede aceptar cualquier cantidad de argumentos enteros. Dentro del método, los
argumentos se tratan como un arreglo.

Es importante recordar que un método solo puede tener un parámetro `varargs`, y debe ser el último parámetro en la
lista de parámetros. Por ejemplo:

```java
public void exampleMethod(String name, int... numbers) {
    // Código aquí
}
```

Esto permite una gran flexibilidad al llamar al método, ya que puedes pasar cualquier número de enteros después del
primer argumento.

## Conclusión

El uso de `var` y `varargs` en Java puede mejorar la legibilidad y flexibilidad del código. `var` permite una
declaración de variables más concisa, mientras que `varargs` facilita la creación de métodos que pueden aceptar un
número variable de argumentos. Sin embargo, es importante usarlos con moderación para mantener la claridad del código.