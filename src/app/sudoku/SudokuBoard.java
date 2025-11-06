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
                if (getCell(row, col).isEmpty()) {
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
        IntStream.range(1, 10).forEach(nums::add);
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
        return IntStream.range(0, 9)
                .noneMatch(col -> getCell(row, col).getValue() == num);
    }

    /**
     * Verifica si es seguro colocar un número en una columna específica.
     *
     * @param col Columna del valor a verificar.
     * @param num Número a verificar.
     * @return true si es seguro, false en caso contrario.
     */
    private boolean isSafeCol(int col, int num) {
        return IntStream.range(0, 9)
                .noneMatch(row -> getCell(row, col).getValue() == num);
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
        return IntStream.range(startRow, startRow + 3)
                .noneMatch(r -> IntStream.range(startCol, startCol + 3)
                        .anyMatch(c -> getCell(r, c).getValue() == num));
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

        int startBoxRow = row - row % 3;
        int startBoxCol = col - col % 3;
        return isSafeRow(row, num) &&
                isSafeCol(col, num) &&
                isSafeBox(startBoxRow, startBoxCol, num);
    }

    /**
     * Cuenta el número de soluciones posibles para el tablero actual.
     *
     * @return Número de soluciones (0, 1 o más).
     */
    public int countSolutions() {
        return countSolutionsHelper(0);
    }

    /**
     * Función recursiva auxiliar para contar soluciones.
     *
     * @param cellIndex Índice lineal de la celda actual (0-80).
     * @return Número de soluciones encontradas desde esta celda en adelante.
     */
    private int countSolutionsHelper(int cellIndex) {
        // Si hemos llegado al final del tablero, hemos encontrado una solución
        if (cellIndex == 81) return 1;
        // En otro caso, obtenemos la fila y columna de la celda actual
        int row = cellIndex / 9;
        int col = cellIndex % 9;
        Cell cell = getCell(row, col);
        // Si la celda ya tiene un valor, pasamos a la siguiente celda
        if (cell.getValue() != 0)
            return countSolutionsHelper(cellIndex + 1);
        // Si la celda está vacía, intentamos colocar números del 1 al 9
        int count = 0;
        // Contamos las soluciones encontradas
        for (int num = 1; num <= 9 && count < 2; num++) {
            // Verificamos si es seguro colocar el número
            if (isSafe(row, col, num)) {
                // Colocamos el número y continuamos recursivamente
                cell.setValue(num);
                // Sumamos las soluciones encontradas en la siguiente celda
                count += countSolutionsHelper(cellIndex + 1);
                // Restauramos la celda a vacía (backtrack)
                cell.setValue(0);
            }
        }
        // Retornamos el número total de soluciones encontradas
        return count;
    }

    /**
     * Elimina celdas del tablero hasta alcanzar el número objetivo de celdas en blanco,
     * asegurando que el tablero resultante tenga una única solución.
     *
     * @param targetBlanks Número objetivo de celdas en blanco.
     */
    public void removeCells(int targetBlanks) {

        List<String> positions = new ArrayList<>(board.keySet());
        Collections.shuffle(positions);
        for (String pos : positions) {
            // Si ya hemos alcanzado el número objetivo de celdas en blanco, salimos del bucle
            if (getBlankCount() >= targetBlanks) break;
            // Guardamos el valor actual de la celda y la vaciamos
            Cell cell = board.get(pos);
            int backup = cell.getValue();
            cell.setValue(0);
            // Verificamos si el tablero sigue teniendo una única solución
            if (countSolutions() != 1) {
                // restaurar si pierde unicidad
                cell.setValue(backup);
            }
        }
    }

    /**
     * Cuenta el número de celdas en blanco (valor 0) en el tablero.
     *
     * @return Número de celdas en blanco.
     */
    private int getBlankCount() {
        return (int) board
                .values()
                .stream()
                .filter(c -> c.getValue() == 0).count();
    }
}
