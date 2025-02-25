# Ámbito y Tiempo de Vida de las Variables en Java

En Java, el ámbito y el tiempo de vida de una variable se refieren a la parte del programa en la que la variable es
accesible y a la duración durante la cual la variable mantiene su valor, respectivamente. Estos conceptos son
importantes para comprender cómo se comportan las variables en un programa Java y cómo se gestionan en la memoria.

## Ámbito de las Variables

El ámbito de una variable en Java se refiere a la parte del programa en la que la variable es accesible y puede ser
utilizada. En Java, el ámbito de una variable está determinado por el bloque de código en el que se declara la variable.

### Ámbito de Variables Locales

Las variables locales en Java tienen un ámbito limitado al bloque de código en el que se declaran. Esto significa que
una variable local solo es accesible dentro del bloque de código en el que se declara, y no puede ser utilizada fuera de
ese bloque.

#### Ejemplo de Ámbito de Variables Locales

A continuación, se muestra un ejemplo de ámbito de variables locales en Java:

```java
public class MiClase {

    public void miMetodo() {
        int x = 10; // Variable local
        System.out.println(x); // Imprime el valor de x
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo();
    }
}
```

En este ejemplo, la variable `x` se declara dentro del método `miMetodo` y solo es accesible dentro de ese método. Si se
intentara acceder a la variable `x` fuera del método `miMetodo`, se produciría un error de compilación.

### Ámbito de Variables de Instancia

Las variables de instancia en Java tienen un ámbito que abarca toda la clase en la que se declaran. Esto significa que
una variable de instancia es accesible desde cualquier parte de la clase en la que se declara, incluidos los métodos y
constructores de la clase.

#### Ejemplo de Ámbito de Variables de Instancia

A continuación, se muestra un ejemplo de ámbito de variables de instancia en Java:

```java
public class MiClase {

    public int x; // Variable de instancia

    public void miMetodo() {
        x = 10; // Accede a la variable de instancia x
        System.out.println(x); // Imprime el valor de x
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo();
    }
}
```

En este ejemplo, la variable de instancia `x` se declara en la clase `MiClase` y es accesible desde el método `miMetodo`
y el método `main`. Esto se debe a que la variable de instancia `x` pertenece a la instancia específica de la clase
`MiClase` a la que se refiere el objeto `obj`.

### Ámbito de Variables Estáticas

Las variables estáticas en Java tienen un ámbito que abarca toda la clase en la que se declaran. Esto significa que una
variable estática es accesible desde cualquier parte de la clase en la que se declara, incluidos los métodos y
constructores de la clase.

#### Ejemplo de Ámbito de Variables Estáticas

A continuación, se muestra un ejemplo de ámbito de variables estáticas en Java:

```java
public class MiClase {

    public static int x; // Variable estática

    public void miMetodo() {
        x = 10; // Accede a la variable estática x
        System.out.println(x); // Imprime el valor de x
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo();
    }
}
```

En este ejemplo, la variable estática `x` se declara en la clase `MiClase` y es accesible desde el método `miMetodo` y
el método `main`. Esto se debe a que la variable estática `x` pertenece a la clase `MiClase` en sí misma, en lugar de a
instancias específicas de la clase.

### Ámbito de Variables de Bloque

Las variables de bloque en Java tienen un ámbito limitado al bloque de código en el que se declaran. Esto significa que
una variable de bloque solo es accesible dentro del bloque de código en el que se declara, y no puede ser utilizada
fuera de ese bloque.

#### Ejemplo de Ámbito de Variables de Bloque

A continuación, se muestra un ejemplo de ámbito de variables de bloque en Java:

```java
public class MiClase {

    public void miMetodo() {
        int x = 10; // Variable de bloque
        if (x > 5) {
            System.out.println("x es mayor que 5");
        }
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo();
    }
}
```

## Tiempo de Vida de las Variables

El tiempo de vida de una variable en Java se refiere a la duración durante la cual la variable mantiene su valor en la
memoria. En Java, el tiempo de vida de una variable depende de si es una variable local, una variable de instancia o una
variable estática.

