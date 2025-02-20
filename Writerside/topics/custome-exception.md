# Excepciones Personalizadas

Una excepción personalizada es una excepción que se crea para manejar un caso específico en un programa. Aunque Java
proporciona muchas excepciones predefinidas, a veces es necesario crear una excepción personalizada para manejar
situaciones que no están cubiertas por las excepciones estándar.

## Creando una excepción personalizada

Para crear una excepción personalizada en Java, se debe crear una clase que extienda la clase `Exception` o una de sus
subclases. La clase personalizada debe tener un constructor que acepte un mensaje de error como argumento y llame al
constructor de la superclase con ese mensaje. A continuación se muestra un ejemplo de una excepción personalizada que
extiende la clase `Exception`:

```java
public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}
```

En este ejemplo, la clase `MyException` extiende la clase `Exception` y define un constructor que acepta un mensaje de
error como argumento y lo pasa al constructor de la superclase.

## Lanzando una excepción personalizada

Una vez que se ha creado una excepción personalizada, se puede lanzar en cualquier parte del código utilizando la
palabra clave `throw`. A continuación se muestra un ejemplo de cómo lanzar una excepción personalizada:

```java
public class MyExceptionExample {

    public static void main(String[] args) {
        try {
            throw new MyException("Este es un mensaje de error personalizado");
        } catch (MyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```