# Constructores con entrada de datos

Como ya hemos visto, los constructores son funciones que permiten crear objetos, sin embargo, estos mismos constructores
pueden solicitar datos al usuario para inicializar los atributos de la clase. Esto es útil cuando se necesita crear un
objeto con valores específicos que no se conocen de antemano.

## Ejemplo de Constructor con Entrada de Datos

A continuación, se muestra un ejemplo de una clase `Persona` que tiene un constructor con entrada de datos:

```java
public class Persona {
    private String nombre;
    private int edad;

    // Constructor con entrada de datos
    public Persona() {
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        this.edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
        JOptionPane.showMessageDialog(null, "Persona creada con éxito.");
    }
    
    // Método para mostrar los datos de la persona
    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nEdad: " + edad);
    }
}
```

En este ejemplo, el constructor de la clase `Persona` solícita al usuario que ingrese el nombre y la edad de la persona
mediante la clase `JOptionPane` de Java. Una vez que se han ingresado los datos, se muestra un mensaje indicando que la
persona ha sido creada con éxito.

Para utilizar esta clase y crear un objeto de tipo `Persona`, se puede hacer lo siguiente:

```java
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.mostrarDatos();
    }
}
```

En este caso, se crea un objeto de tipo `Persona` llamado `persona` y se llama al método `mostrarDatos` para mostrar los
datos ingresados por el usuario.

## Conclusiones

Los constructores con entrada de datos son una forma de inicializar los atributos de una clase con valores específicos
proporcionados por el usuario. Esto permite crear objetos con datos personalizados y flexibles según las necesidades del
programador.