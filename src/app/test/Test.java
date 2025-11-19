package app.test;

public class Test {

    void main() {
//        ShoppingCart cart = new ShoppingCart();
//        Item item1 = new Item("Laptop", 999.99);
//        Item item2 = new Item("Smartphone", 499.99);
//        Item item3 = new Item("Headphones", 199.99);
//
//        cart.addItem(item1);
//        cart.addItem(item2);
//        cart.addItem(item1); // Adding Laptop again to increment quantity
//        cart.addItem(item3); // Trying to increment quantity of an item not in the cart
//
//        cart.showCart();
//
//        Exporter.exportCart(cart);
        ShoppingCart importedCart = Exporter.loadShoppingCart();
        if (importedCart != null) {
            importedCart.showCart();
            Item item1 = importedCart.getItemByName("Laptop");
            if (item1 != null) {
                importedCart.incrementQuantity(item1, 2);
            }
            importedCart.showCart();
            Exporter.exportCart(importedCart);
        } else {
            IO.println("No se pudo cargar el carrito de compras.");
        }
    }
}