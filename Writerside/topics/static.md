# El Modificador `static`

El modificador `static` en Java se utiliza para declarar miembros de clase, es decir, miembros que pertenecen a la clase
en lugar de a una instancia específica de la clase. Los miembros estáticos se comparten entre todas las instancias de la
clase y se pueden acceder directamente a través del nombre de la clase, sin necesidad de crear una instancia de la
clase.

## Variables Estáticas

Las variables estáticas en Java son variables que pertenecen a la clase en la que se declaran en lugar de a una
instancia
específica de la clase. Esto significa que todas las instancias de la clase comparten la misma variable estática y
pueden
acceder a ella directamente a través del nombre de la clase.

A continuación, se muestra un ejemplo de una variable estática en Java:

```java
public class MiClase {

    public static int x; // Variable estática

    public static void main(String[] args) {
        MiClase.x = 10; // Accede a la variable estática x
        System.out.println(MiClase.x); // Imprime el valor de x
    }
}
```

En este ejemplo, la variable estática `x` se declara en la clase `MiClase` y se accede a ella directamente a través del
nombre de la clase. Esto se debe a que la variable estática `x` pertenece a la clase `MiClase` en sí misma, en lugar de
a instancias específicas de la clase.

## Métodos Estáticos

Los métodos estáticos en Java son métodos que pertenecen a la clase en la que se declaran en lugar de a una instancia
específica de la clase. Esto significa que los métodos estáticos se pueden llamar directamente a través del nombre de
la clase, sin necesidad de crear una instancia de la clase.

A continuación, se muestra un ejemplo de un método estático en Java:

```java
public class MiClase {

    public static void miMetodo() {
        System.out.println("Hola, mundo!");
    }

    public static void main(String[] args) {
        MiClase.miMetodo(); // Llama al método estático miMetodo
    }
}
```

En este ejemplo, el método estático `miMetodo` se declara en la clase `MiClase` y se llama directamente a través del
nombre de la clase. Esto se debe a que el método estático `miMetodo` pertenece a la clase `MiClase` en sí misma, en
lugar de a instancias específicas de la clase.

## Bloques Estáticos

Los bloques estáticos en Java son bloques de código que se ejecutan cuando se carga la clase en la JVM (Java Virtual
Machine). Los bloques estáticos se utilizan para inicializar variables estáticas y realizar otras tareas de
inicialización que deben realizarse una sola vez al cargar la clase.

A continuación, se muestra un ejemplo de un bloque estático en Java:

```java
public class MiClase {

    public static int x; // Variable estática

    static {
        x = 10; // Inicializa la variable estática x
    }

    public static void main(String[] args) {
        System.out.println(MiClase.x); // Imprime el valor de x
    }
}
```

En este ejemplo, el bloque estático se utiliza para inicializar la variable estática `x` cuando se carga la clase
`MiClase` en la JVM. Esto garantiza que la variable estática `x` se inicialice antes de que se acceda a ella en otros
métodos de la clase.

## Resumen

En resumen, el modificador `static` en Java se utiliza para declarar miembros de clase, como variables estáticas,
métodos
estáticos y bloques estáticos. Los miembros estáticos pertenecen a la clase en la que se declaran en lugar de a una
instancia específica de la clase y se pueden acceder directamente a través del nombre de la clase. Los miembros
estáticos
se comparten entre todas las instancias de la clase y se inicializan una sola vez al cargar la clase en la JVM.