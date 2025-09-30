# Ejemplo 5: Uso de excepciones y validación de datos en constructores de clases

En este ejemplo, veremos cómo utilizar excepciones y validar datos en los constructores de clases en Java. Los
constructores son métodos especiales que se utilizan para inicializar objetos de una clase y pueden lanzar excepciones
si los datos proporcionados no son válidos.

### Ejemplo de validación de datos en un constructor

Supongamos que tenemos una clase `Person` que representa a una persona con un nombre y una edad. Queremos asegurarnos de
que el nombre no esté vacío y la edad sea mayor que cero al crear una instancia de la clase `Person`. Podemos hacerlo de
la siguiente manera:

```java
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (age <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que cero.");
        }

        this.name = name;
        this.age = age;
    }
}
```

En este ejemplo, el constructor de la clase `Person` valida los datos proporcionados y lanza una excepción
`IllegalArgumentException` si el nombre está vacío o la edad es menor o igual a cero. Esto garantiza que los objetos de
la clase `Person` se creen con datos válidos.

### Ejemplo de validación de datos en un constructor vació con setters

Supongamos la clase previa `Person` pero con un constructor vacío y setters para los atributos `name` y `age` que
soliciten mediante `JOptionPane` los datos al usuario y controlen las excepciones en caso de que los datos no sean
adecuados o incorrectos.

```java
import javax.swing.JOptionPane;

public class Person {

    private String name;
    private int age;

    public Person() {
    
        setName();
        setAge();
    }

    public void setName() {
    
        String input = JOptionPane.showInputDialog("Introduce el nombre:");
        try {
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            name = input;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            setName();
        }
    }

    public void setAge() {
    
        String input = JOptionPane.showInputDialog("Introduce la edad:");
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                throw new IllegalArgumentException("La edad debe ser mayor que cero.");
            }
            age = value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser un número entero.");
            setAge();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            setAge();
        }
    }
}
```

Analicemos el código:

* Creamos una función `setName` que solícita al usuario mediante `JOptionPane` el nombre y lo asigna al atributo `name`.
  Si el nombre está vacío, lanzamos una excepción `IllegalArgumentException` y mostramos un mensaje de error al usuario.
    * La línea:
      ```java
      String input = JOptionPane.showInputDialog("Introduce el nombre:");
      ```
      crea un cuadro de diálogo que solícita al usuario que introduzca un nombre y la respuesta se almacena en la
      variable local `input`.
    * Las líneas:
      ```java
      if (input == null || input.isEmpty()) {
          throw new IllegalArgumentException("El nombre no puede estar vacío.");
      }
      ```
      comprueban si el nombre es nulo o está vacío y lanza una excepción `IllegalArgumentException` si es así.
    * La línea:
      ```java
      name = input;
      ```
      asigna el nombre introducido por el usuario al atributo `name`.
    * La línea:
      ```java
      setName();
      ```
      vuelve a solicitar al usuario que introduzca un nombre si el nombre introducido es incorrecto.
* Creamos una función `setAge` que solícita al usuario mediante `JOptionPane` la edad y la asigna al atributo `age`. Si
  la edad no es un número entero o es menor o igual a cero, lanzamos una excepción `IllegalArgumentException` y
  mostramos un mensaje de error al usuario.
    * La línea:
      ```java
      String input = JOptionPane.showInputDialog("Introduce la edad:");
      ```
      crea un cuadro de diálogo que solícita al usuario que introduzca la edad y la respuesta se almacena en la variable
      local `input`.
    * Las líneas:
      ```java
      int value = Integer.parseInt(input);
      if (value <= 0) {
          throw new IllegalArgumentException("La edad debe ser mayor que cero.");
      }
      ```
      convierten la entrada del usuario a un número entero y comprueban si la edad es menor o igual a cero, lanzando una
      excepción `IllegalArgumentException` si es así. Y en caso de que la entrada no sea un número entero, se lanza una
      excepción `NumberFormatException`, la cual es capturada y se muestra un mensaje de error al usuario.
    * La línea:
      ```java
      age = value;
      ```
      asigna la edad introducida por el usuario al atributo `age`.
    * La línea:
      ```java
      setAge();
      ```
      vuelve a solicitar al usuario que introduzca la edad si la edad introducida es incorrecta.
* En el constructor vacío de la clase `Person`, llamamos a las funciones `setName` y `setAge` para solicitar al usuario
  que introduzca el nombre y la edad.
* En caso de que se lance una excepción `IllegalArgumentException` en las funciones `setName` o `setAge`, se captura la
  excepción y se muestra un mensaje de error al usuario. Luego, se vuelve a solicitar al usuario que introduzca el
  nombre o la edad. Y esto se repite hasta que el usuario introduzca datos válidos.

En este ejemplo, utilizamos los métodos `setName` y `setAge` para solicitar al usuario que introduzca el nombre y la
edad, respectivamente. Si los datos introducidos no son válidos, se lanzan excepciones `IllegalArgumentException` o
`NumberFormatException` y se muestra un mensaje de error al usuario. Esto garantiza que los objetos de la clase `Person`
se creen con datos válidos y evita que se creen objetos con datos incorrectos.

Es importante validar los datos en los constructores de clases para garantizar que los objetos se creen con datos
válidos y evitar errores en tiempo de ejecución. El uso de excepciones y la validación de datos son prácticas
relevantes en la programación orientada a objetos y nos permiten crear programas más robustos y seguros.