# ¿Qué son las clases genéricas en Java?

Las clases genéricas en Java son una característica que nos permite definir clases, interfaces y métodos que operan
sobre un tipo de dato que se espécifica en el momento de la creación de la instancia. Esto nos permite reutilizar código
y escribir programas más genéricos y flexibles.

## ¿Por qué usar clases genéricas?

Las clases genéricas nos permiten escribir código que es más flexible y reutilizable. En lugar de escribir código
específico para un tipo de dato en particular, podemos escribir código que funciona con cualquier tipo de dato.

Por ejemplo, si queremos escribir una clase que almacene una lista de elementos, podemos usar una clase genérica para
definir la lista y luego especificar el tipo de dato en el momento de la creación de la instancia.

```java
public class Lista<T> {
    private List<T> elementos = new ArrayList<T>();

    public void agregarElemento(T elemento) {
        elementos.add(elemento);
    }

    public T obtenerElemento(int indice) {
        return elementos.get(indice);
    }
}
```

En este ejemplo, la clase `Lista` es genérica y puede almacenar cualquier tipo de dato. Podemos crear instancias de la
clase `Lista` para almacenar enteros, cadenas, objetos, etc.

```java
Lista<Integer> listaEnteros = new Lista<Integer>();
listaEnteros.agregarElemento(1);
listaEnteros.agregarElemento(2);
int primerElemento = listaEnteros.obtenerElemento(0);

Lista<String> listaCadenas = new Lista<String>();
listaCadenas.agregarElemento("hola");
listaCadenas.agregarElemento("mundo");
String primerElemento = listaCadenas.obtenerElemento(0);
```

## ¿Cómo se definen clases genéricas en Java?

Para definir una clase genérica en Java, se utiliza la sintaxis `<T>`, donde `T` es un parámetro de tipo que representa
el tipo de dato que se especificará en el momento de la creación de la instancia.

```java
public class NombreClase<T> {
    // Código de la clase
}
```

Los parámetros de tipo pueden tener cualquier nombre, pero es común utilizar una sola letra mayúscula para representar
el tipo de dato genérico.

## ¿Cómo se utilizan clases genéricas en Java?

Para utilizar una clase genérica en Java, se especifica el tipo de dato entre los corchetes angulares (`<>`) al crear
una instancia de la clase.

```java
NombreClase<TipoDato> nombreInstancia = new NombreClase<TipoDato>();
```

En este ejemplo, `NombreClase` es el nombre de la clase genérica, `TipoDato` es el tipo de dato que se especificará en
la instancia y `nombreInstancia` es el nombre de la instancia de la clase.

## ¿Qué son los métodos genéricos en Java?

Además de las clases genéricas, Java también permite definir métodos genéricos que operan sobre un tipo de dato
específico que se espécifica en el momento de la llamada al método.

```java
public <T> void imprimirElemento(T elemento) {
    System.out.println(elemento);
}
```

En este ejemplo, el método `imprimirElemento` es genérico y puede imprimir cualquier tipo de dato. El tipo de dato se
espécifica en el momento de la llamada al método.

```java
imprimirElemento(1); // Imprime: 1
imprimirElemento("hola"); // Imprime: hola
```

## Conclusión

Las clases genéricas en Java son una característica poderosa que nos permite escribir código más genérico y flexible.

Al utilizar clases genéricas, podemos escribir código que es más reutilizable y fácil de mantener. Además, las clases
genéricas nos permiten escribir programas más seguros, ya que el compilador puede detectar errores de tipo en tiempo de
compilación.

En resumen, las clases genéricas en Java son una herramienta poderosa que nos permite escribir código más genérico,
flexible y seguro.