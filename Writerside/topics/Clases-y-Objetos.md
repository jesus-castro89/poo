# Clases y Objetos

Dentro del paradigma de la programación orientada a objetos, una clase es una plantilla para la creación de objetos de
datos según un modelo predefinido. Las clases se utilizan para representar entidades o conceptos. Cada clase es un
modelo que define un conjunto de variables y métodos apropiados para operar con dichos datos.

Un objeto es una instancia de una clase. Cuando se crea un objeto, se crea una copia de la clase, que se almacena en una
dirección de memoria específica. Cada objeto puede tener sus propios valores para las variables de la clase y puede
utilizar los métodos de la clase.

## Creación de una clase

En el caso de Java, la creación de una clase se realiza mediante la palabra clave `class`, seguida del nombre de la
clase. A continuación, se muestra un ejemplo de una clase llamada `Persona`:

```java

public class Persona {
    // Variables de instancia
    String nombre;
    int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }
}

```

En este ejemplo, la clase `Persona` tiene dos variables de instancia (`nombre` y `edad`), un constructor que inicializa
las variables de instancia y un método llamado `saludar` que imprime un mensaje por pantalla.

## Creación de un objeto

Para crear un objeto de la clase `Persona`, se utiliza la palabra clave `new`, seguida del nombre de la clase y de los
argumentos necesarios para el constructor. A continuación, se muestra un ejemplo de creación de un objeto de la clase
`Persona`:

```java

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 30);
        persona.saludar();
    }
}

```

En este ejemplo, se crea un objeto de la clase `Persona` llamado `persona` con el nombre "Juan" y la edad 30. A
continuación, se llama al método `saludar` del objeto `persona`, que imprime el mensaje **"Hola, mi nombre es Juan y
tengo 30 años."** por pantalla.

## Conclusiones

Las clases y objetos son elementos fundamentales en la programación orientada a objetos. Las clases se utilizan para
definir modelos de datos, mientras que los objetos se utilizan para representar instancias de dichos modelos. La
creación de una clase implica definir variables de instancia, un constructor y métodos apropiados para operar con los
datos. La creación de un objeto implica utilizar la palabra clave `new` seguida del nombre de la clase y de los
argumentos necesarios para el constructor.