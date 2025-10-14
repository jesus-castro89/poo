package app.rentquick;

import app.rentquick.entities.Car;
import app.rentquick.entities.RentalService;

public class Main {

    void main(){
        RentalService<Car> rentalService = new RentalService<>(10, 5,
                Car.class);
        rentalService.showMenu();
    }
}
