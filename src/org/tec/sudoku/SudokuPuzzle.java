package org.tec.sudoku;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class SudokuPuzzle implements Serializable {
    private final int[][] puzzle;

    public SudokuPuzzle() {
        this.puzzle = new SudokuGenerator().generateSudoku();
    }

    public SudokuPuzzle(int[][] puzzle) {
        this.puzzle = new int[9][9];
        System.arraycopy(puzzle, 0, this.puzzle, 0, 9);
    }

    public SudokuPuzzle(int visibleCells) {
        this.puzzle = new SudokuGenerator().generateSudoku();
        applyDifficulty(visibleCells);
    }

    public boolean isSolved() {
        return Arrays.stream(puzzle)
                .flatMapToInt(Arrays::stream)
                .allMatch(cell -> cell != 0);

    }

    private void applyDifficulty(int visibleCells) {
        int cellsToRemove = 81 - visibleCells;
        int row, col;
        Random random = new Random();
        while (cellsToRemove > 0 && cellsToRemove < 81) {
            row = random.nextInt(9);
            col = random.nextInt(9);
            if (puzzle[row][col] != 0) {
                puzzle[row][col] = 0;
                cellsToRemove--;
            }
        }
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public String getPrintablePuzzle() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n");
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (column % 3 == 0)
                    sb.append("║");
                else
                    sb.append("│");
                sb.append(String.format(" %s ", puzzle[row][column] != 0 ? puzzle[row][column] : " "));
                if (column == 8)
                    sb.append("║\n");
            }
            switch (row) {
                case 2, 5 -> sb.append("╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n");
                case 8 -> sb.append("╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝");
                default -> sb.append("╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
            }
        }
        return sb.toString();
    }
}