package app.renquick.entities;

import app.rentiquick.interfaces.Insurable;
import app.rentiquick.interfaces.Rentable;
import app.rentquick.exceptions.ValidationException;
import app.rentquick.exceptions.VehicleUnavailableException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.regex.Pattern;

public abstract class Vehicle implements Rentable, Insurable {

    protected final UUID id;
    protected final String licensePlate;
    protected final String brand;
    protected final String model;
    protected final int year;
    protected final double basePricePerDay;
    protected boolean available = true;

    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z0-9\\-]{6,8}$");

    public Vehicle(String licensePlate, String brand, String model, int year, double basePricePerDay)
            throws ValidationException {

        if (licensePlate == null || !PLATE_PATTERN.matcher(licensePlate).matches())
            throw new ValidationException("Invalid license plate format");
        if (year > LocalDate.now().getYear())
            throw new ValidationException("Invalid vehicle year");
        if (basePricePerDay <= 0)
            throw new ValidationException("Base price must be greater than 0");

        this.id = UUID.randomUUID();
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePricePerDay = basePricePerDay;
    }

    @Override
    public synchronized Rental rentTo(Client customer, LocalDate start, LocalDate end)
            throws ValidationException, VehicleUnavailableException {

        if (!available)
            throw new VehicleUnavailableException("Vehicle not available");
        if (start == null || end == null || !start.isBefore(end))
            throw new ValidationException("Invalid rental dates");
        if (!customer.isValidLicense())
            throw new ValidationException("License expired before rental date");
        long days = ChronoUnit.DAYS.between(start, end) + 1;
        double total = calculateRentalPrice(days, customer);
        available = false;
        return new Rental(this, customer, start, end, total);
    }

    @Override
    public synchronized void returnVehicle() {

        this.available = true;
    }

    public boolean isAvailable() {

        return available;
    }

    public abstract double calculateRentalPrice(long days, Client customer) throws ValidationException;
}