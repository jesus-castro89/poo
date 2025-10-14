package app.rentquick.interfaces;

import app.rentquick.entities.Client;
import app.rentquick.entities.Rental;
import app.rentquick.exceptions.ValidationException;
import app.rentquick.exceptions.VehicleUnavailableException;

import java.time.LocalDate;

public interface Rentable {

    LocalDate VALID_EXPIRE_DATE = LocalDate.parse("2026-12-31");

    Rental rentTo(Client customer, LocalDate start, LocalDate end)
            throws ValidationException, VehicleUnavailableException;

    void returnVehicle();
}
