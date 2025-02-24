# El Modificador `final` en Java

En Java, el modificador `final` se utiliza para restringir la modificación de una clase, método o variable. Cuando se
declara una clase como `final`, no se puede heredar de ella. Cuando se declara un método como `final`, no se puede
sobrescribir. Y cuando se declara una variable como `final`, no se puede cambiar su valor una vez que se ha
inicializado.

## Clase `final`

Cuando se declara una clase como `final`, se índica que la clase no puede ser heredada. Esto significa que no se pueden
crear clases que extiendan la clase `final`. Por ejemplo:

```java
public final class MiClase {
    // Código de la clase
}
```

En este ejemplo, la clase `MiClase` se declara como `final`, lo que significa que no se pueden crear subclases de ella.

## Método `final`

Cuando se declara un método como `final`, se indica que el método no puede ser sobrescrito en las subclases. Esto
significa que las subclases no pueden proporcionar una implementación diferente del método. Por ejemplo:

```java
public class MiClase {

    public final void miMetodo() {
        // Código del método
    }
}
```

En este ejemplo, el método `miMetodo` se declara como `final`, lo que significa que no se puede sobrescribir en las
subclases.

## Variable `final`

Cuando se declara una variable como `final`, se indica que la variable no puede cambiar su valor una vez que se ha
inicializado. Esto significa que la variable se convierte en una constante y su valor no puede ser modificado. Por
ejemplo:

```java
public class MiClase {

    public static final int MI_CONSTANTE = 10;
}
```

En este ejemplo, la variable `MI_CONSTANTE` se declara como `final`, lo que significa que su valor no puede ser cambiado
después de ser inicializado.

El modificador `final` se utiliza para garantizar la inmutabilidad y la seguridad en el código Java. Al utilizar `final`
en clases, métodos y variables, se puede prevenir la modificación accidental y garantizar que el código se comporte de
la manera esperada.