package app.test;

public class Persona {

    private int edad;
    private String nombre;

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public void envejecerse() {
        this.edad++;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Edad: %d", this.nombre, this.edad);
    }
}
