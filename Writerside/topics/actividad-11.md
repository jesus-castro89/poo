# Actividad 11: Los Sudokus Parte 3

En la actividad anterior dividimos la funcionalidad de la clase Sudoku en varias clases, cada una con una
responsabilidad específica.

En esta actividad no encargaremos de implementar una nueva funcionalidad en la que el sudoku generado cuente con
una unica solución. Para ello, se te pide que implementes la siguiente funcionalidad en la clase SudokuValidator:

* **hasUniqueSolution**: Este método se encargará de verificar si el sudoku tiene una única solución. Para ello, se te
  pide que implementes un algoritmo de backtracking que verifique si el sudoku tiene una única solución. Si el sudoku
  tiene una única solución, el método debe devolver true, en caso contrario debe devolver false.
* **countSolutions**: Este método se encargará de contar el número de soluciones que tiene el sudoku. Para ello, se te
  pide que implementes un algoritmo de backtracking que cuente el número de soluciones que tiene el sudoku. Si el sudoku
  tiene una única solución, el método debe devolver 1, en caso contrario debe devolver el número de soluciones que tiene
  el sudoku.

## Desarrollo

1. Agrega a la clase `SudokuValidator` los métodos `hasUniqueSolution` y `countSolutions`, así como el atributo
   `solutionCount` que se encargará de contar el número de soluciones que tiene el sudoku.
2. Implementa el método `countSolutions` utilizando un algoritmo de backtracking que cuente el número de soluciones que
   tiene el sudoku.
3. Implementa el método `hasUniqueSolution` utilizando el método `countSolutions` para verificar si el sudoku tiene una
   única solución.
4. Agrega a la clase `SudokuGenerator` el método `generateOneSolutionPuzzle` que se encargará de generar un sudoku
   con una única solución. Para ello, se te pide que utilices la clase `SudokuPuzzle` y definas un tipo enum para
   representar el nivel de dificultad del sudoku. El método `generateOneSolutionPuzzle` debe recibir como parámetro el
   nivel de dificultad del sudoku y devolver un objeto de tipo `SudokuPuzzle` que contenga el sudoku generado. El método
   `generateOneSolutionPuzzle` debe utilizar el método `generatePuzzle` de la clase `SudokuGenerator` para generar el
   sudoku y el método `hasUniqueSolution` de la clase `SudokuValidator` para verificar si el sudoku tiene una única
   solución. Si el sudoku no tiene una única solución, el método `generateOneSolutionPuzzle` debe volver a generar el
   sudoku hasta que tenga una única solución con un límite de intentos de 10. Si el sudoku no tiene una única solución
   en 10 intentos, el método `generateOneSolutionPuzzle` debe devolver null.

### La función `countSolutions`

La función `countSolutions` se encargará de contar el número de soluciones que tiene el sudoku. Para ello, se te pide
que implementes un algoritmo de backtracking que cuente el número de soluciones que tiene el sudoku. La función
`countSolutions` debe recibir como parámetro el sudoku y devolver el número de soluciones que tiene el sudoku.

Para ello toma el siguiente pseudocódigo como referencia:

```text
Función countSolutions(tablero: matriz de enteros, fila: entero, columna: entero)
    Definir siguienteFila, siguienteColumna como enteros

    Si fila no es igual a 9 entonces
        Si el contador de soluciones (solutionCount) es menor o igual a 1 entonces
            // Calcular siguiente celda
            siguienteFila ← (columna es 8) ? fila + 1 : fila
            siguienteColumna ← (columna + 1) módulo 9

            Si tablero[fila][columna] es diferente de 0 entonces
                // Celda ya está llena, continuar con la siguiente
                Llamar a countSolutions(tablero, siguienteFila, siguienteColumna)
            Sino
                // Probar los números del 1 al 9
                Para num desde 1 hasta 9 hacer
                    Si el número num es válido en la posición (fila, columna) según SudokuValidator entonces
                        tablero[fila][columna] ← num
                        Llamar a countSolutions(tablero, siguienteFila, siguienteColumna)
                        tablero[fila][columna] ← 0 // Retroceso (backtracking)
                    Fin Si
                Fin Para
            Fin Si
        Fin Si
    Sino
        // Si fila es 9, significa que ya recorrimos todo el tablero (solución completa)
        Incrementar solutionCount
    Fin Si
Fin Función
```

Toma en cuenta que el pseudocódigo anterior es solo una referencia y no es un código Java válido. Debes adaptarlo a
Java y a la estructura de tu clase `SudokuValidator`. Recuerda que el método `countSolutions` debe ser recursivo y
debe utilizar el algoritmo de backtracking para contar el número de soluciones que tiene el sudoku. Además, debes
implementar el método `hasUniqueSolution` utilizando el método `countSolutions` para verificar si el sudoku tiene una
única solución. Si el sudoku tiene una única solución, el método debe devolver true, en caso contrario debe devolver
false.

> NOTA: El algoritmo previo usa la variable global solutionCount inicializada en 0 antes de iniciar el proceso.