# Las interfaces Comparable y Comparator en Java

Las interfaces `Comparable` y `Comparator` en Java se utilizan para definir el orden natural de los objetos y para
proporcionar una forma personalizada de comparar objetos, respectivamente. Estas interfaces son fundamentales cuando se
trabaja con colecciones que requieren ordenación, como listas y conjuntos.

## Interfaz Comparable

La interfaz `Comparable` se utiliza para definir el orden natural de los objetos de una clase. Una clase que implementa
`Comparable` debe sobrescribir el método `compareTo(T o)`, que compara el objeto actual con otro objeto del mismo tipo.

```java
public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona otra) {
        return Integer.compare(this.edad, otra.edad); // Ordenar por edad
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}
```

En este ejemplo, la clase `Persona` implementa `Comparable` y define el orden natural basado en la edad.

## Interfaz Comparator

La interfaz `Comparator` se utiliza para definir un orden personalizado para los objetos. A diferencia de `Comparable`,
que define un único orden natural, `Comparator` permite crear múltiples criterios de comparación.

```java
import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.nombre.compareTo(p2.nombre); // Ordenar por nombre
    }
}
```

En este ejemplo, `ComparadorPorNombre` implementa `Comparator` y define un criterio de comparación basado en el nombre.

## Uso de Comparable y Comparator

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Luis", 25));
        personas.add(new Persona("Carlos", 35));

        // Ordenar usando Comparable (por edad)
        Collections.sort(personas);
        System.out.println("Ordenado por edad: " + personas);

        // Ordenar usando Comparator (por nombre)
        Collections.sort(personas, new ComparadorPorNombre());
        System.out.println("Ordenado por nombre: " + personas);
    }
}
```