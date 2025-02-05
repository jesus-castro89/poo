# Arreglos y Matrices

Los arreglos y matrices son estructuras de datos que permiten almacenar múltiples valores en una sola variable. Los
arreglos son colecciones de elementos del mismo tipo, mientras que las matrices son colecciones de arreglos.

## Arreglos

Un arreglo es una colección de elementos del mismo tipo que se almacenan en una sola variable. Cada elemento de un
arreglo se identifica por un índice que indica su posición en el arreglo. Los arreglos en Java se declaran de la
siguiente forma:

```java
// Declarar un arreglo de enteros
int[] numeros;
// Declarar un arreglo de cadenas
String[] palabras;
```

Para inicializar un arreglo, se utiliza la palabra clave `new` seguida del tipo de datos y la longitud del arreglo:

```java
// Inicializar un arreglo de enteros con 5 elementos
numeros = new int[5];
// Inicializar un arreglo de cadenas con 3 elementos
palabras = new String[3];
```

Aunque también podemos inicializar un arreglo con valores:

```java
// Inicializar un arreglo de enteros con valores
int[] numeros = {1, 2, 3, 4, 5};
// Inicializar un arreglo de cadenas con valores
String[] palabras = {"hola", "mundo"};
```

Para acceder a un elemento de un arreglo, se utiliza el índice del elemento entre corchetes:

```java
// Acceder al primer elemento del arreglo de enteros
int primerNumero = numeros[0];
// Acceder al segundo elemento del arreglo de cadenas
String segundaPalabra = palabras[1];
```

> **Nota:** Los índices de los arreglos en Java comienzan en cero.

> **Nota:** Los arreglos en Java son objetos, por lo que se almacenan en el montón (heap) y se accede a ellos mediante
> referencias.

### Recorrer un Arreglo

Para recorrer un arreglo, se puede utilizar un bucle `for` que itere sobre los elementos del arreglo:

```java
// Recorrer un arreglo de enteros   
for (int i = 0; i < numeros.length; i++) {
    System.out.println(numeros[i]);
}
// Recorrer un arreglo de cadenas
for (int i = 0; i < palabras.length; i++) {
    System.out.println(palabras[i]);
}
```

También se puede utilizar un bucle `for-each` para recorrer un arreglo:

```java
// Recorrer un arreglo de enteros
for (int numero : numeros) {
    System.out.println(numero);
}
// Recorrer un arreglo de cadenas
for (String palabra : palabras) {
    System.out.println(palabra);
}
```

### Ordenar un Arreglo

Para ordenar un arreglo, se puede utilizar el método `sort` de la clase `Arrays`:

```java
// Ordenar un arreglo de enteros
Arrays.sort(numeros);
// Ordenar un arreglo de cadenas
Arrays.sort(palabras);
```

Sin embargo, este método solo funciona con arreglos de tipos primitivos y objetos que implementen la interfaz
`Comparable`. Para ordenar arreglos de objetos que no implementen `Comparable`, se puede utilizar un comparador:

```java
// Ordenar un arreglo de objetos que no implementan Comparable
Arrays.sort(palabras, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
});
```

En el ejemplo anterior, se utiliza un comparador que compara las cadenas utilizando el método `compareTo`, el cual
devuelve un valor negativo si la primera cadena es menor que la segunda, cero si son iguales, y un valor positivo si la
primera cadena es mayor que la segunda.

Pero también puedes crear un comparador personalizado:

```java
// Crear un comparador personalizado
Comparator<String> comparador = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
};
// Ordenar un arreglo de cadenas con el comparador personalizado
Arrays.sort(palabras, comparador);
```

En el ejemplo anterior, se crea un comparador personalizado que compara las cadenas utilizando el método `compareTo`.
Pero puedes personalizar el comparador para que compare las cadenas de otra forma o bien puedes comparar otros tipos de
datos e incluso objetos de clases personalizadas.

Veamos el siguiente ejemplo:

```java
// Creamos la clase Persona
class Persona {
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

Ahora, vamos a crear un arreglo de objetos de la clase `Persona` y a ordenarlo utilizando un comparador personalizado:

```java
// Crear un arreglo de objetos de la clase Persona
Persona[] personas = {
    new Persona("Juan", 25),
    new Persona("María", 30),
    new Persona("Pedro", 20)
};

// Crear un comparador personalizado para ordenar las personas por edad
Comparator<Persona> comparador = new Comparator<Persona>() {
    @Override
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.getEdad(), p2.getEdad());
    }
};

