package com.shop;

import com.shop.entities.Fruit;
import com.shop.entities.Grocery;
import com.shop.entities.Vegetable;
import com.shop.logic.Inventory;
import com.shop.logic.Shop;

public class Main {

    void main(){

        Fruit apple = new Fruit("Apple", 0.5, "USA");
        Fruit orange = new Fruit("Orange", 0.7, "CHN");
        Vegetable carrot = new Vegetable("Carrot", 0.3, true);
        Vegetable potato = new Vegetable("Potato", 0.4, false);
        Grocery bread = new Grocery("Bread", 1.5, "Bakery");
        Grocery milk = new Grocery("Milk", 1.2, "Dairy");

        Shop shop = new Shop();
        shop.addProductoToInventory(apple, 5);
        shop.addProductoToInventory(orange, 5);
        shop.addProductoToInventory(carrot, 10);
        shop.addProductoToInventory(potato, 7);
        shop.addProductoToInventory(bread, 15);
        shop.addProductoToInventory(milk, 12);
        shop.getInventory().showInventory();
        shop.addProductoToInventory(orange, 5);
        shop.addProductoToInventory(apple, 8);
        shop.getInventory().showInventory();
        IO.println("Eliminando todas las papas");
        try {
            shop.getInventory().removeProduct(potato, 7);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        shop.getInventory().showInventory();
    }
}