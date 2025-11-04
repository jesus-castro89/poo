# Actividad 12: Generador de Sudokus en Java

## Objetivo

Desarrollar un programa en Java que genere tableros de Sudoku válidos de manera aleatoria.
De al menos tres dificultades: fácil, medio y difícil, para ellos usaremos un HashMap para almacenar las posiciones y
valores del Sudoku.
El programa debe permitir al usuario seleccionar la dificultad y mostrar el tablero generado en la consola.

## Requisitos

1. **Generación del tablero**:
    - Crear una función que genere un tablero de Sudoku válido.
    - Asegurarse de que el tablero cumpla con las reglas del Sudoku (cada número del 1 al 9 debe aparecer una sola vez
      en cada fila, columna y subcuadro 3x3).
2. **Dificultad**:
    - Implementar diferentes niveles de dificultad (fácil, medio, difícil) que determinen cuántos números se ocultan en
      el tablero generado.
3. **Uso de HashMap**:
    - Utilizar un `HashMap` para almacenar las posiciones (clave) y los valores (valor) del tablero de Sudoku.
4. **Interfaz de usuario**:
    - Permitir al usuario seleccionar la dificultad del Sudoku.
    - Mostrar el tablero generado en la consola de manera clara y legible.

## Algoritmo sugerido

El algoritmo para generar un Sudoku mediante un HashMap y Backtracking seguiremos los siguientes pasos:

1. **Inicialización**:
    - Crear un `HashMap<Integer, Integer>` para almacenar las posiciones y valores del Sudoku.
        - El clave será un número entero que representa la posición en el tablero (0-80 para un tablero 9x9).
        - El valor será el número del Sudoku (1-9) en esa posición.
    - Crear una función para imprimir el tablero de Sudoku en la consola.
        - Para esto, recorrer el `HashMap` y mostrar los valores en una estructura de 9x9.
        - Si una posición no tiene un valor asignado (`null`), mostrar un espacio en blanco o un punto.
2. **Generación del tablero completo**:
    - Implementar una función `generateFullBoard()` que utilice backtracking para llenar el `HashMap` con un Sudoku
      completo y válido.
        - Comenzar desde la primera posición (0) y tratar de asignar un número del 1 al 9.
        - Verificar si el número puede ser colocado en esa posición sin violar las reglas del Sudoku (verificar fila,
          columna y subcuadro 3x3).
        - Si el número es válido, asignarlo en el `HashMap` y proceder a la siguiente posición.
        - Si no se puede colocar ningún número válido, retroceder (backtrack) y probar con otro número en la posición
          anterior.
3. **Ocultación de números según la dificultad**:
    - Crear una función `removeNumbers(int difficulty)` que oculte números en el tablero generado según la dificultad
      seleccionada.
        - Definir cuántos números se deben ocultar para cada nivel de dificultad (por ejemplo, 40 para fácil, 50 para
          medio, 60 para difícil).
        - Seleccionar posiciones aleatorias en el `HashMap` y establecer su valor a `null` hasta alcanzar el número
          deseado de posiciones ocultas.
4. **Interfaz de usuario**:
    - Implementar una función `main()` que permita al usuario seleccionar la dificultad del Sudoku.
        - Llamar a `generateFullBoard()` para crear un tablero completo.
        - Llamar a `removeNumbers(difficulty)` para ocultar números según la dificultad seleccionada.
        - Llamar a la función de impresión para mostrar el tablero generado en la consola.