# Las clases predefinidas en Java

Java proporciona un conjunto de clases predefinidas que se utilizan comúnmente en la programación. Estas clases
proporcionan funcionalidades básicas y avanzadas que facilitan el desarrollo de aplicaciones en Java.

## Clases predefinidas comunes

Algunas de las clases predefinidas más comunes en Java son:

| Clase         | Descripción                                                                 |
|---------------|-----------------------------------------------------------------------------|
| `String`      | Representa una secuencia de caracteres.                                     |
| `Integer`     | Representa un número entero.                                                |
| `Double`      | Representa un número de punto flotante de doble precisión.                  |
| `Boolean`     | Representa un valor booleano (`true` o `false`).                            |
| `ArrayList`   | Implementa una lista dinámica que puede crecer o reducir su tamaño.         |
| `HashMap`     | Implementa una tabla hash que almacena pares clave-valor.                   |
| `File`        | Representa un archivo o directorio en el sistema de archivos.               |
| `Scanner`     | Permite leer datos de entrada desde diferentes fuentes.                     |
| `Random`      | Genera números aleatorios.                                                  |
| `Math`        | Proporciona funciones matemáticas estáticas como `sin`, `cos`, `sqrt`, etc. |
| `JOptionPane` | Permite mostrar cuadros de diálogo en aplicaciones de escritorio.           |
| `Arrays`      | Proporciona métodos estáticos para trabajar con arreglos.                   |

Estas clases son solo algunas de las muchas clases predefinidas que Java proporciona para facilitar la programación.

## ¿Cómo se utilizan las clases predefinidas en Java?

Para utilizar una clase predefinida en Java, simplemente se crea una instancia de la clase utilizando la palabra clave
`new` seguida del nombre de la clase y los paréntesis de apertura y cierre.

```java
NombreClase nombreInstancia = new NombreClase();
```

En este ejemplo, `NombreClase` es el nombre de la clase predefinida y `nombreInstancia` es el nombre de la instancia de
la clase.

Por ejemplo, para crear una instancia de la clase `String` y asignarle un valor, se puede hacer de la siguiente manera:

```java
String cadena = new String("Hola, mundo!");
```

En este caso, se crea una instancia de la clase `String` con el valor `"Hola, mundo!"` y se asigna a la variable
`cadena`.

Las clases predefinidas en Java son fundamentales para el desarrollo de aplicaciones y proporcionan funcionalidades
esenciales para trabajar con diferentes tipos de datos y realizar operaciones comunes.

## Clases predefinidas y estáticas

Además de las clases predefinidas que se utilizan para crear instancias de objetos, Java también proporciona clases
estáticas que contienen métodos y variables estáticas que se pueden utilizar sin necesidad de crear instancias de la
clase.

Por ejemplo, la clase `Math` contiene métodos estáticos para realizar operaciones matemáticas como `sin`, `cos`, `sqrt`,
etc. Estos métodos se pueden utilizar directamente a través de la clase `Math` sin necesidad de crear una instancia de
la clase.

```java
double seno = Math.sin(30);
double raizCuadrada = Math.sqrt(25);
```

En este ejemplo, se utilizan los métodos estáticos `sin` y `sqrt` de la clase `Math` para calcular el seno de 30 y la
raíz cuadrada de 25 respectivamente.

Las clases predefinidas y estáticas en Java proporcionan funcionalidades esenciales para el desarrollo de aplicaciones y
facilitan la programación en el lenguaje Java.

## Resumen

En resumen, las clases predefinidas en Java son clases proporcionadas por el lenguaje que contienen funcionalidades
comunes y esenciales para el desarrollo de aplicaciones. Estas clases se utilizan para trabajar con diferentes tipos de
datos, realizar operaciones matemáticas, interactuar con el sistema de archivos, mostrar cuadros de diálogo, entre otras
funcionalidades.

Las clases predefinidas en Java son fundamentales para el desarrollo de aplicaciones y facilitan la programación en el
lenguaje Java.