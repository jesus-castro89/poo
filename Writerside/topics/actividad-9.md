# Actividad 9: Los Sudokus Parte 1

## Descripción

Eres el encargado de desarrollar un sistema para resolver Sudokus. El sistema debe incluir las siguientes
funcionalidades:

1. **Generar Sudoku**: Permitir a los usuarios generar un Sudoku aleatorio de 9x9.
2. **Resolver Sudoku**: Permitir a los usuarios resolver un Sudoku ingresando los números en las posiciones
   correspondientes.
3. **Validar Sudoku**: Permitir a los usuarios validar si un Sudoku es correcto o no.
4. **Mostrar Sudoku**: Permitir a los usuarios mostrar el Sudoku en un formato legible.
5. **Guardar Sudoku**: Permitir a los usuarios guardar el Sudoku en un archivo de texto.

## Requisitos

- El sistema debe ser desarrollado en Java.
- Utilizar arreglos bidimensionales para almacenar el Sudoku.
- Utilizar JOptionPane para la interacción con el usuario.
- El sistema debe ser modular y seguir el principio de responsabilidad única.
- El Sudoku debe ser generado de forma aleatoria y debe cumplir con las reglas del Sudoku.
- El Sudoku debe ser resuelto utilizando un algoritmo de backtracking.
- El Sudoku debe ser validado verificando que no haya números repetidos en filas, columnas y subcuadrantes.
- El Sudoku debe ser mostrado en un formato legible utilizando JOptionPane.

## Desarrollo de la Actividad

Para este entregable crearemos el paquete `com.tec.games.sudoku`, y nos centraremos en crear la clase `SudokuGenerator`
que se encargará de generar un Sudoku aleatorio usando un algoritmo de backtracking. La clase debe incluir los
siguientes métodos:

- `generateSudoku()`: Genera un Sudoku aleatorio de 9x9.
- `isValid(int row, int col, int num)`: Verifica si es válido colocar un número en una
  posición específica.
- `isValidRow(int row, int num)`: Verifica si el número ya existe en la fila.
- `isValidColumn(int col, int num)`: Verifica si el número ya existe en la columna.
- `isValidBox(int row, int col, int num)`: Verifica si el número ya existe en el subcuadrante.
- `printSudoku()`: Imprime el Sudoku en un formato legible.

La clase debe de contar con los siguientes atributos:

* `int[][] sudoku`: Matriz que representa el Sudoku, recuerda que el Sudoku es una matriz de 9x9.

## Solución paso a paso

1. **Crear el paquete `com.tec.games.sudoku`**: En este paquete, define la clase `SudokuGenerator`.
2. **Implementar el método `generateSudoku()`**: Este método debe generar un Sudoku aleatorio de 9x9 utilizando
   un algoritmo de backtracking.
3. **Implementar el método `fillboard(int row, int col)`**: Este método debe llenar el Sudoku de forma recursiva.
    - Si la fila y la columna son mayores a 8, significa que se ha llenado todo el Sudoku y se debe retornar `true`.
    - Si la columna es mayor a 8, se debe incrementar la fila y reiniciar la columna a 0.
    - Se debe generar un número aleatorio entre 1 y 9 y verificar si es válido colocarlo en la posición (row, col).
    - Si es válido, se debe colocar el número en la posición (row, col) y continuar con el siguiente número.
    - Si no es válido, se debe intentar colocar otro número en la misma posición.
4. **Implementar el método `isValid(int row, int col, int num)`**: Este método debe verificar si es válido colocar un
   número en una posición específica del Sudoku.
5. **Implementar los métodos `isValidRow(int row, int num)`, `isValidColumn(int col, int num)` y
   `isValidBox(int row, int col, int num)`**: Estos métodos deben verificar si el número ya existe en la fila,
   columna o subcuadrante correspondiente.
6. **Implementar el método `printSudoku()`**: Este método debe imprimir el Sudoku en un formato legible utilizando
   JOptionPane.
7. **Crear una clase `Main`**: En esta clase, crea un menú de opciones que permita a los usuarios generar un Sudoku,
   resolverlo, validarlo y mostrarlo. Utiliza la clase `SudokuGenerator` para implementar la funcionalidad del sistema.

Las funciones `isValidRow`, `isValidColumn` y `isValidBox` deben de ser privadas, ya que no se utilizarán fuera de la
clase `SudokuGenerator`.

### isValidRow

La función `isValidRow` debe de verificar si el número ya existe en la fila, para ello se debe recorrer la fila y
comparar el número que se quiere colocar con los números que ya existen en la fila. Si el número ya existe, se
debe retornar `false`, de lo contrario se debe retornar `true`.

