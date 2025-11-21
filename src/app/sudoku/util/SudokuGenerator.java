package app.sudoku.util;

import app.sudoku.entities.SudokuBoard;
import app.sudoku.entities.SudokuLevel;
import org.util.InputHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Clase responsable de generar tableros de Sudoku jugables.
 */
public class SudokuGenerator {

    /**
     * El tablero de Sudoku generado.
     */
    private SudokuBoard board;

    /**
     * Constructor que inicializa el generador y crea un tablero jugable.
     */
    public SudokuGenerator() {
        this.board = new SudokuBoard();
        fillBoard();
        getPlayableBoard();
        SudokuExporter.exportSudokuToObject(board);
    }

    /**
     * Constructor que recibe un tablero de Sudoku existente.
     *
     * @param board El tablero de Sudoku a utilizar.
     */
    public SudokuGenerator(SudokuBoard board) {
        this.board = board;
    }

    /**
     * Genera un tablero de Sudoku jugable ocultando celdas según el nivel de dificultad seleccionado.
     */
    private void getPlayableBoard() {

        // Mostrando mensaje de bienvenida
        InputHandler.showMessage("¡Bienvenido al Generador de Sudoku!",
                "Generador de Sudoku", JOptionPane.INFORMATION_MESSAGE);
        // Solicitando al usuario el nivel de dificultad
        SudokuLevel level = InputHandler.getInput("Seleccione el nivel de dificultad: ",
                SudokuLevel.values());
        try {
            // Mostrando mensaje de generación
            InputHandler.showMessage("Generando Sudoku de nivel " + level + "...",
                    "Generando Sudoku", JOptionPane.INFORMATION_MESSAGE);
            // Ocultando celdas según el nivel seleccionado
            SudokuUtils utils = new SudokuUtils(board);
            board = utils.hideCells(level);
            // Exportando el Sudoku generado a un archivo de texto
            SudokuExporter.exportSudokuToText(board);
            // Mostrando mensaje de éxito
            InputHandler.showMessage("Sudoku generado y exportado exitosamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            IO.println("Error al exportar el Sudoku a texto: " + e.getMessage());
        }
    }


    /**
     * Generación completa del tablero de Sudoku mediante backtracking.
     *
     * @return true si el tablero se llenó correctamente, false en caso contrario.
     */
    public boolean fillBoard() {

        SudokuValidator validator = new SudokuValidator(board);
        // Recorremos cada fila del tablero
        for (int row = 0; row < 9; row++) {
            // Recorremos cada columna de la fila actual
            for (int col = 0; col < 9; col++) {
                // Si la celda está vacía (valor 0)
                if (board.getCell(row, col).isEmpty()) {
                    // Obtenemos una lista de números del 1 al 9 en orden aleatorio
                    List<Integer> numbers = getRandomNumbers();
                    // Intentamos colocar cada número en la celda
                    for (int num : numbers) {
                        // Verificamos si es seguro colocar el número en la celda
                        if (validator.isSafe(row, col, num)) {
                            // Colocamos el número en la celda
                            board.getCell(row, col).setValue(num);
                            // Llamada recursiva para llenar el resto del tablero
                            if (fillBoard())
                                return true;
                            // Si no se pudo llenar, retrocedemos (backtrack)
                            board.getCell(row, col).setValue(0);
                        }
                    }
                    // Si ningún número es válido, retornamos false para retroceder
                    return false;
                }
            }
        }
        // Si todas las celdas están llenas, retornamos true
        return true;
    }

    /**
     * Genera una lista de números del 1 al 9 en orden aleatorio.
     *
     * @return Lista de números aleatorios del 1 al 9, en un orden mezclado.
     */
    private List<Integer> getRandomNumbers() {

        List<Integer> nums = new ArrayList<>();
        IntStream.range(1, 10).forEach(nums::add);
        Collections.shuffle(nums);
        return nums;
    }
}
