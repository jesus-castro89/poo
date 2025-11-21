package app.sudoku.util;

import app.sudoku.entities.SudokuBoard;
import app.sudoku.entities.SudokuCell;
import app.sudoku.entities.SudokuLevel;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Clase de utilidades para manipular tableros de Sudoku,
 * incluyendo la funcionalidad para ocultar celdas
 * y asegurar una solución única.
 */
public class SudokuUtils {

    /**
     * Número máximo de intentos para ocultar celdas en el tablero de Sudoku.
     */
    private static final int MAX_ATTEMPTS = 10;

    /**
     * Contador de soluciones encontradas en el tablero de Sudoku.
     */
    private int countSolutions = 0;

    /**
     * Tablero de Sudoku a manipular.
     */
    private SudokuBoard board;

    /**
     * Constructor que toma un tablero de Sudoku como parámetro para manipulación.
     *
     * @param board Tablero de Sudoku a manipular.
     */
    public SudokuUtils(SudokuBoard board) {
        this.board = board;
    }

    /**
     * Oculta las celdas en el tablero de Sudoku según el nivel de dificultad especificado,
     * asegurando que el tablero resultante tenga una solución única.
     *
     * @param level Nivel de dificultad que determina cuántas celdas ocultar.
     * @return Tablero de Sudoku con celdas ocultas.
     * @throws Exception Si no se pueden ocultar suficientes celdas manteniendo una solución única.
     */
    public SudokuBoard hideCells(SudokuLevel level) throws Exception {
        try {
            SudokuBoard copyBoard = board.clone();
            int hiddenCells = level.getHiddenCells();
            int attempts = 0;
            do {
                if (attempts++ > MAX_ATTEMPTS) {
                    throw new Exception("No se pudieron ocultar suficientes celdas en el tablero de Sudoku.");
                }
                IntStream.range(0, hiddenCells).forEach(hideCellConsumer(copyBoard));
            } while (!hasUniqueSolution());
            board = copyBoard;
            board.getBoard().forEach(fixCellsConsumer());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return board;
    }

    /**
     * Verifica si el tablero de Sudoku tiene una solución única.
     *
     * @return true si el tablero tiene una solución única, false en caso contrario.
     */
    private boolean hasUniqueSolution() {

        countSolutions = 0;
        countSolutions(0, 0);
        return countSolutions == 1;
    }

    /**
     * Función recursiva para contar las soluciones del tablero de Sudoku.
     *
     * @param row Fila actual.
     * @param col Columna actual.
     */
    private void countSolutions(int row, int col) {

        SudokuValidator validator = new SudokuValidator(board);
        int nextRow, nextCol;
        if (row != 9) {
            if (countSolutions <= 1) {
                nextRow = (col == 8) ? row + 1 : row;
                nextCol = (col + 1) % 9;
                if (!board.getCell(row, col).isEmpty()) {
                    countSolutions(nextRow, nextCol);
                } else {
                    IntStream.range(0, 9)
                            .filter(i -> validator.isSafe(row, col, i))
                            .forEach(tryNumberConsumer(row, col, nextRow, nextCol));
                }
            }
        } else {
            countSolutions++;
        }
    }

    /**
     * Consumidor para fijar las celdas no vacías del tablero de Sudoku.
     *
     * @return BiConsumer que fija las celdas no vacías.
     */
    private static BiConsumer<String, SudokuCell> fixCellsConsumer() {
        return (key, cell) -> {
            if (!cell.isEmpty()) {
                cell.setFixed(true);
            }
        };
    }

    /**
     * Consumidor para ocultar una celda aleatoria en el tablero de Sudoku.
     *
     * @param copyBoard Tablero de Sudoku en el que se ocultará la celda.
     * @return IntConsumer que oculta una celda aleatoria.
     */
    private IntConsumer hideCellConsumer(SudokuBoard copyBoard) {
        return i -> {
            Random random = new Random();
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (!copyBoard.getCell(row, col).isEmpty())
                copyBoard.getCell(row, col).setValue(0);
        };
    }

    /**
     * Consumidor para intentar colocar un número en una celda y contar soluciones recursivamente.
     *
     * @param row     Fila de la celda.
     * @param col     Columna de la celda.
     * @param nextRow Fila de la siguiente celda.
     * @param nextCol Columna de la siguiente celda.
     * @return IntConsumer que intenta colocar un número y cuenta soluciones.
     */
    private IntConsumer tryNumberConsumer(int row, int col, int nextRow, int nextCol) {
        return i -> {
            board.getCell(row, col).setValue(i);
            countSolutions(nextRow, nextCol);
            board.getCell(row, col).setValue(0);
        };
    }
}
