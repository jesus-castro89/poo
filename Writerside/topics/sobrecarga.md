# Sobrecarga de Métodos en Java

La sobrecarga de métodos en Java es una característica que permite definir múltiples métodos con el mismo nombre en una
clase, siempre y cuando tengan diferente cantidad o tipo de parámetros. Esto permite a los programadores utilizar el
mismo nombre de método para realizar operaciones similares en diferentes contextos.

## Reglas de Sobrecarga de Métodos

Para que dos métodos en Java puedan ser sobrecargados, deben cumplir con las siguientes reglas:

* Los métodos deben tener el mismo nombre.
* Los métodos deben estar en la misma clase.
* Los métodos deben tener diferente lista de parámetros (cantidad o tipo).
* Los métodos pueden tener diferente tipo de retorno.
* Los métodos pueden tener diferente nivel de acceso.
* Los métodos pueden lanzar diferentes excepciones.
* Los métodos no pueden ser sobrecargados solo por el tipo de retorno.
    - En Java, no se puede sobrecargar un método solo por el tipo de retorno, ya que el compilador no puede determinar
      cuál de los métodos sobrecargados se debe llamar en función del tipo de retorno.
    - Por ejemplo, los siguientes métodos no pueden ser sobrecargados:
    ```java
    public int miMetodo() {
        return 0;
    }
  
    public String miMetodo() {
        return "Hola";
    }
    ```
    - En este caso, el compilador no puede determinar cuál de los métodos `miMetodo` se debe llamar si se invoca con
      `miMetodo()`. Por lo tanto, este código no compilará.
* Los métodos no pueden ser sobrecargados solo por el nivel de acceso.
    - En Java, no se puede sobrecargar un método solo por el nivel de acceso, ya que el compilador no puede determinar
      cuál de los métodos sobrecargados se debe llamar en función del nivel de acceso.
    - Por ejemplo, los siguientes métodos no pueden ser sobrecargados:
    ```java
    public void miMetodo() {
        // Código
    }
  
    private void miMetodo() {
        // Código
    }
    ```
    - En este caso, el compilador no puede determinar cuál de los métodos `miMetodo` se debe llamar si se invoca con
      `miMetodo()`. Por lo tanto, este código no compilará.
* Los métodos no pueden ser sobrecargados solo por el lanzamiento de excepciones.
    - En Java, no se puede sobrecargar un método solo por el lanzamiento de excepciones, ya que el compilador no puede
      determinar cuál de los métodos sobrecargados se debe llamar en función de las excepciones lanzadas.
    - Por ejemplo, los siguientes métodos no pueden ser sobrecargados:
    ```java
    public void miMetodo() throws IOException {
        // Código
    }
  
    public void miMetodo() throws SQLException {
        // Código
    }
    ```
    - En este caso, el compilador no puede determinar cuál de los métodos `miMetodo` se debe llamar si se invoca con
      `miMetodo()`. Por lo tanto, este código no compilará.

## Ejemplo de Sobrecarga de Métodos

A continuación, se muestra un ejemplo de sobrecarga de métodos en Java:

```java
public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println(calc.sumar(5, 10));
        System.out.println(calc.sumar(3.5, 2.5));
        System.out.println(calc.sumar(1, 2, 3));
    }
}
```

En este ejemplo, la clase `Calculadora` define tres métodos `sumar` con diferentes listas de parámetros. Estos métodos
realizan operaciones de suma con diferentes tipos de datos y cantidades de parámetros. Al llamar a estos métodos con
diferentes argumentos, se invocará el método correspondiente en función de los parámetros proporcionados.

## Resumen

En resumen, la sobrecarga de métodos en Java permite definir múltiples métodos con el mismo nombre en una clase, siempre
y cuando tengan diferente cantidad o tipo de parámetros. Esto facilita la reutilización de nombres de métodos y la
implementación de operaciones similares en diferentes contextos. Sin embargo, es importante tener en cuenta las reglas
de sobrecarga de métodos para evitar conflictos y errores de compilación.