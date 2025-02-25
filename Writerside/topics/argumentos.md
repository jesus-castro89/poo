# Argumentos y paso de parámetros en Java

En Java, los argumentos y los parámetros son elementos clave en la definición y llamada de métodos. Los argumentos son
los valores que se pasan a un método cuando se llama, mientras que los parámetros son las variables que reciben esos
valores en la definición del método. En este tutorial, aprenderás cómo trabajar con argumentos y parámetros en Java.

## Definición de Parámetros de Método

Los parámetros de método en Java se definen entre paréntesis después del nombre del método. Cada parámetro se compone de
un tipo de dato y un nombre separados por un espacio. A continuación, se muestra un ejemplo de cómo se definen los
parámetros de método en Java:

```java
public void miMetodo(int parametro1, String parametro2) {
    // Cuerpo del método
}
```

En este ejemplo, el método `miMetodo` tiene dos parámetros: `parametro1` de tipo `int` y `parametro2` de tipo `String`.

## Paso de Argumentos a un Método

Cuando se llama a un método en Java, se pueden pasar argumentos que coincidan con los parámetros definidos en la
declaración del método. Los argumentos se colocan entre paréntesis después del nombre del método y se separan por comas.

A continuación, se muestra un ejemplo de cómo se pasan argumentos a un método en Java:

```java
public class MiClase {

    public void miMetodo(int parametro1, String parametro2) {
        // Cuerpo del método
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        obj.miMetodo(10, "Hola");
    }
}
```

En este ejemplo, se crea una instancia de la clase `MiClase` y se llama al método `miMetodo` con los argumentos `10` y
`"Hola"`.

## Pase por Referencia vs. Pase por Valor

En Java, los argumentos se pasan por valor, lo que significa que se pasa una copia del valor de la variable al método
en lugar de la variable en sí misma. Esto significa que cualquier cambio realizado en los parámetros dentro del método
no afectará a las variables originales fuera del método.

A continuación, se muestra un ejemplo que ilustra el pase por valor en Java:

```java
public class MiClase {

    public void miMetodo(int x) {
        x = x + 10;
        System.out.println("Dentro del método: " + x);
    }

    public static void main(String[] args) {
        MiClase obj = new MiClase();
        int y = 5;
        obj.miMetodo(y);
        System.out.println("Fuera del método: " + y);
    }
}
```

En este ejemplo, el valor de `y` se incrementa en `10` dentro del método `miMetodo`, pero el valor de `y` fuera del
método sigue siendo `5`.

Por su parte, el pase por referencia implica que se pasa la dirección de memoria de la variable al método, lo que
permite que el método modifique directamente la variable original. Java no admite el pase por referencia, pero se
pueden simular efectos similares utilizando objetos o arreglos.

## Conclusión

En resumen, los argumentos y los parámetros son elementos esenciales en la programación de Java. Al comprender cómo
trabajar con argumentos y parámetros, podrás crear métodos más flexibles y reutilizables en tus programas Java.