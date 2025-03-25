package herencia.abstracto;

public class Rectangle extends Shape {

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
}
