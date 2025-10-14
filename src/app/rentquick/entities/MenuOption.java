package app.rentquick.entities;

public enum MenuOption {

    ADD_VEHICLE("Agregar Vehículo"),
    ADD_CLIENT("Agregar Cliente"),
    CREATE_RENTAL("Crear Alquiler"),
    RETURN_VEHICLE("Devolver Vehículo"),
    EXIT("Salir");

    private final String description;

    MenuOption(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}