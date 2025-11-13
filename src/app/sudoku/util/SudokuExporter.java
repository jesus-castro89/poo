package app.sudoku.util;

import app.sudoku.entities.SudokuBoard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SudokuExporter {

    public static void exportSudokuToText(SudokuBoard sudokuBoard) {

        File file = new File("files/sudokuText.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(SudokuPrinter.printSudoku(sudokuBoard));
        } catch (Exception e) {
            System.err.println("Error al exportar el Sudoku a texto: " + e.getMessage());
        }
    }
}
