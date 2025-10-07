package app.agencia.entities;

import org.util.InputHandler;

public abstract class ElectricVehicle extends Vehicle {

    protected double batteryCapacity;

    public ElectricVehicle() {

        batteryCapacity = InputHandler.getInput("Ingrese la capacidad de la batería (kWh):", 0.0);
    }

    public abstract void chargeBattery();
}
