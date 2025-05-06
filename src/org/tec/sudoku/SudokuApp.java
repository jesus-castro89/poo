package org.tec.sudoku;

import javax.swing.*;

public class SudokuApp {

    public static void start() {

        SudokuDifficultyLevel difficultyLevel;
        do {
            difficultyLevel = (SudokuDifficultyLevel) JOptionPane.showInputDialog(null,
                    "Selecciona dificultad:",
                    "Sudoku",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    SudokuDifficultyLevel.values(),
                    SudokuDifficultyLevel.EASY);
            if (difficultyLevel == null) {
                JOptionPane.showMessageDialog(null, "Selección invalidada, intente de nuevo.");
                start();
            }
        } while (difficultyLevel == null);
        int visibleCells = difficultyLevel.getVisibleCells();
        SudokuGenerator generator = new SudokuGenerator();
        int[][] fullBoard = generator.generateSudoku();
        SudokuPuzzle puzzle = new SudokuPuzzle(fullBoard, visibleCells);
        SudokuFileManager.exportToFile(puzzle, "org/tec/sudoku/sudoku_output.txt");
    }

    public static void loadSudoku() {
        String filePath = "org/tec/sudoku/sudoku_output.txt";
        SudokuPuzzle puzzle = SudokuFileManager.importFromFile(filePath);
        if (puzzle != null)
            puzzle.printPuzzle();
    }
}