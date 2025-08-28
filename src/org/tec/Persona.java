package org.tec;

public class Persona {

    private String nombre;
    private int edad;
    private double peso;

    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
        this.peso = 0.0;
    }

    public Persona(String nombre, int edad, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public Persona(String nombre, int edad) {
        this(nombre, edad, 40.0);
    }

    public Persona(String nombre) {
        this(nombre, 0, 1.5);
    }

    @Override
    public String toString() {
        return String.format("""
                ---------------------
                Nombre: %s
                Edad: %d años
                Peso: %.2f kg
                %s
                ---------------------
                """, nombre, edad, peso, esMayorDeEdad());
    }

    private String esMayorDeEdad() {
        return edad >= 18 ? nombre + " es mayor de edad." :
                nombre + " es menor de edad.";
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
