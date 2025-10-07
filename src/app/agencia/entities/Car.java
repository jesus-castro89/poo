package app.agencia.entities;

import org.util.InputHandler;

import javax.swing.*;

public class Car extends Vehicle {

    private final int numberOfDoors;

    public Car() {

        numberOfDoors = InputHandler.getInput(
                "Ingrese el número de puertas del carro:", 0);
    }

    @Override
    public void displayInfo() {
        String info = """
                Información del Carro:
                Marca: %s
                Modelo: %s
                Año: %d
                Placa: %s
                Número de Puertas: %d
                """.formatted(brand, model, year, licensePlate, numberOfDoors);
        InputHandler.showMessage(info, "Información del Carro", JOptionPane.INFORMATION_MESSAGE);
    }
}
