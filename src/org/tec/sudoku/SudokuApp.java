package org.tec.sudoku;

import org.tec.utils.FileManager;

import javax.swing.*;

public class SudokuApp {

    private static SudokuDifficultyLevel selectedDifficultyLevel;

    public static void loadSudoku() {
        SudokuPuzzle puzzle = FileManager.readObject("SudokuPuzzle.sudoku", SudokuPuzzle.class);
        if (puzzle == null) {
            JOptionPane.showMessageDialog(null, "No hay un Sudoku guardado.");
        } else {
            System.out.println(puzzle.getPrintablePuzzle());
            int option = JOptionPane.showConfirmDialog(null, "¿Desea resolver el Sudoku guardado?", "Sudoku", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                SudokuPuzzle solvedPuzzle = SudokuSolver.solve(puzzle);
                System.out.println(solvedPuzzle.getPrintablePuzzle());
            } else {
                System.out.println("No se resolvió el Sudoku guardado.");
            }
        }
    }

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
            SudokuPuzzle puzzle = new SudokuGenerator().generateOneSolutionPuzzle(selectedDifficultyLevel);
            exportSudoku(puzzle);
        } catch (ManySolutionsException e) {
            throw new RuntimeException(e);
        }
    }

    private static void exportSudoku(SudokuPuzzle puzzle) {
        FileManager.createFile("Sudoku.txt", puzzle.getPrintablePuzzle(), false);
        FileManager.writeObject("SudokuPuzzle.sudoku", puzzle);
    }
}