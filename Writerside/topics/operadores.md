# Los Operadores en Java

Los operadores son símbolos que se utilizan para realizar operaciones sobre variables y valores en un programa. En Java,
los operadores se utilizan para realizar operaciones aritméticas, lógicas, de comparación y de asignación.

## Operadores aritméticos

Los operadores aritméticos se utilizan para realizar operaciones matemáticas sobre variables numéricas. Los operadores
aritméticos más comunes son:

- `+` (suma): Suma dos valores.
- `-` (resta): Resta un valor de otro.
- `*` (multiplicación): Multiplica dos valores.
- `/` (división): Divide un valor entre otro.
- `%` (módulo): Devuelve el resto de la división de un valor entre otro.

## Operadores de Incremento y Decremento

Los operadores de incremento y decremento se utilizan para aumentar o disminuir el valor de una variable en una unidad.
Los operadores de incremento y decremento más comunes son:

- `++` (incremento): Incrementa en uno el valor de una variable.
- `--` (decremento): Decrementa en uno el valor de una variable.

Estos operadores pueden utilizarse de dos formas:

- Prefijo: El operador se coloca antes de la variable (`++i`, `--i`), y se incrementa o decrementa el valor de la
  variable antes de realizar la operación.
- Postfijo: El operador se coloca después de la variable (`i++`, `i--`), y se incrementa o decrementa el valor de la
  variable después de realizar la operación.

Esto puede tener un impacto en el resultado de la operación, especialmente si la variable se utiliza en una expresión.

## Operadores de Asignación

Los operadores de asignación se utilizan para asignar un valor a una variable. Los operadores de asignación más comunes
son:

- `=` (asignación): Asigna un valor a una variable.
- `+=` (suma y asignación): Suma un valor a una variable y asigna el resultado.
- `-=` (resta y asignación): Resta un valor a una variable y asigna el resultado.
- `*=` (multiplicación y asignación): Multiplica un valor a una variable y asigna el resultado.
- `/=` (división y asignación): Divide un valor a una variable y asigna el resultado.
- `%=` (módulo y asignación): Calcula el módulo de un valor a una variable y asigna el resultado.

### Ejemplo

```java
int x = 5;
int y = 10;

x += y; // x = x + y
System.out.println(x); // 15

x -= y; // x = x - y
System.out.println(x); // 5

x *= y; // x = x * y
System.out.println(x); // 50

x /= y; // x = x / y
System.out.println(x); // 5

x %= y; // x = x % y
System.out.println(x); // 5
```

## Operadores de Comparación

Los operadores de comparación se utilizan para comparar dos valores y devolver un resultado booleano. Los operadores de
comparación más comunes son:

- `==` (igual a): Devuelve `true` si los valores son iguales.
- `!=` (distinto de): Devuelve `true` si los valores son distintos.
- `>` (mayor que): Devuelve `true` si el primer valor es mayor que el segundo.
- `<` (menor que): Devuelve `true` si el primer valor es menor que el segundo.
- `>=` (mayor o igual que): Devuelve `true` si el primer valor es mayor o igual que el segundo.
- `<=` (menor o igual que): Devuelve `true` si el primer valor es menor o igual que el segundo.
- `instanceof` (instancia de): Devuelve `true` si un objeto es una instancia de una clase.
- `equals` (igual a): Devuelve `true` si dos objetos son iguales.
- `compareTo` (comparar con): Devuelve un valor entero que indica si un objeto es menor, igual o mayor que otro.
- `contains` (contiene): Devuelve `true` si un objeto contiene otro.