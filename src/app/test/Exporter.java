package app.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Exporter {

    public static void exportCart(ShoppingCart cart) {

        File file = new File("files/shoppingCart.shop");
        try (var oos = new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(cart);
        } catch (Exception e) {
            IO.println("Error exporting shopping cart: " + e.getMessage());
            IO.println(e);
        }
        IO.println("Archivo exportado correctamente");
    }

    public static ShoppingCart loadShoppingCart() {

        File file = new File("files/shoppingCart.shop");
        ShoppingCart cart = null;
        try (var ois = new ObjectInputStream(new FileInputStream(file))) {

            cart = (ShoppingCart) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error loading shopping cart: " + e.getMessage());
            IO.println(e);
        }
        return cart;
    }
}
