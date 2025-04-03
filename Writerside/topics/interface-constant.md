# ¿Las interfaces pueden tener constantes, atributos o funciones?

Las interfaces en Java pueden contener constantes, pero no pueden contener atributos. Una constante en una
interfaz se define como una variable estática y final. Esto significa que su valor no puede cambiar una vez que se ha
asignado. A continuación se muestra un ejemplo de cómo definir una constante en una interfaz:

```java
public interface Constants {
    int MAX_VALUE = 100;
    String DEFAULT_NAME = "Usuario";
}
```

En este ejemplo, hemos definido una interfaz `Constants` que contiene dos constantes: `MAX_VALUE` y `DEFAULT_NAME`.
Estas constantes son implícitamente `public`, `static` y `final`, lo que significa que pueden ser accedidas desde
cualquier lugar del programa utilizando la sintaxis `Constants.MAX_VALUE` o `Constants.DEFAULT_NAME`.

## Funciones en interfaces

Las interfaces pueden contener métodos abstractos, que son métodos sin implementación. Estos métodos deben ser
implementados por cualquier clase que implemente la interfaz. A continuación se muestra un ejemplo de cómo definir
métodos en una interfaz:

```java
public interface Shape {
    double calculateArea();

    double calculatePerimeter();
}
```

En este ejemplo, hemos definido una interfaz `Shape` que contiene dos métodos abstractos: `calculateArea()` y
`calculatePerimeter()`. Cualquier clase que implemente la interfaz `Shape` deberá proporcionar una implementación para
estos métodos.

### Funciones predeterminadas en interfaces

Las interfaces pueden incluir funciones predeterminadas (default methods) a partir de Java 8. Estas funciones tienen una
implementación por defecto y no necesitan ser implementadas por las clases que implementan la interfaz. A continuación
se muestra un ejemplo de cómo definir una función predeterminada en una interfaz:

```java
public interface Shape {
    double calculateArea();

    double calculatePerimeter();

    default void printDetails() {
        System.out.println("Área: " + calculateArea());
        System.out.println("Perímetro: " + calculatePerimeter());
    }
}
```

En este ejemplo, hemos añadido un método predeterminado `printDetails()` a la interfaz `Shape`. Este método
proporciona una implementación por defecto que imprime el área y el perímetro de la figura geométrica. Las clases que
implementan la interfaz `Shape` pueden optar por sobrescribir este método o utilizar la implementación por defecto.

### Funciones estáticas en interfaces

Las interfaces también pueden incluir funciones estáticas a partir de Java 8. Estas funciones se pueden llamar sin
crear una instancia de la interfaz. A continuación se muestra un ejemplo de cómo definir una función estática en una
interfaz:

```java
public interface MathUtils {
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }
}
```

En este ejemplo, hemos definido una interfaz `MathUtils` que contiene dos funciones estáticas: `add(int a, int b)` y
`subtract(int a, int b)`. Estas funciones se pueden llamar directamente utilizando la sintaxis `MathUtils.add(a, b)` o
`MathUtils.subtract(a, b)` sin necesidad de crear una instancia de la interfaz.

### Funciones privadas en interfaces

Las interfaces también pueden incluir funciones privadas a partir de Java 9. Estas funciones son útiles para
compartir código entre métodos de la misma interfaz sin exponerlo a las clases que implementan la interfaz. A
continuación se muestra un ejemplo de cómo definir una función privada en una interfaz:

```java
public interface Shape {
    double calculateArea();

    double calculatePerimeter();

    private void printDetails() {
        System.out.println("Área: " + calculateArea());
        System.out.println("Perímetro: " + calculatePerimeter());
    }

    default void display() {
        printDetails();
    }
}
```

En este ejemplo, hemos añadido un método privado `printDetails()` a la interfaz `Shape`. Este método se utiliza
para imprimir el área y el perímetro de la figura geométrica, pero no es accesible desde las clases que implementan
la interfaz. En su lugar, hemos añadido un método predeterminado `display()` que llama al método privado
`printDetails()`. Las clases que implementan la interfaz `Shape` pueden llamar al método `display()` para mostrar
los detalles de la figura geométrica.

## Resumen

Las interfaces en Java son una herramienta poderosa para definir un comportamiento común entre diferentes clases. Pueden
contener constantes, métodos abstractos, funciones predeterminadas, funciones estáticas y funciones privadas. Las
interfaces son útiles para crear un código más limpio y modular, y permiten la implementación de múltiples
herencias en Java. Al utilizar interfaces, podemos definir un contrato que las clases deben cumplir, lo que facilita
la creación de sistemas más flexibles y escalables.