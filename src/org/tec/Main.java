package org.tec;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String d = JOptionPane.showInputDialog("Digite el nombre del producto: ");
        String p = JOptionPane.showInputDialog("Digite el precio del producto: ");
        String c = JOptionPane.showInputDialog("Digite la cantidad del producto: ");
        double precio = Double.parseDouble(p);
        JOptionPane.showMessageDialog(null,
                "El precio del producto " + d + " es: " + precio);
    }
}
