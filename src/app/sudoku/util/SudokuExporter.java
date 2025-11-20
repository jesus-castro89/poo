package app.sudoku.util;

import app.sudoku.entities.SudokuBoard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase responsable de exportar el Sudoku a diferentes formatos.
 */
public class SudokuExporter {

    /**
     * Exporta el Sudoku a un archivo de texto.
     * @param sudokuBoard El tablero de Sudoku a exportar.
     */
    public static void exportSudokuToText(SudokuBoard sudokuBoard) {
        // 1. Generar el atributo de tipo File
        File file = new File("files/sudokuText.txt");
        // 2. Iniciar el try-with-resources para el BufferedWriter que
        //    escribirá en el archivo mediante un FileWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            // 3. Escribir el Sudoku en el archivo usando la función
            //    printSudoku de la clase SudokuPrinter
            bw.write(SudokuPrinter.printSudoku(sudokuBoard));
        } catch (IOException e) {
            // 4. Manejar la excepción en caso de error de E/S
            IO.println("Error al exportar el Sudoku a texto: " + e.getMessage());
        }
    }
}
