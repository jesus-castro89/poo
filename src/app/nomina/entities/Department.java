package app.nomina.entities;

import java.util.Comparator;

public enum Department {

    HR("Recursos Humanos", 1.0),
    IT("Tecnología de la Información", 1.2),
    SALES("Ventas", 1.1),
    MARKETING("Marketing", 1.15),
    FINANCE("Finanzas", 1.3);

    /**
     * Nombre del departamento.
     */
    private final String displayName;
    /**
     * Multiplicador de salario para el departamento.
     */
    private final double salaryMultiplier;

    Department(String displayName, double salaryMultiplier) {
        this.displayName = displayName;
        this.salaryMultiplier = salaryMultiplier;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
