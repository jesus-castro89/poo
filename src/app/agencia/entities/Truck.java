package app.agencia.entities;

import app.input.InputHandler;

public class Truck extends Vehicle {

    private final double loadCapacity;

    public Truck() {
        super();
        loadCapacity = InputHandler.getInput("Ingrese la capacidad de carga del camión (en toneladas):", 0.0);
    }

    @Override
    public void displayInfo() {
        String info = "Información del Camión:\n" +
                "Modelo: " + model + "\n" +
                "Marca: " + brand + "\n" +
                "Placa: " + licensePlate + "\n" +
                "Año: " + year + "\n" +
                "Capacidad de carga: " + loadCapacity + " toneladas";
        InputHandler.showMessage(info, "Información del Camión",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}
