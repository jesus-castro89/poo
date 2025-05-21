# Actividad 12: Los sudokus Parte Final

Para esta última actividad del curso, deberemos de realizar una serie de cambios en el código que hemos
desarrollado en las actividades anteriores.

En concreto, la lógica de trabajo de las aplicaciones finales son la siguientes:

- La aplicación deberá solicitar mediante JOptionPane al usuario el nivel de dificultad del sudoku a generar.
- El nivel de dificultad del sudoku se representará mediante un tipo enum que contendrá los siguientes valores:
    - RESUELTO, 81 celdas visibles
    - FÁCIL, 70 celdas visibles
    - MEDIO. 60 celdas visibles
    - DIFÍCIL, 50 celdas visibles
- El sistema deberá generar un sudoku con una única solución y el número de celdas visibles según el nivel de dificultad
  seleccionado por el usuario.
- El sudoku generado se mostrará en un cuadro de diálogo.
- El sudoku generado se guardará en un archivo de texto con el nombre `sudoku.txt` y en un archivo `.sudoku` con el
  nombre `sudoku.sudoku`.

Por otra parte, deberemos de contar con otra función de la App que nos permita indicarle de ante mano la ubicación del
archivo `sudoku.sudoku` y que nos permita cargar el sudoku en memoria, y con ello resolverlo y mostrarlo en un cuadro de
diálogo.

## Desarrollo

1. La clase `SudokuGenerator` deberá contar ahora con las siguientes funciones:
    * `clearBoard`: Este método se encargará de limpiar el tablero del sudoku.
    * `shuffledNumbers`: Este método se encargará de devolver un array de enteros con los números del 1 al 9 en orden
      aleatorio.
    * `fillBoard`: Este método se encargará de llenar el tablero del sudoku con números aleatorios. Para ello, se te
      pide que utilices el método `shuffledNumbers` para obtener los números aleatorios y el método `isValid` de la
      clase `SudokuValidator` para verificar si el número es válido en la posición (fila, columna) según las reglas del
      sudoku.
    * `solveSudoku`: Este método recibirá como entrada un objeto de tipo `SudokuPuzzle` y se encargará de resolver el
      sudoku. Toma en cuenta que ya cuentas con la función `fillBoard` que se encargará de llenar el tablero del sudoku
      con números aleatorios.
    * `generateOneSolutionPuzzle`: Este método se encargará de generar un sudoku con una única solución. Para ello, se
      te pide que utilices el método `hasUniqueSolution` de la clase `SudokuValidator` para verificar si el sudoku
      contiene una única solución. Si el sudoku no tiene una única solución, el método `generateOneSolutionPuzzle` debe
      devolver null. Y el número de intentos debe ser de 10. Si el sudoku no tiene una única solución en 10 intentos,
      el método `generateOneSolutionPuzzle` debe devolver null.
2. La clase `SudokuValidator` deberá contar ahora con las siguientes funciones:
    * `isValid`: Este método se encargará de verificar si el número es válido en la posición (fila, columna) según las
      reglas del sudoku. Para ello, se te pide que implementes un algoritmo que verifique si el número es válido en la
      posición (fila, columna) según las reglas del sudoku.
    * `isValidRow`: Este método se encargará de verificar si el número es válido en la fila (fila) según las reglas del
      sudoku. Para ello, se te pide que implementes un algoritmo que verifique si el número es válido en la fila (fila)
      según las reglas del sudoku.
    * `isValidColumn`: Este método se encargará de verificar si el número es válido en la columna (columna) según las
      reglas del sudoku. Para ello, se te pide que implementes un algoritmo que verifique si el número es válido en la
      columna (columna) según las reglas del sudoku.
    * `isValidBox`: Este método se encargará de verificar si el número es válido en la caja (fila, columna) según las
      reglas del sudoku. Para ello, se te pide que implementes un algoritmo que verifique si el número es válido en la
      caja (fila, columna) según las reglas del sudoku.
    * `hasUniqueSolution`: Este método se encargará de verificar si el sudoku tiene una única solución. Para ello, se te
      pide que implementes un algoritmo de backtracking que verifique si el sudoku tiene una única solución. Si el
      sudoku tiene una única solución, el método debe devolver true, en caso contrario debe devolver false.
    * `countSolutions`: Este método se encargará de contar el número de soluciones que tiene el sudoku. Para ello, se te
      pide que implementes un algoritmo de backtracking que cuente el número de soluciones que tiene el sudoku. Si el
      sudoku tiene una única solución, el método debe devolver 1, en caso contrario debe devolver el número de
      soluciones que tiene el sudoku.
