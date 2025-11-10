package app.sudoku;

import org.util.InputHandler;

import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    void main() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.printBoard();
        sudokuBoard.fillBoard();
        sudokuBoard.printBoard();
    }
}