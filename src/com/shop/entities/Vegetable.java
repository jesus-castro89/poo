package com.shop.entities;

public class Vegetable extends Product {

    private boolean isOrganic;

    public Vegetable(String name, double price, boolean isOrganic) {
        super(name, price);
        this.isOrganic = isOrganic;
    }

    public boolean isOrganic() {
        return isOrganic;
    }
}
