# Ejemplo 9: Carrito de Compras con HashMap en Java

En este ejemplo, crearemos una aplicación simple de carrito de compras utilizando la clase `HashMap` en Java. El carrito
permitirá agregar productos, eliminar productos y mostrar el contenido del carrito junto con el total a pagar.

## Clases

- **Product**: Representa un producto con un nombre y un precio.
- **ShoppingCart**: Utiliza un `HashMap` para almacenar productos y sus cantidades.
- **Main**: Clase principal para ejecutar la aplicación.

### Product.java

```java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
```

### ShoppingCart.java

```java
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<Product, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product) {
        cart.remove(product);
    }

    public void displayCart() {
        double total = 0;
        System.out.println("Carrito de Compras:");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double subtotal = product.getPrice() * quantity;
            total += subtotal;
            System.out.println(product + " x " + quantity + " = $" + subtotal);
        }
        System.out.println("Total a pagar: $" + total);
    }
}
```