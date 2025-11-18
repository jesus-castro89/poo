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
        // 1. Creamos el archivo de texto
        // Asegúrate de que la carpeta "files" exista en el directorio raíz del proyecto.
        // Si no existe, debes crearla antes de ejecutar este código.
        File file = new File("files/sudokuText.txt");
        // 2. Creamos el BufferedWriter para escribir en el archivo mediante FileWriter
        // Recuerda que esto lo haremos con el bloque try-with-resources para
        // cerrar el BufferedWriter automáticamente
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            // 3. Escribimos el contenido del Sudoku en el archivo
            // Usamos la clase SudokuPrinter para obtener la representación en
            // texto del Sudoku
            bw.write(SudokuPrinter.printSudoku(sudokuBoard));
        } catch (IOException e) {
            // 4. Manejamos la excepción en caso de error
            System.err.println("Error al exportar el Sudoku a texto: " + e.getMessage());
        }
    }
}
