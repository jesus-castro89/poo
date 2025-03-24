package herencia;

public class Hamster extends Animal {

    public Hamster(String nombre, int edad) {

        super(nombre, edad);
    }

    public void correr() {

        System.out.println("El hamster está corriendo");
    }

    public void comer(String comida) {

        System.out.println("El hamster está comiendo " + comida);
    }

    @Override
    public void dormir() {

        System.out.println("El hamster está durmiendo");
    }
}
