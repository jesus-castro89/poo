package app.rentquick.entities;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Clase que representa un alquiler de un vehículo por un cliente.
 */
public class Rental {

    /**
     * Identificador único del alquiler.
     */
    private final UUID id;
    /**
     * Vehículo alquilado.
     */
    private final Vehicle vehicle;
    /**
     * Cliente que realiza el alquiler.
     */
    private final Client customer;
    /**
     * Fecha de inicio del alquiler.
     */
    private final LocalDate start;
    /**
     * Fecha de fin del alquiler.
     */
    private final LocalDate end;
    /**
     * Precio total del alquiler.
     */
    private final double totalPrice;

    /**
     * Constructor que inicializa un alquiler con los datos proporcionados.
     *
     * @param vehicle    Vehículo alquilado.
     * @param customer   Cliente que realiza el alquiler.
     * @param start      Fecha de inicio del alquiler.
     * @param end        Fecha de fin del alquiler.
     * @param totalPrice Precio total del alquiler.
     */
    public Rental(Vehicle vehicle, Client customer, LocalDate start, LocalDate end, double totalPrice) {

        this.id = UUID.randomUUID();
        this.vehicle = vehicle;
        this.customer = customer;
        this.start = start;
        this.end = end;
        this.totalPrice = totalPrice;
    }

    /**
     * Devuelve una representación en cadena del alquiler.
     *
     * @return Representación en cadena del alquiler.
     */
    @Override
    public String toString() {

        return String.format("Rental[id=%s, vehicle=%s, customer=%s, from=%s to=%s, total=%.2f]",
                id, vehicle.plate, customer.getName(), start, end, totalPrice);
    }
}