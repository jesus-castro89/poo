# ¿Qué son los tipos enumerados?

Los tipos enumerados son un conjunto de valores constantes que se pueden asignar a una variable. En Java, los tipos
enumerados se definen mediante la palabra clave `enum`. Por ejemplo, el siguiente código define un tipo enumerado
llamado `Día` que contiene los días de la semana:

```java
enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

En este caso, `WeekDay` es un tipo enumerado que contiene los valores `MONDAY`, `TUESDAY`, `WEDNESDAY`, `THURSDAY`,
`FRIDAY`, `SATURDAY` y `SUNDAY`. Estos valores son constantes y se pueden utilizar en lugar de números o cadenas de
texto para representar días de la semana.

Los tipos enumerados son útiles cuando se necesita representar un conjunto fijo de valores que no cambian durante la
vida útil de un programa. Por ejemplo, los tipos enumerados se pueden utilizar para representar los estados de un
objeto, los colores, los días de la semana, etc.

En resumen, los tipos enumerados son una forma de definir un conjunto de valores constantes que se pueden asignar a
una variable. Esto hace que el código sea más legible y menos propenso a errores, ya que los valores permitidos están
restringidos a un conjunto fijo y conocido de antemano.

## Características de los tipos enumerados

Los tipos enumerados tienen las siguientes características:

* **Valores constantes:** Los valores de un tipo enumerado son constantes y no se pueden modificar una vez que se han
  definido.
* **Tipos seguros:** Los tipos enumerados son tipos seguros, lo que significa que el compilador verifíca que los
  valores asignados a una variable enumerada son válidos.
* **Iteración:** Los tipos enumerados se pueden recorrer utilizando un bucle `for` o `foreach`.
* **Métodos y campos:** Los tipos enumerados pueden tener métodos y campos asociados que permiten realizar operaciones
  específicas con los valores enumerados.
* **Constructores:** Los tipos enumerados pueden tener constructores personalizados que permiten inicializar los valores
  enumerados con parámetros específicos.
* **Implementación de interfaces:** Los tipos enumerados pueden implementar interfaces y métodos abstractos, lo que
  permite definir comportamientos específicos para cada valor enumerado.
* **Propiedades:** Los tipos enumerados pueden tener propiedades asociadas que permiten acceder a información adicional
  sobre los valores enumerados.
* **Métodos estáticos:** Los tipos enumerados pueden tener métodos estáticos que permiten realizar operaciones comunes
  con los valores enumerados.

En resumen, los tipos enumerados son una forma poderosa y flexible de representar un conjunto fijo de valores constantes
en Java. Permiten definir un conjunto de valores predefinidos, restringir las opciones disponibles y mejorar la
legibilidad y mantenibilidad del código.

## Ejemplos de uso de tipos enumerados

A continuación se muestran algunos ejemplos de cómo se pueden utilizar los tipos enumerados en Java:

```java
// Definir un tipo enumerado para los colores
enum Color {
    RED, GREEN, BLUE
}

// Utilizar un tipo enumerado para representar el día de la semana
enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Utilizar un tipo enumerado con constructores personalizados
enum Size {
    SMALL(10),
    MEDIUM(20),
    LARGE(30);

    private int value;

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
```

En estos ejemplos, se muestran diferentes formas de utilizar los tipos enumerados en Java. Los tipos enumerados se
pueden utilizar para representar colores, días de la semana, operaciones matemáticas, tamaños, etc. Además, los tipos
enumerados pueden tener métodos, campos, constructores y propiedades asociadas que permiten realizar operaciones
específicas con los valores enumerados.

## La función `values()` y `valueOf()` de los tipos enumerados

Los tipos enumerados en Java tienen dos métodos estáticos útiles: `values()` y `valueOf()`. La función `values()`
devuelve un array que contiene todos los valores enumerados, en el orden en que fueron declarados. Por otro lado, la
función `valueOf()` permite obtener un valor enumerado a partir de su nombre. Por ejemplo:

```java
enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

WeekDay[] days = WeekDay.values(); // Devuelve un array con los días de la semana

WeekDay monday = WeekDay.valueOf("MONDAY"); // Devuelve el valor enumerado MONDAY
```

Estas funciones son útiles cuando se necesita recorrer los valores de un tipo enumerado o cuando se necesita obtener un
valor enumerado a partir de su nombre.

## La función `ordinal()` de los tipos enumerados

Los tipos enumerados en Java tienen un método llamado `ordinal()` que devuelve la posición de un valor enumerado en la
lista de valores. Por ejemplo:

```java
enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

int mondayPosition = WeekDay.MONDAY.ordinal(); // Devuelve 0

int tuesdayPosition = WeekDay.TUESDAY.ordinal(); // Devuelve 1

int sundayPosition = WeekDay.SUNDAY.ordinal(); // Devuelve 6
```

Este método es útil cuando se necesita obtener la posición de un valor enumerado en la lista de valores.

## La función `compareTo()` de los tipos enumerados

Los tipos enumerados en Java implementan la interfaz `Comparable`, lo que permite comparar los valores enumerados entre
sí. La función `compareTo()` compara dos valores enumerados y devuelve un valor entero que índica si el primer valor es
menor, igual o mayor que el segundo valor. Por ejemplo:

```java
enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

int result = WeekDay.MONDAY.compareTo(WeekDay.TUESDAY); // Devuelve un valor negativo
int result2 = WeekDay.TUESDAY.compareTo(WeekDay.MONDAY); // Devuelve un valor positivo
int result3 = WeekDay.MONDAY.compareTo(WeekDay.MONDAY); // Devuelve 0
```

Esta función es útil cuando se necesita comparar los valores de un tipo enumerado entre sí.

## La función `toString()` de los tipos enumerados

Los tipos enumerados en Java tienen un método llamado `toString()` que devuelve el nombre del valor enumerado como una
cadena de texto. Por ejemplo:

```java
enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

String mondayName = WeekDay.MONDAY.toString(); // Devuelve "MONDAY"
String tuesdayName = WeekDay.TUESDAY.toString(); // Devuelve "TUESDAY"
```

Esta función es útil cuando se necesita obtener el nombre de un valor enumerado como una cadena de texto.

Por consiguiente podemos sobreescribir el método `toString()` para que devuelva un valor personalizado. Por ejemplo:

```java
enum WeekDay {
    MONDAY("Lunes"), 
    TUESDAY("Martes"), 
    WEDNESDAY("Miércoles"), 
    THURSDAY("Jueves"), 
    FRIDAY("Viernes"), 
    SATURDAY("Sábado"), 
    SUNDAY("Domingo");

    private String name;

    WeekDay(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
```

En este caso, el método `toString()` se ha sobrescrito para que devuelva el nombre del día de la semana en español.

## Conclusión

Los tipos enumerados son una forma poderosa y flexible de representar un conjunto fijo de valores constantes en Java.
Permiten definir un conjunto de valores predefinidos, restringir las opciones disponibles y mejorar la legibilidad y
mantenibilidad del código. Los tipos enumerados tienen muchas características útiles, como valores constantes, tipos
seguros, iteración, métodos y campos asociados, constructores personalizados, implementación de interfaces, propiedades
y métodos estáticos. Además, los tipos enumerados tienen funciones útiles como `values()`, `valueOf()`, `ordinal()`,
`compareTo()` y `toString()` que facilitan su uso y manipulación en el código.

En resumen, los tipos enumerados son una herramienta poderosa que puede mejorar la calidad y claridad del código Java,
y se recomienda su uso cuando se necesita representar un conjunto fijo de valores constantes en un programa.