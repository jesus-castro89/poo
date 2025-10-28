package com.empresa.nomina.model;

public enum
Department {

    MARKETING("Marketing", 0.12),
    RRHH("Recursos Humanos", 0.10),
    DESARROLLO("Desarrollo", 0.15),
    VENTAS("Ventas", 0.20);

    private final String description;

    private final double bonusPercentage;

    Department(String description, double bonusPercentage) {
        this.description = description;
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public String toString() {
        return "%s (Bonificación: %.2f%%)".formatted(description, bonusPercentage * 100);
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public String getDescription() {
        return description;
    }
}
