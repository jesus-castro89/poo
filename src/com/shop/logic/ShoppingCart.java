package com.shop.logic;

import com.shop.entities.Product;

import java.util.HashMap;

public class ShoppingCart {

    private HashMap<Product, Integer> inventory;

    public ShoppingCart() {
        this.inventory = new HashMap<>();
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
            IO.println("El producto no existe en el carrito.");
            throw new Exception("El producto no existe en el carrito.");
        }
    }

    public void clearCart() {
        this.inventory.clear();
    }

    public double getTotal() {
        double total = 0;
        for (Product product : this.inventory.keySet()) {
            total += product.getPrice() * this.inventory.get(product);
        }
        return total;
    }
}
