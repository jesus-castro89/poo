package app.rentquick.entities;

import app.rentquick.exceptions.ValidationException;
import org.util.InputHandler;

import java.util.UUID;

/**
 * Clase que representa un camión en el sistema de alquiler.
 * Extiende la clase Vehicle e implementa las interfaces Rentable e Insurable.
 */
public class Truck extends Vehicle {

    /**
     * Carga máxima del camión en kilogramos.
     */
    private final double maxLoadKg;

    /**
     * Constructor que inicializa un camión con datos ingresados por el usuario.
     * Realiza validaciones básicas en los datos ingresados.
     *
     * @throws ValidationException si ocurre un error de validación.
     */
    public Truck() throws ValidationException {

        super();
        this.maxLoadKg = InputHandler.getInput("Ingrese la carga máxima en kg: ", 0.0);
    }

    /**
     * Calcula el precio de alquiler para el camión.
     *
     * @param days     Número de días de alquiler.
     * @param customer Cliente que realiza el alquiler.
     * @return Precio total del alquiler.
     * @throws ValidationException si ocurre un error de validación.
     */
    @Override
    public double calculateRentalPrice(long days, Client customer) throws ValidationException {

        if (customer.getAge() < 25)
            throw new ValidationException("Customer must be at least 25 for trucks");
        double price = basePricePerDay * days;
        price += (maxLoadKg / 1000.0) * 10.0 * days; // surcharge per ton
        price += getInsuranceCost(days);
        return price;
    }

    public Truck(String plate, String brand, String model, int year, double basePricePerDay, double maxLoadKg) {
        super(plate, brand, model, year, basePricePerDay);
        this.maxLoadKg = maxLoadKg;
    }

    /**
     * Calcula el costo del seguro para el camión.
     *
     * @param days Número de días de alquiler.
     * @return Costo del seguro.
     */
    @Override
    public double getInsuranceCost(long days) {

        return 30 * days;
    }

    /**
     * Devuelve una representación en cadena del camión.
     *
     * @return Representación en cadena del camión.
     */
    @Override
    public String toString() {
        return "Modelo: %s - Matrícula: %s - Carga Máx: %.2f kg"
                .formatted(model, plate, maxLoadKg);
    }

    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }
}