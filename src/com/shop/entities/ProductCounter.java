package com.shop.entities;

public class ProductCounter {

    private final Product product;
    private int quantity;

    public ProductCounter(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void makeSale() {

        product.sell(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Producto: " + product.getName() + ", Cantidad: " + quantity;
    }
}
