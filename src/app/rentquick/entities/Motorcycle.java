package app.rentquick.entities;

import app.rentquick.exceptions.ValidationException;
import org.util.InputHandler;

/**
 * Clase que representa una motocicleta en el sistema de alquiler.
 * Extiende la clase Vehicle e implementa las interfaces Rentable e Insurable.
 */
public class Motorcycle extends Vehicle {

    /**
     * Capacidad del motor en centímetros cúbicos (cc).
     */
    private final int engineCc;

    /**
     * Constructor que inicializa una motocicleta con datos ingresados por el usuario.
     * Realiza validaciones básicas en los datos ingresados.
     *
     * @throws ValidationException si ocurre un error de validación.
     */
    public Motorcycle() throws ValidationException {

        super();
        this.engineCc = InputHandler.getInput("Ingrese la capacidad del motor en cc: ", 0);
    }

    /**
     * Calcula el precio de alquiler para la motocicleta.
     *
     * @param days     Número de días de alquiler.
     * @param customer Cliente que realiza el alquiler.
     * @return Precio total del alquiler.
     * @throws ValidationException si ocurre un error de validación.
     */
    @Override
    public double calculateRentalPrice(long days, Client customer) throws ValidationException {

        if (customer.getAge() < 18)
            throw new ValidationException("Customer too young for motorcycles");
        double price = basePricePerDay * days;
        price += getInsuranceCost(days);
        return price;
    }

    /**
     * Calcula el costo del seguro para la motocicleta.
     *
     * @param days Número de días de alquiler.
     * @return Costo del seguro.
     */
    @Override
    public double getInsuranceCost(long days) {

        return 8 * days;
    }

    /**
     * Devuelve una representación en cadena de la motocicleta.
     *
     * @return Representación en cadena de la motocicleta.
     */
    @Override
    public String toString() {
        return "Modelo: %s - Matrícula: %s - Motor: %dcc"
                .formatted(model, plate, engineCc);
    }
}
