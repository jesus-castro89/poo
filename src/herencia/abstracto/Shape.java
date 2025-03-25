package herencia.abstracto;

public abstract class Shape {

    protected String color;
    protected boolean filled;
    private String name;

    public Shape(String color, boolean filled, String name) {

        this.color = color;
        this.filled = filled;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public final String getInfo() {
        return """
                +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                Nombre: %s
                Color: %s
                Relleno: %s
                Área: %.2f
                Perímetro: %.2f
                +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                """.formatted(name, color, filled ? "Sí" : "No",
                calculateArea(), calculatePerimeter());
    }

    @Override
    public String toString() {

        return "El área de la figura %s es: %.2f y el perímetro es: %.2f".formatted(name, calculateArea(), calculatePerimeter());
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();
}
