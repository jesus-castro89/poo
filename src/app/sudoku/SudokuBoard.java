package app.sudoku;

import app.sudoku.Cell;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Clase que representa un tablero de Sudoku.
 */
public class SudokuBoard {

    /**
     * Mapa que representa las celdas del tablero de Sudoku.
     */
    private final Map<String, Cell> board = new HashMap<>();
    /**
     * Generador de números aleatorios.
     */
    private final Random random = new Random();

    /**
     * Constructor para un tablero de Sudoku vacío.
     */
    public SudokuBoard() {
        // Inicializar el tablero vacío
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.put(key(row, col), new Cell(row, col, 0));
            }
        }
    }

    /**
     * Genera una clave única para una celda basada en su fila y columna.
     *
     * @param row Fila de la celda.
     * @param col Columna de la celda.
     * @return Clave única en formato "fila-columna".
     */
    private String key(int row, int col) {
        return row + "-" + col;
    }

    /**
     * Obtiene la celda en la posición especificada.
     *
     * @param row Fila de la celda.
     * @param col Columna de la celda.
     * @return Celda en la posición dada.
     */
    public Cell getCell(int row, int col) {
        return board.get(key(row, col));
    }

    /**
     * Imprime el tablero de Sudoku en la consola.
     */
    public void printBoard() {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) System.out.println("+-------+-------+-------+");
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) System.out.print("| ");
                System.out.print(getCell(row, col).toString() + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }

    /**
     * Generación completa del tablero de Sudoku mediante backtracking.
     *
     * @return true si el tablero se llenó correctamente, false en caso contrario.
     */
    public boolean fillBoard() {
        // Recorremos cada fila del tablero
        for (int row = 0; row < 9; row++) {
            // Recorremos cada columna de la fila actual
            for (int col = 0; col < 9; col++) {
                // Si la celda está vacía (valor 0)
                if (getCell(row, col).getValue() == 0) {
                    // Obtenemos una lista de números del 1 al 9 en orden aleatorio
                    List<Integer> numbers = getRandomNumbers();
                    // Intentamos colocar cada número en la celda
                    for (int num : numbers) {
                        // Verificamos si es seguro colocar el número en la celda
                        if (isSafe(row, col, num)) {
                            // Colocamos el número en la celda
                            getCell(row, col).setValue(num);
                            // Llamada recursiva para llenar el resto del tablero
                            if (fillBoard())
                                return true;
                            // Si no se pudo llenar, retrocedemos (backtrack)
                            getCell(row, col).setValue(0);
                        }
                    }
                    // Si ningún número es válido, retornamos false para retroceder
                    return false;
                }
            }
        }
        // Si todas las celdas están llenas, retornamos true
        return true;
    }

    /**
     * Genera una lista de números del 1 al 9 en orden aleatorio.
     *
     * @return Lista de números aleatorios del 1 al 9, en un orden mezclado.
     */
    private List<Integer> getRandomNumbers() {

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) nums.add(i);
        Collections.shuffle(nums);
        return nums;
    }

    /**
     * Verifica si es seguro colocar un número en una celda específica.
     *
     * @param row Fila del valor a verificar.
     * @param num Número a verificar.
     * @return true si es seguro, false en caso contrario.
     */
    private boolean isSafeRow(int row, int num) {
        return IntStream.range(0, 9).noneMatch(col -> getCell(row, col).getValue() == num);
    }

    /**
     * Verifica si es seguro colocar un número en una columna específica.
     *
     * @param col Columna del valor a verificar.
     * @param num Número a verificar.
     * @return true si es seguro, false en caso contrario.
     */
    private boolean isSafeCol(int col, int num) {
        return IntStream.range(0, 9).noneMatch(row -> getCell(row, col).getValue() == num);
    }

    /**
     * Verifica si es seguro colocar un número en una caja 3x3 específica.
     *
     * @param startRow Fila inicial de la caja 3x3.
     * @param startCol Columna inicial de la caja 3x3.
     * @param num      Número a verificar.
     * @return true si es seguro, false en caso contrario.
     */
    private boolean isSafeBox(int startRow, int startCol, int num) {
        return IntStream.range(startRow, startRow + 3).noneMatch(r -> IntStream.range(startCol, startCol + 3).anyMatch(c -> getCell(r, c).getValue() == num));
    }

    /**
     * Verifica si es seguro colocar un número en una celda específica.
     * Para el caso de las regiones sub-3x3, calcula la posición inicial de la caja mediante
     * la fórmula (row - row % 3, col - col % 3).
     * Por ejemplo, para la celda (5,7), la caja 3x3 correspondiente comienza en (3,6).
     * Y esto será así para toda celda dentro de esa caja.
     *
     * @param row Fila de la celda.
     * @param col Columna de la celda.
     * @param num Número a verificar.
     * @return true si es seguro, false en caso contrario.
     */
    private boolean isSafe(int row, int col, int num) {

        return isSafeRow(row, num) &&
                isSafeCol(col, num) &&
                isSafeBox(row - row % 3, col - col % 3, num);
    }

    // ---------------------------------------------------------
    // 2️⃣ Verificación de unicidad de la solución
    // ---------------------------------------------------------
    public int countSolutions() {
        return countSolutionsHelper(0);
    }

    private int countSolutionsHelper(int cellIndex) {
        if (cellIndex == 81) return 1;

        int row = cellIndex / 9;
        int col = cellIndex % 9;
        Cell cell = getCell(row, col);

        if (cell.getValue() != 0)
            return countSolutionsHelper(cellIndex + 1);

        int count = 0;
        for (int num = 1; num <= 9 && count < 2; num++) {
            if (isSafe(row, col, num)) {
                cell.setValue(num);
                count += countSolutionsHelper(cellIndex + 1);
                cell.setValue(0);
            }
        }
        return count;
    }

    // ---------------------------------------------------------
    // 3️⃣ Eliminación controlada de celdas
    // ---------------------------------------------------------
    public void removeCells(int targetBlanks) {
        List<String> positions = new ArrayList<>(board.keySet());
        Collections.shuffle(positions);

        for (String pos : positions) {
            if (getBlankCount() >= targetBlanks) break;

            Cell cell = board.get(pos);
            int backup = cell.getValue();
            cell.setValue(0);

            if (countSolutions() != 1) {
                cell.setValue(backup); // restaurar si pierde unicidad
            }
        }
    }

    private int getBlankCount() {
        int count = 0;
        for (Cell c : board.values())
            if (c.getValue() == 0) count++;
        return count;
    }
}
