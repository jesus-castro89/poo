package app.test;

public class Item {

    private String name;
    private double price;

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
}