# Las clases en Java

En Java el componente más básico y fundamental es la **clase**. Una clase es una plantilla o modelo que define las
propiedades y comportamientos de un objeto. En otras palabras, una clase es un molde a partir del cual se pueden crear
múltiples objetos con características similares.

## ¿Qué es una clase en Java?

Una clase en Java es un tipo de dato que define la estructura y el comportamiento de un objeto. En otras palabras,
una clase es un molde o plantilla a partir de la cual se pueden crear múltiples objetos con características similares.

Las clases en Java se definen utilizando la palabra clave `class`, seguida del nombre de la clase y un bloque de código
que contiene los atributos y métodos de la clase.

```java
public class [NombreDeLaClase] {
    // Atributos
    [modificadorDeAcceso] [TipoDeDato] [nombreDelAtributo];
    
    // Métodos
    [modificadorDeAcceso] [TipoDeDato] [nombreDelMetodo]([Parámetros]) {
        // Cuerpo del método
        return [ValorDeRetorno];// Opcional
    }
}
```

Donde:

- `[NombreDeLaClase]` es el nombre de la clase. Debe comenzar con una letra mayúscula y seguir la convención de nombres
  de Java, CamelCase.
- `[TipoDeDato]` es el tipo de dato de un atributo o método. Puede ser un tipo primitivo, un objeto o un tipo de dato
  definido por el usuario.
- `[nombreDelAtributo]` es el nombre de un atributo de la clase. Debe seguir la convención de nombres de Java,
  lowerCamelCase.
- `[modificadorDeAcceso]` es un modificador de acceso que define la visibilidad de un método. Puede ser `public`,
  `private` o `protected`.
- `[nombreDelMetodo]` es el nombre de un método de la clase. Debe seguir la convención de nombres de Java,
  lowerCamelCase.
- `[Parámetros]` son los parámetros que recibe un método. Pueden ser de cualquier tipo de dato y cantidad.
   - Recuerda que los parámetros se definen como `TipoDeDato nombreDelParámetro`. Y siguen el mismo formato que los
     atributos.
- `[ValorDeRetorno]` es el tipo de dato que devuelve un método. Puede ser un tipo primitivo, un objeto o un tipo de dato
  definido por el usuario. Este fragmento es opcional, y solo será util cuando el método devuelva un valor.

Por ejemplo, la siguiente es la definición de una clase simple en
Java:

```java
public class Persona {
    // Atributos
    private String nombre;
    private int edad;
    private double estatura;
    private double peso;
    
    // Constructor
    public Persona() {
        nombre = "";
        edad = 0;
        estatura = 0.0;
        peso = 0.0;
    }
    
    public Persona(String nombre, int edad, double estatura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
    }
    
    // Métodos
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " 
                            + edad + " años.");
        System.out.println("Mi estatura es " + estatura 
                            + " m y mi peso es " 
                            + peso + " kg.");
        System.out.println("Mi índice de masa corporal es " 
                            + calcularIMC());                    
    }
    
    private double calcularIMC() {
        return peso / (estatura * estatura);
    }
}
```

En este ejemplo, la clase `Persona` define un objeto con cuatro atributos (`nombre`, `edad`, `estatura` y `peso`) y
dos métodos (`saludar` y `calcularIMC`). El método `saludar` imprime un mensaje con la información de la persona,
mientras que el método `calcularIMC` calcula el índice de masa corporal de la persona.

> **Nota:** Los métodos `saludar` y `calcularIMC` tienen diferentes modificadores de acceso: `public` y `private`,
> respectivamente. Esto significa que el método `saludar` es accesible desde cualquier clase, mientras que el método
> `calcularIMC` solo es accesible desde la clase `Persona`.

> **Nota:** El método `calcularIMC` es un método privado, lo que significa que solo puede ser accedido desde la misma
> clase. Esto es útil cuando queremos encapsular la lógica de un método y evitar que sea modificado o accedido desde
> otras clases.

> **Nota:** Ambas funciones se generán respecto al contexto de la clase `Persona`. Por lo que si se desea acceder a
> ellas desde otra clase, se deberá crear un objeto de la clase `Persona` y acceder a ellas mediante dicho objeto.
> Además de que proveen una estructura clara y organizada para el código, mientras las funciones y atributos se
> definen de forma clara, semántica y coherente.

> **Nota:** En Java, los nombres de las clases deben comenzar con una letra mayúscula y seguir la convención de
> nomenclatura CamelCase, donde cada palabra en el nombre de la clase comienza con una letra mayúscula.

> **Recuerda que tanto los atributos como funciones deben estar dentro de la clase. Es decir, no pueden estar fuera
> de la clase. Este límite lo dictan las llaves `{}` que delimitan el cuerpo de la clase.**
> {style="warning"}

## Ejemplo de Clases

### Clase `Carro` de Forma Correcta

```java
public class Carro {
    // Atributos de la clase
    private String marca;
    private String modelo;
    private int anio;

    // Constructor de la clase
    public Carro(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    // Métodos de la clase
    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
    }
}
```

### Clase `Carro` de Forma Incorrecta

