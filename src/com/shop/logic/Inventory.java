package com.shop.logic;

import com.shop.entities.Fruit;
import com.shop.entities.Product;
import com.shop.interfaces.Reciclable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {

    private HashMap<Product, Integer> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public void showInventory() {
        IO.println("+-------------------- Inventario --------------------+");
        for (Product p : this.inventory.keySet()) {
            IO.println("%s - Cantidad: %d"
                    .formatted(p, this.inventory.get(p)));
        }
        IO.println("+----------------------------------------------------+");
    }

    public void addProduct(Product product, int quantity) {

        this.inventory.put(product,
                this.inventory.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product, int quantity) throws Exception {

        if (this.inventory.containsKey(product)) {
            int currentQuantity = this.inventory.get(product);
            if (currentQuantity <= quantity) {
                this.inventory.remove(product);
            } else {
                this.inventory.put(product, currentQuantity - quantity);
            }
        } else {
            IO.println("El producto no existe en el inventario.");
            throw new Exception("El producto no existe en el inventario.");
        }
    }

    public List<Reciclable> getReciclableProducts() {
        List<Reciclable> reciclables = new ArrayList<>();
        for (Product p : this.inventory.keySet()) {
            if (p instanceof Reciclable) {
                reciclables.add((Reciclable) p);
            }
        }
        return reciclables;
    }

    public List<Product> getFruits() {
        List<Product> fruits = new ArrayList<>();
        for (Product p : this.inventory.keySet()) {
            if (p instanceof Fruit) {
                fruits.add(p);
            }
        }
        return fruits;
    }

    public List<Product> getVegetables() {
        List<Product> vegetables = new ArrayList<>();
        for (Product p : this.inventory.keySet()) {
            if (p instanceof com.shop.entities.Vegetable) {
                vegetables.add(p);
            }
        }
        return vegetables;
    }

    public List<Product> getGroceries() {
        List<Product> groceries = new ArrayList<>();
        for (Product p : this.inventory.keySet()) {
            if (p instanceof com.shop.entities.Grocery) {
                groceries.add(p);
            }
        }
        return groceries;
    }
}