package org.tec.sudoku;

public enum SudokuDifficultyLevel {
    SOLVED(81, "Resuelto"),
    EASY(70, "Fácil"),
    MEDIUM(65, "Medio"),
    HARD(50, "Difícil");

    private final int visibleCells;
    private final String name;

    SudokuDifficultyLevel(int visibleCells, String name) {
        this.visibleCells = visibleCells;
        this.name = name;
    }

    public static SudokuDifficultyLevel[] getValues() {
        return new SudokuDifficultyLevel[]{EASY, MEDIUM, HARD};
    }

    public int getCellsToRemove() {
        return 81 - visibleCells;
    }

    @Override
    public String toString() {
        return "%s(Celdas visibles: %d)".formatted(name, visibleCells);
    }
}
