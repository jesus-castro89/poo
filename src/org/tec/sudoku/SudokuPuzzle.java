package org.tec.sudoku;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class SudokuPuzzle {

    private final int[][] puzzle;

    public SudokuPuzzle(int[][] fullBoard, int visibleCells) {
        this.puzzle = Arrays.copyOf(fullBoard, fullBoard.length);
        applyDifficulty(visibleCells);
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

    public void printPuzzle() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0)
                    sb.append("║");
                else
                    sb.append("│");
                sb.append(String.format(" %s ", puzzle[i][j]!= 0 ? puzzle[i][j] : " "));
                if(j == 8)
                    sb.append("║\n");
            }
            switch (i) {
                case 2, 5 -> sb.append("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣\n");
                case 8 -> sb.append("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
                default -> sb.append("║───┼───┼───║───┼───┼───║───┼───┼───║\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