### isValidColumn

La función `isValidColumn` debe de verificar si el número ya existe en la columna, para ello se debe recorrer la
columna y comparar el número que se quiere colocar con los números que ya existen en la columna. Si el número ya
existe, se debe retornar `false`, de lo contrario se debe retornar `true`.

### isValidBox

La función `isValidBox` debe de verificar si el número ya existe en el subcuadrante, para ello se debe recorrer el
subcuadrante y comparar el número que se quiere colocar con los números que ya existen en el subcuadrante. Si el
número ya existe, se debe retornar `false`, de lo contrario se debe retornar `true`.

Para recorrer el subcuadrante se debe de saber en qué subcuadrante se encuentra la posición (row, col), para ello se
debe de dividir la fila y la columna entre 3, y multiplicar el resultado por 3. Por ejemplo, si la posición es
(4, 5), se debe de dividir 4 entre 3 y 5 entre 3, lo que nos da (1, 1). Luego se debe de multiplicar (1, 1) por
3, lo que nos da (3, 3). Por lo tanto, el subcuadrante es el que empieza en la posición (3, 3) y termina en la
posición (5, 5). Para recorrer el subcuadrante se debe de recorrer desde la posición (3, 3) hasta la posición
(5, 5).

### printSudoku

El método `printSudoku` debe de imprimir el Sudoku en un formato legible utilizando JOptionPane. Para ello se
debe de recorrer la matriz y concatenar los números en una cadena de texto. Luego se debe de mostrar la cadena de
texto en un JOptionPane. Para mostrar el Sudoku en un formato legible, se puede utilizar el siguiente formato:

```
———————————————————————————————————————
| 5 | 3 |   ||   | 7 |   ||   |   |   |
———————————————————————————————————————
| 6 |   |   || 1 | 9 | 5 ||   |   |   |
———————————————————————————————————————
|   | 9 | 8 ||   |   |   ||   | 6 |   |
=======================================
| 8 |   |   ||   | 6 |   ||   |   | 3 |
———————————————————————————————————————
| 4 |   |   || 8 |   | 3 ||   |   | 1 |
———————————————————————————————————————
| 7 |   |   ||   | 2 |   ||   |   | 6 |
=======================================
|   | 6 |   ||   |   |   || 2 | 8 |   |
———————————————————————————————————————
|   |   |   || 4 | 1 | 9 ||   |   | 5 |
———————————————————————————————————————
|   |   |   ||   | 8 |   ||   | 7 | 9 |
———————————————————————————————————————
```

## fillboard

El proceso de llenado del Sudoku se realiza de forma recursiva de la siguiente manera:

1. Se verifica si la fila es distinta de 9, lo que indica que hemos llenado todo el Sudoku, en cuyo caso se retorna
   `true`.
2. En caso contrario, tomamos un número aleatorio entre 1 y 9 y verificamos si es válido colocarlo en la posición (row,
   col).
3. Si es válido, colocamos el número en la posición (row, col) y llamamos recursivamente a `fillboard` con la
   siguiente posición
    * nextRow = (column == 8) ? row + 1 : row;
    * nextColumn = (column + 1) % 9;
4. Si la llamada recursiva retorna `true`, significa que hemos llenado el Sudoku correctamente y retornamos `true`.
5. Si la llamada recursiva retorna `false`, significa que no hemos podido llenar el Sudoku, por lo que debemos
   eliminar el número colocado en la posición (row, col), por lo que lo igualamos a 0 y continuar con el siguiente
   número.
6. Si no hemos podido colocar ningún número en la posición (row, col), retornamos `false`.

El proceso previo se ejemplifica en el siguiente código:

```java
public boolean fillboard(int row, int column) {
    if (row == 9) {
        return true;
    }
    int nextRow = (column == 8) ? row + 1 : row;
    int nextColumn = (column + 1) % 9;
    for (int i = 1; i <= 9; i++) {
        int num = (int) (Math.random() * 9 + 1);
        if (isValid(row, column, num)) {
            sudoku[row][column] = num;
            if (fillboard(nextRow, nextColumn)) {
                return true;
            }
            sudoku[row][column] = 0;
        }
    }
    return false;
}
```

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
| Modularidad | Uso de arreglos bidimensionales.                              | 20%        |
| Interacción | Uso de JOptionPane para la interacción con el usuario.        | 20%        |
| Total       |                                                               | **100%**   |

## Notas

- El sistema debe ser entregado en un archivo comprimido (zip) que contenga el código fuente y las pruebas.
- La fecha de entrega es el 14 de mayo de 2025 a las 23:59 horas.