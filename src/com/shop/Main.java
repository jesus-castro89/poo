package com.shop;

import com.shop.entities.Fruit;
import com.shop.entities.Grocery;
import com.shop.entities.Vegetable;
import com.shop.logic.Inventory;

public class Main {

    void main(){
        Fruit apple = new Fruit("Apple", 0.5, "USA");
        Fruit orange = new Fruit("Orange", 0.7, "CHN");

        Vegetable carrot = new Vegetable("Carrot", 0.3, true);
        Vegetable potato = new Vegetable("Potato", 0.4, false);

        Grocery bread = new Grocery("Bread", 1.5, "Bakery");
        Grocery milk = new Grocery("Milk", 1.2, "Dairy");

        Inventory inventory = new Inventory();
        inventory.addProduct(apple, 100);
        inventory.addProduct(orange, 150);
        inventory.addProduct(carrot, 200);
        inventory.addProduct(potato, 250);
        inventory.addProduct(bread, 300);
        inventory.addProduct(milk, 350);

        inventory.showInventory();

        inventory.addProduct(apple, 100);

        inventory.showInventory();
    }
}
