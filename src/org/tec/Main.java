package org.tec;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Estilizar los JOptionPane
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("ComboBox.font", new Font("Arial", Font.PLAIN, 16));
//        int a= Integer.parseInt(JOptionPane.showInputDialog("Dame un número"));
//        double d= Double.parseDouble(JOptionPane.showInputDialog("Dame un dinero"));
//        float f= Float.parseFloat(JOptionPane.showInputDialog("Dame un fondo"));
//        long l= Long.parseLong(JOptionPane.showInputDialog("Dame un largo"));
//        byte b= Byte.parseByte(JOptionPane.showInputDialog("Dame un byte"));
//        JOptionPane.showMessageDialog(null,
//                "Número: " + a +
//                        "\nDinero: " + d +
//                        "\nFondo: " + f +
//                        "\nLargo: " + l +
//                        "\nByte: " + b);
        // Definir opciones para el JOptionPane
        LibraryOption[] options = LibraryOption.values();
        // Mostrar el JOptionPane con las opciones
        LibraryOption selectedOption = (LibraryOption) JOptionPane.showInputDialog(
                null, "Seleccione una opción:",
                "Menú de Biblioteca", JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        // Manejar la opción seleccionada
        switch (selectedOption) {
            case ADD_BOOK -> JOptionPane.showMessageDialog(null, "Agregar Libro seleccionado");
            case REMOVE_BOOK -> JOptionPane.showMessageDialog(null, "Eliminar Libro seleccionado");
            case VIEW_BOOKS -> JOptionPane.showMessageDialog(null, "Ver Libros seleccionado");
            case SEARCH_BOOK -> JOptionPane.showMessageDialog(null, "Buscar Libro seleccionado");
            case EXIT -> JOptionPane.showMessageDialog(null, "Salir seleccionado");
            default -> JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción");
        }
    }
}
