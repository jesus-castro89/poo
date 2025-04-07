package herencia.abstracto.arreglos;

import java.util.Arrays;
import java.util.Collections;

public class Arreglos {

    public static void main(String[] args) {

        Integer[] numeros = new Integer[10];
        Integer[] numeros2 = new Integer[10];
        Arrays.fill(numeros2, 0);
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Math.abs((int) (Math.random() * 100) + 1);
        }
        numeros[1] = 99;
        System.out.println("---------------------");
        System.out.println(Arrays.toString(numeros));
        System.out.println("---------------------");
        System.out.printf("El número 99 se encuentra la posición %d del primer arreglo%n"
                .formatted(Arrays.binarySearch(numeros, 99)));
        System.out.println("---------------------");
        System.out.println(Arrays.toString(numeros2));
        System.out.println("---------------------");
        System.arraycopy(numeros, 5, numeros2, 0, 3);
        System.out.println(Arrays.toString(numeros2));
        System.out.println("---------------------");
        Arrays.sort(numeros);
        System.out.println(Arrays.toString(numeros));
        System.out.println("---------------------");
        System.out.printf("El número 99 se encuentra la posición %d del primer arreglo%n"
                .formatted(Arrays.binarySearch(numeros, 99)));
        System.out.println("---------------------");
        Arrays.sort(numeros, Collections.reverseOrder());
        System.out.println(Arrays.toString(numeros));
        System.out.println("---------------------");

    }
}
