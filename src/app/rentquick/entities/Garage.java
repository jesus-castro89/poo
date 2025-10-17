package app.rentquick.entities;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Clase genérica que representa un garaje que puede almacenar vehículos de tipo T.
 * El tipo T debe ser una subclase de Vehicle.
 *
 * @param <T> Tipo de vehículo que el garaje puede almacenar.
 */
public class Garage<T extends Vehicle> {

    /**
     * Arreglo que almacena los vehículos en el garaje.
     */
    private final T[] vehicles;

    /**
     * Constructor que inicializa el garaje con una capacidad específica.
     *
     * @param capacity Capacidad máxima del garaje.
     */
    public Garage(int capacity) {

        this.vehicles = (T[]) new Vehicle[capacity];
    }

    /**
     * Agrega un vehículo al garaje.
     *
     * @param vehicle Vehículo a agregar.
     * @throws IllegalStateException si el garaje está lleno.
     */
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

    /**
     * Verifica si el garaje está lleno.
     *
     * @return true si el garaje está lleno, false en caso contrario.
     */
    public boolean isGarageFull() {

        return Arrays.stream(vehicles).allMatch(Objects::nonNull);
    }

    /**
     * Obtiene todos los vehículos actualmente almacenados en el garaje.
     *
     * @return Arreglo de vehículos en el garaje.
     */
    public Object[] getRentedVehicles() {

        if (Arrays.stream(vehicles).allMatch(Objects::isNull))
            return new Vehicle[0];
        else
            return Arrays.stream(vehicles)
                    .filter(vehicle ->
                            vehicle != null && !vehicle.isAvailable())
                    .toArray();
    }

    /**
     * Obtiene todos los vehículos disponibles para alquiler en el garaje.
     *
     * @return Arreglo de vehículos disponibles en el garaje.
     */
    public Object[] getAvailableVehicles() {

        if (Arrays.stream(vehicles).allMatch(Objects::isNull))
            return new Vehicle[0];
        else
            return Arrays.stream(vehicles)
                    .filter(vehicle -> vehicle != null && vehicle.isAvailable())
                    .toArray();
    }
}
