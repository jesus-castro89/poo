package app.shop;

import org.util.InputHandler;

public class Electronic extends Product{

    protected String brand;
    protected String model;

    public Electronic(String name, double price, int existences, String brand, String model) {
        super(name, price, existences);
        this.brand = brand;
        this.model = model;
    }

    public Electronic() {
        super();
        this.brand = InputHandler.getInput(
                "Ingrese la marca del producto electrónico:",
                isNonEmpty.and(isAlphabetic),
                "La marca no debe estar vacía.",
                "");
        this.model = InputHandler.getInput(
                "Ingrese el modelo del producto electrónico:",
                isNonEmpty,
                "El modelo no debe estar vacío.",
                "");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
