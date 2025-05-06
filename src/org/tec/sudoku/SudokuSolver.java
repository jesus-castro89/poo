package org.tec.sudoku;

public class SudokuSolver {
    private static int solutionCount = 0;

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
