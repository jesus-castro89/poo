package app.test;

public class MiClase {

    public static int x = 10;
    private int y = 20;

    public MiClase() {

    }

    public static void main(String[] args) {
        MiClase obj1 = new MiClase();
        MiClase obj2 = new MiClase();

        obj1.decrementar();
        obj2.decrementar();

        obj1.incrementar();

        System.out.printf("Valor de x: %d%n", obj1.getX()); // Mostrar el valor de la variable estática
        System.out.println("Valor de y en obj1: " + obj1.y); // Mostrar el valor de la variable de instancia para obj1
        System.out.println("Valor de y en obj2: " + obj2.y);
        obj2.incrementar();
        System.out.printf("Valor de x: %d%n", obj2.getX()); // Mostrar el valor de la variable de instancia para obj2
    }

    public void decrementar() {
        y--; // Decremento de la variable de instancia
    }

    public static void incrementar() {
        x++; // Incremento de la variable estática
    }

    public static void showValue() {
        x++;
        System.out.println("Valor de x: " + x); // Mostrar el valor de la variable estática
    }

    public int getY() {
        return y;
    }

    public static int getX() {
        return x;
    }
}