```java
public class Carro {
    private String marca;
    private String modelo;
    private int anio;
}

public void mostrarInformacion() {
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Año: " + anio);
}
```

Nota como en el segundo ejemplo, el método `mostrarInformacion` está fuera de la clase `Carro`, lo cual es incorrecto y
generará un error de compilación.

## Creación de objetos a partir de una clase

Una vez que hemos definido una clase en Java, podemos crear objetos a partir de esa clase utilizando la palabra clave
`new` seguida del constructor de la clase.

```java
[NombreDeLaClase] [nombreDelObjeto] = new [NombreDeLaClase]([Argumentos]);
```

Donde:

- `[NombreDeLaClase]` es el nombre de la clase a partir de la cual se creará el objeto.
- `[nombreDelObjeto]` es el nombre del objeto que se creará. Debe seguir la convención de nombres de Java,
  lowerCamelCase.
- `[Argumentos]` son los argumentos que se pasan al constructor de la clase. Estos argumentos deben coincidir con los
  parámetros del constructor de la clase.
   - Si la clase no tiene un constructor definido, se utilizará el constructor predeterminado sin argumentos.
   - Si la clase tiene un constructor definido, se debe proporcionar un constructor que coincida con la firma del
     constructor de la clase. La firma es el nombre del constructor y los tipos y número de parámetros que recibe.
- `[nombreDelObjeto].[nombreDelMetodo]([Argumentos])` es la forma de acceder a los métodos de un objeto.
   - `[nombreDelObjeto]` es el nombre del objeto creado.
   - `[nombreDelMetodo]` es el nombre del método al que se desea acceder. Y solo podremos acceder a los métodos que
     sean públicos.
   - `[Argumentos]` son los argumentos que se pasan al método. Estos argumentos deben coincidir con los parámetros del
     método.

Por ejemplo, para crear un objeto de la clase `Persona` y llamar al método `saludar`, podemos hacer lo siguiente:

```java
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 25, 1.75, 70.0);
        persona.saludar();
    }
}
```

En este ejemplo, creamos un objeto `persona` de la clase `Persona` con los valores `"Juan"`, `25`, `1.75` y `70.0`
para los atributos `nombre`, `edad`, `estatura` y `peso`, respectivamente. Luego, llamamos al método `saludar` del
objeto `persona`, que imprime un mensaje con la información de la persona.

> **Nota:** La creación de objetos a partir de una clase es fundamental en la programación orientada a objetos, ya que
> nos permite modelar entidades del mundo real como objetos con atributos y métodos. Al crear objetos a partir de una
> clase, podemos encapsular la lógica y el comportamiento de un programa de manera eficiente y reutilizable.

## ¿Cómo se si mi clase es correcta?

Para verificar si una clase en Java es correcta, podemos seguir los siguientes pasos:

1. Verificar la sintaxis de la clase:
   - Asegurarnos de que la clase comience con la palabra clave `class` seguida del nombre de la clase.
   - Verificar que los atributos y métodos estén definidos correctamente con los tipos de datos y nombres adecuados.
   - Comprobar que los métodos tengan un modificador de acceso válido (`public`, `private`, `protected`).
   - Revisar que los métodos tengan la estructura correcta con los parámetros y el valor de retorno adecuados.
2. Asegurarnos de que se haya creado al menos un objeto a partir de la clase.
   - Verificar que se haya utilizado la palabra clave `new` seguida del constructor de la clase.
   - Comprobar que se hayan proporcionado los argumentos correctos al constructor.
   - Verificar que se haya llamado a los métodos del objeto creado.
3. Ejecutar el programa y verificar que no haya errores de compilación ni de ejecución.
   - Compilar el programa y asegurarnos de que no haya errores de sintaxis.
   - Ejecutar el programa y verificar que los resultados sean los esperados.
4. Realizar pruebas adicionales para validar el comportamiento de la clase.

Al seguir estos pasos, podemos asegurarnos de que una clase en Java esté correctamente definida y se comporte de la
manera esperada.

> **Nota:** También es importante seguir las convenciones de codificación de Java al definir clases, atributos y
> métodos. Además de verificar que las funciones y atributos sean coherentes y estén bien definidos, además de
> relacionados con el contexto de la clase.

## Relación de Archivos y Clases

En Java, cada archivo fuente (`.java`) debe de contener **exactamente una clase pública**. Esta clase debe tener el
mismo nombre que el archivo fuente. Por ejemplo, si tenemos una clase `Persona`, el archivo fuente debe llamarse
`Persona.java`.

> **Nota:** Aunque es posible tener múltiples clases en un solo archivo fuente, solo una de ellas puede ser pública y
> debe tener el mismo nombre que el archivo. Las demás clases pueden ser privadas o tener un nivel de acceso
> restringido. Sin embargo, es una buena práctica tener una sola clase por archivo.

## Conclusión

Las clases son los componentes fundamentales de la programación orientada a objetos en Java. Permiten definir plantillas
o modelos que describen las propiedades y comportamientos de los objetos. Al crear una clase en Java, debemos definir
sus atributos y métodos, siguiendo las convenciones de nomenclatura y estructura de la clase.