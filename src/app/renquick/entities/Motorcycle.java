package app.renquick.entities;

import app.rentquick.exceptions.ValidationException;

public class Motorcycle extends Vehicle {

    private final int engineCc;

    public Motorcycle(String licensePlate, String brand, String model, int year,
                      double basePricePerDay, int engineCc) throws ValidationException {

        super(licensePlate, brand, model, year, basePricePerDay);
        this.engineCc = engineCc;
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
}
