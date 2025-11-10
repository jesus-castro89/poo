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

Se usa **backtracking** puro para llenar un tablero vacío con una solución válida.

Idea:

* Rellenas casillas de izquierda a derecha y de arriba abajo.
* En cada celda, intentas un número del 1 al 9 (en orden aleatorio).
* Si el número cumple las reglas del Sudoku (sin repetir en fila, columna, ni cuadrante 3×3), lo colocas y pasas a la
  siguiente celda.
* Si no puedes colocar ningún número, haces backtrack (retrocedes) y cambias el valor anterior.

✅ Al final obtienes un tablero completo y válido.

> Nota: Backtracking es un enfoque de fuerza bruta, pero es eficiente para este problema específico.
> {style="note"}

> Puedes usar un enfoque similar para eliminar números y crear diferentes niveles de dificultad. Sin embargo asegurarnos
> de que el Sudoku resultante tenga una única solución puede ser más complejo y requerir un análisis adicional.
> {style="warning"}

Por consiguiente en nuestro código implementaremos este algoritmo para generar el Sudoku, sin embargo, lo haremos
mediante el uso de dos clases iniciales:

* `Cell`: Representa una celda individual del Sudoku.
* `SudokuBoard`: Maneja la generación y visualización del tablero de Sudoku.

## 🧩 Concepto básico: Dificultad según cantidad de pistas

Un Sudoku tiene 81 celdas (9×9). Al eliminar números, dejamos solo “pistas” que el jugador puede usar para deducir el
resto.

| Nivel   | Cantidad de celdas vacías | Pistas visibles aproximadas | Definición                                                                                                     |
|---------|---------------------------|-----------------------------|----------------------------------------------------------------------------------------------------------------|
| Fácil   | 36 – 45                   | 36 – 45 vacías              | El jugador puede resolverlo casi sin hipótesis; la mayoría de los números se deducen por eliminación directa.  |
| Medio   | 30 – 35                   | 46 – 51 vacías              | Se requieren más pasos lógicos; algunos números deben deducirse por intersección o patrón.                     |
| Difícil | 22 – 29                   | 52 – 59 vacías              | Se necesita razonamiento avanzado (por ejemplo, cadenas o pares ocultos). Ideal para jugadores experimentados. |

📏 En términos de código, nosotros usaremos los siguientes valores:

| Nivel   | Celdas vacías | Celdas visibles |
|---------|---------------|-----------------|
| Fácil   | 36            | 45              |
| Medio   | 46            | 35              |
| Difícil | 54            | 27              |

> Estos valores son aproximados y pueden variar ligeramente según la implementación, pero proporcionan una buena base
> para definir la dificultad.
> {style="info"}

## Estructura del código

### Clase Cell

Para la clase `Cell`, que representa una celda individual del Sudoku, la definiremos de la siguiente manera:

* Atributos:
    - `row`: Fila de la celda.
    - `col`: Columna de la celda.
    - `value`: Valor actual de la celda (0 si está vacía).
    - `isFixed`: Indica si el valor es fijo (parte del Sudoku inicial) o puede ser modificado. Esto nos servira para
      diferenciar entre las celdas que el usuario puede cambiar y las que no para futuras implementaciones.
* Constructores:
    - `Cell(int row, int col, int value, boolean isFixed)`: Inicializa la celda con la fila, columna, valor y si es
      fija.
    - `Cell(int row, int col)`: Inicializa la celda con fila y columna, valor 0 y no fija.
* Métodos:
    - `isEmpty()`: Devuelve true si el valor es 0.
    - `getValue()`: Devuelve el valor de la celda.
    - `setValue(int value)`: Establece el valor de la celda.
    - `isFixed()`: Devuelve si la celda es fija.
    - `setFixed(boolean isFixed)`: Establece si la celda es fija.
    - `toString()`: Devuelve vacío si el valor es 0, o el valor como cadena.
    - `getAreaIndex()`: Devuelve el índice del área 3x3 a la que pertenece la celda.
        - Para calcular el índice del área 3x3, usamos la fórmula: `(row / 3) * 3 + (col / 3)`.
        - Esto divide el tablero en nueve áreas 3x3 y asigna un índice de 0 a 8 basados en la posición de la celda.
        - Por ejemplo, la celda en la fila 4, columna 5 pertenece al área 4 (segunda fila, segunda columna de áreas).

### Clase SudokuBoard

La clase `SudokuBoard` manejará la generación y visualización del tablero de Sudoku:

* Atributos:
    - `board`: Mapa de celdas del Sudoku del tipo `HashMap<String, Cell>`.
    - `rowContains`: BiPredicate para verificar si un número está en una fila.
    - `colContains`: BiPredicate para verificar si un número está en una columna.
    - `areaContains`: BiPredicate para verificar si un número está en un área 3x3.
* Constructores:
    - `SudokuBoard()`: Inicializa el tablero vacío y los predicados.
* Métodos:
    - `makeChecker(boolean iterateRows)`: Crea los predicados para verificar filas y columnas.
    - `key(int row, int col)`: Genera una clave única para una celda basada en su fila y columna.
    - `getCell(int row, int col)`: Devuelve la celda en la posición dada.
    - `isSafe(int row, int col, int num)`: Verifica si es seguro colocar un número en una celda.
    - `fillBoard()`: Llena el tablero usando backtracking.
    - `removeCells(int cellsToRemove)`: Elimina celdas para crear el Sudoku con la dificultad deseada.
    - `printBoard()`: Imprime el tablero en la consola.
    - `generateSudoku(int difficulty)`: Genera un Sudoku completo y luego elimina celdas según la dificultad.