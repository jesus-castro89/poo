package app.test;

public class Persona {

    private int edad;
    private String nombre;

    public Persona(String nombre) {
        this.edad = 0;
        this.nombre = nombre;
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
