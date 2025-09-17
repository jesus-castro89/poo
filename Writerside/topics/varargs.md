# Los argumentos variables (varargs)

Los argumentos variables (varargs) son una característica de Java que permite a un método recibir un número variable de
argumentos de un tipo específico. Esto es útil cuando se necesita pasar un número variable de argumentos a un método sin
tener que definir una lista de argumentos fija. En este tutorial, veremos cómo usar los argumentos variables en Java y
cuándo es útil utilizarlos.

## Sintaxis de los argumentos variables

![var_args.png](var_args.png){style="block"}

Los argumentos variables se definen en Java utilizando tres puntos (`...`) después del tipo de datos del argumento en la
lista de parámetros del método.

En este ejemplo, el método `printNumbers()` acepta un número variable de argumentos enteros. Los argumentos variables se
tratan como un array dentro del método, lo que permite iterar sobre ellos utilizando un bucle `for-each`.

## Pasar argumentos variables a un método

Para pasar argumentos variables a un método, se pueden proporcionar una lista de valores separados por comas. 

En este caso, el método `printNumbers()` recibirá los valores `1`, `2`, `3`, `4` y `5` como argumentos.

## Reglas para los argumentos variables

Algunas reglas a tener en cuenta al trabajar con argumentos variables en Java son las siguientes:

* Un método solo puede tener un parámetro de argumentos variables.
* El parámetro de argumentos variables debe ser el último parámetro en la lista de parámetros del método.
* Los argumentos variables se tratan como un array dentro del método, lo que permite acceder a ellos utilizando índices.
* Si se proporcionan argumentos fijos junto con los argumentos variables, los argumentos fijos deben ir antes de los
  argumentos variables en la lista de argumentos.
* Los argumentos variables se pueden combinar con otros tipos de argumentos en la lista de parámetros del método.
* Los argumentos variables se pueden utilizar con cualquier tipo de datos, incluidos tipos primitivos y objetos.
* Los argumentos variables no son lo mismo que un array, pero se pueden utilizar de manera similar en el código.
* Los argumentos variables se pueden utilizar en métodos estáticos y no estáticos.
* Los argumentos variables se pueden utilizar con métodos sobrecargados.
* Los argumentos variables se pueden utilizar con métodos que lanzan excepciones.
* Los argumentos variables se pueden utilizar con métodos genéricos.

En resumen, los argumentos variables son una característica útil de Java que permite a los métodos aceptar un número
variable de argumentos de un tipo específico. Esto simplifica la llamada a métodos con un número variable de argumentos
y hace que el código sea más flexible y fácil de mantener.

## Cuando usar argumentos variables

Los argumentos variables son útiles en situaciones en las que se necesita pasar un número variable de argumentos a un
método sin tener que definir una lista de argumentos fija. Algunos casos de uso comunes de los argumentos variables son:

* Métodos que realizan operaciones matemáticas con un número variable de operandos.
* Métodos que formatean cadenas de texto con un número variable de argumentos.
* Métodos que realizan operaciones con un número variable de objetos.
* Métodos que necesitan aceptar un número variable de valores de configuración.
* Métodos que necesitan aceptar un número variable de parámetros de entrada.
* Métodos que necesitan aceptar un número variable de valores de opciones.

En general, los argumentos variables son útiles cuando se necesita flexibilidad en la cantidad de argumentos que se
pueden pasar a un método y se desea simplificar la llamada al método sin tener que definir una lista de argumentos fija.

## Conclusión

Los argumentos variables son una característica útil de Java que permite a los métodos aceptar un número variable de
argumentos de un tipo específico. Esta característica simplifica la llamada a métodos con un número variable de
argumentos y hace que el código sea más flexible y fácil de mantener. Los argumentos variables son útiles en situaciones
en las que se necesita pasar un número variable de argumentos a un método sin tener que definir una lista de argumentos
fija, lo que los hace ideales para una amplia variedad de casos de uso en el desarrollo de software.