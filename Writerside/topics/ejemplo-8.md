# Ejemplo 8: Uso de diversos tipos de interfaces

## Descripción

En este ejemplo, se muestra cómo utilizar diferentes tipos de interfaces en un programa. Se definen varias interfaces y
se implementan en diferentes clases. Luego, se crean instancias de estas clases y se utilizan para demostrar el uso de
las interfaces.

## Código

### Animal.java

```java
public interface Animal {
    int ESPERANZA_DE_VIDA = 10; // constante de la interfaz

    void hacerSonido();

    default void dormir() {
        System.out.println("El animal está durmiendo.");
    }

    static void comer() {
        System.out.println("El animal está comiendo.");
    }
}
```

### Perro.java

```java
public class Perro implements Animal {

    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void dormir() {
        System.out.println("El perro está durmiendo.");
    }
}
```

### Gato.java

```java
public class Gato implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void dormir() {
        System.out.println("El gato está durmiendo.");
    }
}
```

### Main.java

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();
        animales.add(new Perro());
        animales.add(new Gato());

        animales.forEach(animal -> {
            animal.hacerSonido();
            animal.dormir();
        });

        Animal.comer(); // Llamada al método estático de la interfaz    
    }
}
```

> Nota: Asegúrate de que todas las clases estén en el mismo paquete o en paquetes apropiados para evitar problemas de
> importación. Así mismo, como podrás notar, puedes usar la interfaz `Animal` como tipo de referencia para almacenar
> diferentes implementaciones de la misma, como `Perro` y `Gato`, lo que permite un enfoque polimórfico en el código.

## Explicación

En este ejemplo, se define una interfaz `Animal` que contiene un método abstracto `hacerSonido()`, un método por defecto
`dormir()` y un método estático `comer()`. Luego, se crean dos clases `Perro` y `Gato` que implementan la interfaz
`Animal`. Cada clase proporciona su propia implementación del método `hacerSonido()` y también puede sobrescribir el
método por defecto `dormir()`. En la clase `Main`, se crean instancias de `Perro` y `Gato`, y se llaman a los métodos
definidos en la interfaz. También se llama al método estático `comer()` de la interfaz `Animal`.