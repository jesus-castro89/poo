package app.rentquick.entities;

import app.rentquick.exceptions.ValidationException;
import org.util.InputHandler;

public class Motorcycle extends Vehicle {

    private final int engineCc;

    public Motorcycle() throws ValidationException {

        super();
        this.engineCc = InputHandler.getInput("Ingrese la capacidad del motor en cc: ", 0);
    }

    @Override
    public double calculateRentalPrice(long days, Client customer) throws ValidationException {

        if (customer.getAge() < 18)
            throw new ValidationException("Customer too young for motorcycles");
        double price = basePricePerDay * days;
        price += getInsuranceCost(days);
        return price;
    }

    @Override
    public double getInsuranceCost(long days) {

        return 8 * days;
    }

    @Override
    public String toString() {
        return "Modelo: %s - Matrícula: %s - Motor: %dcc"
                .formatted(model, plate, engineCc);
    }
}
