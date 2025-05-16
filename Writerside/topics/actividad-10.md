# Actividad 10: Los sudokus Parte 2

En la actividad previa teníamos una sola clase que se encargaba de crear, validar y mostrar el sudoku.
Sin embargo, de acuerdo a los principios SOLID, es mejor dividir la funcionalidad en varias clases.

En esta actividad, se te pide que dividas la funcionalidad de la clase Sudoku en varias clases, cada una con una
responsabilidad específica.

## Clases a crear

1. **SudokuGenerator**: Esta clase se encargará de generar un sudoku válido. Debe tener un método `generate` que
   devuelva una matriz de enteros representando el sudoku generado.
2. **SudokuValidator**: Esta clase se encargará de validar un sudoku. Debe tener un método `isValid` que tome una
   matriz de enteros y devuelva un booleano indicando si el sudoku es válido o no, para un valor concreto en una celda.
3. **SudokuPuzzle**: Esta clase se encargará de representar un sudoku como un rompecabezas. Debe tener un método
   `getPuzzle` que devuelva una matriz de enteros representando el sudoku. Además, debe tener un método `printSudoku`
   que imprima el sudoku en la consola, utilizando caracteres ASCII para representar las celdas y contornos de la
   matriz.

### "SudokuGenerator"

Esta clase deberá de contener el siguiente atributo:

- `sudoku`: una matriz de enteros que representa el sudoku generado.

Así mismo, las siguientes funciones:

- `generateSudoku` que generará un sudoku válido y lo almacenará en el atributo `sudoku`.
- `clearBoard` que limpiará el tablero de sudoku.
- `shuffledNumbers` que generará una lista de números del 1 al 9 en un orden aleatorio.
- `fillBoard(int row, int column)` que llenará el tablero de sudoku con números aleatorios.

> NOTA: Toma en consideración que el sudoku es un rompecabezas de 9x9, por lo que la matriz debe ser de 9x9.
> Así mismo, dicha matriz debe ser un atributo estático y final de la clase. Y sus funciones de igual manera,
> deben ser estáticas.

### "SudokuValidator"

Esta clase deberá de contener el siguiente atributo:

- `sudoku`: una matriz de enteros que representa el sudoku a validar.

Así mismo, las siguientes funciones:

- `isValid(int row, int column, int number)` que validará si el número es válido en la celda (row, column).
- `isRowValid(int row, int number)` que validará si el número es válido en la fila (row).
- `isColumnValid(int column, int number)` que validará si el número es válido en la columna (column).
- `isBoxValid(int row, int column, int number)` que validará si el número es válido en el cuadrante (box), en el que se
  encuentra la celda (row, column).

> NOTA: Al igual que la clase anterior, esta clase también debe de tener un atributo estático y final que contenga la
> matriz de sudoku a validar. Así como sus funciones deben de ser estáticas. Sin embargo, solo la función `isValid`
> deberá de ser pública, las demás deben de ser privadas.

### "SudokuPuzzle"

Esta clase deberá de contener el siguiente atributo:

- `sudoku`: una matriz de enteros que representa el sudoku a mostrar.

Así mismo, los siguientes constructores:

- `SudokuPuzzle()`: constructor que crear uná un sudoku válido y completo mediante el uso de las clases
  `SudokuGenerator` y `SudokuValidator`.
- `SudokuPuzzle(int visibleCells)`: constructor que recibe el número de celdas visibles y crea un sudoku
  válido y completo, pero con el número de celdas visibles especificado. El resto de las celdas deben de estar vacías.

Por último, la clase debe de tener las siguientes funciones:

- `printSudoku()`: que imprimirá el sudoku en la consola, utilizando caracteres ASCII para representar las celdas y
  contornos de la matriz.
- `getSudoku()`: que devolverá la matriz de enteros que representa el sudoku.
- `applyDifficulty(int visibleCells)`: que aplicará la dificultad al sudoku, eliminando el número de celdas visibles
  especificado.

> NOTA: Al igual que las clases anteriores, esta clase también debe de tener un atributo estático y final que
> contenga la matriz de sudoku a mostrar. Sin embargo, sus funciones no deben de ser estáticas. Ya que el objeto
> resultante de la clase `SudokuPuzzle` es el que se encargará de mostrar el sudoku.

> NOTA: La función `applyDifficulty` solo deberá de ser declarada ya que la implementación se realizará en la
> actividad 8.

## Requisitos

- El sudoku debe de ser un rompecabezas de 9x9.
- El sudoku debe de ser un sudoku válido y completo.
- El sudoku puede ser mostrado en consola o JOptionPane, dependiendo de tu preferencia, pero utilizando caracteres
  ASCII para representar las celdas y contornos de la matriz.

## Entregables

- Código fuente del sistema.
- Pruebas funcionales que demuestren el correcto funcionamiento de cada una de las funcionalidades.
- Portada con datos de identificación del equipo de trabajo.

## Criterios de Evaluación

| Criterio    | Descripción                                                   | Puntuación |
|-------------|---------------------------------------------------------------|------------|
| Portada     | Presentación y datos de identificación del equipo de trabajo. | 10%        |
| Código      | Calidad del código, modularidad y uso de buenas prácticas.    | 20%        |
| Pruebas     | Cobertura de pruebas funcionales y casos de prueba.           | 30%        |
| Modularidad | Separación de clases y responsabilidades.                     | 20%        |
| Impresión   | Presentación del sudoku en consola o JOptionPane.             | 20%        |
| **Total**   | **Total de puntos posibles.**                                 | **100%**   |

## Notas

- El sistema debe ser entregado en un archivo comprimido (zip) que contenga el código fuente y las pruebas.
- La fecha de entrega es el 21 de mayo de 2025 a las 23:59 horas.