package org.tec.sudoku;

import javax.swing.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class SudokuPuzzle implements Serializable {

    private final int[][] puzzle;

    public SudokuPuzzle() {
        this.puzzle = SudokuGenerator.generateSudoku();
    }

    public SudokuPuzzle(int visibleCells) {
        this.puzzle = SudokuGenerator.generateSudoku();
        applyDifficulty(visibleCells);
    }

    public boolean isSolved() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (puzzle[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
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

    public void setPuzzle(int[][] puzzle) {
        for (int i = 0; i < 9; i++) {
            System.arraycopy(puzzle[i], 0, this.puzzle[i], 0, 9);
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
                default -> sb.append("║───┼───┼───║───┼───┼───║───┼───┼───║\n");
            }
        }
        return sb.toString();
    }
}
