package herencia;

public class Perro extends Animal {

    public Perro(String nombre, int edad) {

        super(nombre, edad);
    }

    public void ladrar() {

        System.out.println("El perro está ladrando");
    }

    @Override
    public void dormir() {

        System.out.println("El perro está durmiendo");
    }
}
