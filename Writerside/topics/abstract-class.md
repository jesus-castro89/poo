# ¿Qué son las clases abstractas?

Las clases abstractas son clases que no pueden ser instanciadas, es decir, no se pueden crear objetos de ellas. Estas
clases son utilizadas para definir una estructura base que será heredada por otras clases, las cuales sí podrán ser
instanciadas.

En Java, las clases abstractas se definen con la palabra clave `abstract`. Dentro de una clase abstracta, se pueden
definir métodos abstractos, los cuales no tienen implementación y deben ser implementados por las clases hijas. Para
definir un método abstracto, se utiliza la palabra clave `abstract` antes de la palabra clave `void` o del tipo de dato
de retorno del método.

```java
public abstract class Figura {
    public abstract void dibujar();
}
```

En el ejemplo anterior, la clase `Figura` es una clase abstracta que define un método abstracto llamado `dibujar`. Las
clases que hereden de la clase `Figura` deberán implementar el método `dibujar`.

```java
public class Circulo extends Figura {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}
```

En el ejemplo anterior, la clase `Circulo` hereda de la clase `Figura` y sobrescribe el método `dibujar` para imprimir
el mensaje "Dibujando un círculo".

Las clases abstractas también pueden tener métodos concretos, es decir, métodos que tienen una implementación. Estos
métodos pueden ser heredados por las clases hijas o sobrescritos si es necesario.

```java
public abstract class Figura {
    public abstract void dibujar();

    public void mostrarNombre() {
        System.out.println("Figura");
    }
}
```

En el ejemplo anterior, la clase `Figura` tiene un método concreto llamado `mostrarNombre` que imprime el mensaje
"Figura". Este método puede ser heredado por las clases hijas sin necesidad de sobrescribirlo.

## Características de las clases abstractas

* Las clases abstractas no pueden ser instanciadas.
    * Es decir, no se pueden crear objetos de una clase abstracta.
* Las clases abstractas pueden tener métodos abstractos y concretos.
* Las clases hijas de una clase abstracta deben implementar los métodos abstractos de la clase padre.
    * En otras palabras, las clases hijas deben sobrescribir los métodos abstractos de la clase padre.
* Las clases hijas heredan los métodos concretos de la clase padre.
    * Siempre y cuando no sean privados. De lo contrario, no se heredan o no pueden ser invocados por las clases hijas.
    * Los métodos concretos pueden ser sobrescritos si es necesario.
    * Los métodos concretos pueden ser heredados por las clases hijas sin necesidad de sobrescribirlos.
* Las clases hijas pueden ser instanciadas.
    * Es decir, se pueden crear objetos de las clases hijas.
* Las clases hijas pueden heredar de una sola clase abstracta.
    * Java no soporta la herencia múltiple, por lo que una clase hija solo puede heredar de una clase abstracta.

Las clases abstractas son una herramienta poderosa en la programación orientada a objetos, ya que permiten definir una
estructura base que puede ser compartida por varias clases hijas. Esto facilita la reutilización de código y la
organización de la lógica de un programa.

## Resumen

Las clases abstractas son clases que no pueden ser instanciadas y se utilizan para definir una estructura base que será
heredada por otras clases. Las clases abstractas pueden tener métodos abstractos y concretos, y las clases hijas deben
implementar los métodos abstractos de la clase padre. Las clases hijas pueden heredar los métodos concretos de la clase
padre y sobrescribirlos si es necesario. Las clases abstractas son una herramienta poderosa en la programación orientada
a objetos para organizar y reutilizar código de manera eficiente.