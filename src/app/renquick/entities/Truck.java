package app.renquick.entities;

import app.rentquick.exceptions.ValidationException;

// File: Truck.java
public class Truck extends Vehicle {
    private final double maxLoadKg;

    public Truck(String licensePlate, String brand, String model, int year,
                 double basePricePerDay, double maxLoadKg) throws ValidationException {
        super(licensePlate, brand, model, year, basePricePerDay);
        this.maxLoadKg = maxLoadKg;
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
}