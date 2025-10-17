package app.shop;

import org.util.InputHandler;

public class Fruit extends Product{

    protected String origin;

    public Fruit(String name, double price, int existences, String origin) {
        super(name, price, existences);
        this.origin = origin;
    }

    public Fruit() {
        super();
        this.origin = InputHandler.getInput(
                "Ingrese el origen de la fruta:",
                isNonEmpty.and(isAlphabetic),
                "El origen no debe estar vacío.",
                "");
    }

    public String getOrigin() {
        return origin;
    }
}
