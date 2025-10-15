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

/**
 * Clase abstracta que representa un vehículo en el sistema de alquiler.
 * Implementa las interfaces Rentable e Insurable.
 */
public abstract class Vehicle implements Rentable, Insurable {

    /**
     * Identificador único del vehículo.
     */
    protected final UUID id;
    /**
     * Placas del vehículo.
     */
    protected final String plate;
    /**
     * Marca del vehículo.
     */
    protected final String brand;
    /**
     * Modelo del vehículo.
     */
    protected final String model;
    /**
     * Año del vehículo.
     */
    protected final int year;
    /**
     * Precio base por día de alquiler.
     */
    protected final double basePricePerDay;
    /**
     * Indica si el vehículo está disponible para alquiler.
     */
    protected boolean available = true;
    /**
     * Patrón regex para validar las placas del vehículo.
     */
    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z]{3}-\\d{4}$");

    /**
     * Constructor que inicializa un vehículo con datos ingresados por el usuario.
     * Realiza validaciones básicas en los datos ingresados.
     */
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

    public boolean isAvailable() {

        return available;
    }

    /**
     * Función para alquilar el vehículo a un cliente.
     *
     * @param customer Cliente que desea alquilar el vehículo.
     * @param start    Fecha de inicio del alquiler.
     * @param end      Fecha de fin del alquiler.
     * @return Objeto Rental que representa el alquiler realizado.
     * @throws ValidationException         Si las fechas son inválidas o la licencia del cliente ha expirado.
     * @throws VehicleUnavailableException Si el vehículo no está disponible para alquiler.
     */
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

    /**
     * Función para devolver el vehículo.
     * Marca el vehículo como disponible nuevamente.
     */
    @Override
    public void returnVehicle() {

        this.available = true;
    }

    /**
     * Método abstracto para calcular el precio del alquiler.
     * Debe ser implementado por las subclases.
     *
     * @param days     Número de días del alquiler.
     * @param customer Cliente que realiza el alquiler.
     * @return Precio total del alquiler.
     * @throws ValidationException Si hay algún error en la validación de datos.
     */
    public abstract double calculateRentalPrice(long days, Client customer) throws ValidationException;
}