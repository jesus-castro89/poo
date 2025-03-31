package herencia.abstracto.zoologico;

public enum Species {

    LION("León", 102, 10.5, 20),
    TIGER("Tigre", 110, 9.5, 22),
    BEAR("Oso", 112.5, 8.5, 25),
    ELEPHANT("Elefante", 235.45, 12.57, 60),
    GIRAFFE("Jirafa", 115.75, 8.5, 28),
    MONKEY("Mono", 95.85, 5.5, 15);

    String speciesName;
    double maxFood;
    double maxWeight;
    int expectedLifeSpan;

    Species(String speciesName, double maxWeight, double maxFood, int expectedLifeSpan) {
        this.speciesName = speciesName;
        this.maxWeight = maxWeight;
        this.maxFood = maxFood;
        this.expectedLifeSpan = expectedLifeSpan;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public double getMaxFood() {
        return maxFood;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getExpectedLifeSpan() {
        return expectedLifeSpan;
    }

    @Override
    public String toString() {
        return "%d - %s".formatted(ordinal() + 1, speciesName);
    }
}
