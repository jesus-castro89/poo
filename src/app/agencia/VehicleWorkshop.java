package app.agencia;

import app.agencia.entities.Vehicle;
import app.agencia.exceptions.VehicleNullException;
import app.input.InputHandler;

import javax.swing.*;

public class VehicleWorkshop<T extends Vehicle> {

    private final T[] vehicles;

    public VehicleWorkshop() {
        vehicles = (T[]) new Vehicle[10]; // Array to hold up to 10 vehicles
    }

    public void addVehicle(T vehicle) {

        boolean added = false;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                added = true;
                break;
            }
        }
        if (!added) {
            InputHandler.showMessage("El taller está lleno, no se puede agregar más vehículos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addVehicle(T vehicle, int index) {
        if (index >= 0 && index < vehicles.length) {
            vehicles[index] = vehicle;
        } else {
            InputHandler.showMessage("La vehiculo esta vacía",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public T searchVehicle(int index) {

        try {
            if (index >= 0 && index < vehicles.length) {
                T vehicle = vehicles[index];
                if (vehicle != null) {
                    vehicle.displayInfo();
                    return vehicle;
                } else {
                    throw new VehicleNullException();
                }
            } else {
                throw new VehicleNullException();
            }
        } catch (VehicleNullException e) {
            InputHandler.showMessage(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public T[] searchVehicle(String brand) {

        T[] foundVehicles = (T[]) new Vehicle[vehicles.length];
        int count = 0;
        for (T vehicle : vehicles) {
            if (vehicle != null && vehicle.getBrand().equalsIgnoreCase(brand)) {
                foundVehicles[count++] = vehicle;
            }
        }
        if (count == 0) {
            InputHandler.showMessage("No se encontraron vehículos de la marca: " + brand,
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        T[] result = (T[]) new Vehicle[count];
        System.arraycopy(foundVehicles, 0, result, 0, count);
        return result;
    }

    public void displayVehicles() {
        for (T vehicle : vehicles) {
            if (vehicle != null) {
                vehicle.displayInfo();
            }
        }
    }
}
