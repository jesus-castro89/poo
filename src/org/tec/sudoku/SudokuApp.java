package org.tec.sudoku;

import org.tec.utils.FileManager;

import javax.swing.*;

public class SudokuApp {

    private static SudokuPuzzle solution;
    private static SudokuDifficultyLevel selectedDifficultyLevel;

    public static void start() {
        do {
            selectedDifficultyLevel = (SudokuDifficultyLevel) JOptionPane.showInputDialog(null,
                    "Selecciona dificultad:",
                    "Sudoku",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    SudokuDifficultyLevel.getValues(),
                    SudokuDifficultyLevel.EASY);
            if (selectedDifficultyLevel == null) {
                JOptionPane.showMessageDialog(null, "Selección invalidada, intente de nuevo.");
                start();
            }
        } while (selectedDifficultyLevel == null);
        populateSolution();
    }

    private static void populateSolution() {
        try {
            SudokuPuzzle puzzle = SudokuGenerator.generateOneSolutionPuzzle(selectedDifficultyLevel);
            solution = SudokuSolver.solve(puzzle);
            exportSudoku();
        } catch (ManySolutionsException e) {
            throw new RuntimeException(e);
        }
    }

    private static void exportSudoku() {
        FileManager.createFile("Sudoku.txt", solution.getPrintablePuzzle(), false);
        FileManager.writeObject("SudokuPuzzle.sudoku", solution);
    }
}