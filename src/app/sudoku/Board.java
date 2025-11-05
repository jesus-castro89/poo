package app.sudoku;

import java.io.Serializable;
import java.util.HashMap;

public class Board implements Serializable {

    private HashMap<Integer, Cell> cells;

    public Board() {
        cells = new HashMap<>();
    }

    public void initializeBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = 0;
                int key = row * 9 + col;
                cells.put(key, new Cell(value));
            }
        }
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n");
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0)
                    sb.append("║");
                else
                    sb.append("│");
                int key = row * 9 + col;
                int value = cells.get(key).getValue();
                sb.append(String.format(" %s ", value != 0 ? value : " "));
                if (col == 8)
                    sb.append("║\n");
            }
            if (row == 8)
                sb.append("╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n");
            else if ((row + 1) % 3 == 0)
                sb.append("╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n");
            else
                sb.append("╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
        }
        System.out.print(sb.toString());
    }
}
