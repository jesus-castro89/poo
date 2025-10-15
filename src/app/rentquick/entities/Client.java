package app.rentquick.entities;

import app.rentquick.interfaces.Rentable;
import org.util.InputHandler;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * Clase que representa un cliente en el sistema de alquiler.
 */
public final class Client {

    /**
     * Identificador único del cliente.
     */
    private final UUID id;
    /**
     * Nombre del cliente.
     */
    private String name;
    /**
     * Edad del cliente.
     */
    private int age;
    /**
     * Número de licencia del cliente.
     */
    private String licenseNumber;
    /**
     * Fecha de vencimiento de la licencia del cliente.
     */
    private LocalDate licenseExpiry;

    /**
     * Constructor que inicializa un cliente con datos ingresados por el usuario.
     * Realiza validaciones básicas en los datos ingresados.
     */
    public Client() {

        this.id = UUID.randomUUID();
        this.name = InputHandler.getInput(
                "Ingrese el nombre del cliente: ", "");

        Predicate<Integer> minumAgePredicate =
                age -> age >= 18;
        this.age = InputHandler.getInput(
                "Ingrese la edad del cliente: ", minumAgePredicate,
                "La edad mínima para rentar es 18 años.",
                0);

        Predicate<String> licensePredicate =
                input -> !input.isEmpty() && input.matches("^[A-Z]{3}\\d{4}$");
        this.licenseNumber = InputHandler.getInput(
                "Ingrese el número de licencia del cliente (formato ABC1234): ", licensePredicate,
                "El número de licencia debe tener el formato ABC1234.",
                "");

        Predicate<LocalDate> datePredicate =
                date -> date.isAfter(Rentable.VALID_EXPIRE_DATE);
        this.licenseExpiry = InputHandler.getInput(
                "Ingrese la fecha de vencimiento de la licencia (yyyy-MM-dd) posterior a 2026-12-31: ",
                datePredicate, "La fecha debe ser posterior a 2026-12-31.",
                LocalDate.now());
    }

    /**
     * Verifica si la licencia del cliente es válida.
     *
     * @return true si la licencia es válida, false en caso contrario.
     */
    public boolean isValidLicense() {
        return licenseExpiry.isAfter(Rentable.VALID_EXPIRE_DATE);
    }

    /**
     * Devuelve una representación en cadena del cliente.
     *
     * @return Representación en cadena del cliente.
     */
    @Override
    public String toString() {
        return "Nombre: %s - Licencia: %s".formatted(name, licenseNumber);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}