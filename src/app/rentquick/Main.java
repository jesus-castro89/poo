package app.rentquick;

import app.rentquick.entities.Car;
import app.rentquick.entities.RentalService;
import app.rentquick.entities.Truck;
import app.rentquick.entities.Vehicle;
import app.rentquick.exceptions.ValidationException;

import java.util.Arrays;

public class Main {

    void main() {
        RentalService<Vehicle> rentalService =
                new RentalService<>(10, 5, Vehicle.class);
        rentalService.addVehicle(
                new Car("ABC-1234", "Toyota",
                        "Camry", 2020,
                        70.0, true));
        rentalService.addVehicle(
                new Truck("ABC-1234", "Toyota",
                        "Camry", 2020,
                        70.0, 2000.0));
        Vehicle v = rentalService.selectVehicle();
        IO.println(v);
    }
}
