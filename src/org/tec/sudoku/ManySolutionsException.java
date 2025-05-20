package org.tec.sudoku;

public class ManySolutionsException extends Exception {

    public ManySolutionsException() {
        super("El Sudoku tiene múltiples soluciones.");
    }
}
