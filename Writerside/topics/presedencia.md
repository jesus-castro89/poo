# Precedencia de Operadores

La precedencia de operadores determina el orden en que se evalúan las operaciones en una expresión. Los operadores con
mayor precedencia se evalúan primero, mientras que los operadores con menor precedencia se evalúan después.

Los operadores de mayor a menor en Java son:

1. Paréntesis `()`
2. Incremento `++`, Decremento `--`, Negación `!`, Complemento `~`
3. Multiplicación `*`, División `/`, Módulo `%`
4. Suma `+`, Resta `-`
5. Menor `<`, Menor o igual `<=`, Mayor `>`, Mayor o igual `>=`
6. Igual `==`, Distinto `!=`
7. Y lógico `&&`
8. O lógico `||`
9. Asignación `=`, Suma y asignación `+=`, Resta y asignación `-=`, Multiplicación y asignación `*=`, División y
   asignación `/=`, Módulo y asignación `%=`
10. Ternario `? :`
11. Coma `,`
12. Lambda `->`

### Ejemplo

```java
int x = 5;
int y = 10;
int z = 15;

int resultado = x + y * z; // 5 + (10 * 15) = 155
System.out.println(resultado);

resultado = (x + y) * z; // (5 + 10) * 15 = 225

boolean condicion = x > y && y < z; // false

int a = 5;
int b = 10;
int c = 15;

a += b * c; // a = a + (b * c)
System.out.println(a); // 155
```

En el primer caso, la multiplicación tiene mayor precedencia que la suma, por lo que se evalúa primero. En el segundo
caso, los paréntesis tienen mayor precedencia que la multiplicación, por lo que se evalúan primero. En el tercer caso,
el operador `&&` tiene mayor precedencia que `>`, por lo que se evalúa primero. En el cuarto caso, la multiplicación
tiene mayor precedencia que la suma y asignación, por lo que se evalúa primero.

La precedencia de operadores es importante para evitar errores y garantizar que las expresiones se evalúen
correctamente.

## Referencias

- [Java Operator Precedence](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- [Java Operators](https://www.w3schools.com/java/java_operators.asp)
- [Java Operators Precedence Table](https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html)
- [Java Operators Precedence and Associativity](https://www.geeksforgeeks.org/operators-in-java/)