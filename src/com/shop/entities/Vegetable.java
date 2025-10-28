package com.shop.entities;

import com.shop.interfaces.Reciclable;

public class Vegetable extends Product implements Reciclable {

    private boolean isOrganic;

    public Vegetable(String name, double price, boolean isOrganic) {
        super(name, price);
        this.isOrganic = isOrganic;
    }

    public boolean isOrganic() {
        return isOrganic;
    }
}
