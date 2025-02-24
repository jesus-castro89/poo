# El Modificador `static` en Java

En Java, el modificador `static` se utiliza para declarar miembros de una clase que pertenecen a la clase en sí misma,
en lugar de a las instancias individuales de la clase. Esto significa que los miembros estáticos se comparten entre
todas las instancias de la clase y se pueden acceder directamente a través del nombre de la clase, sin necesidad de
crear una instancia de la clase.

## Variables estáticas

Cuando se declara una variable como `static`, se crea una sola copia de la variable que es compartida por todas las
instancias de la clase. Esto significa que si se modifica la variable en una instancia, el cambio se reflejará en todas
las demás instancias. Por ejemplo:

```java
public class MiClase {

    public static int contador = 0;

    public MiClase() {
        contador++;
    }

    public static void main(String[] args) {
        MiClase obj1 = new MiClase();
        MiClase obj2 = new MiClase();
        MiClase obj3 = new MiClase();

        System.out.println("Contador: " + MiClase.contador);
    }
}
```

En este ejemplo, la variable `contador` se declara como `static`, lo que significa que es compartida por todas las
instancias de la clase `MiClase`. Cada vez que se crea una nueva instancia de `MiClase`, se incrementa el valor de
`contador`, y al final se imprime el valor de `contador`.

## Métodos estáticos

Cuando se declara un método como `static`, el método pertenece a la clase en sí misma en lugar de a las instancias
individuales de la clase. Esto significa que el método se puede llamar directamente a través del nombre de la clase,
sin necesidad de crear una instancia de la clase. Por ejemplo:

```java
public class MiClase {

    public static void saludar() {
        System.out.println("¡Hola, mundo!");
    }

    public static void main(String[] args) {
        MiClase.saludar();
    }
}
```

En este ejemplo, el método `saludar` se declara como `static`, lo que significa que se puede llamar directamente a
través del nombre de la clase `MiClase`. No es necesario crear una instancia de `MiClase` para llamar al método
`saludar`.

## Bloques estáticos

En Java, también se pueden declarar bloques de inicialización estáticos que se ejecutan cuando se carga la clase en
memoria. Estos bloques se utilizan para inicializar variables estáticas y realizar otras tareas de inicialización que
sólo deben realizarse una vez. Por ejemplo:

```java
public class MiClase {

    public static int numero;

    static {
        numero = 10;
        System.out.println("Bloque estático ejecutado");
    }

    public static void main(String[] args) {
        System.out.println("Número: " + MiClase.numero);
    }
}
```

En este ejemplo, se declara un bloque estático que inicializa la variable `numero` con el valor `10` y muestra un
mensaje en la consola. Cuando se ejecuta el programa, el bloque estático se ejecuta antes de que se imprima el valor
de `numero`.

El modificador `static` se utiliza para declarar miembros de una clase que pertenecen a la clase en sí misma en lugar
de a las instancias individuales de la clase. Al utilizar `static`, se pueden crear variables y métodos compartidos
entre todas las instancias de la clase y realizar tareas de inicialización que sólo deben realizarse una vez.