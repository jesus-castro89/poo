package app.sudoku;

public class Main {

    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard();
        board.printBoard();
        board.fillBoard();
        board.printBoard();
    }
}
