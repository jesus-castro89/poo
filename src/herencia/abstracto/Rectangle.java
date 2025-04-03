package herencia.abstracto;

import interfaz.Vendible;

public class Rectangle extends Shape implements Vendible {

    private final double width;
    private final double height;

    public Rectangle(String color, boolean filled, String name, double width, double height) {
        super(color, filled, name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getPrecio() {
        return 0;
    }

    @Override
    public void setPrecio(double precio) {

    }

    @Override
    public String getNombre() {
        return "";
    }
}
