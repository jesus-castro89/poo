package app.rentquick.entities;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class Garage<T extends Vehicle> {

    private final T[] vehicles;

    public Garage(int capacity) {

        this.vehicles = (T[]) new Vehicle[capacity];
    }

    public void addVehicle(T vehicle) {
        // Creamos un predicado para verificar si el garaje está lleno
        Predicate<T[]> isFullPredicate =
                arr -> Arrays.stream(arr).allMatch(Objects::nonNull);
        // Si el garaje está lleno, lanzamos una excepción
        if (isFullPredicate.test(vehicles))
            throw new IllegalStateException("Garage is full");
        // Si no está lleno, agregamos el vehículo en la primera posición nula
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                break;
            }
        }
    }

    public boolean isGarageFull() {

        return Arrays.stream(vehicles).allMatch(Objects::nonNull);
    }

    public Object[] getRentedVehicles() {

        if (Arrays.stream(vehicles).allMatch(Objects::isNull))
            return new Vehicle[0];
        else
            return Arrays.stream(vehicles)
                    .filter(vehicle -> vehicle != null && !vehicle.isAvailable())
                    .toArray();
    }

    public Object[] getAvailableVehicles() {

        if (Arrays.stream(vehicles).allMatch(Objects::isNull))
            return new Vehicle[0];
        else
            return Arrays.stream(vehicles)
                    .filter(vehicle -> vehicle != null && vehicle.isAvailable())
                    .toArray();
    }
}
