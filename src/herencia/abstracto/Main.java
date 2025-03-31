package herencia.abstracto;

import herencia.abstracto.zoologico.AnimalGender;

import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int s = JOptionPane.showOptionDialog(null,
                "Bienvenido al zoológico", "Zoológico",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                AnimalGender.values(), AnimalGender.values()[0]);
        System.out.println(s);
        switch (s) {
            case 0 -> System.out.println("Has seleccionado macho.");
            case 1 -> System.out.println("Has seleccionado hembra.");
            default -> System.out.println("Selección no válida.");
        }
    }
}
