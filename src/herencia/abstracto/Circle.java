package herencia.abstracto;

public class Circle extends Shape {

    private final double radius;

    public Circle(String color, boolean filled, String name, double radius) {
        super(color, filled, name);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
