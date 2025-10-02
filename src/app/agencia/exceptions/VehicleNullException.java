package app.agencia.exceptions;

public class VehicleNullException extends Exception {

    public VehicleNullException() {
        super("No existe el vehículo en esa posición del taller.");
    }
}
