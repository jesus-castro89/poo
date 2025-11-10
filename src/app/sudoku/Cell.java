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

    private boolean isFixed;

    /**
     * Constructor para una celda del Sudoku con un valor inicial.
     *
     * @param row   Fila de la celda.
     * @param col   Columna de la celda.
     * @param value Valor inicial de la celda.
     */
    public Cell(int row, int col, int value, boolean isFixed) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.isFixed = isFixed;
    }

    /**
     * Constructor para una celda del Sudoku sin valor inicial (vacía).
     *
     * @param row Fila de la celda.
     * @param col Columna de la celda.
     */
    public Cell(int row, int col) {
        this(row, col, 0, false); // Valor por defecto 0 (vacío)
    }

    /**
     * Verifica si la celda está vacía (valor 0).
     *
     * @return true si la celda está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.value == 0;
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

    /**
     * Obtiene el índice del área 3x3 a la que pertenece la celda.
     *
     * @return Índice del área (0-8).
     */
    public int getAreaIndex() {
        return (row / 3) * 3 + (col / 3);
    }

    // Getters y Setters estándar

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }
}
