package app.agencia;

import app.agencia.entities.Car;
import app.agencia.entities.Motorcycle;
import app.agencia.entities.Truck;
import app.agencia.entities.Vehicle;

public class Test {

    void main(){

        VehicleWorkshop<Vehicle> vw = new VehicleWorkshop<>();
        vw.addVehicle(new Car());
        vw.addVehicle(new Motorcycle());
        vw.addVehicle(new Truck());

        Vehicle v = vw.searchVehicle(1);
        if (v != null) {
            v.displayInfo();
        }

        VehicleWorkshop<Car> vw2 = new VehicleWorkshop<>();
        vw2.addVehicle(new Car());
        vw2.addVehicle(new Car());
        vw2.addVehicle(new Car());

        Car v2 = vw2.searchVehicle(1);
        if (v2 != null) {
            v2.displayInfo();
        }
    }
}
