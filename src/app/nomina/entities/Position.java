package app.nomina.entities;

public enum Position {

    SECRETARY("Secretario/a", 0.15),
    CASHIER("Cajero/a", 0.10),
    MANAGER("Conserje", 0.20),
    DIRECTOR("Director/a", 0.25);

    private final String displayName;
    private final double retentionRate;

    Position(String displayName, double retentionRate) {
        this.displayName = displayName;
        this.retentionRate = retentionRate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getRetentionRate() {
        return retentionRate;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
