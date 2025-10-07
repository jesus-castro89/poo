package app.agencia.entities;

import org.util.InputHandler;

public abstract class Vehicle {

    protected String model;
    protected String brand;
    protected String licensePlate;
    protected int year;

    public Vehicle() {

        model = InputHandler.getInput(
                "Ingrese el modelo del vehículo:", "");
        brand = InputHandler.getInput(
                "Ingrese la marca del vehículo:", "");
        licensePlate = InputHandler.getInput(
                "Ingrese la placa del vehículo:", "");
        year = InputHandler.getInput(
                "Ingrese el año del vehículo:", 0);
    }

    public abstract void displayInfo();

    public String getBrand() {
        return brand;
    }
}