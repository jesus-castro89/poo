package app.sudoku;

import app.sudoku.entities.SudokuBoard;
import app.sudoku.entities.SudokuLevel;
import app.sudoku.util.SudokuExporter;
import app.sudoku.util.SudokuPrinter;
import app.sudoku.util.SudokuGenerator;
import app.sudoku.util.SudokuUtils;
import org.util.InputHandler;

import javax.swing.*;

public class Main {

    void main() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuGenerator maker = new SudokuGenerator(sudokuBoard);
        if (maker.fillBoard()) {
            InputHandler.showMessage("Tablero de Sudoku generado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            InputHandler.showMessage("Error al generar el tablero de Sudoku.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        InputHandler.showMessage(SudokuPrinter.printSudoku(sudokuBoard),
                "Tablero de Sudoku Completo",
                JOptionPane.INFORMATION_MESSAGE);
        SudokuLevel level = InputHandler.getInput("Seleccione el nivel de dificultad",
                SudokuLevel.values());
        SudokuBoard hiddenBoard;
        try {
            hiddenBoard = sudokuBoard.clone();
            SudokuUtils utils = new SudokuUtils(hiddenBoard);
            hiddenBoard = utils.hideCells(level);
            InputHandler.showMessage(SudokuPrinter.printSudoku(hiddenBoard),
                    "Tablero de Sudoku Completo",
                    JOptionPane.INFORMATION_MESSAGE);
            SudokuExporter.exportSudokuToText(hiddenBoard);
            InputHandler.showMessage("El Sudoku ha sido exportado a 'files/sudokuText.txt'",
                    "Exportación Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            InputHandler.showMessage("Error al ocultar celdas o exportar el Sudoku: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}