package org.tec.sudoku;

public class SudokuSolver {

    public static SudokuPuzzle solve(SudokuPuzzle puzzle) {
        return (puzzle.isSolved()) ?
                puzzle : new SudokuGenerator().solveSudoku(puzzle);
    }
}
