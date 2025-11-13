package app.sudoku;

import app.sudoku.entities.SudokuBoard;
import app.sudoku.entities.SudokuLevel;
import app.sudoku.util.SudokuExporter;
import app.sudoku.util.SudokuPrinter;
import app.sudoku.util.SudokuGenerator;
import app.sudoku.util.SudokuUtils;

public class Main {

    void main() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuGenerator maker = new SudokuGenerator(sudokuBoard);
        if (maker.fillBoard()) {
            System.out.println("Tablero de Sudoku generado correctamente.");
        } else {
            System.out.println("Error al generar el tablero de Sudoku.");
            System.exit(1);
        }
        IO.println(SudokuPrinter.printSudoku(sudokuBoard));
        SudokuLevel level = SudokuLevel.EXPERT;
        System.out.println("Nivel seleccionado: " + level);
        SudokuBoard hiddenBoard;
        try {
            hiddenBoard = sudokuBoard.clone();
            SudokuUtils utils = new SudokuUtils(hiddenBoard);
            hiddenBoard = utils.hideCells(level);
            System.out.println("Tablero con celdas ocultas:");
            IO.println(SudokuPrinter.printSudoku(hiddenBoard));
            SudokuExporter.exportSudokuToText(hiddenBoard);
        } catch (Exception e) {
            System.err.println("Error al ocultar celdas: " + e.getMessage());
        }
    }
}