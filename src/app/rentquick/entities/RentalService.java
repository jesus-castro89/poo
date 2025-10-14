package app.rentquick.entities;

import app.rentquick.exceptions.ClientsFullException;
import app.rentquick.exceptions.RentalsFullException;
import app.rentquick.exceptions.ValidationException;
import org.util.InputHandler;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class RentalService<T extends Vehicle> {

    private Garage<T> garage;
    private Client[] clients;
    private Rental[] rentals;
    private Class<T> vehicleType;

    public RentalService(int garageCapacity, int maxClients, Class<T> vehicleType) {

        this.garage = new Garage<>(garageCapacity);
        this.clients = new Client[maxClients];
        this.rentals = new Rental[garageCapacity];
        this.vehicleType = vehicleType;
    }

    public void showMenu() {

        MenuOption option;
        do {
            option = InputHandler.getInput("Seleccione una opción:", MenuOption.values());
            try {
                switch (option) {
                    case ADD_VEHICLE -> {
                        switch (vehicleType.getSimpleName()) {
                            case "Car" -> addVehicle((T) new Car());
                            case "Motorcycle" -> addVehicle((T) new Motorcycle());
                            case "Truck" -> addVehicle((T) new Truck());
                            default -> throw new IllegalStateException("Tipo de vehículo no soportado.");
                        }
                        InputHandler.showMessage("Vehículo agregado exitosamente.",
                                "ÉXITO",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    case ADD_CLIENT -> {
                        addClient();
                        InputHandler.showMessage("Cliente agregado exitosamente.",
                                "ÉXITO",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    case CREATE_RENTAL -> {
                        addRental();
                        InputHandler.showMessage("Alquiler creado exitosamente.",
                                "ÉXITO",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    case RETURN_VEHICLE -> returnVehicle();
                    case EXIT -> InputHandler.showMessage("Saliendo del sistema.",
                            "SALIR",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ClientsFullException | RentalsFullException |
                     IllegalStateException | ValidationException e) {
                InputHandler.showMessage(e.getMessage(),
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (option != MenuOption.EXIT);
    }

    public void returnVehicle() {

        T vehicle = selectRentedVehicle();
        if (vehicle != null) {
            vehicle.returnVehicle();
            InputHandler.showMessage("Vehículo devuelto exitosamente.",
                    "ÉXITO",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            InputHandler.showMessage("No hay vehículos alquilados.",
                    "INFO",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addClient() throws ClientsFullException {

        Predicate<Client[]> isFullClientsPredicate =
                clientsArray -> Arrays.stream(clientsArray).allMatch(Objects::nonNull);

        if (isFullClientsPredicate.test(clients))
            throw new ClientsFullException("Se ha alcanzado el número máximo de clientes.");

        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                clients[i] = new Client();
                break;
            }
        }
    }

    public void addRental() throws RentalsFullException, ValidationException {

        Client client;
        T vehicle;
        LocalDate startDate, endDate;
        int rentalDays;
        Predicate<LocalDate> startDatePredicate =
                date -> date.isAfter(LocalDate.now());
        Predicate<LocalDate> endDatePredicate;

        if (Arrays.stream(rentals).allMatch(Objects::nonNull))
            throw new RentalsFullException("No hay espacio para más alquileres.");

        for (int i = 0; i < rentals.length; i++) {
            if (rentals[i] == null) {
                client = selectClient();
                if(client == null)
                    InputHandler.showMessage("No hay clientes disponibles. Agregue un cliente primero.",
                            "INFO",
                            JOptionPane.INFORMATION_MESSAGE);
                vehicle = selectVehicle();
                if(vehicle == null)
                    InputHandler.showMessage("No hay vehículos disponibles. Agregue un vehículo primero.",
                            "INFO",
                            JOptionPane.INFORMATION_MESSAGE);
                if (client != null && vehicle != null) {

                    startDate = InputHandler.getInput(
                            "Ingrese la fecha de inicio del alquiler (yyyy-MM-dd) posterior a hoy: ",
                            startDatePredicate,
                            "La fecha debe ser posterior a hoy.",
                            LocalDate.now());
                    endDatePredicate =
                            date -> date.isAfter(startDate);
                    endDate = InputHandler.getInput(
                            "Ingrese la fecha de fin del alquiler (yyyy-MM-dd) posterior a la fecha de inicio: ",
                            endDatePredicate,
                            "La fecha debe ser posterior a la fecha de inicio.",
                            startDate);
                    try {
                        // Aquí deberíamos llamar a vehicle.rentTo, pero para simplificar:
                        rentals[i] = vehicle.rentTo(client, startDate, endDate);
                    } catch (ValidationException e) {
                        InputHandler.showMessage("No es posible crear el alquiler: " + e.getMessage(),
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    throw new ValidationException("Cliente o vehículo no seleccionado.");
                }
                break;
            }
        }
    }

    public void addVehicle(T vehicle) {

        if (garage.isGarageFull())
            throw new IllegalStateException("Garage is full");
        garage.addVehicle(vehicle);
    }

    private Client selectClient() {

        return getAvailableClients().length > 0 ?
                (Client) InputHandler.getInput("Seleccione un cliente: ", getAvailableClients()) : null;
    }

    private T selectRentedVehicle() {

        return garage.getRentedVehicles().length > 0 ?
                (T) InputHandler.getInput("Seleccione un vehículo alquilado: ",
                        garage.getRentedVehicles()) : null;
    }

    private T selectVehicle() {

        return garage.getAvailableVehicles().length > 0 ?
                (T) InputHandler.getInput("Seleccione un vehículo: ",
                        garage.getAvailableVehicles()) : null;
    }

    private Object[] getAvailableClients() {

        return Arrays.stream(clients)
                .filter(Objects::nonNull)
                .toArray();
    }
}
