package org.tec;

public class Main {
    public static void main(String[] args) {
        Persona[] personas = new Persona[3];
        personas[0] = new Persona("Juan", 25, 70.5);
        personas[1] = new Persona("Ana", 30);
        personas[2] = new Persona("Miguel");
        for (Persona persona : personas) {
            persona.esMayorDeEdad();
        }
    }
}
