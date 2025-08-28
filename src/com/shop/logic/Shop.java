package com.shop.logic;

import com.shop.entities.Product;
import com.shop.entities.ProductCounter;
import org.tec.utils.Validator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Shop {

    private ArrayList<Product> products;
    private HashMap<Product, ProductCounter> shoppingCart;

    public Shop() {
        // Inicializa la lista de productos y el carrito de compras
        products = new ArrayList<>();
        shoppingCart = new HashMap<>();
        menu();
    }

    public void menu(){}

    private void addProduct() {
        // Crea un nuevo producto y lo agrega a la lista de productos
        Product product = new Product();
        products.add(product);
    }

    private void deleteProduct() {
        // Permite al usuario seleccionar un producto de la lista de productos
        Product toDelete = selectProductFromList();
        // Verifica si el producto seleccionado existe en la lista de productos
        if (toDelete != null) {
            // Verifica si el producto está en el carrito de compras
            if (existInShoppingCart(toDelete)) {
                // Muestra un mensaje de error si el producto está en el carrito de compras
                JOptionPane.showMessageDialog(null,
                        "No se puede eliminar el producto porque está en el carrito de compras",
                        "Error de eliminación",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                // Elimina el producto de la lista de productos
                products.remove(toDelete);
                // Muestra un mensaje de éxito si el producto se eliminó correctamente
                JOptionPane.showMessageDialog(null,
                        "Producto eliminado correctamente",
                        "Eliminación de producto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void deleteProductFromShoppingCart(){
        // Permite al usuario seleccionar un producto del carrito de compras
        Product product = selectProductFromShoppingCart();
        // Verifica si el producto seleccionado existe en el carrito de compras
        if (product != null) {
            // Elimina el producto del carrito de compras
            shoppingCart.remove(product);
            // Muestra un mensaje de éxito si el producto se eliminó correctamente
            JOptionPane.showMessageDialog(null,
                    "Producto eliminado del carrito de compras correctamente",
                    "Eliminación de producto del carrito",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateProductStock() {
        // Permite al usuario seleccionar un producto de la lista de productos
        Product product = selectProductFromList();
        if (product != null) {
            // Actualiza el stock del producto seleccionado
            int newStock = Validator.validate(Integer.class,
                    (Integer value) -> value > 0,
                    "Ingrese la nueva cantidad de productos en venta",
                    "La cantidad de productos en venta debe ser un número entero positivo",
                    "Actualizar stock");
            product.setStock(newStock);
            JOptionPane.showMessageDialog(null,
                    "Stock actualizado correctamente",
                    "Actualización de stock",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateProductPrice() {
        // Permite al usuario seleccionar un producto de la lista de productos
        Product product = selectProductFromList();
        if (product != null) {
            // Actualiza el precio del producto seleccionado
            double newPrice = Validator.validate(Double.class,
                    (Double value) -> value > 0,
                    "Ingrese el nuevo precio del producto",
                    "El precio del producto debe ser un número positivo",
                    "Actualizar precio");
            product.setPrice(newPrice);
            JOptionPane.showMessageDialog(null,
                    "Precio actualizado correctamente",
                    "Actualización de precio",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addProductToShoppingCart() {
        // Permite al usuario seleccionar un producto de la lista de productos
        Product product = selectProductFromList();
        boolean safeQuantity = false;
        int quantity;
        // Verifica si el producto seleccionado existe en la lista de productos
        if (product != null) {
            // Verifica si el producto ya está en el carrito de compras
            if (!existInShoppingCart(product)) {
                // Permite al usuario ingresar la cantidad del producto a agregar al carrito
                do{
                    // Solicita al usuario la cantidad del producto a agregar al carrito
                    quantity = Validator.validate(Integer.class,
                            (Integer value) -> value > 0,
                            "Ingrese la cantidad del producto a agregar al carrito",
                            "La cantidad debe ser un número entero positivo",
                            "Agregar al carrito");
                    // Verifica si hay suficiente stock del producto
                    if (quantity > product.getStock()) {
                        // Muestra un mensaje de error si no hay suficiente stock
                        JOptionPane.showMessageDialog(null,
                                "No hay suficiente stock para agregar al carrito",
                                "Error de stock",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Agrega el producto y su cantidad al carrito de compras
                        shoppingCart.put(product, new ProductCounter(product, quantity));
                        JOptionPane.showMessageDialog(null,
                                "Producto agregado al carrito de compras correctamente",
                                "Agregar al carrito",
                                JOptionPane.INFORMATION_MESSAGE);
                        safeQuantity = true;
                    }
                }while (!safeQuantity);
            } else {
                // Muestra un mensaje de error si el producto ya está en el carrito de compras
                JOptionPane.showMessageDialog(null,
                        "El producto ya está en el carrito de compras",
                        "Error de selección",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateQuantityInShoppingCart(){
        // Permite al usuario seleccionar un producto del carrito de compras
        Product product = selectProductFromShoppingCart();
        boolean safeQuantity = false;
        int quantity;
        // Verifica si el producto seleccionado existe en el carrito de compras
        if (product != null) {
            // Permite al usuario ingresar la nueva cantidad del producto en el carrito
            do{
                // Solicita al usuario la nueva cantidad del producto en el carrito
                quantity = Validator.validate(Integer.class,
                        (Integer value) -> value > 0,
                        "Ingrese la nueva cantidad del producto en el carrito",
                        "La cantidad debe ser un número entero positivo",
                        "Actualizar cantidad");
                // Verifica si hay suficiente stock del producto
                if (quantity > product.getStock()) {
                    // Muestra un mensaje de error si no hay suficiente stock
                    JOptionPane.showMessageDialog(null,
                            "No hay suficiente stock para actualizar la cantidad",
                            "Error de stock",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // Actualiza la cantidad del producto en el carrito de compras
                    shoppingCart.get(product).setQuantity(quantity);
                    JOptionPane.showMessageDialog(null,
                            "Cantidad actualizada correctamente",
                            "Actualizar cantidad",
                            JOptionPane.INFORMATION_MESSAGE);
                    safeQuantity = true;
                }
            }while (!safeQuantity);
        }
    }

    private void makeSale(){
        // Verifica si el carrito de compras está vacío
        if (shoppingCart.isEmpty()) {
            // Muestra un mensaje de error si no hay productos en el carrito
            JOptionPane.showMessageDialog(null,
                    "No hay productos en el carrito de compras",
                    "Error de venta",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // Realiza la venta de los productos en el carrito de compras
            shoppingCart.values().forEach(ProductCounter::makeSale);
            // Limpia el carrito de compras después de realizar la venta
            shoppingCart.clear();
            // Muestra un mensaje de éxito si la venta se realizó correctamente
            JOptionPane.showMessageDialog(null,
                    "Venta realizada correctamente",
                    "Venta",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean existInShoppingCart(Product product) {
        // Verifica si el producto ya está en el carrito de compras
        return shoppingCart.containsKey(product);
    }

    private Product selectProductFromList() {
        // Verifica si la lista de productos está vacía
        if (products.isEmpty()) {
            // Muestra un mensaje de error si no hay productos disponibles
            JOptionPane.showMessageDialog(null,
                    "No hay productos disponibles",
                    "Error de selección",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            // Permite al usuario seleccionar un producto de la lista de productos
            return Validator.validate(
                    products.toArray(new Product[0]),
                    "Seleccione un producto",
                    "No hay productos disponibles",
                    "Selección de producto");
        }
    }

    private Product selectProductFromShoppingCart() {
        // Verifica si el carrito de compras está vacío
        if (shoppingCart.isEmpty()) {
            // Muestra un mensaje de error si no hay productos en el carrito
            JOptionPane.showMessageDialog(null,
                    "No hay productos en el carrito de compras",
                    "Error de selección",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            // Permite al usuario seleccionar un producto del carrito de compras
            return Validator.validate(
                    shoppingCart.keySet().toArray(new Product[0]),
                    "Seleccione un producto del carrito de compras",
                    "No hay productos en el carrito de compras",
                    "Selección de producto del carrito");
        }
    }
}
