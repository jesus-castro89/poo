# Actividad 11: El Juego de Ahorcado

## Descripción

El juego de ahorcado es un juego en el que el jugador debe adivinar una palabra, letra por letra. El jugador tiene un
número limitado de intentos para adivinar la palabra. Cada vez que el jugador adivina una letra, se muestra en la
palabra. Si el jugador adivina una letra que no está en la palabra, pierde un intento. Si el jugador adivina la palabra
antes de quedarse sin intentos, gana el juego.

## Objetivos

Desarrollar una aplicación que permita jugar al ahorcado. La aplicación debe mostrar la palabra a adivinar con guiones
en lugar de las letras. El jugador debe poder ingresar letras para adivinar la palabra. La aplicación debe mostrar las
letras adivinadas y los intentos restantes. La aplicación debe mostrar un mensaje de victoria si el jugador adivina la
palabra y un mensaje de derrota si el jugador se queda sin intentos.

## Requerimientos

1. La aplicación debe definir una lista de palabras a adivinar (al menos 5 palabras).
2. La aplicación debe seleccionar una palabra al azar de la lista de palabras.
3. La aplicación debe mostrar la palabra a adivinar con guiones en lugar de las letras.
4. La aplicación debe permitir al jugador ingresar letras para adivinar la palabra.
5. La aplicación debe mostrar las letras adivinadas y los intentos restantes.
    * Cada letra adivinada debe mostrarse en la palabra.
    * El número de intentos debe ser de al menos 5, pero puede ser mayor.
6. La aplicación debe mostrar un mensaje de victoria si el jugador adivina la palabra.
7. La aplicación debe mostrar un mensaje de derrota si el jugador se queda sin intentos.
8. La aplicación debe permitir al jugador jugar de nuevo.
9. La aplicación debe mostrar un mensaje de despedida cuando el jugador decide salir del juego.
10. La aplicación debe ser desarrollada en Java.
11. La aplicación debe ser desarrollada usando arreglos para almacenar las palabras a adivinar y las letras adivinadas.
12. La aplicación debe ser desarrollada usando funciones para dividir la lógica del juego en partes más pequeñas.
13. La aplicación debe ser desarrollada usando ventanas emergentes para mostrar mensajes al jugador (JOptionPane).
14. La aplicación debe guardar el registro de palabras seleccionadas.
15. La aplicación debe validar la entrada del jugador para asegurarse de que solo se ingresen letras válidas (A-Z, a-z).
16. La aplicación debe ser capaz de manejar tanto letras mayúsculas como minúsculas.
17. La aplicación debe evitar que el jugador ingrese la misma letra más de una vez.
18. La aplicación debe mostrar la palabra completa al final del juego, ya sea que el jugador gane o pierda.
19. La aplicación debe evitar el uso de palabras seleccionadas previamente en juegos anteriores durante la misma sesión.

## Metodología

Para el desarrollo de esta actividad, se recomienda seguir los siguientes pasos:

1. Definiremos una clase con tres arreglos:
    * uno para las palabras a adivinar
    * otro para las letras adivinadas
    * otro para las palabras ya seleccionadas.
    * NOTA: Pueden o no ser arreglos dinámicos.
2. La clase deberá contar con un número fijo de intentos máximos y el contador de intentos restantes.
3. De igual manera deberás mantener una variable para la palabra seleccionada en el juego actual y su representación con
   guiones.
4. Implementaremos métodos para:
    * Seleccionar una palabra al azar de la lista de palabras, asegurándonos de que no haya sido seleccionada
      previamente.
    * Mostrar la palabra a adivinar con guiones en lugar de las letras.
    * Permitir al jugador ingresar letras para adivinar la palabra, validando la entrada.
    * Mostrar las letras adivinadas y los intentos restantes.
    * Verificar si el jugador ha ganado o perdido el juego.
    * Permitir al jugador jugar de nuevo o salir del juego.

### Seleccionando una palabra al azar

Para la selección de una palabra al azar, podemos utilizar la clase `Random` de Java, para ello usaremos la función
`nextInt(VALUE)`, donde `VALUE` es el tamaño del arreglo de palabras. Esto nos devolverá un número entero aleatorio
entre `0` y `VALUE - 1`, que podemos usar como índice para seleccionar una palabra del arreglo.

> **Nota:** Aquí estamos tomando en cuenta que el índice del arreglo comienza en `0`, como es habitual en Java.
> Y que el índice máximo es el tamaño del arreglo menos `1`.
> {style="note"}

Por otro lado, para asegurarnos de que la palabra seleccionada no haya sido usada previamente, usaremos el arreglo de
palabras ya seleccionadas. Cada vez que seleccionemos una palabra, verificaremos si está en este arreglo. Si está,
seleccionaremos otra palabra hasta encontrar una que no haya sido usada.

> **Nota:** Para verificar si una palabra está en el arreglo de palabras ya seleccionadas, podemos usar un ciclo `for`
> para recorrer el arreglo y comparar cada palabra con la palabra seleccionada. O bien usar la clase `Arrays` de Java y
> su función `asList()` para convertir el arreglo en una lista y luego usar la función `contains()` para verificar si la
> palabra está en la lista. Aunque podemos ahorrarnos el uso de la clase `Arrays` si la lista en cuestión es un
`ArrayList`.
> {style="note"}

### Validando la entrada del jugador

Para validar la entrada del jugador, podemos usar la función `matches()` de la clase `String` para verificar si la
entrada es una letra válida de la `A` a la `Z` (mayúscula o minúscula), incluyendo la ñ y la Ñ. La expresión regular
para
esto sería `"^[a-zA-ZñÑ]$"`.

