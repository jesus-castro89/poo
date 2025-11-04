package com.shop.entities;

public class Fruit extends Product {

    private String origin;

    public Fruit(String name, double price, String origin) {
        super(name, price);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }
}
