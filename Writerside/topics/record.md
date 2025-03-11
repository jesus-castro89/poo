# ¿Qué son los records en Java?

Los records son una nueva característica introducida en Java 14 que permite definir clases de datos de forma concisa. Un
record es una clase que encapsula datos y proporciona métodos de acceso a esos datos, como getters y setters, de forma
automática. Los records son inmutables por defecto, lo que significa que una vez creados no se pueden modificar sus
valores.

Los records se definen utilizando la palabra clave `record` seguida del nombre de la clase y una lista de campos que
representan los datos que se van a encapsular. Por ejemplo, el siguiente código define un record llamado `Person` con
dos campos, `name` y `age`:

```java
public record Person(String name, int age) {
}
```

En este ejemplo, el record `Person` tiene dos campos, `name` de tipo `String` y `age` de tipo `int`. Los records
proporcionan automáticamente métodos `equals()`, `hashCode()`, `toString()` y getters para acceder a los campos. Por
ejemplo, se puede crear una instancia de `Person` y acceder a sus campos de la siguiente manera:

```java
Person person = new Person("Alice", 30);
String name = person.name();
int age = person.age();
System.out.println(person); // Imprime "Person[name=Alice, age=30]"
```

Los records son útiles cuando se necesita definir clases de datos simples y concisas. Permiten reducir la cantidad de
código necesario para definir una clase de datos y mejorar la legibilidad y mantenibilidad del código.

## Características de los records

Los records tienen varias características útiles que los hacen adecuados para representar clases de datos simples:

* **Concisión**: Los records permiten definir clases de datos de forma concisa, eliminando la necesidad de escribir
  getters, setters, `equals()`, `hashCode()` y `toString()` manualmente.
* **Inmutabilidad**: Los records son inmutables por defecto, lo que significa que una vez creados no se pueden modificar
  sus valores. Esto evita problemas de estado mutable y facilita el razonamiento sobre el código.
* **Desestructuración**: Los records permiten desestructurar instancias en expresiones lambda y de switch, lo que
  facilita el manejo de datos.
* **Interoperabilidad**: Los records son compatibles con las clases existentes de Java y se pueden utilizar en cualquier
  lugar donde se requiera una clase de datos.
* **Compatibilidad con patrones**: Los records son compatibles con patrones de diseño como Value Object y Data Transfer
  Object, lo que facilita su uso en aplicaciones empresariales.
* **Personalización**: Los records permiten personalizar su comportamiento mediante métodos y constructores
  personalizados, lo que permite adaptarlos a las necesidades específicas de una aplicación.
* **Serialización**: Los records son serializables por defecto, lo que facilita su uso en aplicaciones distribuidas y
  sistemas de almacenamiento.
* **Compatibilidad con interfaces**: Los records pueden implementar interfaces y métodos abstractos, lo que permite
  definir comportamientos específicos para cada clase de datos.
* **Propiedades**: Los records pueden tener propiedades asociadas que permiten acceder a información adicional sobre los
  datos encapsulados.
* **Métodos estáticos**: Los records pueden tener métodos estáticos que permiten realizar operaciones comunes con los
  datos encapsulados.

## Ejemplos de uso de records

A continuación se muestran algunos ejemplos de cómo se pueden utilizar los records en Java:

```java 
// Definir un record para representar una persona
record Person(String name, int age) {
}

// Crear una instancia de Person
Person person = new Person("Alice", 30);

// Acceder a los campos de la instancia
String name = person.name();
int age = person.age();

// Imprimir la instancia
System.out.println(person); // Imprime "Person[name=Alice, age=30]"
```

A continuación se muestra un ejemplo de cómo se pueden utilizar los records en una expresión lambda:

```java
// Crear una lista de personas
List<Person> people = List.of(new Person("Alice", 30), new Person("Bob", 25));

// Filtrar las personas mayores de 25 años
List<Person> filteredPeople = people.stream()
    .filter(person -> person.age() > 25)
    .collect(Collectors.toList());
```

A continuación se muestra un ejemplo de cómo se pueden utilizar los records en una expresión de switch:

```java
// Crear una instancia de Person
Person person = new Person("Alice", 30);

// Realizar una acción basada en el nombre de la persona
switch (person.name()) {
    case "Alice" -> System.out.println("Hola, Alice!");
    case "Bob" -> System.out.println("Hola, Bob!");
    default -> System.out.println("Hola, desconocido!");
}
```

A continuación se muestra un ejemplo de cómo se pueden personalizar los records con métodos y constructores
personalizados:

```java
// Definir un record con un constructor personalizado
public record Point(int x, int y) {
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordenadas inválidas");
        }
    }
    
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x() - x, 2) + Math.pow(other.y() - y, 2));
    }
}

// Crear una instancia de Point
Point point = new Point(10, 20);

// Acceder a los campos de la instancia
int x = point.x();
int y = point.y();

// Calcular la distancia a otra instancia de Point
Point other = new Point(30, 40);
double distance = point.distanceTo(other);

// Imprimir la instancia
System.out.println(point); // Imprime "Point[x=10, y=20]"
```