> **Nota:** La función `matches()` devuelve `true` si la cadena coincide con la expresión regular y `false` en caso
> contrario. Y que la expresión regular `"^[a-zA-ZñÑ]$"` verifica si la cadena contiene solo una letra válida.
> {style="note"}

Una vez entendido lo anterior, podemos crear un objeto de tipo `Predicate<String>` que contenga la expresión regular y
usar su método `test()` para validar la entrada del jugador.

> **Nota:** Un `Predicate` es una interfaz funcional en Java que representa una función que toma un solo argumento y
> devuelve un valor booleano. En este caso, el argumento es una cadena (la entrada del jugador) y el valor booleano
> indica si la cadena es una letra válida o no. Y ya contemos con nuestra clase `InputHandler` para la gestión de
> entradas, podemos incluir este `Predicate` como un atributo de la función de validación de entradas.
> {style="note"}

Si el usuario ingresa una letra válida, procederemos a verificar si ya ha sido adivinada previamente. Si es así,
mostraremos un mensaje indicando que la letra ya fue adivinada y solicitaremos una nueva entrada. Si la letra no ha sido
adivinada, la agregaremos al arreglo de letras adivinadas y procederemos a verificar si la letra está en la palabra a
adivinar.

Para ellos podemos hacer de la misma lógica que usamos para verificar si una palabra ya fue seleccionada previamente.
Pero en este caso, verificando si la letra ya está en el arreglo de letras adivinadas.

> **Nota:** Recuerda que las letras pueden ser un arreglo de caracteres (`char`) o un arreglo de cadenas (`String`),
> dependiendo de cómo decidas implementarlo.
> {style="note"}

### Agregando la letra adivinada a la palabra mostrada

Para agregar la letra adivinada a la palabra mostrada, podemos recorrer la palabra a adivinar y verificar si cada
letra coincide con la letra adivinada. Si coincide, reemplazamos el guion correspondiente en la palabra mostrada con la
letra adivinada.

Sin embargo, debemos de tomar en consideración que la letra puede ser una vocal o una consonante, y que puede aparecer
en mayúscula o minúscula en la palabra a adivinar. Por lo tanto, al comparar las letras, debemos ignorar el caso (
mayúscula o minúscula) y considerar las variantes de las vocales con acentos y/o diéresis.

> **Nota:** Para ignorar el caso al comparar las letras, podemos usar el método `equalsIgnoreCase()` de la clase
> `String`. Y para considerar las variantes de las vocales con acentos y/o diéresis, **podemos crear un método que
> normalice las letras, es decir, que convierta las letras con acentos y/o diéresis a su forma base (sin acentos ni
> diéresis) antes de compararlas**. Sin embargo, al mostrar la palabra al jugador, debemos mantener las letras con
> acentos y/o diéresis en su forma original.
> {style="note"}

## Entregables

1. Código fuente de la aplicación.
    * El código fuente debe estar organizado en clases y métodos, así como modularizado, es decir, debe estar dividido
      en partes más pequeñas y manejables dentro de archivos `.java`.
2. Capturas de pantalla de la aplicación en ejecución.
    * Incluir capturas de pantalla de la aplicación mostrando la palabra a adivinar, las letras adivinadas y los
      intentos restantes.
3. Portada con datos de identificación de los miembros del equipo.
4. Archivo PDF con los entregables 2 y 3.
5. El juego debe de implementarse en Java, por lo que no se aceptarán aplicaciones desarrolladas en otro lenguaje de
   programación.
6. El código fuente debe estar comentado y documentado.
7. El código fuente debe implementar el uso de la clase JOptionPane para mostrar mensajes al jugador.
    * La aplicación debe interactuar con el usuario a través de ventanas emergentes.
    * Otra interacción con el usuario no será evaluada.

## Criterios de Evaluación

| Criterio             | Descripción                                                                                 | Puntaje  |
|----------------------|---------------------------------------------------------------------------------------------|----------|
| Portada              | Datos de identificación de los miembros del equipo                                          | 5%       |
| Palabras             | Definición de la lista de palabras a adivinar                                               | 5%       |
| Selección            | Selección de una palabra al azar de la lista de palabras                                    | 5%       |
| Palabra              | Mostrar la palabra a adivinar con guiones en lugar de las letras                            | 10%      |
| Letras               | Permitir al jugador ingresar letras para adivinar la palabras y validar la entrada de datos | 10%      |
| Adivinadas           | Mostrar las letras adivinadas y los intentos restantes                                      | 10%      |
| Victoria             | Mostrar un mensaje de victoria si el jugador adivina la palabra                             | 10%      |
| Derrota              | Mostrar un mensaje de derrota si el jugador se queda sin intentos                           | 10%      |
| Jugar de nuevo       | Permitir al jugador jugar de nuevo                                                          | 10%      |
| Despedida            | Mostrar un mensaje de despedida cuando el jugador decide salir del juego                    | 10%      |
| Código fuente        | Código fuente de la aplicación                                                              | 5%       |
| Comentarios          | Código fuente comentado y documentado                                                       | 5%       |
| Capturas de pantalla | Capturas de pantalla de la aplicación en ejecución                                          | 5%       |
| **Total**            |                                                                                             | **100%** |

> **Nota:** La aplicación debe ser desarrollada en Java. No se aceptarán aplicaciones desarrolladas en otro lenguaje de
> programación.

> **Nota:** Recuerda que puedes hacer uso de las funciones de la clase Arrays de Java para trabajar con arreglos.

> Miembro del equipo que no aparece en la portada, no será evaluado.
> {style="warning"}

> Entregas fuera de la fecha límite, serán evaluadas sobre 70 puntos.
> {style="warning"}