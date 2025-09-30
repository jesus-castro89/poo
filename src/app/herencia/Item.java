package app.herencia;

public class Item {

    private String itemName;
    private String description;
    private double price;

    public Item(String itemName, String description, double price) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return ("""
                ------------------------
                Nombre del Producto: %s
                Descripción: %s
                Precio: %.2f
                ------------------------
                """.formatted(itemName, description, price));
    }

    public Item clone() {

        return new Item(this.itemName, this.description, this.price);
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
