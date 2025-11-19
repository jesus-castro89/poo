package app.test;

import java.io.Serializable;
import java.util.HashMap;

public class ShoppingCart implements Serializable {

    private HashMap<Item, ItemCounter> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void showCart() {
        IO.println("Carrito de Compras");
        items.forEach((cartItem, counter) -> {
            IO.println(counter);
        });
        IO.println("+------------------------------+");
    }

    public Item getItemByName(String name) {
        for (Item item : items.keySet()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item) {

        if (items.containsKey(item)) {
            ItemCounter counter = items.get(item);
            counter.increment(1);
        } else {
            items.putIfAbsent(item, new ItemCounter(item));
        }
    }

    public void incrementQuantity(Item item, int quantity) {
        ItemCounter counter = items.getOrDefault(item, null);
        if (counter != null) {
            counter.increment(quantity);
        } else {
            IO.println("ERROR: Item not found");
        }
    }
}
