package app.sudoku.util;

import app.sudoku.entities.SudokuBoard;

public class SudokuPrinter {

    public static String printSudoku(SudokuBoard board) {

        StringBuilder sb = new StringBuilder();
        sb.append("╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n");
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0)
                    sb.append("║");
                else
                    sb.append("│");
                sb.append(String.format(" %s ", board.getCell(row, col).toString()));
                if (col == 8)
                    sb.append("║\n");
            }
            switch (row) {
                case 2, 5 -> sb.append("╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n");
                case 8 -> sb.append("╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n");
                default -> sb.append("╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
            }
        }
        return sb.toString();
    }
}
