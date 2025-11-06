package app.sudoku;

import java.io.Serializable;

/**
 * Clase que representa una celda en un tablero de Sudoku.
 */
public class Cell {
    /**
     * Fila de la celda en el tablero.
     */
    private final int row;

    /**
     * Columna de la celda en el tablero.
     */
    private final int col;

    /**
     * Valor de la celda (0 si está vacía).
     */
    private int value;

    /**
     * Constructor para una celda del Sudoku con un valor inicial.
     *
     * @param row   Fila de la celda.
     * @param col   Columna de la celda.
     * @param value Valor inicial de la celda.
     */
    public Cell(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    /**
     * Constructor para una celda del Sudoku sin valor inicial (vacía).
     *
     * @param row Fila de la celda.
     * @param col Columna de la celda.
     */
    public Cell(int row, int col) {
        this(row, col, 0); // Valor por defecto 0 (vacío)
    }

    /**
     * Representación en cadena de la celda.
     * Si el valor es 0, se representa como un espacio en blanco, de lo contrario, se muestra el valor.
     *
     * @return Representación en cadena de la celda.
     */
    @Override
    public String toString() {
        return value == 0 ? " " : String.valueOf(value);
    }

    // Getters y Setters estándar

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
