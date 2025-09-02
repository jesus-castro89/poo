package app.nomina;

public enum MenuOption {
    ADD_EMPLOYEE("Agregar empleado"),
    UPDATE_EMPLOYEE("Actualizar empleado"),
    REMOVE_EMPLOYEE("Eliminar empleado"),
    LIST_EMPLOYEES("Listar empleados"),
    CALCULATE_PAYROLL("Calcular nómina"),
    EXIT("Salir");

    private String description;

    MenuOption(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
