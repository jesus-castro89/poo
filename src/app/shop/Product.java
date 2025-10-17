package app.shop;

import org.util.InputHandler;

import java.util.UUID;
import java.util.function.Predicate;

public abstract class Product implements Comparable<Product> {

    protected UUID id;
    protected String name;
    protected double price;
    protected int existences;

    protected static final Predicate<Double> isPositive =
            value -> value > 0;
    protected static final Predicate<Integer> isPositiveInt =
            value -> value > 0;
    protected static final Predicate<String> isNonEmpty =
            str -> str != null && !str.trim().isEmpty();
    protected static final Predicate<String> isAlphabetic =
            str -> str.chars().allMatch(Character::isLetter);

    public Product(String name, double price, int existences) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.existences = existences;
    }

    public Product() {
        this.id = UUID.randomUUID();
        // Validamos que el nombre no esté vacío y solo contenga letras
        this.name = InputHandler.getInput(
                "Ingrese el nombre del producto:",
                isNonEmpty.and(isAlphabetic),
                "El nombre debe ser no vacío y solo contener letras.",
                "");
        // Validamos que el precio sea un número positivo
        this.price = InputHandler.getInput(
                "Ingrese el precio del producto:",
                isPositive.and(value -> value >= 25.00),
                "El precio debe ser un número positivo.",
                0.0);
        // Validamos que las existencias sean un número positivo
        this.existences = InputHandler.getInput(
                "Ingrese las existencias del producto:",
                isPositiveInt,
                "Las existencias deben ser un número positivo.",
                0);
    }

    /**
     * Esto se considerará el ordenamiento natural de los productos.
     *
     * @param other el otro producto a comparar.
     * @return un entero negativo, cero o positivo si este producto es
     * menor, igual o mayor que el otro producto respectivamente.
     */
    @Override
    public int compareTo(Product other) {

        return orderByPrice(other);
    }

    public int orderByPrice(Product other) {
        return Double.compare(this.price, other.price);
    }

    public int orderByName(Product other) {
        return this.name.compareTo(other.name);
    }

    public int orderByExistences(Product other) {
        return Integer.compare(this.existences, other.existences);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getExistences() {
        return existences;
    }

    @Override
    public String toString() {
        return "%s - Precio: $%.2f - Existencias: %d"
                .formatted(name, price, existences);
    }
}
