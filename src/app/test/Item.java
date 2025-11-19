package app.test;

import java.io.Serializable;

public class Item implements Serializable {

    private String name;
    private double price;
    private String brand;

    public Item(String name, double price) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "%s (%.2f)".formatted(name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
}