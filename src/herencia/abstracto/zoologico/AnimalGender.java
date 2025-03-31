package herencia.abstracto.zoologico;

public enum AnimalGender {
    MALE("Macho"),
    FEMALE("Hembra");

    String name;

    AnimalGender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d - %s".formatted(ordinal() + 1, name);
    }
}
