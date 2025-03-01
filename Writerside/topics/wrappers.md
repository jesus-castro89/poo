# ¿Qué son las clases Wrapper en Java?

Las clases Wrapper en Java son clases que envuelven tipos primitivos en objetos. Estas clases proporcionan métodos y
utilidades adicionales para trabajar con tipos primitivos de una manera más orientada a objetos. Las clases Wrapper son
útiles cuando se necesita tratar un tipo primitivo como un objeto, como en el caso de las colecciones de Java, que solo
pueden contener objetos y no tipos primitivos.

## Clases Wrapper comunes

Algunas de las clases Wrapper comunes en Java son:

| Tipo primitivo | Clase Wrapper |
|----------------|---------------|
| `boolean`      | `Boolean`     |
| `byte`         | `Byte`        |
| `short`        | `Short`       |
| `int`          | `Integer`     |
| `long`         | `Long`        |
| `float`        | `Float`       |
| `double`       | `Double`      |
| `char`         | `Character`   |

Estas clases proporcionan métodos para convertir entre tipos primitivos y objetos, realizar operaciones matemáticas y
comparaciones, y trabajar con valores nulos.

## Ejemplos de uso de las clases Wrapper

A continuación se muestran algunos ejemplos de cómo utilizar las clases Wrapper en Java:

```java
// Crear un objeto Integer a partir de un entero
int numeroEntero = 10;
Integer entero = Integer.valueOf(numeroEntero);

// Convertir un objeto Integer a un entero
int numero = entero.intValue();

// Realizar operaciones matemáticas con objetos Integer
Integer suma = Integer.sum(10, 20);

// Comparar dos objetos Integer
boolean iguales = Integer.compare(10, 10) == 0;

// Trabajar con valores nulos
Integer nulo = null;
```

En estos ejemplos, se utilizan los métodos de las clases Wrapper para crear objetos a partir de tipos primitivos,
realizar operaciones matemáticas y comparaciones, y trabajar con valores nulos de una manera más orientada a objetos.

## Casting entre tipos primitivos y clases Wrapper

Es posible realizar casting entre tipos primitivos y clases Wrapper en Java de forma automática, ya que Java proporciona
conversiones implícitas entre tipos primitivos y sus clases Wrapper correspondientes. Por ejemplo:

```java
// Casting automático de int a Integer
int numeroEntero = 10;
Integer entero = numeroEntero;

// Casting automático de Integer a int
Integer entero = 10;
int numero = entero;
```

En estos ejemplos, se realiza un casting automático entre un tipo primitivo `int` y su clase Wrapper `Integer` de forma
implícita, lo que facilita la conversión entre tipos primitivos y objetos en Java.

## Castings explícitos de `String` a tipos primitivos

Además de los castings automáticos entre tipos primitivos y clases Wrapper, también es posible realizar castings
explícitos entre `String` y tipos primitivos utilizando los métodos `parse` de las clases Wrapper. Por ejemplo:

```java
// Casting explícito de String a int
String texto = "10";
int numero = Integer.parseInt(texto);

// Casting explícito de String a double
String texto = "10.5";
double decimal = Double.parseDouble(texto);
```

En estos ejemplos, se utiliza el método `parseInt` de la clase `Integer` y el método `parseDouble` de la clase `Double`
para convertir un `String` en un entero y un decimal, respectivamente.

> Es importante tener en cuenta que los castings explícitos entre `String` y tipos primitivos pueden lanzar excepciones
> si el `String` no se puede convertir al tipo primitivo correspondiente.
> {type="warning"}

> **Nota:** Cada clase Wrapper tiene métodos específicos para realizar conversiones entre tipos primitivos y objetos,
> así como para realizar operaciones matemáticas y comparaciones. Consulta la documentación de Java para obtener más
> información sobre las clases Wrapper y sus métodos. O bien puedes usar la ayuda de tu IDE para explorar las clases
> Wrapper y sus métodos.

## Conclusiones

Las clases Wrapper en Java son clases que envuelven tipos primitivos en objetos y proporcionan métodos y utilidades
adicionales para trabajar con tipos primitivos de una manera más orientada a objetos. Las clases Wrapper son útiles
cuando se necesita tratar un tipo primitivo como un objeto, como en el caso de las colecciones de Java, que solo pueden
contener objetos y no tipos primitivos. Las clases Wrapper facilitan la conversión entre tipos primitivos y objetos, la
realización de operaciones matemáticas y comparaciones, y el trabajo con valores nulos en Java.