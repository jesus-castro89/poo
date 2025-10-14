package app.rentquick.entities;

import app.rentquick.interfaces.Insurable;
import app.rentquick.interfaces.Rentable;
import app.rentquick.exceptions.ValidationException;
import app.rentquick.exceptions.VehicleUnavailableException;
import org.util.InputHandler;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public abstract class Vehicle implements Rentable, Insurable {

    protected final UUID id;
    protected final String plate;
    protected final String brand;
    protected final String model;
    protected final int year;
    protected final double basePricePerDay;
    protected boolean available = true;

    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z]{3}-\\d{4}$");

    public Vehicle() {

        Predicate<String> plateValidator =
                plate -> PLATE_PATTERN.matcher(plate).matches();
        Predicate<Integer> yearValidator =
                year -> year > 2015 && year <= LocalDate.now().getYear();
        Predicate<Double> priceValidator =
                price -> price > 0;

        this.id = UUID.randomUUID();
        this.plate = InputHandler.getInput(
                "Ingrese las placas del vehículo en formato ABC-1234: ",
                plateValidator, "Formato inválido. Intente de nuevo.", "");
        this.brand = InputHandler.getInput("Ingrese la marca del vehículo: ", "");
        this.model = InputHandler.getInput("Ingrese el modelo del vehículo: ", "");
        this.year = InputHandler.getInput("Ingrese el año del vehículo: ", yearValidator,
                "Año inválido. Debe ser mayor a 2015 y no mayor al año actual.", 0);
        this.basePricePerDay = InputHandler.getInput("Ingrese el precio base por día: ",
                priceValidator, "Precio inválido. Debe ser un número positivo.", 0.0);
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    @Override
    public Rental rentTo(Client customer, LocalDate start, LocalDate end)
            throws ValidationException, VehicleUnavailableException {

        // Validaciones
        if (!available)
            throw new VehicleUnavailableException("Vehicle not available");
        if (start == null || end == null || !start.isBefore(end))
            throw new ValidationException("Invalid rental dates");
        if (!customer.isValidLicense())
            throw new ValidationException("License expired before rental date");
        // Cálculo del precio
        long days = ChronoUnit.DAYS.between(start, end) + 1;
        double total = calculateRentalPrice(days, customer);
        // Aquí podemos agregar descuentos o promociones si es necesario
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