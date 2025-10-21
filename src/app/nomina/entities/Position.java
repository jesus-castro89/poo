package app.nomina.entities;

public enum Position {

    SECRETARY("Secretario/a"),
    CASHIER("Cajero/a"),
    MANAGER("Conserje"),
    DIRECTOR("Director/a");

    private final String displayName;

    Position(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
