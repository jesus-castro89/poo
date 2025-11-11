package app.sudoku.util;

import app.sudoku.entities.SudokuBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuGenerator {

    private SudokuBoard board;

    public SudokuGenerator(SudokuBoard board) {
        this.board = board;
    }

    /**
     * Generación completa del tablero de Sudoku mediante backtracking.
     *
     * @return true si el tablero se llenó correctamente, false en caso contrario.
     */
    public boolean fillBoard() {

        SudokuValidator validator = new SudokuValidator(board);
        // Recorremos cada fila del tablero
        for (int row = 0; row < 9; row++) {
            // Recorremos cada columna de la fila actual
            for (int col = 0; col < 9; col++) {
                // Si la celda está vacía (valor 0)
                if (board.getCell(row, col).isEmpty()) {
                    // Obtenemos una lista de números del 1 al 9 en orden aleatorio
                    List<Integer> numbers = getRandomNumbers();
                    // Intentamos colocar cada número en la celda
                    for (int num : numbers) {
                        // Verificamos si es seguro colocar el número en la celda
                        if (validator.isSafe(row, col, num)) {
                            // Colocamos el número en la celda
                            board.getCell(row, col).setValue(num);
                            // Llamada recursiva para llenar el resto del tablero
                            if (fillBoard())
                                return true;
                            // Si no se pudo llenar, retrocedemos (backtrack)
                            board.getCell(row, col).setValue(0);
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
}
