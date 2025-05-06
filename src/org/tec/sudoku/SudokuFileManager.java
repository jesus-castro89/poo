package org.tec.sudoku;

import javax.swing.*;
import java.io.*;

public class SudokuFileManager {

    public static void exportToFile(SudokuPuzzle puzzle, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int[] row : puzzle.getPuzzle()) {
                for (int cell : row) {
                    writer.write(cell + " ");
                }
                writer.newLine();
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Sudoku exportado con éxito a " + filePath,
                    "Exportación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.err.println("Error exporting Sudoku puzzle: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static SudokuPuzzle importFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int[][] puzzle = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String line = reader.readLine();
                if (line != null) {
                    String[] values = line.split(" ");
                    for (int j = 0; j < 9; j++) {
                        puzzle[i][j] = Integer.parseInt(values[j]);
                    }
                }
            }
            reader.close();
//            JOptionPane.showMessageDialog(null, "Sudoku importado con éxito desde " + filePath,
//                    "Importación exitosa", JOptionPane.INFORMATION_MESSAGE);
            return new SudokuPuzzle(puzzle, 0);
        } catch (IOException e) {
            System.err.println("Error importando Sudoku puzzle: " + e.getMessage());
        }
        return null;
    }
}
