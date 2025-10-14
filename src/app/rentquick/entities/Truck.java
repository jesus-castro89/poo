package app.rentquick.entities;

import app.rentquick.exceptions.ValidationException;
import org.util.InputHandler;

public class Truck extends Vehicle {

    private final double maxLoadKg;

    public Truck() throws ValidationException {

        super();
        this.maxLoadKg = InputHandler.getInput("Ingrese la carga máxima en kg: ", 0.0);
    }

    @Override
    public double calculateRentalPrice(long days, Client customer) throws ValidationException {

        if (customer.getAge() < 25)
            throw new ValidationException("Customer must be at least 25 for trucks");
        double price = basePricePerDay * days;
        price += (maxLoadKg / 1000.0) * 10.0 * days; // surcharge per ton
        price += getInsuranceCost(days);
        return price;
    }

    @Override
    public double getInsuranceCost(long days) {

        return 30 * days;
    }

    @Override
    public String toString() {
        return "Modelo: %s - Matrícula: %s - Carga Máx: %.2f kg"
                .formatted(model, plate, maxLoadKg);
    }
}