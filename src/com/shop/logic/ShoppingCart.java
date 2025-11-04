package com.shop.logic;

import com.shop.entities.Product;

import java.util.HashMap;

public class ShoppingCart {

    private HashMap<Product, Integer> cartProducts;

    public ShoppingCart() {
        this.cartProducts = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {

        this.cartProducts.put(product,
                this.cartProducts.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product, int quantity) throws Exception {

        if (this.cartProducts.containsKey(product)) {
            int currentQuantity = this.cartProducts.get(product);
            if (currentQuantity <= quantity) {
                this.cartProducts.remove(product);
            } else {
                this.cartProducts.put(product, currentQuantity - quantity);
            }
        } else {
            IO.println("El producto no existe en el carrito.");
            throw new Exception("El producto no existe en el carrito.");
        }
    }

    public <T extends Product> double getTotalTypePrice(Class<T> type) {
        double total = 0;
        for (Product product : this.cartProducts.keySet()) {
            if (type.isInstance(product)) {
                total += product.getPrice() * this.cartProducts.get(product);
            }
        }
        return total;
    }

    public void clearCart() {
        this.cartProducts.clear();
    }

    public HashMap<Product, Integer> makeSale() {
        printCart();
        return this.cartProducts;
    }

    public void printCart() {
        IO.println("Carrito de compras:");
        for (Product product : this.cartProducts.keySet()) {
            IO.println("%s - Cantidad: %d - Precio unitario: $%.2f".formatted(
                    product.getName(),
                    this.cartProducts.get(product),
                    product.getPrice()
            ));
        }
        IO.println("Total: $" + getTotal());
    }

    public double getTotal() {
        double total = 0;
        for (Product product : this.cartProducts.keySet()) {
            total += product.getPrice() * this.cartProducts.get(product);
        }
        return total;
    }
}