### Tiempo de Vida de Variables Locales

Las variables locales en Java tienen un tiempo de vida limitado al bloque de código en el que se declaran. Esto
significa que una variable local se crea cuando se entra en el bloque de código en el que se declara y se destruye
cuando se sale de ese bloque.

#### Ejemplo de Tiempo de Vida de Variables Locales

A continuación, se muestra un ejemplo de tiempo de vida de variables locales en Java:

```java
public class MiClase {

    public void miMetodo() {
        int x = 10; // Variable local
        System.out.println(x); // Imprime el valor de x
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo();
    }
}
```

En este ejemplo, la variable `x` se crea cuando se entra en el método `miMetodo` y se destruye cuando se sale de ese
método. Esto significa que la variable `x` no conserva su valor entre llamadas al método `miMetodo`.

### Tiempo de Vida de Variables de Instancia

Las variables de instancia en Java tienen un tiempo de vida que coincide con la duración de la instancia de la clase a
la que pertenecen. Esto significa que una variable de instancia se crea cuando se crea una instancia de la clase y se
destruye cuando se elimina la instancia.

#### Ejemplo de Tiempo de Vida de Variables de Instancia

A continuación, se muestra un ejemplo de tiempo de vida de variables de instancia en Java:

```java
public class MiClase {

    public int x; // Variable de instancia

    public void miMetodo() {
        x = 10; // Accede a la variable de instancia x
        System.out.println(x); // Imprime el valor de x
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo();
    }
}
```

En este ejemplo, la variable de instancia `x` se crea cuando se crea una instancia de la clase `MiClase` y se destruye
cuando se elimina la instancia. Esto significa que la variable `x` conserva su valor mientras la instancia de la clase
`MiClase` esté activa.

### Tiempo de Vida de Variables Estáticas

Las variables estáticas en Java tienen un tiempo de vida que coincide con la duración de la clase a la que pertenecen.
Esto significa que una variable estática se crea cuando se carga la clase en la memoria y se destruye cuando la clase se
descarga de la memoria.

#### Ejemplo de Tiempo de Vida de Variables Estáticas

A continuación, se muestra un ejemplo de tiempo de vida de variables estáticas en Java:

```java
public class MiClase {

    public static int x; // Variable estática

    public void miMetodo() {
        x = 10; // Accede a la variable estática x
        System.out.println(x); // Imprime el valor de x
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo();
    }
}
```

En este ejemplo, la variable estática `x` se crea cuando se carga la clase `MiClase` en la memoria y se destruye cuando
la clase se descarga de la memoria. Esto significa que la variable `x` conserva su valor mientras la clase `MiClase`
esté activa.

### Tiempo de Vida de Variables de Bloque

Las variables de bloque en Java tienen un tiempo de vida limitado al bloque de código en el que se declaran. Esto
significa que una variable de bloque se crea cuando se entra en el bloque de código en el que se declara y se destruye
cuando se sale de ese bloque.

#### Ejemplo de Tiempo de Vida de Variables de Bloque

A continuación, se muestra un ejemplo de tiempo de vida de variables de bloque en Java:

```java
public class MiClase {

    public void miMetodo() {
        if (true) {
            int x = 10; // Variable de bloque
            System.out.println(x); // Imprime el valor de x
        }
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo();
    }
}
```

En este ejemplo, la variable `x` se crea cuando se entra en el bloque `if` y se destruye cuando se sale de ese bloque.
Esto significa que la variable `x` no conserva su valor fuera del bloque `if`.

## Resumen

En resumen, en Java el ámbito de una variable se refiere a la parte del programa en la que la variable es accesible, y
el tiempo de vida de una variable se refiere a la duración durante la cual la variable mantiene su valor en la memoria.
Los conceptos de ámbito y tiempo de vida son importantes para comprender cómo se comportan las variables en un programa
Java y cómo se gestionan en la memoria.