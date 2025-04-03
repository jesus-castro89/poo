# ¿Qué son las interfaces funcionales?

En Java, una interfaz funcional es una interfaz que tiene exactamente un método abstracto. Estas interfaces son
utilizadas principalmente para representar funciones o comportamientos que pueden ser pasados como argumentos a métodos
o almacenados en variables. Las interfaces funcionales son una parte fundamental de la programación funcional en Java y
son ampliamente utilizadas en el contexto de las expresiones lambda y las referencias a métodos.

## Ejemplo de interfaz funcional

A continuación se muestra un ejemplo de una interfaz funcional en Java:

```java 

@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b);
}
``` 

En este ejemplo, hemos definido una interfaz funcional `Calculator` que tiene un único método abstracto `calculate(int
a, int b)`. Esta interfaz puede ser utilizada para representar cualquier operación de cálculo que tome dos enteros como
argumentos y devuelva un entero como resultado.

## Uso de interfaces funcionales

Las interfaces funcionales son comúnmente utilizadas con expresiones lambda. A continuación se muestra un ejemplo de
cómo utilizar la interfaz funcional `Calculator` con una expresión lambda:

```java
public class Main {
    public static void main(String[] args) {
        Calculator addition = (a, b) -> a + b;
        Calculator subtraction = (a, b) -> a - b;

        System.out.println("Suma: " + addition.calculate(5, 3)); // Salida: Suma: 8
        System.out.println("Resta: " + subtraction.calculate(5, 3)); // Salida: Resta: 2
    }
}
```

En este ejemplo, hemos creado dos instancias de la interfaz funcional `Calculator` utilizando expresiones lambda: una
para la suma y otra para la resta. Luego, hemos utilizado estas instancias para realizar cálculos y mostrar los
resultados en la consola.

## Ventajas de las interfaces funcionales

Las interfaces funcionales ofrecen varias ventajas, entre ellas:

- **Simplicidad**: Permiten representar comportamientos de manera concisa y legible utilizando expresiones lambda.
- **Flexibilidad**: Pueden ser utilizadas como argumentos para métodos, lo que permite crear código más modular y
  reutilizable.
- **Compatibilidad con programación funcional**: Facilitan la adopción de un estilo de programación funcional en Java,
  lo que puede llevar a un código más limpio y mantenible.
- **Compatibilidad con Streams**: Las interfaces funcionales son ampliamente utilizadas en la API de Streams de Java,
  lo que permite realizar operaciones en colecciones de manera más eficiente y expresiva.
- **Facilidad de uso**: Las interfaces funcionales son fáciles de implementar y utilizar, lo que las convierte en una
  herramienta poderosa para los desarrolladores de Java.
- **Mejora de la legibilidad**: El uso de expresiones lambda y referencias a métodos con interfaces funcionales puede
  mejorar la legibilidad del código al reducir la cantidad de código boilerplate necesario para implementar clases
  anónimas.
- **Facilitación de la programación concurrente**: Las interfaces funcionales son ideales para la programación
  concurrente, ya que permiten definir tareas que pueden ser ejecutadas en paralelo sin necesidad de crear clases
  adicionales.
- **Facilitación de la creación de APIs**: Las interfaces funcionales son útiles para crear APIs que permiten a los
  desarrolladores personalizar el comportamiento de las operaciones sin necesidad de modificar el código subyacente.
- **Mejora del rendimiento**: El uso de expresiones lambda y referencias a métodos puede mejorar el rendimiento al
  permitir que el compilador realice optimizaciones adicionales en el código generado.
- **Facilitación de la creación de patrones de diseño**: Las interfaces funcionales son útiles para implementar
  patrones de diseño como el patrón de estrategia, el patrón de comando y el patrón de observador, lo que permite crear
  sistemas más flexibles y escalables.

## Conclusión

Las interfaces funcionales son una herramienta poderosa en Java que permite representar comportamientos de manera
concisa y flexible. Su uso con expresiones lambda y referencias a métodos facilita la creación de código más limpio,
modular y reutilizable. Al adoptar un estilo de programación funcional, los desarrolladores pueden mejorar la
legibilidad, mantenibilidad y rendimiento de su código, lo que lleva a la creación de aplicaciones más eficientes y
escalables.