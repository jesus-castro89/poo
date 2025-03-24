package herencia;

public final class Gato extends Animal {

    private String color;

    public Gato(String nombre, String color, int edad) {

        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
    }

    public void comer(String comida) {

        System.out.println("El gato está comiendo " + comida);
    }

    public void maullar() {
        System.out.println("El gato está maullando");
    }

    @Override
    public void dormir() {

        super.dormir();
        System.out.println("El gato está durmiendo");
    }
}
