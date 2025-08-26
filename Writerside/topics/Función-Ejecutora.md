# Función Ejecutora

Como notaste en el capítulo anterior, la función `main` es el punto de entrada de cualquier programa en Java. Es el
método que se ejecuta cuando se inicia un programa y es el encargado de iniciar la ejecución del resto del código.

## Sintaxis

La función `main` tiene la siguiente sintaxis:

```java

public class Main {
    public static void main(String[] args) {
        // Código a ejecutar
    }
}

```

En este ejemplo, la función `main` se define dentro de una clase llamada `Main`. La función es `public`, lo que
significa que es accesible desde cualquier parte del programa. Además, la función es `static`, lo que significa que
puede ser invocada sin necesidad de crear un objeto de la clase `Main`.

El parámetro `String[] args` es un arreglo de cadenas que se utiliza para pasar argumentos a la función `main`. Por
defecto, este parámetro se utiliza para pasar argumentos desde la línea de comandos al programa.

## Ejemplo

A continuación, se muestra un ejemplo de una función `main` que imprime un mensaje por pantalla:

```java

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola, mundo!");
    }
}

```

Cómo podrás notar, la función `main` imprime el mensaje **"Hola, mundo!"** por pantalla utilizando el método
`System.out.println`.

## Conclusiones

La función `main` es el punto de entrada de cualquier programa en Java. Es el método que se ejecuta cuando se inicia un
programa y es el encargado de iniciar la ejecución del resto del código. La función `main` se define dentro de una clase
y tiene la sintaxis `public static void main(String[] args)`. Además, la función puede recibir argumentos desde la línea
de comandos a través del parámetro `String[] args`.