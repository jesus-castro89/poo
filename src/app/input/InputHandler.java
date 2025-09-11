package app.input;

import javax.swing.*;
import java.awt.*;

public class InputHandler {

    private static final Font MESSAGE_FONT = new Font("Arial", java.awt.Font.BOLD, 16);
    private static final Font TITLE_FONT = new Font("Arial", java.awt.Font.BOLD, 18);
    private static final Font BUTTON_FONT = TITLE_FONT;
    private static final Font INPUT_FONT = new Font("Arial", java.awt.Font.PLAIN, 16);


    static {
        UIManager.put("OptionPane.messageFont", MESSAGE_FONT);
        UIManager.put("OptionPane.buttonFont", BUTTON_FONT);
        UIManager.put("OptionPane.titleFont", TITLE_FONT);
        UIManager.put("TextField.font", INPUT_FONT);
    }

    public static <T> T getInput(String message, Class<T> type) {
        // Solicitamos la entrada del usuario
        String input= getInput(message);
        // Creamos una variable para almacenar la salida
        T output;
        try {
            // Validamos la entrada del usuario
            // Si la entrada es nula o está vacía, lanzamos una excepción
            if (input == null || input.isEmpty())
                throw new InvalidDataException();
            // En caso contrario, convertimos la entrada al tipo de dato solicitado
            // y la almacenamos en la variable de salida
            output = switch (type.getSimpleName()) {
                case "Integer" -> (T) Integer.valueOf(input);
                case "Double" -> (T) Double.valueOf(input);
                default -> null;
            };
        } catch (Exception e) {
            // Si ocurre una excepción, mostramos un mensaje de error y solicitamos la entrada nuevamente
            JOptionPane.showMessageDialog(null,
                    "Entrada inválida", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return getInput(message, type);
        }
        // Retornamos la variable de salida con el valor convertido
        return output;
    }

    private static String getInput(String message) {

        return JOptionPane.showInputDialog(null, message);
    }
}
