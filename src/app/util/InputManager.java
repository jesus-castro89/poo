package app.util;

import javax.swing.*;

public class InputManager {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int selectedNumber = (int) JOptionPane.showInputDialog(
                null, "Seleccione un número",
                "Selección de número", JOptionPane.QUESTION_MESSAGE,
                null, numbers2, numbers2[0]);
        switch (selectedNumber) {
            case 1, 2 -> {
                System.out.println("Seleccionaste un número pequeño");
                System.out.println("Doble: " + (selectedNumber * 2));
            }
            case 3, 4, 5, 6, 7 -> System.out.println("Seleccionaste un número mediano");
            case 8, 9, 10 -> System.out.println("Seleccionaste un número grande");
            default -> System.out.println("Número no válido");
        }
    }
}
