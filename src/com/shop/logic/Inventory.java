package com.shop.logic;

import com.shop.entities.Fruit;
import com.shop.entities.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Inventory {

    private HashMap<Product, Integer> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public void updateInventory(ShoppingCart cart) {
        HashMap<Product, Integer> soldProducts = cart.makeSale();
        for (Product p : soldProducts.keySet()) {
            try {
                this.removeProduct(p, soldProducts.get(p));
            } catch (Exception e) {
                IO.println("Error al actualizar el inventario: " + e.getMessage());
            }
        }
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
                this.inventory.getOrDefault(product, 0)
                        + quantity);
    }

    public void removeProduct(Product product, int quantity)
            throws Exception {

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

    public <T extends Product> ArrayList<T> getProducts(Class<T> tClass) {
        ArrayList<T> products = new ArrayList<>();
        for (Product p : this.inventory.keySet()) {
            if (tClass.isInstance(p)) {
                products.add(tClass.cast(p));
            }
        }
        return products;
    }
}