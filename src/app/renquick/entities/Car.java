package app.renquick.entities;

import app.rentquick.exceptions.ValidationException;

// File: Car.java
public class Car extends Vehicle {
    private final boolean isLuxury;

    public Car(String licensePlate, String brand, String model, int year,
               double basePricePerDay, boolean isLuxury) throws ValidationException {
        super(licensePlate, brand, model, year, basePricePerDay);
        this.isLuxury = isLuxury;
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
}
