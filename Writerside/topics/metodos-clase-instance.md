# Métodos de Clase e Instancia en Java

En Java, los métodos pueden ser de dos tipos: métodos de clase (o métodos estáticos) y métodos de instancia. Ambos tipos
de métodos se definen dentro de una clase y se utilizan para realizar operaciones sobre los atributos de un objeto, pero
difieren en su forma de invocación y en su comportamiento.

## Métodos de Clase (Estáticos)

Los métodos de clase (o métodos estáticos) en Java se definen con la palabra clave `static` y pertenecen a la clase en
sí misma en lugar de a las instancias individuales de la clase. Esto significa que los métodos estáticos se pueden
llamar directamente a través del nombre de la clase, sin necesidad de crear una instancia de la clase.

### Sintaxis de Métodos Estáticos

La sintaxis para definir un método estático en Java es la siguiente:

```java
public static tipo_de_retorno nombre_del_metodo(parametros) {
    // Cuerpo del método
}
```

Donde:

* `public` es el nivel de acceso del método (puede ser `public`, `private`, `protected` o `default`).
* `static` indica que el método es estático y pertenece a la clase en sí misma.
* `tipo_de_retorno` es el tipo de dato que devuelve el método (puede ser cualquier tipo de dato válido en Java, o `void`
  si el método no devuelve nada).
* `nombre_del_metodo` es el nombre que se le da al método.
* `parametros` son los parámetros que recibe el método (pueden ser opcionales).
* `cuerpo_del_metodo` es el código que se ejecuta al llamar al método.

### Ejemplo de Métodos Estáticos

A continuación, se muestra un ejemplo de cómo se definen y utilizan métodos estáticos en Java:

```java
public class MiClase {

    public static int contador = 0;

    public static void incrementarContador() {
        contador++;
    }

    public static void main(String[] args) {
        incrementarContador();
        incrementarContador();
        System.out.println("Contador: " + contador);
    }
}
```

En este ejemplo, se define una clase `MiClase` con un método estático `incrementarContador` que incrementa el valor de
la variable estática `contador`. Al llamar al método `incrementarContador` dos veces y luego imprimir el valor de
`contador`, se obtendrá el resultado `2`.

## Métodos de Instancia

Los métodos de instancia en Java se definen sin la palabra clave `static` y pertenecen a las instancias individuales de
la clase. Esto significa que los métodos de instancia se invocan a través de una instancia específica de la clase y
pueden acceder a los atributos y métodos no estáticos de esa instancia.

## Resumen

En resumen, en Java existen dos tipos de métodos: métodos de clase (o métodos estáticos) y métodos de instancia. Los
métodos de clase se definen con la palabra clave `static` y pertenecen a la clase en sí misma, mientras que los métodos
de instancia se definen sin la palabra clave `static` y pertenecen a las instancias individuales de la clase. Ambos
tipos de métodos se utilizan para realizar operaciones sobre los atributos de un objeto, pero difieren en su forma de
invocación y en su comportamiento.

Los métodos de clase son útiles para definir operaciones que no dependen de una instancia específica de la clase,
mientras que los métodos de instancia son útiles para definir operaciones que dependen de los atributos de una instancia
particular. Al comprender la diferencia entre estos dos tipos de métodos, podemos diseñar clases más eficientes y
reutilizables en Java.