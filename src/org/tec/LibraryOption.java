package org.tec;

public enum LibraryOption {
    ADD_BOOK("Agregar Libro"),
    REMOVE_BOOK("Eliminar Libro"),
    VIEW_BOOKS("Ver Libros"),
    SEARCH_BOOK("Buscar Libro"),
    EXIT("Salir");

    private final String description;

    LibraryOption(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "%d. %s".formatted(this.ordinal() + 1, this.description);
    }
}
