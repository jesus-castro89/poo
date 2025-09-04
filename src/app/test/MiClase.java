package app.test;

public class MiClase {

    public static int x = 10;
    private int y = 20;

    public MiClase() {

    }

    public void incrementar() {
        x++; // Incremento de la variable estática
    }

    public static void showValue() {
        x++;
        System.out.println("Valor de x: " + x); // Mostrar el valor de la variable estática
    }
}
