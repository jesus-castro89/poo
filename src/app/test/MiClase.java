package app.test;

public class MiClase {

    public int x; // Variable de instancia

    public void misPalabras() {

        Persona[] personas = new Persona[3];
        personas[0] = new Persona(25, "Ana");
        personas[1] = new Persona(30, "Luis");
        personas[2] = new Persona(22, "Marta");
        mostrarPersonas(personas);
        System.out.println("---- Después de envejecer ----");
        envejecePersona(personas[0], personas);
        mostrarPersonas(personas);
    }

    public void envejecePersona(Persona persona, Persona[] personas) {

        persona.envejecerse();
        for (Persona p : personas) {
            p = new Persona(0, "Sin Nombre");
        }
    }

    public void mostrarPersonas(Persona[] personas) {

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}