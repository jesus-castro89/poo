package org.tec.sudoku;

public class SudokuSolver {

    public static SudokuPuzzle solve(SudokuPuzzle puzzle) {
        return (puzzle.isSolved()) ?
                puzzle : SudokuGenerator.solveSudoku(puzzle);
    }
}
