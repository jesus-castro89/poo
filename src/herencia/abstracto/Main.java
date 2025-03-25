package herencia.abstracto;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Shape[] figuras = new Shape[4];
        figuras[0] = new Circle("Rojo", true, "Círculo", 5);
        figuras[1] = new Rectangle("Azul", false, "Rectángulo", 5, 10);
        figuras[2] = new Circle("Verde", true, "Círculo", 10);
        figuras[3] = new Rectangle("Amarillo", false, "Rectángulo", 10, 20);

        for (Shape figura : figuras) {
            System.out.println(figura.getInfo());
        }

        Arrays.stream(figuras).filter(figura -> figura instanceof Circle);

        for (Shape figura : figuras) {
            System.out.println(figura.getInfo());
        }
    }
}
