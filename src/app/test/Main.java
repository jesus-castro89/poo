package app.test;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Paso por valor con tipos primitivos
        int a = 10;
        System.out.println("------------------------------");
        System.out.println("Antes de modificarPrimitivo: " + a);
        modificarPrimitivo(a);
        System.out.println("Después de modificarPrimitivo: " + a);
        System.out.println("------------------------------");
        // Paso por referencia con objetos
        Persona persona = new Persona("Juan");
        System.out.println("Antes de modificarObjeto: " + persona.getNombre());
        modificarObjeto(persona);
        System.out.println("Después de modificarObjeto: " + persona.getNombre());
        System.out.println("------------------------------");
        // Paso por referencia con array de Strings
        String[] nombres = {"Ana", "Luis", "Marta"};
        System.out.println("Arreglo de Strings antes de modificarArray: ");
        System.out.println(Arrays.toString(nombres));
        System.out.println("Antes de modificarArray de Strings: " + nombres[0]);
        modificarArray(nombres);
        System.out.println("Después de modificarArray de Strings: " + nombres[0]);
        System.out.println("Arreglo de Strings después de modificarArray: ");
        System.out.println(Arrays.toString(nombres));
        System.out.println("------------------------------");
        // Paso por referencia con arrays
        int[] numeros = {1, 2, 3};
        System.out.println("Arreglo de enteros antes de modificarArray: ");
        System.out.println(Arrays.toString(numeros));
        System.out.println("Antes de modificarArray: " + numeros[0]);
        modificarArray(numeros);
        System.out.println("Después de modificarArray: " + numeros[0]);
        System.out.println("Arreglo de enteros después de modificarArray: ");
        System.out.println(Arrays.toString(numeros));
        System.out.println("------------------------------");
    }

    public static void modificarPrimitivo(int num) {
        num = 20; // Esto no afecta al valor original
    }

    public static void modificarObjeto(Persona p) {
        p.setNombre("Carlos"); // Esto modifica el objeto original
    }

    public static void modificarArray(String[] arr) {
        arr[0] = arr[0].toUpperCase(); // Esto modifica el array original
    }

    public static void modificarArray(int[] arr) {
        arr[0] = 10; // Esto modifica el array original
    }
}
