# Los Predicados dobles en Java (BiPredicate)

En Java, un `BiPredicate` es una interfaz funcional que representa una función que toma dos argumentos y devuelve un
valor booleano. Es parte del paquete `java.util.function` y es útil cuando necesitas evaluar una condición que involucra
dos entradas.

## Definición de BiPredicate

```java
import java.util.function.BiPredicate;

BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
```

En este ejemplo, `isGreater` es un `BiPredicate` que toma dos enteros y devuelve `true` si el primer entero es mayor que
el segundo.

## Uso de BiPredicate

Puedes usar un `BiPredicate` para evaluar condiciones en diferentes contextos. Aquí hay algunos ejemplos:

### Ejemplo 1: Comparar dos números

```java
BiPredicate<Integer, Integer> isEqual = (a, b) -> a.equals(b);
System.out.

println(isEqual.test(5, 5)); // true
        System.out.

println(isEqual.test(5, 3)); // false
```

### Ejemplo 2: Verificar si la suma de dos números es par

```java
BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
System.out.

println(isSumEven.test(2, 4)); // true
        System.out.

println(isSumEven.test(2, 3)); // false
```

### Ejemplo 3: Validar si dos cadenas tienen la misma longitud

```java
BiPredicate<String, String> haveSameLength = (s1, s2) -> s1.length() == s2.length();
System.out.

println(haveSameLength.test("hello", "world")); // true
        System.out.

println(haveSameLength.test("hello", "java")); // false
```

## Composición de BiPredicates

Puedes combinar múltiples `BiPredicate` usando métodos como `and`, `or` y `negate`.

```java
BiPredicate<Integer, Integer> isPositive = (a, b) -> a > 0 && b > 0;
BiPredicate<Integer, Integer> isLessThanTen = (a, b) -> a < 10 && b < 10;
BiPredicate<Integer, Integer> isPositiveAndLessThanTen = isPositive.and(isLessThanTen);
System.out.

println(isPositiveAndLessThanTen.test(5, 7)); // true
        System.out.

println(isPositiveAndLessThanTen.test(5, 15)); // false
```

## Conclusión

El `BiPredicate` es una herramienta poderosa en Java para evaluar condiciones que involucran dos entradas. Su uso puede
hacer que tu código sea más limpio y expresivo, especialmente cuando trabajas con funciones lambda y programación
funcional.