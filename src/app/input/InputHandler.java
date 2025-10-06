package app.input;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Clase que maneja la entrada y salida de datos mediante ventanas gráficas.
 * Permite solicitar entradas de diferentes tipos de datos y mostrar mensajes
 * personalizados con estilos específicos.
 */
public class InputHandler {

    /**
     * Atributo que define la fuente personalizada para los mensajes de las ventanas.
     */
    private static final Font MESSAGE_FONT;
    /**
     * Atributo que define la fuente personalizada para los botones de las ventanas.
     */
    private static final Font BUTTON_FONT;
    /**
     * Atributo que define la fuente personalizada para los campos de entrada de las ventanas.
     */
    private static final Font INPUT_FONT;
    /**
     * Atributo que define la fuente personalizada para las listas desplegables de las ventanas.
     */
    private static final Font COMBOBOX_FONT;

    static {
        try {
            MESSAGE_FONT = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/text.ttf")).deriveFont(26f);
            BUTTON_FONT = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/button.ttf")).deriveFont(26f);
            INPUT_FONT = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/input.ttf")).deriveFont(24f);
            COMBOBOX_FONT = BUTTON_FONT.deriveFont(24f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        // Esto permite cambiar la fuente del texto principal de la ventana.
        UIManager.put("OptionPane.messageFont", MESSAGE_FONT);
        // Esto permite cambiar el color del texto principal de la ventana.
        UIManager.put("OptionPane.messageForeground", Color.BLUE);
        // Esto permite cambiar la fuente de los botones de la ventana.
        UIManager.put("OptionPane.buttonFont", BUTTON_FONT);
        // Esto permite cambiar el color del campo de entrada de la ventana.
        UIManager.put("TextField.font", INPUT_FONT);
        // Esto permite cambiar el color del campo de entrada de la ventana.
        UIManager.put("TextField.foreground", Color.BLACK);
        // Esto permite cambiar la fuente de la lista desplegable de la ventana.
        UIManager.put("ComboBox.font", COMBOBOX_FONT);
        // Esto permite cambiar el color de la lista desplegable de la ventana.
        UIManager.put("ComboBox.foreground", Color.BLACK);
    }

    /**
     * Función que solicita al usuario una entrada de datos de un tipo específico.
     * {@snippet
     * //Ejemplo de uso:
     * // Solicitar una opción de un conjunto de opciones
     *  String[] colors = {"Rojo", "Verde", "Azul", "Amarillo"};
     * String color = InputHandler.getInput("Seleccione un color", colors);
     *}
     *
     * @param message El mensaje que se mostrará al usuario.
     * @param options Las opciones disponibles para el usuario.
     * @return La opción seleccionada por el usuario.
     * @param <T> El tipo de dato de la opción seleccionada.
     */
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

    /**
     * Función que solicita al usuario una entrada de datos de un tipo específico.
     * {@snippet
     * //Ejemplo de uso:
     * // Solicitar un número entero
     * int number = InputHandler.getInput("Ingrese un número entero", 0);
     * // Solicitar un número decimal
     * double decimal = InputHandler.getInput("Ingrese un número decimal", 0.0);
     * // Solicitar un texto
     * String text = InputHandler.getInput("Ingrese un texto", "");
     *}
     *
     * @param message El mensaje que se mostrará al usuario.
     * @param type    Un valor del tipo de dato que se desea solicitar.
     * @return La entrada del usuario convertida al tipo de dato solicitado.
     * @param <T> El tipo de dato que se desea solicitar.
     */
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

    /**
     * Función que muestra un mensaje al usuario con un título y un tipo de mensaje específico.
     * {@snippet
     * //Ejemplo de uso:
     * // Mostrar un mensaje de información
     *  InputHandler.showMessage("Operación completada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
     * // Mostrar un mensaje de advertencia
     *  InputHandler.showMessage("Cuidado: Esta acción no se puede deshacer", "Advertencia", JOptionPane.WARNING_MESSAGE);
     *}
     *
     * @param message     El mensaje que se mostrará al usuario.
     * @param title       El título de la ventana del mensaje.
     * @param messageType El tipo de mensaje (por ejemplo, JOptionPane.INFORMATION_MESSAGE).
     */
    public static void showMessage(String message, String title, int messageType) {

        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    private static String getInput(String message) {

        return JOptionPane.showInputDialog(null, message);
    }
}
