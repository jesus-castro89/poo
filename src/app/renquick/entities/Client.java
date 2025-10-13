package app.renquick.entities;

import app.rentiquick.interfaces.Rentable;
import org.util.InputHandler;

import javax.swing.*;
import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Predicate;

public final class Client {

    private final UUID id;
    private String name;
    private int age;
    private String licenseNumber;
    private LocalDate licenseExpiry;

    public Client() {

        this.id = UUID.randomUUID();
        this.name = InputHandler.getInput(
                "Ingrese el nombre del cliente: ", "");
        this.age = InputHandler.getInput(
                "Ingrese la edad del cliente: ", 0);
        Predicate<String> licensePredicate =
                input -> !input.isEmpty() && input.matches("^[A-Z]{3}\\d{4}$");
        this.licenseNumber = InputHandler.getInput(
                "Ingrese el número de licencia del cliente (formato ABC1234): ", licensePredicate,
                "El número de licencia debe tener el formato ABC1234.",
                "");
        Predicate<LocalDate> datePredicate =
                date -> date.isAfter(LocalDate.parse("2026-12-31"));
        this.licenseExpiry = InputHandler.getInput(
                "Ingrese la fecha de vencimiento de la licencia (yyyy-MM-dd) posterior a 2026-12-31: ",
                datePredicate, "La fecha debe ser posterior a 2026-12-31.",
                LocalDate.now());
    }

    public boolean isValidLicense() {
        return licenseExpiry.isAfter(Rentable.VALID_EXPIRE_DATE);
    }

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