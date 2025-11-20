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

        SudokuGenerator generator = new SudokuGenerator(new SudokuBoard());
        SudokuBoard board = generator.getBoard();
    }
}