package org.util;

import javax.swing.*;
import java.util.function.Predicate;

public class Main {

    void main() {
        String test;
        Predicate<String> names = s ->
                s != null && s.toUpperCase().matches("[A-ZÁÉÍÓÚÑÜ\\s]+");
        Predicate<Integer> adult = i -> i != null && (i >= 1 && i <= 15);
        test = InputHandler.getInput(
                "Ingrese el nombre de la persona", names,
                "Nombre inválido. Intente de nuevo.", "");
        InputHandler.showMessage("Hola, " + test + "!",
                "Saludo", JOptionPane.INFORMATION_MESSAGE);
    }
}