// Ordenar el arreglo de personas con el comparador personalizado
Arrays.sort(personas, comparador);
```

En el ejemplo anterior, se crea un arreglo de objetos de la clase `Persona` y se ordena utilizando un comparador
personalizado que compara las personas por edad. El comparador utiliza el método `compare` de la clase `Integer` para
comparar las edades de las personas, pero puedes usar cualquier criterio de comparación que desees, siempre que devuelva
un valor negativo si el primer objeto es menor que el segundo, cero si son iguales, y un valor positivo si el primer
objeto es mayor que el segundo.

## Matrices

Las matrices o arreglos bidimensionales son arreglos de arreglos, es decir, colecciones de arreglos que se almacenan en
una sola variable. Las matrices en Java se declaran de la siguiente forma:

```java
// Declarar una matriz de enteros
int[][] matriz;
// Declarar una matriz de cadenas
String[][] palabras;
```

Para inicializar una matriz, se utiliza la palabra clave `new` seguida del tipo de datos y las dimensiones de la matriz:

```java
// Inicializar una matriz de enteros con 3 filas y 3 columnas
matriz = new int[3][3];
// Inicializar una matriz de cadenas con 2 filas y 2 columnas
palabras = new String[2][2];
```

Aunque también podemos inicializar una matriz con valores:

```java
// Inicializar una matriz de enteros con valores
int[][] matriz = {{1, 2, 3}, 
                  {4, 5, 6}, 
                  {7, 8, 9}};
// Inicializar una matriz de cadenas con valores
String[][] palabras = {{"hola", "mundo"}, 
                       {"adiós", "mundo"}};
```

Para acceder a un elemento de una matriz, se utiliza el índice de la fila y el índice de la columna entre corchetes:

```java
// Acceder al elemento en la primera fila y la primera columna de la matriz de enteros
int primerElemento = matriz[0][0];
// Acceder al elemento en la segunda fila y la segunda columna de la matriz de cadenas
String segundoElemento = palabras[1][1];
```

Entendamos entonces que una matriz es como un mapa de dos dimensiones, donde cada elemento se identifica por dos
coordenadas: la fila y la columna. Por ejemplo, en una matriz de 3x3, el elemento en la primera fila y la primera
columna se identifica como (0, 0), el elemento en la segunda fila y la segunda columna se identifica como (1, 1), y así
sucesivamente.

Así entonces el primer arreglo de número podemos ver de la siguiente manera:

```text
| 1 (0, 0) | 2 (0, 1) | 3 (0, 2) |
| 4 (1, 0) | 5 (1, 1) | 6 (1, 2) |
| 7 (2, 0) | 8 (2, 1) | 9 (2, 2) |
```

Siendo el primer número el elemento en la primera fila y la primera columna, el segundo número el elemento en la
primera fila y la segunda columna, y así sucesivamente. Y los índices de las filas y columnas comienzan en cero.

### Recorrer una Matriz

Para recorrer una matriz, se pueden utilizar dos bucles `for` anidados que iteren sobre las filas y las columnas de la
matriz:

```java
// Recorrer una matriz de enteros
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.println(matriz[i][j]);
    }
}
// Recorrer una matriz de cadenas
for (int i = 0; i < palabras.length; i++) {
    for (int j = 0; j < palabras[i].length; j++) {
        System.out.println(palabras[i][j]);
    }
}
```

También se puede utilizar un bucle `for-each` anidado para recorrer una matriz:

```java
// Recorrer una matriz de enteros
for (int[] fila : matriz) {
    for (int elemento : fila) {
        System.out.println(elemento);
    }
}
// Recorrer una matriz de cadenas
for (String[] fila : palabras) {
    for (String elemento : fila) {
        System.out.println(elemento);
    }
}
```

## Conclusiones

Los arreglos y matrices son estructuras de datos fundamentales en Java que permiten almacenar múltiples valores en una
sola variable. Los arreglos son colecciones de elementos del mismo tipo, mientras que las matrices son colecciones de
arreglos. Ambos tipos de estructuras se utilizan para almacenar y manipular datos de forma eficiente en programas Java.

Los arreglos y matrices en Java se declaran y se inicializan de forma similar, pero se acceden a sus elementos de manera
diferente. Los arreglos se acceden mediante un solo índice, mientras que las matrices se acceden mediante dos índices:
uno para la fila y otro para la columna.

Es importante recordar que los índices de los arreglos y matrices en Java comienzan en cero, por lo que el primer
elemento de un arreglo o matriz se identifica con el índice cero. Además, es fundamental tener en cuenta que los
arreglos en Java son objetos, por lo que se almacenan en el montón (heap) y se accede a ellos mediante referencias.

En resumen, los arreglos y matrices son estructuras de datos esenciales en Java que se utilizan para almacenar y
manipular datos de forma eficiente en programas Java. Conocer cómo declarar, inicializar, acceder, recorrer y ordenar
arreglos y matrices es fundamental para desarrollar aplicaciones Java efectivas y eficientes.