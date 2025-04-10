package com.shop.entities;

import org.tec.utils.Validator;

import javax.swing.*;

public class Product {

    private String name;
    private String description;
    private double price;
    private int stock;

    public Product() {
        name = Validator.validate(String.class,
                "Ingrese el nombre del producto",
                "El nombre del producto no puede estar vacío",
                "Nuevo producto");
        description = Validator.validate(String.class,
                "Ingrese la descripción del producto",
                "La descripción del producto no puede estar vacía",
                "Nuevo producto");
        price = Validator.validate(Double.class,
                (Double value) -> value > 0,
                "Ingrese el precio del producto",
                "El precio del producto debe ser un número positivo",
                "Nuevo producto");
        stock = Validator.validate(Integer.class,
                (Integer value) -> value > 0,
                "Ingrese el número de productos en venta",
                "La cantidad de productos en venta debe ser un número entero positivo",
                "Nuevo producto");
    }

    public void sell(int quantity) {

        if (quantity > stock) {
            JOptionPane.showMessageDialog(null,
                    "No hay suficiente stock para realizar la venta",
                    "Error de venta",
                    JOptionPane.ERROR_MESSAGE);
        } else
            stock -= quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