En estos ejemplos, se muestran diferentes formas de utilizar los records en Java. Los records se pueden utilizar para
representar personas, puntos, coordenadas, etc. Además, los records pueden tener métodos, constructores y propiedades
asociadas que permiten realizar operaciones específicas con los datos encapsulados.

## Constructores auxiliares

Los records pueden tener constructores auxiliares que permiten inicializar instancias de forma personalizada. Los
constructores auxiliares se definen utilizando la palabra clave `this` seguida de los parámetros del constructor. Por
ejemplo, el siguiente código define un record `Point` con un constructor auxiliar que inicializa las coordenadas a cero:

```java
public record Point(int x, int y) {
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordenadas inválidas");
        }
    }
    
    public Point (int x) {
        this(x, 0);
    }
}
```

En este ejemplo, el record `Point` tiene un constructor auxiliar que inicializa la coordenada `y` a cero si no se
proporciona un valor. Esto permite crear instancias de `Point` con una sola coordenada, como en el siguiente código:

```java
Point point = new Point(10);
System.out.println(point); // Imprime "Point[x=10, y=0]"
```

Los constructores auxiliares son útiles cuando se necesita inicializar instancias de forma personalizada o proporcionar
valores predeterminados para los campos de un record.

## Personalización de métodos

Los records pueden personalizar sus métodos `equals()`, `hashCode()` y `toString()` para adaptar su comportamiento a las
necesidades específicas de una aplicación. Para personalizar estos métodos, se pueden definir métodos con los mismos
nombres en el record. Por ejemplo, el siguiente código define un record `Person` con métodos personalizados para
comparar personas por edad:

```java
public record Person(String name, int age) {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person other = (Person) obj;
            return age == other.age();
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
    
    @Override
    public String toString() {
        return "Person[age=" + age + "]";
    }
}
```

En este ejemplo, el record `Person` personaliza los métodos `equals()`, `hashCode()` y `toString()` para comparar
personas por edad, calcular el código hash basado en la edad y mostrar solo la edad en la representación de cadena,
respectivamente.

## Interoperabilidad con clases existentes

Los records son compatibles con las clases existentes de Java y se pueden utilizar en cualquier lugar donde se requiera
una clase de datos. Los records pueden extender clases, implementar interfaces y tener métodos y campos adicionales. Por
ejemplo, el siguiente código define un record `Employee` que extiende la clase `Person` y agrega un campo adicional
`salary`:

```java
public record Employee(String name, int age, double salary) extends Person(name, age) {
}
```

En este ejemplo, el record `Employee` extiende la clase `Person` y agrega un campo `salary` adicional. Esto permite
utilizar el record `Employee` en lugar de la clase `Person` en cualquier lugar donde se requiera una clase de datos.

## Propiedades asociadas

Los records pueden tener propiedades asociadas que permiten acceder a información adicional sobre los datos
encapsulados. Las propiedades se definen utilizando la palabra clave `get` seguida del nombre de la propiedad. Por
ejemplo, el siguiente código define un record `Circle` con una propiedad `radius` que calcula el radio del círculo:

```java
public record Circle(double radius) {
    public double area() {
        return Math.PI * radius * radius;
    }
    
    public double circumference() {
        return 2 * Math.PI * radius;
    }
    
    public double radius() {
        return radius;
    }
}
```

En este ejemplo, el record `Circle` tiene una propiedad `radius` que permite acceder al radio del círculo. Esto facilita
el acceso a la información adicional sobre los datos encapsulados y mejora la legibilidad y mantenibilidad del código.

## Métodos estáticos

Los records pueden tener métodos estáticos que permiten realizar operaciones comunes con los datos encapsulados. Los
métodos estáticos se definen utilizando la palabra clave `static` seguida del nombre del método. Por ejemplo, el
siguiente código define un record `MathUtils` con un método estático `sum` que calcula la suma de dos números:

```java
public record MathUtils {
    public static int sum(int a, int b) {
        return a + b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
}
```

En este ejemplo, el record `MathUtils` tiene métodos estáticos `sum` y `multiply` que permiten realizar operaciones
comunes con los datos encapsulados. Esto facilita la reutilización de código y mejora la legibilidad y mantenibilidad
del código.

## ¿Cuándo utilizar records?

Los records son útiles cuando se necesita definir clases de datos simples y concisas, en otras palabras, cuando se
necesita representar datos que no cambian durante la vida útil de un programa. Los records son adecuados para
representar objetos inmutables, como personas, puntos, coordenadas, etc.

Los records son una buena opción cuando se necesita una clase de datos con métodos `equals()`, `hashCode()` y
`toString()`, getters y setters automáticos, y métodos personalizados. Los records son especialmente útiles cuando se
necesita definir clases de datos de forma concisa y mejorar la legibilidad y mantenibilidad del código.

## Conclusión

Los records son una característica poderosa y flexible de Java que permite definir clases de datos de forma concisa y
eficiente. Los records son útiles para representar datos simples y mejorar la legibilidad y mantenibilidad del código.
Al utilizar records, se puede reducir la cantidad de código necesario para definir clases de datos y mejorar la
productividad de los desarrolladores. En resumen, los records son una herramienta valiosa para simplificar el desarrollo
de aplicaciones en Java y mejorar la calidad del código.