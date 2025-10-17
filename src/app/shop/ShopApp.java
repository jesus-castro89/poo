package app.shop;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopApp {

    public static void printProducts(Product[] products) {
        IO.println("+----------------------------+");
        IO.println("Lista de productos disponibles:");
        for (Product product : products) {
            IO.println(product);
        }
        IO.println("+----------------------------+");
    }

    void main() {

        IO.println("Bienvenido a la tienda en línea");
        Product[] products = new Product[4];
        products[0] = new Fruit("Manzana", 22.50,
                10, "Americana");
        products[1] = new Electronic("Televisor", 3500.00,
                2, "Samsung", "4K UHD");
        products[2] = new Fruit("Plátano", 22.55,
                5, "Ecuatoriano");
        products[3] = new Electronic("Laptop", 12000.00,
                3, "Dell", "Inspiron 15");
        printProducts(products);
        IO.println("Productos ordenados por existencia:");
        Arrays.sort(products, Product::orderByExistences);
        printProducts(products);
        int index = Arrays.binarySearch(products,
                new Fruit("", 0,
                        5, ""),
                Product::orderByExistences);
        IO.println("El producto con 5 existencias está en el índice: " + index);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Fruit("Naranja", 20.00, 15, "Mexicana"));
        productList.add(new Electronic("Smartphone", 8000.00, 4, "Apple", "iPhone 13"));
        productList.add(new Fruit("Fresa", 30.00, 8, "Canadiense"));
        productList.add(new Electronic("Tablet", 5000.00, 6, "Microsoft", "Surface Pro"));
        IO.println("Productos en la lista:");
        for (Product p : productList) {
            IO.println(p);
        }
        productList.sort(Product::orderByExistences);
        for (Product p : productList) {
            IO.println(p);
        }
        Product searchProduct = new Fruit("", 0, 8, "");
        int listIndex = productList.stream().filter(p -> p.getExistences()==8)
                .findFirst()
                .map(productList::indexOf)
                .orElse(-1);
        Object[] filteredProducts = productList.stream().filter(
                p -> p.getExistences() >= 5
        ).toArray();
        IO.println("El producto con 8 existencias está en el índice: " + listIndex);
        for (Object p : filteredProducts) {
            IO.println(p);
        }
    }
}
