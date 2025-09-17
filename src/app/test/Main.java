package app.test;

public class Main {

    public static void main(String[] args) {
        MiClase obj1 = new MiClase();
        MiClase obj2 = new MiClase();

        obj1.decrementar();
        obj2.decrementar();

        MiClase.incrementar();

        System.out.printf("Valor de x: %d%n", MiClase.getX());
        System.out.println("Valor de y en obj1: " + obj1.getY()); // Mostrar el valor de la variable de instancia para obj1
        System.out.println("Valor de y en obj2: " + obj2.getY());
        MiClase.incrementar();
        System.out.printf("Valor de x: %d%n", MiClase.getX());// Mostrar el valor de la variable de instancia para obj2
    }
}
