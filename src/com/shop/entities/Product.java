package com.shop.entities;

public abstract class Product {

    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "%s (%.2f USD)".formatted(this.name, this.price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
