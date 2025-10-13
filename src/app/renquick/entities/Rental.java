package app.renquick.entities;

// File: Rental.java

import java.time.LocalDate;
import java.util.UUID;

public class Rental {
    private final UUID id;
    private final Vehicle vehicle;
    private final Client customer;
    private final LocalDate start;
    private final LocalDate end;
    private final double totalPrice;

    public Rental(Vehicle vehicle, Client customer, LocalDate start, LocalDate end, double totalPrice) {
        this.id = UUID.randomUUID();
        this.vehicle = vehicle;
        this.customer = customer;
        this.start = start;
        this.end = end;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return String.format("Rental[id=%s, vehicle=%s, customer=%s, from=%s to=%s, total=%.2f]",
                id, vehicle.licensePlate, customer.getName(), start, end, totalPrice);
    }
}
