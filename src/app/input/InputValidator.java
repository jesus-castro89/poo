package app.input;

import app.exceptions.NotIntegerException;
import app.exceptions.NotPositiveException;

import javax.swing.*;
import java.awt.*;

public class InputValidator {

    private static final Font MESSAGE_FONT = new Font("Arial", Font.BOLD, 18);
    private static final Font BUTTON_FONT = MESSAGE_FONT;
    private static final Font TEXTFIELD_FONT = new Font("Arial", Font.PLAIN, 18);

    static {
        UIManager.put("OptionPane.messageFont", MESSAGE_FONT);
        UIManager.put("OptionPane.buttonFont", BUTTON_FONT);
        UIManager.put("TextField.font", TEXTFIELD_FONT);
    }

    public static int validatePositiveInteger() {
        int value;
        String title = "Entrada inválida";
        String message = "Por favor, ingrese un número entero positivo.";
        try {
            value = validateInteger();
            if (value <= 0)
                throw new NotPositiveException();
        } catch (NotIntegerException e) {
            value = validatePositiveInteger();
        } catch (NotPositiveException e) {
            showErrorMessage(title, message);
            value = validatePositiveInteger();
        }
        return value;
    }

    private static int validateInteger() throws NotIntegerException {
        int value;
        String title = "Entrada de número entero";
        String message = "Por favor, ingrese un número entero.";
        try {
            value = Integer.parseInt(showInputDialog(title, message));
        } catch (NumberFormatException e) {
            title = "Entrada inválida";
            showErrorMessage(title, message);
            throw new NotIntegerException();
        }
        return value;
    }

    private static void showErrorMessage(String title, String message) {

        JOptionPane.showMessageDialog(null, message, title,
                JOptionPane.ERROR_MESSAGE);
    }

    private static String showInputDialog(String title, String message) {

        return JOptionPane.showInputDialog(null, message, title,
                JOptionPane.QUESTION_MESSAGE);
    }

    public static <T> T showInputDialog(String title, String message, T[] options) {

        T selectedOption;
        try {
            selectedOption = (T) JOptionPane.showInputDialog(null, message, title,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (selectedOption == null)
                throw new Exception();
        } catch (Exception e) {
            showErrorMessage("Entrada inválida",
                    "Por favor, seleccione una opción de la lista.");
            selectedOption = showInputDialog(title, message, options);
        }

        return selectedOption;
    }
}
