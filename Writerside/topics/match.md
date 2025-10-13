# La función Match en Java

La función `match` en Java no es una función incorporada en el lenguaje, pero el término "match" se utiliza comúnmente
en el contexto de expresiones regulares y coincidencias de patrones. En Java, las expresiones regulares se manejan a
través de la clase `Pattern` y la clase `Matcher` en el paquete `java.util.regex`.

## Uso de expresiones regulares en Java

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchExample {
    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";

        // Definir un patrón para buscar la palabra "fox"
        Pattern pattern = Pattern.compile("fox");
        Matcher matcher = pattern.matcher(input);

        // Verificar si hay una coincidencia
        if (matcher.find()) {
            System.out.println("Se encontró una coincidencia: " + matcher.group());
        } else {
            System.out.println("No se encontró ninguna coincidencia.");
        }

        // Ejemplo de uso de match en una lista de cadenas
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        String regex = "a.*e"; // Coincide con palabras que comienzan con 'a' y terminan con 'e'

        List<String> matchedWords = words.stream()
                .filter(word -> word.matches(regex))
                .collect(Collectors.toList());

        System.out.println("Palabras que coinciden con el patrón: " + matchedWords);
    }
}
```

## Descripción del código

- Se importa las clases necesarias del paquete `java.util.regex` para trabajar con expresiones regulares.
- Se define un patrón utilizando `Pattern.compile("fox")` para buscar la palabra "fox" en una cadena de texto.
- Se crea un `Matcher` a partir del patrón y la cadena de entrada.
- Se utiliza el método `find()` del `Matcher` para verificar si hay una coincidencia y se imprime el resultado.
- En el segundo ejemplo, se utiliza el método `matches` de la clase `String` para filtrar una lista de palabras que
  coinciden con un patrón específico (palabras que comienzan con 'a' y terminan con 'e').
- Se recopilan las palabras coincidentes en una lista y se imprimen.

## Expresiones regulares más comunes

| Objetivo              | Expresión Regular               | Descripción                                                                      |
|-----------------------|---------------------------------|----------------------------------------------------------------------------------|
| Número de teléfono    | `^\\d{3}-\\d{3}-\\d{4}$`        | Coincide con números de teléfono en formato 123-456-7890                         |
| Correo electrónico    | `^[\\w.-]+@[\\w.-]+\\.\\w{2,}$` | Coincide con direcciones de correo electrónico válidas                           |
| Solo letras           | `^[a-zA-Z]+$`                   | Coincide con cadenas que contienen solo letras                                   |
| Solo dígitos          | `^\\d+$`                        | Coincide con cadenas que contienen solo dígitos                                  |
| Fecha (YYYY-MM-DD)    | `^\\d{4}-\\d{2}-\\d{2}$`        | Coincide con fechas en formato YYYY-MM-DD                                        |
| Tarjeta de crédito    | `^\\d{4}-\\d{4}-\\d{4}-\\d{4}$` | Coincide con números de tarjeta de crédito en formato XXXX-XXXX-XXXX-XXXX        |
| Solo una palabra      | `^\\w+$`                        | Coincide con cadenas que contienen solo una palabra (sin espacios)               |
| De una a dos palabras | `^\\w+( \\w+)?$`                | Coincide con cadenas que contienen una o dos palabras (separadas por un espacio) |

## Conclusión

La función `match` en Java, a través del uso de expresiones regulares, es una herramienta poderosa para buscar y
manipular cadenas de texto. Permite realizar coincidencias de patrones complejos y es ampliamente utilizada en
validaciones y procesamiento de datos.