# Los Comparadores de la función `sort` en Java

La función `sort` de la clase `Arrays` en Java permite ordenar un arreglo de elementos de acuerdo a un comparador. Un
comparador es una interfaz funcional que define un método `compare` que recibe dos elementos y retorna un entero que
índica si el primer elemento es menor, igual o mayor que el segundo.

La interfaz `Comparator` en Java tiene un método estático llamado `comparing` que permite crear un comparador a partir
de una función que extrae una clave de un objeto. Por ejemplo, si tenemos una lista de objetos `Persona` y queremos
ordenarla por el atributo `nombre`, podemos hacerlo de la siguiente manera:

```java
import java.util.Arrays;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Persona[] personas = {
            new Persona("Juan", 25),
            new Persona("María", 30),
            new Persona("Pedro", 20)
        };

        Arrays.sort(personas, Comparator.comparing(Persona::getNombre));

        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " - " + persona.getEdad());
        }
    }
}
```

En este caso, la lista de personas se ordenará por el atributo `nombre` de cada objeto. Si queremos ordenarla por otro
atributo, simplemente debemos cambiar la función que se pasa como argumento a `comparing`.

Además, la interfaz `Comparator` tiene un método `reversed` que permite invertir el orden de un comparador. Por ejemplo,
si queremos ordenar la lista de personas por el atributo `edad` de mayor a menor, podemos hacerlo de la siguiente
manera:

```java
Arrays.sort(personas, Comparator.comparing(Persona::getEdad).reversed());
```

## Comparadores Personalizados

En algunos casos, puede ser necesario definir un comparador personalizado para ordenar una lista de objetos de acuerdo a
un criterio específico. Para ello, podemos implementar la interfaz `Comparator` y sobrescribir el método `compare`.

Por ejemplo, si queremos ordenar una lista de personas por la longitud de su nombre, podemos hacerlo de la siguiente
manera:

```java
import java.util.Comparator;

public class LongitudNombreComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona persona1, Persona persona2) {
        return Integer.compare(persona1.getNombre().length(), persona2.getNombre().length());
    }
}
```

```java
Arrays.sort(personas, new LongitudNombreComparator());
```

En este caso, la lista de personas se ordenará por la longitud de su nombre en orden ascendente.

Sin embargo, podemos usar cualquier tipo de comparador, por ejemplo, si queremos ordenar una lista de personas por la
primera letra de su nombre, podemos hacerlo de la siguiente manera:

```java
import java.util.Comparator;

public class PrimeraLetraNombreComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona persona1, Persona persona2) {
        return Character.compare(persona1.getNombre().charAt(0), persona2.getNombre().charAt(0));
    }
}
```

```java
Arrays.sort(personas, new PrimeraLetraNombreComparator());
```

En este caso, la lista de personas se ordenará por la primera letra de su nombre en orden ascendente.

En resumen, los comparadores son una forma de personalizar el ordenamiento de una lista de objetos en Java y permiten
definir criterios de ordenamiento específicos de acuerdo a las necesidades del programador. Además, la interfaz
`Comparator` proporciona métodos estáticos y de instancia que facilitan la creación y manipulación de comparadores de
forma sencilla y eficiente mediante expresiones lambda y referencias a métodos de las clases Wrapper.