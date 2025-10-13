package org.util;

import org.exceptions.InvalidInputException;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.function.Predicate;

public class InputHandler {

    private static final Font MESSAGE_FONT;
    private static final Font INPUT_FONT;
    private static final Font BUTTON_FONT;

    static {

        MESSAGE_FONT = loadCustomFont("text.ttf", 20, Font.BOLD);
        INPUT_FONT = loadCustomFont("input.ttf", 18, Font.PLAIN);
        BUTTON_FONT = loadCustomFont("button.ttf", 48, Font.BOLD);

        UIManager.put("OptionPane.messageFont", MESSAGE_FONT);
        UIManager.put("TextField.font", INPUT_FONT);
        UIManager.put("ComboBox.font", INPUT_FONT.deriveFont(Font.BOLD));
        UIManager.put("OptionPane.buttonFont", BUTTON_FONT);
    }

    void main() {
        showMessage("Hola, este es un mensaje de prueba.", "Mensaje de Prueba",
                JOptionPane.INFORMATION_MESSAGE);
        getInput("Ingrese su nombre:");
        getInput("Seleccione una opción:", new String[]{"Opción 1", "Opción 2", "Opción 3"});
    }

    private static Font loadCustomFont(String name, int size, int style) {

        try {
            InputStream stream = InputHandler.class.getResourceAsStream("/fonts/" + name);
            if (stream == null) throw new RuntimeException("No se encontró la fuente: " + name);
            Font font = Font.createFont(Font.TRUETYPE_FONT, stream);
            return font.deriveFont(style, size);
        } catch (Exception e) {
            return new Font("SansSerif", style, size);
        }
    }

    public static void showMessage(String message, String title, int messageType) {

        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    private static String getInput(String prompt) {

        return JOptionPane.showInputDialog(null, prompt);
    }

    public static <T> T getInput(String prompt, T[] options) {

        return (T) JOptionPane.showInputDialog(
                null,
                prompt,
                "Selección",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options.length > 0 ? options[0] : null
        );
    }

    public static <T> T getInput(String prompt, T type) {

        String input = getInput(prompt);
        T output;
        try {
            if (input == null || input.isEmpty())
                throw new InvalidInputException("La entrada no puede estar vacía.");
            output = switch (type.getClass().getSimpleName()) {
                case "Integer" -> (T) Integer.valueOf(input);
                case "Double" -> (T) Double.valueOf(input);
                case "Float" -> (T) Float.valueOf(input);
                case "Long" -> (T) Long.valueOf(input);
                case "Short" -> (T) Short.valueOf(input);
                case "Byte" -> (T) Byte.valueOf(input);
                case "Boolean" -> (T) Boolean.valueOf(input);
                case "String" -> (T) input;
                case "LocalDate" -> (T) LocalDate.parse(input);
                default -> null;
            };
        } catch (InvalidInputException e) {
            showMessage("Error: Entrada Invalida", "Entrada de Datos", JOptionPane.ERROR_MESSAGE);
            return getInput(prompt, type);
        }
        return output;
    }

    public static <T> T getInput(String prompt, Predicate<T> predicate, String errorMessage, T type) {

        T input = getInput(prompt, type);
        if (!predicate.test(input)) {
            showMessage("Error: " + errorMessage, "Entrada de Datos", JOptionPane.ERROR_MESSAGE);
            return getInput(prompt, predicate, errorMessage, type);
        }
        return input;
    }
}
