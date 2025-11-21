package app.sudoku.entities;

/**
 * Enum que representa los niveles de dificultad del Sudoku.
 */
public enum SudokuLevel {

    EASY(36),
    MEDIUM(45),
    HARD(54),
    EXPERT(60);

    /**
     * Descripción del nivel de dificultad
     */
    final String description;

    /**
     * Número de celdas ocultas para este nivel de dificultad.
     */
    final int hiddenCells;

    /**
     * Constructor del enum SudokuLevel.
     *
     * @param hiddenCells Número de celdas ocultas para este nivel de dificultad.
     */
    SudokuLevel(int hiddenCells) {
        this.description = switch (this) {
            case EASY -> "Fácil";
            case MEDIUM -> "Medio";
            case HARD -> "Difícil";
            case EXPERT -> "Experto";
        };
        this.hiddenCells = hiddenCells;
    }

    /**
     * Devuelve la descripción del nivel de dificultad.
     *
     * @return Descripción del nivel de dificultad.
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Devuelve el número de celdas ocultas para este nivel de dificultad.
     *
     * @return Número de celdas ocultas.
     */
    public int getHiddenCells() {
        return hiddenCells;
    }
}
