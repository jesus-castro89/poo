package app.input;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class InputHandler {

    private static final Font MESSAGE_FONT;
    private static final Font BUTTON_FONT;
    private static final Font INPUT_FONT;

    static {
        try {
            MESSAGE_FONT = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/jd_digital.ttf")).deriveFont(52f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        BUTTON_FONT = MESSAGE_FONT.deriveFont(Font.BOLD);
        INPUT_FONT = MESSAGE_FONT.deriveFont(Font.PLAIN);
        UIManager.put("OptionPane.messageFont", MESSAGE_FONT);
        UIManager.put("OptionPane.messageForeground", Color.BLUE);
        UIManager.put("OptionPane.buttonFont", BUTTON_FONT);
        UIManager.put("TextField.font", INPUT_FONT);
        UIManager.put("TextField.foreground", Color.GREEN);
        UIManager.put("ComboBox.font", INPUT_FONT);
        UIManager.put("ComboBox.foreground", Color.GREEN);
    }

    public static <T> T getInput(String message, T[] options) {
        // Solicitamos la entrada del usuario
        T input = (T) JOptionPane.showInputDialog(null, message,
                "Selección", JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        // Validamos la entrada del usuario
        if (input == null) {
            showMessage(message, "Error: Debe seleccionar una opción", JOptionPane.ERROR_MESSAGE);
            return getInput(message, options);
        }
        return input;
    }

    public static <T> T getInput(String message, T type) {
        // Solicitamos la entrada del usuario
        String input = getInput(message);
        // Creamos una variable para almacenar la salida
        T output;
        try {
            // Validamos la entrada del usuario
            // Si la entrada es nula o está vacía, lanzamos una excepción
            if (input == null || input.isEmpty())
                throw new InvalidDataException();
            // En caso contrario, convertimos la entrada al tipo de dato solicitado
            // y la almacenamos en la variable de salida
            output = switch (type.getClass().getSimpleName()) {
                case "Integer" -> (T) Integer.valueOf(input);
                case "Double" -> (T) Double.valueOf(input);
                case "Float" -> (T) Float.valueOf(input);
                case "Long" -> (T) Long.valueOf(input);
                case "String" -> (T) input;
                case "Boolean" -> (T) Boolean.valueOf(input);
                case "Byte" -> (T) Byte.valueOf(input);
                case "Short" -> (T) Short.valueOf(input);
                case "Character" -> (T) (Character) input.charAt(0);
                default -> null;
            };
        } catch (Exception e) {
            // Si ocurre una excepción, mostramos un mensaje de error y solicitamos la entrada nuevamente
            showMessage(message, "Error: Entrada inválida", JOptionPane.ERROR_MESSAGE);
            return getInput(message, type);
        }
        // Retornamos la variable de salida con el valor convertido
        return output;
    }

    public static void showMessage(String message, String title, int messageType) {

        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    private static String getInput(String message) {

        return JOptionPane.showInputDialog(null, message);
    }
}
