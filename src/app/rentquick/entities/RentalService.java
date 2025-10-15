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

/**
 * Clase que representa el servicio de alquiler de vehículos.
 *
 * @param <T> Tipo de vehículo que extiende de Vehicle.
 */
public class RentalService<T extends Vehicle> {

    /**
     * Capacidad máxima del garaje.
     */
    private Garage<T> garage;
    /**
     * Arreglo que almacena los clientes registrados.
     */
    private Client[] clients;
    /**
     * Arreglo que almacena los alquileres realizados.
     */
    private Rental[] rentals;
    /**
     * Tipo de vehículo que maneja el servicio de alquiler.
     */
    private Class<T> vehicleType;

    /**
     * Constructor que inicializa el servicio de alquiler con la capacidad del garaje,
     * el número máximo de clientes y el tipo de vehículo.
     *
     * @param garageCapacity Capacidad máxima del garaje.
     * @param maxClients     Número máximo de clientes.
     * @param vehicleType    Tipo de vehículo que maneja el servicio.
     */
    public RentalService(int garageCapacity, int maxClients, Class<T> vehicleType) {

        this.garage = new Garage<>(garageCapacity);
        this.clients = new Client[maxClients];
        this.rentals = new Rental[garageCapacity];
        this.vehicleType = vehicleType;
    }

    /**
     * Función que muestra el menú principal y maneja las opciones seleccionadas por el usuario.
     * Permite agregar vehículos, clientes, crear alquileres y devolver vehículos.
     * Maneja excepciones y muestra mensajes de éxito o error según corresponda.
     */
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

    /**
     * Función para devolver un vehículo alquilado.
     * Permite al usuario seleccionar un vehículo alquilado y marcarlo como devuelto.
     * Muestra mensajes de éxito o información según corresponda.
     */
    public void returnVehicle() {

        T vehicle = selectRentedVehicle();
        if (vehicle != null) {
            vehicle.returnVehicle();
            InputHandler.showMessage("Vehículo devuelto exitosamente.",
                    "ÉXITO",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            InputHandler.showMessage("No hay vehículos alquilados.",
                    "INFO",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Función para agregar un nuevo cliente al sistema.
     * Verifica si hay espacio disponible para nuevos clientes y agrega uno si es posible.
     *
     * @throws ClientsFullException si no hay espacio para más clientes.
     */
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

    /**
     * Función para agregar un nuevo alquiler al sistema.
     * Permite seleccionar un cliente y un vehículo, y especificar las fechas de inicio y fin del alquiler.
     * Verifica si hay espacio disponible para nuevos alquileres y crea uno si es posible.
     *
     * @throws RentalsFullException si no hay espacio para más alquileres.
     * @throws ValidationException  si ocurre un error de validación en los datos ingresados.
     */
    public void addRental() throws RentalsFullException, ValidationException {

        Client client;
        T vehicle;
        LocalDate startDate, endDate;
        Predicate<LocalDate> startDatePredicate =
                date -> date.isAfter(LocalDate.now());
        Predicate<LocalDate> endDatePredicate;

        if (Arrays.stream(rentals).allMatch(Objects::nonNull))
            throw new RentalsFullException("No hay espacio para más alquileres.");

        for (int i = 0; i < rentals.length; i++) {
            if (rentals[i] == null) {
                client = selectClient();
                if (client == null)
                    InputHandler.showMessage("No hay clientes disponibles. Agregue un cliente primero.",
                            "INFO",
                            JOptionPane.INFORMATION_MESSAGE);
                vehicle = selectVehicle();
                if (vehicle == null)
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
                        rentals[i] = vehicle.rentTo(client, startDate, endDate);
                    } catch (ValidationException e) {
                        InputHandler.showMessage("No es posible crear el alquiler: " + e.getMessage(),
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    throw new ValidationException("Cliente o vehículo no seleccionado.");
                }
                break;
            }
        }
    }

    /**
     * Función para agregar un nuevo vehículo al garaje.
     * Verifica si hay espacio disponible en el garaje y agrega el vehículo si es posible.
     *
     * @param vehicle Vehículo a agregar.
     * @throws IllegalStateException si el garaje está lleno.
     */
    public void addVehicle(T vehicle) {

        if (garage.isGarageFull())
            throw new IllegalStateException("Garage is full");
        garage.addVehicle(vehicle);
    }

    /**
     * Función para seleccionar un cliente de la lista de clientes disponibles.
     *
     * @return Cliente seleccionado o null si no hay clientes disponibles.
     */
    private Client selectClient() {

        return getAvailableClients().length > 0 ?
                (Client) InputHandler.getInput("Seleccione un cliente: ", getAvailableClients()) : null;
    }

    /**
     * Función para seleccionar un vehículo alquilado de la lista de vehículos alquilados.
     *
     * @return Vehículo seleccionado o null si no hay vehículos alquilados.
     */
    private T selectRentedVehicle() {

        return garage.getRentedVehicles().length > 0 ?
                (T) InputHandler.getInput("Seleccione un vehículo alquilado: ",
                        garage.getRentedVehicles()) : null;
    }

    /**
     * Función para seleccionar un vehículo disponible de la lista de vehículos disponibles.
     *
     * @return Vehículo seleccionado o null si no hay vehículos disponibles.
     */
    private T selectVehicle() {

        return garage.getAvailableVehicles().length > 0 ?
                (T) InputHandler.getInput("Seleccione un vehículo: ",
                        garage.getAvailableVehicles()) : null;
    }

    /**
     * Función para obtener todos los clientes actualmente registrados en el sistema.
     *
     * @return Arreglo de clientes registrados.
     */
    private Object[] getAvailableClients() {

        return Arrays.stream(clients)
                .filter(Objects::nonNull)
                .toArray();
    }
}
