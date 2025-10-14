package app.rentquick.entities;

import app.rentquick.exceptions.ValidationException;
import org.util.InputHandler;

public class Car extends Vehicle {

    private final boolean isLuxury;

    public Car() throws ValidationException {

        super();
        this.isLuxury = InputHandler.getInput("El vehículo es de lujo? (s/n): ", true);
    }

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

    @Override
    public double getInsuranceCost(long days) {

        return 15 * days;
    }

    @Override
    public String toString() {
        return "Modelo: %s - Matrícula: %s - Lujo: %s"
                .formatted(model, plate, isLuxury ? "Sí" : "No");
    }
}