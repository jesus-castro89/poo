package com.shop.logic;

import com.shop.entities.Fruit;
import com.shop.entities.Product;

import java.util.ArrayList;

public class Shop {

    private Inventory inventory;
    private ArrayList<ShoppingCart> sales;

    public Shop() {
        this.inventory = new Inventory();
        this.sales = new ArrayList<>();
    }

    public void addProductoToInventory(Product product, int quantity) {
        this.inventory.addProduct(product, quantity);
    }

    public ShoppingCart addSale(ShoppingCart cart) {
        this.sales.add(cart);
        return cart;
    }

    public void makeSale(ShoppingCart cart) {
        this.inventory.updateInventory(cart);
        addSale(cart);
    }

    public void printSales() {
        IO.println("Ventas realizadas:");
        for (int i = 0; i < this.sales.size(); i++) {
            IO.println("Venta %d:".formatted(i + 1));
            this.sales.get(i).printCart();
        }
    }

    public void printTotalSales() {
        double totalSales = 0;
        for (ShoppingCart cart : this.sales) {
            totalSales += cart.getTotal();
        }
        IO.println("Total de ventas: $%.2f".formatted(totalSales));
    }

    public void printTotalFruitSale() {
        double totalFruitSales = 0;
        for (ShoppingCart cart : this.sales) {
            totalFruitSales += cart.getTotalTypePrice(Fruit.class);
        }
        IO.println("Total de ventas de frutas: $%.2f".formatted(totalFruitSales));
    }

    public Inventory getInventory() {
        return inventory;
    }
}
