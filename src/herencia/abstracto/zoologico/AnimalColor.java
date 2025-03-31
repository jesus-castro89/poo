package herencia.abstracto.zoologico;

public enum AnimalColor {

    WHITE("Blanco"),
    BLACK("Negro"),
    BROWN("Café"),
    GRAY("Gris"),
    YELLOW("Amarillo"),
    RED("Rojo"),
    OTHER("Otro");

    String colorName;

    AnimalColor(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    @Override
    public String toString() {
        return "%d - %s".formatted(ordinal() + 1, colorName);
    }
}
