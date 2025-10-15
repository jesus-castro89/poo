package app.rentquick.entities;

import app.rentquick.exceptions.ValidationException;
import org.util.InputHandler;

/**
 * Clase que representa un automóvil en el sistema de alquiler.
 * Extiende la clase Vehicle e implementa las interfaces Rentable e Insurable.
 */
public class Car extends Vehicle {

    /**
     * Indica si el automóvil es de lujo.
     */
    private final boolean isLuxury;

    /**
     * Constructor que inicializa un automóvil con datos ingresados por el usuario.
     * Realiza validaciones básicas en los datos ingresados.
     *
     * @throws ValidationException si ocurre un error de validación.
     */
    public Car() throws ValidationException {

        super();
        this.isLuxury = InputHandler.getInput("El vehículo es de lujo? (s/n): ", true);
    }

    /**
     * Calcula el precio de alquiler para el automóvil.
     *
     * @param days     Número de días de alquiler.
     * @param customer Cliente que realiza el alquiler.
     * @return Precio total del alquiler.
     * @throws ValidationException si ocurre un error de validación.
     */
    @Override
    public double calculateRentalPrice(long days, Client customer) throws ValidationException {

        if (customer.getAge() < 21)
            throw new ValidationException("Customer must be at least 21 for cars");
        double price = basePricePerDay * days;
        if (isLuxury) price += 50 * days;  // surcharge for luxury
        if (customer.getAge() < 25) price += 20 * days;  // young driver fee
        price += getInsuranceCost(days);
        return price;
    }

    /**
     * Calcula el costo del seguro para el automóvil.
     *
     * @param days Número de días de alquiler.
     * @return Costo del seguro.
     */
    @Override
    public double getInsuranceCost(long days) {

        return 15 * days;
    }

    /**
     * Devuelve una representación en cadena del automóvil.
     *
     * @return Representación en cadena del automóvil.
     */
    @Override
    public String toString() {
        return "Modelo: %s - Matrícula: %s - Lujo: %s"
                .formatted(model, plate, isLuxury ? "Sí" : "No");
    }
}