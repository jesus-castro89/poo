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
    - `existInRow`: BiPredicate para verificar si un número está en una fila.
        - Para crear este predicado, usaremos las funciones range y anyMatch de un IntStream.
        - El predicado tomará dos enteros: el índice de la fila y el número a verificar.
        - Usaremos `IntStream.range(0, 9).anyMatch(col -> getCell(row, col).getValue() == num)` para verificar si el
          número ya existe en la fila.
    - `existInColumn`: BiPredicate para verificar si un número está en una columna.
        - Para crear este predicado, usaremos la misma lógica que para las filas, pero iterando sobre las filas en lugar
          de las
          columnas.
        - El predicado tomará dos enteros: el índice de la columna y el número a verificar.
        - Usaremos `IntStream.range(0, 9).anyMatch(row -> getCell(row, col).getValue() == num)` para verificar si el
          número ya existe en la columna.
    - `existInBox`: BiPredicate para verificar si un número está en un área 3x3.
        - Para crear este predicado, usaremos dos bucles anidados para iterar sobre las filas y columnas del área
          3x3.
        - El predicado tomará dos enteros: el índice del área y el número a verificar.
        - Calcularemos la fila y columna inicial del área usando `startRow = (box / 3) * 3` y
          `startCol = (box % 3) * 3`.
        - Luego, usaremos dos bucles anidados para iterar sobre las filas y columnas del área 3x3 y verificar si el
          número ya existe.
        - Si encontramos el número, devolveremos true; de lo contrario, devolveremos false.
* Constructores:
    - `SudokuBoard()`: Inicializa el tablero vacío y los predicados.
* Métodos:
    - `key(int row, int col)`: Genera una clave única para una celda basada en su fila y columna.
        - Definimos la clave como una cadena en el formato "row-col".
    - `getCell(int row, int col)`: Devuelve la celda en la posición dada.
        - Recuperamos la celda del mapa `board` usando la clave generada por el método `key(row, col)`.
    - `isSafe(int row, int col, int num)`: Verifica si es seguro colocar un número en una celda.
        - Usando los predicados `existInRow`, `existInColumn` y `existInBox`, verificamos si el número ya existe en la
          fila,
          columna o área 3x3 correspondiente.
        - Si el número no existe en ninguna de estas, devolvemos true; de lo contrario, devolvemos false.
    - `fillBoard()`: Llena el tablero usando backtracking.
        - Recorremos cada celda del tablero, esto mediante dos bucles anidados para filas y columnas.
        - Obtenemos una lista de números del 1 al 9 y la mezclamos para asegurar aleatoriedad.
        - Si la celda está vacía (0), intentamos colocar números del 1 al 9 en orden aleatorio.
        - Para cada número, verificamos si es seguro colocarlo usando el método `isSafe`.
        - Si es seguro, colocamos el número en la celda y llamamos recursivamente a `fillBoard` para llenar la siguiente
          celda.
        - Si no podemos colocar ningún número, hacemos backtrack (retrocedemos) y restablecemos la celda a 0.
        - Si llenamos todo el tablero, devolvemos true.
    - `printBoard()`: Imprime el tablero en la consola.
        - Podemos usar la siguiente función para imprimir el tablero de manera legible:
    ```java
      public void printBoard() {
    
            StringBuilder sb = new StringBuilder();
            sb.append("╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n");
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (col % 3 == 0)
                        sb.append("║");
                    else
                        sb.append("│");
                    sb.append(String.format(" %s ", getCell(row, col).toString()));
                    if (col == 8)
                        sb.append("║\n");
                }
                switch (row) {
                    case 2, 5 -> sb.append("╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n");
                    case 8 -> sb.append("╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n");
                    default -> sb.append("╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
                }
            }
            IO.println(sb.toString());
      }
    ```

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

## Criterios de Evaluación

| Criterio          | Descripción                                                                                                             | Puntuación |
|-------------------|-------------------------------------------------------------------------------------------------------------------------|------------|
| Funcionalidad     | El programa genera tableros de Sudoku válidos y permite seleccionar la dificultad.                                      | 40%        |
| Uso de HashMap    | El programa utiliza un HashMap para almacenar las posiciones y valores del Sudoku.                                      | 20%        |
| Uso de Predicados | Se hace uso de  `BiPredicate` para la evaluación de existencia de un elemento dentro de una fila, columna o zona de 3x3 | 20%        |
| Documentación     | El código está bien comentado y documentado.                                                                            | 10%        |
| Presentación      | El informe y las capturas de pantalla están bien organizados y presentados.                                             | 10%        |
| **Total**         |                                                                                                                         | **100%**   |