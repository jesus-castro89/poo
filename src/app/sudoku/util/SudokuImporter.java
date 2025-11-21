package app.sudoku.util;

import app.sudoku.entities.SudokuBoard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Clase responsable de importar un Sudoku desde diferentes formatos.
 */
public class SudokuImporter {

    /**
     * El tablero de Sudoku importado.
     */
    private SudokuBoard sudokuBoard;

    /**
     * Constructor que inicializa el importador y procesa la importación del Sudoku.
     */
    public SudokuImporter() {
        // Implementación futura para importar un Sudoku desde un archivo
        importSudokuFromObject();
        solveSudoku();
    }

    /**
     * Importa un Sudoku desde un archivo de objeto serializado.
     */
    private void importSudokuFromObject() {

        File file = new File("files/sudokuObject.sudoku");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            sudokuBoard = (SudokuBoard) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            IO.println("Error al importar el Sudoku desde objeto: " + e.getMessage());
        }
    }

    /**
     * Resuelve el Sudoku importado y muestra el resultado.
     */
    private void solveSudoku() {
        SudokuGenerator generator = new SudokuGenerator(sudokuBoard);
        IO.println("Carga del Sudoku importado:");
        IO.println(SudokuPrinter.printSudoku(sudokuBoard));
        IO.println("Resolviendo el Sudoku importado...");
        generator.fillBoard();
        IO.println(SudokuPrinter.printSudoku(sudokuBoard));
    }
}
