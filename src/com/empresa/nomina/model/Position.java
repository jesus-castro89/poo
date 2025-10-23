package com.empresa.nomina.model;

public enum Position {

    GERENTE("Gerente", 0.25, 0.15),
    ANALISTA("Analista", 0.15, 0.10),
    DESARROLLADOR("Desarrollador", 0.10, 0.08),
    ASISTENTE("Asistente", 0.05, 0.05);

    private final String description;
    private final double bonusPercentage;
    private final double retentionPercentage;

    Position(String description, double bonusPercentage, double retentionPercentage) {
        this.description = description;
        this.bonusPercentage = bonusPercentage;
        this.retentionPercentage = retentionPercentage;
    }

    @Override
    public String toString() {
        return "%s (Bonificación: %.2f%%, Retención: %.2f%%)".formatted(description, bonusPercentage * 100, retentionPercentage * 100);
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public double getRetentionPercentage() {
        return retentionPercentage;
    }

    public String getDescription() {
        return description;
    }
}
