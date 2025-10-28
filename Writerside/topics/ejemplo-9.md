# Ejemplo 9: Carrito de Compras con HashMap en Java

En este ejemplo, crearemos una aplicación simple de carrito de compras utilizando la clase `HashMap` en Java. El carrito
permitirá agregar productos, eliminar productos y mostrar el contenido del carrito junto con el total a pagar.

## Clases

```plantuml
@startuml
abstract class Product{
    - String name
    - double price
    + Product(String name, double price)
    + String getName()
    + double getPrice()
}

class Fruit extends Product{
    - String origin
    + Fruit(String name, double price, String origin)
    + String getOrigin()
}

class Vegetable extends Product{
    - boolean isOrganic
    + Vegetable(String name, double price, boolean isOrganic)
    + boolean isOrganic()
}

class Grocerie extends Product{
    - String brand
    + Grocerie(String name, double price, String brand)
    + String getBrand()
}

class Inventory{
    - HashMap<Product, Integer> products
    + Inventory()
    + void addProduct(Product product, int quantity)
    + void removeProduct(Product product)
    + List<Product> getFruits()
    + List<Product> getVegetables()
    + List<Product> getGroceries()
}

class ShoppingCart{
    - HashMap<Product, Integer> cartItems
    + ShoppingCart()
    + void addItem(Product product, int quantity)
    + void removeItem(Product product)
    + double calculateTotal()
    + void displayCart()
}

ShoppingCart --> Inventory
Inventory --> Product
@enduml
```