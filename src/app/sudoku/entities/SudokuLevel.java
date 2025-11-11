package app.sudoku.entities;

public enum SudokuLevel {

    EASY(36),
    MEDIUM(45),
    HARD(54),
    EXPERT(60);

    final String description;
    final int hiddenCells;

    SudokuLevel(int hiddenCells) {
        this.description = switch (this) {
            case EASY -> "Fácil";
            case MEDIUM -> "Medio";
            case HARD -> "Difícil";
            case EXPERT -> "Experto";
        };
        this.hiddenCells = hiddenCells;
    }

    @Override
    public String toString() {
        return description;
    }

    public int getHiddenCells() {
        return hiddenCells;
    }
}
