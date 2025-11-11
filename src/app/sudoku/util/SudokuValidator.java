package app.sudoku.util;

import app.sudoku.entities.SudokuCell;
import app.sudoku.entities.SudokuBoard;

import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class SudokuValidator {

    private SudokuBoard board;

    private final BiPredicate<Integer, Integer> existInRow = (row, num) ->
            IntStream.range(0, 9)
                    .anyMatch(col -> board.getCell(row, col).getValue() == num);

    private final BiPredicate<Integer, Integer> existInColumn = (col, num) ->
            IntStream.range(0, 9)
                    .anyMatch(row -> board.getCell(row, col).getValue() == num);

    private final BiPredicate<Integer, Integer> existInBox = (areaIndex, num) -> {
        int startRow = (areaIndex / 3) * 3;
        int startCol = (areaIndex % 3) * 3;
        return IntStream.range(startRow, startRow + 3)
                .anyMatch(r -> IntStream.range(startCol, startCol + 3)
                        .anyMatch(c -> board.getCell(r, c).getValue() == num));
    };

    public SudokuValidator(SudokuBoard board) {
        this.board = board;
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
    public boolean isSafe(int row, int col, int num) {

        SudokuCell sudokuCell = board.getCell(row, col);
        return !existInRow.test(row, num)
                && !existInColumn.test(col, num)
                && !existInBox.test(sudokuCell.getAreaIndex(), num);
    }
}
