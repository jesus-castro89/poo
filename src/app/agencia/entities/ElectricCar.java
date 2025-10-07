package app.agencia.entities;

import org.util.InputHandler;

import javax.swing.*;

public class ElectricCar extends ElectricVehicle {

    private final int numberOfDoors;

    public ElectricCar() {

        numberOfDoors = InputHandler.getInput("Ingrese el número de puertas del auto eléctrico:", 0);
    }

    @Override
    public void displayInfo() {
        String message = """
                Información del Auto Eléctrico:
                Modelo: %s
                Marca: %s
                Placa: %s
                Año: %d
                Capacidad de la batería: %.2f kWh
                Número de puertas: %d
                """.formatted(model, brand, licensePlate, year, batteryCapacity, numberOfDoors);
        InputHandler.showMessage(message, "Información del Auto Eléctrico", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void chargeBattery() {
        InputHandler.showMessage("El auto eléctrico está cargando su batería.", "Cargando Batería",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