3. La clase `SudokuPuzzle` deberá contar ahora con los siguientes métodos:
    * `isSolved`: Este método se encargará de verificar si el sudoku está resuelto. Para ello, se te pide que
      implementes un algoritmo que verifique si el sudoku está resuelto. El método `isSolved` debe devolver true si el
      sudoku está resuelto, en caso contrario debe devolver false.
    * `applyDifficulty`: Este método se encargará de aplicar la dificultad al sudoku. Para ello, se te pide que
      implementes un algoritmo que aplique la dificultad al sudoku. El método `applyDifficulty` debe recibir como
      parámetro el nivel de dificultad del sudoku y devolver un objeto de tipo `SudokuPuzzle` que contenga el sudoku
      generado.
    * `setPuzzle`: Este método se encargará de establecer el sudoku en el objeto `SudokuPuzzle`. Para ello, se te pide
      que implementes un algoritmo que copie la matriz de entrada como sudoku en el objeto `SudokuPuzzle`.
    * `getPuzzle`: Este método se encargará de devolver el sudoku en el objeto `SudokuPuzzle`. Para ello, se te pide
      que implementes un algoritmo que devuelva la matriz de sudoku en el objeto `SudokuPuzzle`.
    * `getPrintablePuzzle`: Este método se encargará de devolver el sudoku en un formato imprimible. Para ello, se
      te pide que implementes un algoritmo que devuelva el sudoku en un formato imprimible.
4. La clase `SudokuSolver` deberá de contar ahora con los siguientes métodos:
    * `solve`: Este método se encargará de resolver el sudoku. Para ello, se te pide que implementes un algoritmo que
      resuelva el sudoku. El método `solve` debe devolver un objeto de tipo `SudokuPuzzle` que contenga el sudoku
      resuelto.
5. El Enumerado `SudokuDifficultyLevel` deberá de contar ahora con los siguientes valores:
    * `RESUELTO`, 81 celdas visibles
    * `FÁCIL`, 70 celdas visibles
    * `MEDIO` 60 celdas visibles
    * `DIFÍCIL`, 50 celdas visibles
    * Adicionalmente, el enumerado deberá de contar con un método `getCellsToRemove` que devolverá el número de celdas
      a eliminar según el nivel de dificultad del sudoku. Así como un método `getValues` que devolverá el arreglo de
      dificultades a elegir sin contar la opción `RESUELTO`. Y por último, su función `toString` deberá de devolver el
      nombre del nivel de dificultad y el número de celdas visibles.
6. La clase `SudokuApp` deberá de contar ahora con los siguientes métodos:
    * `start`: Este método se encargará de iniciar la aplicación. La función deberá solicitar un nivel de dificultad al
      usuario mediante un cuadro de diálogo y generar un sudoku con una única solución. El sudoku generado se
      mostrará en un cuadro de diálogo y se guardará en un archivo de texto con el nombre `sudoku.txt` y en un archivo
      `.sudoku` con el nombre `sudoku.sudoku`.
    * `load`: Este método se encargará de cargar el sudoku desde un archivo `.sudoku`. Para ello, se te pide que
      implementes un algoritmo que cargue el sudoku desde un archivo `.sudoku` y lo muestre en un cuadro de diálogo.
    * `populateSolution`: Este método se encargará de llenar el sudoku con los números del 1 al 9. Para ello, se te pide
      que implementes un algoritmo que llene el sudoku con los números del 1 al 9.
    * `exportSudoku`: Este método se encargará de exportar el sudoku a un archivo de texto. Para ello, se te pide que
      implementes un algoritmo que exporte el sudoku a un archivo de texto con el nombre `sudoku.txt` y un archivo
      `.sudoku` con el nombre `sudoku.sudoku`.

> NOTA: Recuerda agregar una exception para manejar los casos cuando un sudoku tiene más de una solución.

## Requisitos

- El sudoku debe de ser un rompecabezas de 9x9.
- El sudoku debe de ser un sudoku válido y completo.
- El sudoku puede ser mostrado en consola o JOptionPane, dependiendo de tu preferencia, pero utilizando caracteres
  ASCII para representar las celdas y contornos de la matriz.
- El sistema deberá exportar el sudoku a un archivo de texto con el nombre `sudoku.txt` y en un archivo `.sudoku` con el
  nombre `sudoku.sudoku`.
- El sistema deberá permitir cargar el sudoku desde un archivo `.sudoku`, resolverlo y mostrarlo en un cuadro de
  diálogo.

## Entregables

- Código fuente del sistema.
- Pruebas funcionales que demuestren el correcto funcionamiento de cada una de las funcionalidades.
- Portada con datos de identificación del equipo de trabajo.

## Criterios de Evaluación

| Criterio    | Descripción                                                   | Puntuación |
|-------------|---------------------------------------------------------------|------------|
| Portada     | Presentación y datos de identificación del equipo de trabajo. | 10%        |
| Código      | Calidad del código, modularidad y uso de buenas prácticas.    | 20%        |
| Pruebas     | Cobertura de pruebas funcionales y casos de prueba.           | 20%        |
| Modularidad | Separación de clases y responsabilidades.                     | 20%        |
| Exportar    | Exportación del sudoku a un archivo de texto.                 | 10%        |
| Cargar      | Carga del sudoku desde un archivo `.sudoku`.                  | 10%        |  
| Imprimir    | Presentación del sudoku en JOptionPane.                       | 10%        |
| **Total**   | **Total de puntos posibles.**                                 | **100%**   |

## Notas

- El sistema debe ser entregado en un archivo comprimido (zip) que contenga el código fuente y las pruebas.
- La fecha de entrega es el 28 de mayo de 2025 a las 23:59 horas.
- Trabajo entregado en fecha posterior no será tomado en cuenta.