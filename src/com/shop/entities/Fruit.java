package com.shop.entities;

import com.shop.interfaces.Reciclable;

public class Fruit extends Product implements Reciclable {

    private String origin;

    public Fruit(String name, double price, String origin) {
        super(name, price);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }
}
