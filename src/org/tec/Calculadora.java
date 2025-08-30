package org.tec;

import javax.swing.JOptionPane;

/**
 * Clase Calculadora que realiza operaciones básicas.
 */
public class Calculadora {
    /**
     * Representa el primer número ingresado por el usuario.
     */
    private double numero1;
    /**
     * Representa el segundo número ingresado por el usuario.
     */
    private double numero2;

    /**
     * Función que muestra un menú para seleccionar la operación a realizar.
     */
    private void menu() {
        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir", "Salir"};
        String eleccion;
        do {
            eleccion = JOptionPane.showInputDialog(null, "Seleccione una operación:",
                    "Menú de Operaciones", JOptionPane.QUESTION_MESSAGE, null, opciones,
                    opciones[0]).toString();

            switch (eleccion) {
                case "Sumar" -> sumar();
                case "Restar" -> restar();
                case "Multiplicar" -> multiplicar();
                case "Dividir" -> dividir();
                case "Salir" -> JOptionPane.showMessageDialog(null, "Saliendo del programa.");
            }
        } while (eleccion.compareTo("Salir") != 0);
    }

    /**
     * Función para solicitar y leer dos números del usuario.
     */
    private void readNumbers() {
        numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número:"));
        numero2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo número:"));
    }

    /**
     * Función para sumar los dos números y mostrar el resultado.
     */
    private void sumar() {
        readNumbers();
        double resultado = numero1 + numero2;
        JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + resultado);
    }

    /**
     * Función para restar los dos números y mostrar el resultado.
     */
    private void restar() {
        readNumbers();
        double resultado = numero1 - numero2;
        JOptionPane.showMessageDialog(null, "El resultado de la resta es: " + resultado);
    }

    /**
     * Función para multiplicar los dos números y mostrar el resultado.
     */
    private void multiplicar() {
        readNumbers();
        double resultado = numero1 * numero2;
        JOptionPane.showMessageDialog(null, "El resultado de la multiplicación es: " + resultado);
    }

    /**
     * Función para dividir los dos números y mostrar el resultado.
     */
    private void dividir() {
        readNumbers();
        if (numero2 != 0) {
            double resultado = numero1 / numero2;
            JOptionPane.showMessageDialog(null, "El resultado de la división es: " + resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Error: División por cero no permitida.");
        }
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.menu();
    }
}
