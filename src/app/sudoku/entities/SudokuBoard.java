package app.sudoku.entities;

import java.io.Serializable;
import java.util.*;

/**
 * Clase que representa un tablero de Sudoku.
 */
public class SudokuBoard implements Cloneable, Serializable {

    /**
     * Mapa que representa las celdas del tablero de Sudoku.
     */
    private final HashMap<String, SudokuCell> board = new HashMap<>();

    /**
     * Constructor para un tablero de Sudoku vacío.
     */
    public SudokuBoard() {
        // Inicializar el tablero vacío
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.put(key(row, col), new SudokuCell(row, col));
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
     * Clona el tablero de Sudoku.
     *
     * @return Nuevo objeto SudokuBoard clonado.
     * @throws CloneNotSupportedException Si la clonación no es soportada.
     */
    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public SudokuBoard clone() throws CloneNotSupportedException {

        SudokuBoard clonedBoard = new SudokuBoard();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                SudokuCell originalSudokuCell = this.getCell(row, col);
                SudokuCell clonedSudokuCell = new SudokuCell(row, col, originalSudokuCell.getValue(), false);
                clonedBoard.board.put(clonedBoard.key(row, col), clonedSudokuCell);
            }
        }
        return clonedBoard;
    }

    /**
     * Obtiene la celda en la posición especificada.
     *
     * @param row Fila de la celda.
     * @param col Columna de la celda.
     * @return Celda en la posición dada.
     */
    public SudokuCell getCell(int row, int col) {
        return board.get(key(row, col));
    }

    public HashMap<String, SudokuCell> getBoard() {
        return board;
    }
}
