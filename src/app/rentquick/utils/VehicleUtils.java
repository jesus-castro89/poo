package app.rentquick.utils;

import app.rentquick.entities.Vehicle;

public class VehicleUtils {

    private Vehicle vehicle;

    public VehicleUtils(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleInfo() {

        return """
                Vehicle Information:
                --------------------
                Tipo: %s
                Marca: %s
                Modelo: %s
                Año: %d
                Matrícula: %s
                Precio base por día: %.2f
                --------------------
                """.formatted(
                vehicle.getClass().getSimpleName(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getPlate(),
                vehicle.getBasePricePerDay());
    }
}
