package app.sudoku;

import java.io.Serializable;

public class Cell implements Serializable {
    private int value;
    private boolean isFixed;

    public Cell(int value) {
        this.value = value;
        this.isFixed = false;
    }

    public Cell(int value, boolean isFixed) {
        this.value = value;
        this.isFixed = isFixed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (!isFixed) {
            this.value = value;
        }
    }

    public boolean isFixed() {
        return isFixed;
    }
}
