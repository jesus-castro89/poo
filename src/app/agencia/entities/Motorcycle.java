package app.agencia.entities;

import app.input.InputHandler;

import javax.swing.*;

public class Motorcycle extends Vehicle {

    private final String engineType;

    public Motorcycle() {

        engineType = InputHandler.getInput(
                "Ingrese el tipo de motor de la motocicleta:", "");
    }

    @Override
    public void displayInfo() {
        String info = "Información de la Motocicleta:\n" +
                "Modelo: " + model + "\n" +
                "Marca: " + brand + "\n" +
                "Placa: " + licensePlate + "\n" +
                "Año: " + year + "\n" +
                "Tipo de motor: " + engineType;
        InputHandler.showMessage(info, "Información de la Motocicleta",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
