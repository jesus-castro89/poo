# La superclase `Object`

En Java, todas las clases heredan de la clase `Object`. La clase `Object` es la superclase de todas las clases en Java y
proporciona métodos y funcionalidades comunes a todas las clases.

Por ejemplo, la clase `Object` tiene los siguientes métodos:

* `equals(Object obj)`: Comprueba si el objeto actual es igual al objeto especificado.
* `hashCode()`: Devuelve un valor hash para el objeto.
* `toString()`: Devuelve una representación en forma de cadena del objeto.
* `getClass()`: Devuelve la clase del objeto.
* `clone()`: Crea y devuelve una copia superficial del objeto.
* `finalize()`: Limpia los recursos antes de que el objeto sea eliminado por el recolector de basura.
* `notify()`, `notifyAll()`, `wait()`: Métodos para la sincronización de hilos.

Al heredar de la clase `Object`, una clase en Java obtiene automáticamente estos métodos y funcionalidades. Por ejemplo,
si no se define el método `equals` en una clase, la implementación predeterminada de `equals` de la clase `Object` se
utilizará para comparar objetos.

En resumen, la clase `Object` es la superclase de todas las clases en Java y proporciona métodos y funcionalidades
comunes a todas las clases. Al heredar de la clase `Object`, una clase en Java obtiene automáticamente estos métodos y
funcionalidades.

> **Nota**: La clase `Object` es una clase especial en Java y no es necesario extenderla explícitamente en una clase
> personalizada. Todas las clases en Java heredan de la clase `Object` de forma implícita. Por consiguiente, no es
> necesario utilizar la palabra clave `extends Object` al definir una clase en Java.
> {style="note"}

## Ejemplo

Supongamos que tenemos una clase `Persona` que tiene un atributo `nombre` y un método `saludar`. Podemos definir la
clase `Persona` de la siguiente manera:

```java
public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre);
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Juan");
        persona.saludar();
        // Llama al método toString de la clase Object
        System.out.println(persona);
    }
}
```

En este ejemplo, la clase `Persona` hereda de la clase `Object` de forma implícita. La clase `Persona` tiene un atributo
`nombre` y un método `saludar`. Al heredar de la clase `Object`, la clase `Persona` obtiene automáticamente los métodos
y funcionalidades de la clase `Object`.

## Conclusión

La clase `Object` es la superclase de todas las clases en Java y proporciona métodos y funcionalidades comunes a todas
las clases. Al heredar de la clase `Object`, una clase en Java obtiene automáticamente estos métodos y funcionalidades.
En la práctica, esto significa que no es necesario extender explícitamente la clase `Object` al definir una clase en
Java, ya que todas las clases heredan de la clase `Object` de forma implícita.