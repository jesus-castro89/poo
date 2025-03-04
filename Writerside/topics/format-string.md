# ¿Qué son las cadenas de formato en Java?

En Java, las cadenas de formato son una forma de crear cadenas de texto con formato que contienen marcadores de posición
para valores que se insertarán en la cadena. Los marcadores de posición se especifican utilizando el carácter `%`
seguido de un carácter que indica el tipo de dato que se va a insertar. Por ejemplo, `%d` se utiliza para insertar
valores enteros, `%f` para insertar valores de punto flotante y `%s` para insertar cadenas de texto.

Las cadenas de formato se crean utilizando el método `String.format()`, que toma una cadena de formato y una lista de
valores que se insertarán en la cadena. Por ejemplo:

```java
int edad = 30;
String nombre = "Juan";
String mensaje = String.format("Hola, %s. Tienes %d años.", nombre, edad);
System.out.println(mensaje);
```

En este ejemplo, se crea una cadena de formato que contiene dos marcadores de posición: `%s` para el nombre y `%d` para
la edad. Luego, se utiliza el método `String.format()` para insertar los valores `nombre` y `edad` en la cadena y se
imprime el resultado.

Las cadenas de formato son útiles cuando se necesita crear cadenas de texto con formato específico, como mensajes de
saludo personalizados o informes detallados. También son útiles para formatear valores numéricos y fechas de una manera
legible para los humanos.

## Comodines de formato

Dentro de Java los comodines de formato son una forma de especificar cómo se deben formatear los valores que se insertan
en una cadena de formato. Los comodines de formato se especifican utilizando el carácter `%` seguido de un carácter que
indica el tipo de dato que se va a insertar. Algunos de los comodines de formato más comunes son:

| Comodín | Tipo de dato    | Descripción                                                    |
|---------|-----------------|----------------------------------------------------------------|
| `%d`    | Entero          | Formatea un valor entero.                                      |
| `%f`    | Punto flotante  | Formatea un valor de punto flotante.                           |
| `%.nf`  | Punto flotante  | Formatea un valor de punto flotante con `n` dígitos decimales. |
| `%s`    | Cadena de texto | Formatea una cadena de texto.                                  |
| `%b`    | Booleano        | Formatea un valor booleano.                                    |
| `%c`    | Carácter        | Formatea un carácter.                                          |
| `%t`    | Fecha/hora      | Formatea una fecha u hora.                                     |
| `%x`    | Hexadecimal     | Formatea un valor en hexadecimal.                              |
| `%o`    | Octal           | Formatea un valor en octal.                                    |

Estos comodines de formato se utilizan para especificar cómo se deben formatear los valores que se insertan en una
cadena de formato. Por ejemplo, `%d` se utiliza para formatear valores enteros, `%f` para formatear valores de punto
flotante y `%s` para formatear cadenas de texto.

## Especificadores de formato

Los especificadores de formato son una forma de controlar cómo se formatean los valores que se insertan en una cadena de
formato. Los especificadores de formato se especifican utilizando el carácter `%` seguido de un número opcional que
indica la anchura mínima del campo y un carácter que indica el tipo de dato que se va a insertar. Por ejemplo, `%10d`
indica que el valor entero se debe formatear con una anchura mínima de 10 caracteres.

Algunos de los especificadores de formato más comunes son:

| Especificador | Descripción                                                                   |
|---------------|-------------------------------------------------------------------------------|
| `%nd`         | Formatea un valor entero con una anchura mínima de `n` caracteres.            |
| `%n.mf`       | Formatea un valor de punto flotante con `m` dígitos decimales y `n` de ancho. |

Estos especificadores de formato se utilizan para controlar cómo se formatean los valores que se insertan en una cadena
de formato. Por ejemplo, `%10d` se utiliza para formatear valores enteros con una anchura mínima de 10 caracteres y
`%.2f` se utiliza para formatear valores de punto flotante con dos dígitos decimales.

## Bloque de Texto

En Java el uso de `"""` permite crear bloques de texto, lo que facilita la escritura de cadenas de texto largas y
complejas. Por ejemplo:

```java
String texto = """
    Este es un bloque de texto
    que contiene varias líneas
    y puede incluir comillas " y caracteres especiales \t
    """;
System.out.println(texto);
```

En este ejemplo, se crea un bloque de texto que contiene varias líneas de texto y se imprime en la consola. El uso de
bloques de texto facilita la escritura de cadenas de texto largas y complejas sin tener que escapar los caracteres de
nueva línea y comillas. Así mismo, pueden ser usadas en conjunto a las cadenas de formato para crear mensajes más
complejos y detallados.

## Bloques de texto con formato

Los bloques de texto con formato en Java permiten combinar texto con valores de variables de una manera más legible y
flexible. Para crear un bloque de texto con formato, se utiliza la notación `"""` seguida de la cadena de texto y luego
`"""` y se pueden incluir especificadores de formato dentro del bloque de texto.

```java
String texto = """
    Hola, %s.
    Tu edad es %d años
    y mides %.2f metros.
    """;

String mensaje = String.format(texto, nombre, edad, altura);
System.out.println(mensaje);
```

En este ejemplo, se crea un bloque de texto con formato que incluye especificadores de formato para combinar texto con
valores de variables, y luego se utiliza el método `String.format()` para reemplazar los especificadores de formato con
los valores de las variables.

Los bloques de texto con formato son útiles para incluir mensajes con formato en el código fuente de una manera más
legible y mantenible.

> **Nota:** Los bloques de texto con formato se introdujeron en Java 15 como una característica del lenguaje para
> mejorar la legibilidad y mantenibilidad del código fuente.

## Conclusión

En resumen, las cadenas de formato en Java son una forma de crear cadenas de texto con formato que contienen marcadores
de posición para valores que se insertarán en la cadena. Los comodines de formato se utilizan para especificar cómo se
deben formatear los valores que se insertan en la cadena, y los especificadores de formato se utilizan para controlar
cómo se formatean los valores. El uso de bloques de texto facilita la escritura de cadenas de texto largas y complejas,
lo que puede ser útil al crear mensajes detallados y personalizados en una aplicación Java.