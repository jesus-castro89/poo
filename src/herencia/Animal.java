package herencia;

public class Animal {

    protected String nombre;
    protected int edad;

    public Animal(){

        this.nombre = "";
        this.edad = 0;
    }

    public Animal(String nombre, int edad) {

        this.nombre = nombre;
        this.edad = edad;
    }

    public void comer() {

        System.out.println("El animal está comiendo");
    }

    public void dormir() {

        System.out.println("El animal está durmiendo");
    }
}
