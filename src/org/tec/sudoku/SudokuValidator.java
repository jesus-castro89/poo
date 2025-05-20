package org.tec.sudoku;

import java.util.stream.IntStream;

public class SudokuValidator {

    private static int[][] sudoku;
    private static int solutionCount = 0;

    public static boolean isValid(int[][] board, int row, int column, int number) {
        sudoku = board;
        return isValidRow(row, number) &&
                isValidColumn(column, number) &&
                isValidBox(row, column, number);
    }

    private static boolean isValidRow(int row, int number) {
        return IntStream.range(0, 9).noneMatch(column -> sudoku[row][column] == number);
    }

    private static boolean isValidColumn(int column, int number) {
        return IntStream.range(0, 9).noneMatch(row -> sudoku[row][column] == number);
    }

    private static boolean isValidBox(int row, int column, int number) {
        int startRow = row - row % 3;
        int startCol = column - column % 3;
        return IntStream.range(0, 3).noneMatch(i ->
                IntStream.range(0, 3).anyMatch(
                        j -> sudoku[startRow + i][startCol + j] == number));
    }

    public static boolean hasUniqueSolution(int[][] board) {
        solutionCount = 0;
        countSolutions(board, 0, 0);
        return solutionCount == 1;
    }

    private static void countSolutions(int[][] board, int row, int col) {
        int nextRow, nextCol;
        if (row != 9) {
            if (solutionCount <= 1) {
                nextRow = (col == 8) ? row + 1 : row;
                nextCol = (col + 1) % 9;
                if (board[row][col] != 0) {
                    countSolutions(board, nextRow, nextCol);
                } else {
                    for (int num = 1; num <= 9; num++) {
                        if (SudokuValidator.isValid(board, row, col, num)) {
                            board[row][col] = num;
                            countSolutions(board, nextRow, nextCol);
                            board[row][col] = 0;
                        }
                    }
                }
            }
        } else {
            solutionCount++;
        }
    }
}
