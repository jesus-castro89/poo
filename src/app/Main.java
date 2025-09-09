package app;

import app.input.InputValidator;
import app.test.MiClase;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5};
        String[] array2 = {"a", "b", "c", "d", "e"};

        Integer val1;
        String val2;

        val1 = InputValidator.showInputDialog(
                "Seleccione un número",
                "Seleccione un número del 1 al 5", array);
        val2 = InputValidator.showInputDialog(
                "Seleccione una letra",
                "Seleccione una letra de la a a la e", array2);

        JOptionPane.showMessageDialog(null, val1);
        JOptionPane.showMessageDialog(null, val2);
    }
}
