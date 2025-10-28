package com.shop.entities;

public class Grocery extends Product {

    private String brand;

    public Grocery(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
