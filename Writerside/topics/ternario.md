# El Operador Ternario en Java

El operador ternario es una forma de simplificar la estructura de un condicional `if-else` en una sola línea. Su
estructura es la siguiente:

```java
condicion ? valor_si_cierto : valor_si_falso;
```

Donde `condicion` es una expresión booleana, `valor_si_cierto` es el valor que se asignará si la condición es verdadera
y `valor_si_falso` es el valor que se asignará si la condición es falsa.

Por ejemplo, si queremos asignar a la variable `resultado` el valor `true` si `numero` es mayor a 10 y `false` en caso
contrario, podemos hacerlo de la siguiente manera:

```java
int numero = 15;
boolean resultado = numero > 10 ? true : false;
```

En este caso, la variable `resultado` tendrá el valor `true`, ya que la condición `numero > 10` es verdadera.

El operador ternario también puede ser utilizado para retornar un valor en un método. Por ejemplo, si queremos
implementar un método que retorne el valor absoluto de un número, podemos hacerlo de la siguiente manera:

```java
public static int valorAbsoluto(int numero) {
    return numero >= 0 ? numero : -numero;
}
```

En este caso, si el número es mayor o igual a cero, se retornará el mismo número. En caso contrario, se retornará el
número multiplicado por `-1`.

En resumen, el operador ternario es una forma de simplificar la estructura de un condicional `if-else` en una sola línea
y puede ser utilizado tanto para asignar valores como para retornarlos en un método.

> **Nota:** El operador ternario es una forma de simplificar el código, pero su uso excesivo puede hacer que el código
> sea menos legible. Por lo tanto, se recomienda utilizarlo con moderación y en situaciones donde su uso sea apropiado.

Otros uso que se le puede dar es concatenar cadenas de texto, por ejemplo:

```java
String nombre = "Juan";
String saludo = "Hola, " + (nombre != null ? nombre : "invitado") + "!";
System.out.println(saludo); // Imprime: Hola, Juan!
```

En este caso, si la variable `nombre` es `null`, se imprimirá el saludo "Hola, invitado!". Si la variable `nombre` tiene
un valor distinto de `null`, se imprimirá el saludo "Hola, Juan!".