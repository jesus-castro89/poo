package org.tec.sudoku;

public enum SudokuDifficultyLevel {
    SOLVED(81),
    EASY(40),
    MEDIUM(32),
    HARD(26),
    EXPERT(20);

    private final int visibleCells;

    SudokuDifficultyLevel(int visibleCells) {
        this.visibleCells = visibleCells;
    }

    public int getVisibleCells() {
        return visibleCells;
    }

    @Override
    public String toString() {
        return "%d. %s(Celdas visibles: %d)".formatted(ordinal() + 1, name(), visibleCells);
    }
}
