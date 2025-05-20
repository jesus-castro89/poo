package org.tec.sudoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuGenerator {

    private static final int[][] sudoku = new int[9][9];

    public static int[][] generateSudoku() {
        clearBoard();
        fillBoard(0, 0);
        return sudoku;
    }

    private static void clearBoard() {
        Arrays.stream(sudoku).forEach(row -> Arrays.fill(row, 0));
    }

    private static Integer[] shuffledNumbers() {
        Integer[] numbers = IntStream.range(1, 10).boxed().toArray(Integer[]::new);
        List<Integer> intList = Arrays.asList(numbers);
        Collections.shuffle(intList);
        intList.toArray(numbers);
        return numbers;
    }

    private static boolean fillBoard(int row, int column) {
        int nextRow;
        int nextColumn;
        Integer[] numbers;
        if (row >= 0 && row < 9) {
            nextRow = (column == 8) ? row + 1 : row;
            nextColumn = (column + 1) % 9;
            numbers = shuffledNumbers();
            for (int number : numbers) {
                if (SudokuValidator.isValid(sudoku, row, column, number)) {
                    sudoku[row][column] = number;
                    if (fillBoard(nextRow, nextColumn))
                        return true;
                    else
                        sudoku[row][column] = 0; // Backtrack
                }
            }
            return false;
        } else {
            return true;
        }
    }

    public static SudokuPuzzle solveSudoku(SudokuPuzzle puzzle) {
        System.arraycopy(puzzle.getPuzzle(), 0, sudoku, 0, 9);
        fillBoard(0, 0);
        puzzle.setPuzzle(sudoku);
        return puzzle;
    }

    public static SudokuPuzzle generateOneSolutionPuzzle(SudokuDifficultyLevel difficultyLevel) throws ManySolutionsException {
        SudokuPuzzle puzzle = new SudokuPuzzle();
        int[][] board = puzzle.getPuzzle();
        int cellsToRemove = difficultyLevel.getCellsToRemove();
        int row, col, attempts = 0;
        do {
            if (attempts++ > 10) {
                throw new ManySolutionsException();
            }
            while (cellsToRemove > 0 && cellsToRemove < 81) {
                row = (int) (Math.random() * 9);
                col = (int) (Math.random() * 9);
                if (board[row][col] != 0) {
                    board[row][col] = 0;
                    cellsToRemove--;
                }
            }
        } while (!SudokuValidator.hasUniqueSolution(board));
        return puzzle;
    }
}
