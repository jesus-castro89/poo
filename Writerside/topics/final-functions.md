# Funciones finales y Herencia

En Java, la palabra clave `final` se puede utilizar para definir una función que no puede ser sobrescrita por las clases
hijas. Esto significa que una vez que una función es declarada como `final`, no se puede modificar su comportamiento en
las clases hijas. Esto es útil cuando se quiere asegurar que una función no sea modificada en las clases hijas, ya sea
por error o intencionalmente.

Para definir una función como `final`, se utiliza la palabra clave `final` antes de la palabra clave `void` o del tipo
de dato de retorno de la función. Por ejemplo:

```java
public class Shape {
    public final void draw() {
        System.out.println("Drawing a shape");
    }
}
```

En el ejemplo anterior, la función `draw` de la clase `Shape` es declarada como `final`, lo que significa que no puede
ser sobrescrita por las clases hijas. Si se intenta sobrescribir la función `draw` en una clase hija, se generará un
error de compilación.

```java
public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
```

En el ejemplo anterior, la clase `Circle` intenta sobrescribir la función `draw` de la clase `Shape`, pero como la
función `draw` está declarada como `final`, se generará un error de compilación.

Las funciones `final` son útiles cuando se quiere asegurar que cierto comportamiento no sea modificado en las clases
hijas. Sin embargo, es importante tener en cuenta que una función `final` no puede ser sobrescrita, pero sí puede ser
heredada por las clases hijas.

## Una clase final

Además de las funciones, la palabra clave `final` también se puede utilizar para definir una clase que no puede ser
heredada por otras clases. Esto significa que una vez que una clase es declarada como `final`, no se pueden crear
clases que hereden de ella.

Para definir una clase como `final`, se utiliza la palabra clave `final` antes de la palabra clave `class`. Por ejemplo:

```java
public final class Triangle extends Shape {
    // Código de la clase Triangle
}
```

En el ejemplo anterior, la clase `Triangle` es declarada como `final`, lo que significa que no puede ser heredada por
otras clases. Si se intenta heredar de la clase `Triangle`, se generará un error de compilación.

Las clases `final` son útiles cuando se quiere asegurar que una clase no sea heredada por otras clases. Esto puede ser
útil en situaciones donde se quiere evitar que cierto comportamiento sea modificado o extendido por clases hijas.

En resumen, la palabra clave `final` se puede utilizar para definir funciones que no pueden ser sobrescritas por las
clases hijas y clases que no pueden ser heredadas por otras clases. Esto permite controlar y proteger el comportamiento
de las funciones y clases en una jerarquía de herencia.