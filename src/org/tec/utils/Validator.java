package org.tec.utils;

import javax.swing.*;
import java.util.function.Predicate;

/**
 * Clase que permite validar la entrada de datos en un JOptionPane.
 */
public class Validator {

    /**
     * Función que permite validar la entrada de datos en un JOptionPane y retorna un valor de tipo T.
     * <p>
     * <b>Ejemplo de uso:</b>
     * {@code Validator.validate(Integer.class, " Ingrese un número entero : ", " Número inválido. ", " Validación de número entero ");}
     * </p>
     *
     * @param type         Tipo de dato a retornar.
     * @param inputMessage Mensaje que se muestra al usuario para ingresar el dato.
     * @param errorMessage Mensaje que se muestra al usuario si el dato ingresado no es válido.
     * @param windowTitle  Título de la ventana del JOptionPane.
     * @param <T>          Clase genérica que representa el tipo de dato a retornar.
     * @return Valor de tipo T ingresado por el usuario.
     */
    public static <T> T validate(Class<T> type, String inputMessage, String errorMessage, String windowTitle) {

        String input;
        boolean valid = false;
        T result = null;
        while (!valid) {
            try {
                input = JOptionPane.showInputDialog(null, inputMessage, windowTitle, JOptionPane.QUESTION_MESSAGE);
                if (input == null || input.isEmpty())
                    throw new IllegalArgumentException();
                result = switch (type.getName()) {
                    case "java.lang.String" -> (T) input;
                    case "java.lang.Integer" -> (T) Integer.valueOf(input);
                    case "java.lang.Double" -> (T) Double.valueOf(input);
                    case "java.lang.Float" -> (T) Float.valueOf(input);
                    case "java.lang.Long" -> (T) Long.valueOf(input);
                    case "java.lang.Short" -> (T) Short.valueOf(input);
                    case "java.lang.Byte" -> (T) Byte.valueOf(input);
                    case "java.lang.Boolean" -> (T) Boolean.valueOf(input);
                    case "java.lang.Character" -> (T) Character.valueOf(input.charAt(0));
                    default -> throw new IllegalArgumentException();
                };
                valid = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errorMessage, windowTitle, JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }

    /**
     * Función que permite validar la selección de un valor de un arreglo de opciones en un JOptionPane y retorna un valor de tipo T.
     * <p>
     * <b>Ejemplo de uso:</b>
     * {@code validate(new String[] { " Opción 1 ", " Opción 2 ", " Opción 3 " }, " Seleccione una opción : ", " Opción inválida. ", " Validación de opción ");}
     * </p>
     *
     * @param options      Arreglo de opciones a seleccionar de tipo T.
     * @param inputMessage Mensaje que se muestra al usuario para seleccionar una opción.
     * @param errorMessage Mensaje que se muestra al usuario si la opción seleccionada no es válida.
     * @param windowTitle  Título de la ventana del JOptionPane.
     * @param <T>          Clase genérica que representa el tipo de dato a retornar.
     * @return Valor de tipo T seleccionado por el usuario.
     */
    public static <T> T validate(T[] options, String inputMessage, String errorMessage, String windowTitle) {

        T result = null;
        boolean valid = false;
        while (!valid) {
            try {
                result = (T) JOptionPane.showInputDialog(null, inputMessage, windowTitle, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (result == null)
                    throw new IllegalArgumentException();
                valid = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errorMessage, windowTitle, JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }

    /**
     * Función que permite validar la entrada de datos en un JOptionPane y retorna un valor de tipo T que cumpla con una condición.
     * <p>
     * <b>Ejemplo de uso:</b>
     * {@code Validator.validate(Integer.class, (Integer i) -> i > 0, " Ingrese un número entero positivo : ", " Número inválido. ", " Validación de número entero positivo ");}
     * </p>
     *
     * @param type         Tipo de dato a retornar.
     * @param condition    Condición que debe cumplir el valor ingresado una vez convertido a tipo T.
     * @param inputMessage Mensaje que se muestra al usuario para ingresar el dato.
     * @param errorMessage Mensaje que se muestra al usuario si el dato ingresado no es válido.
     * @param windowTitle  Título de la ventana del JOptionPane.
     * @param <T>          Clase genérica que representa el tipo de dato a retornar.
     * @return Valor de tipo T ingresado por el usuario que cumple con la condición.
     */
    public static <T> T validate(Class<T> type, Predicate<T> condition, String inputMessage, String errorMessage, String windowTitle) {

        boolean valid = false;
        T result = null;
        while (!valid) {
            try {
                result = validate(type, inputMessage, errorMessage, windowTitle);
                if (!condition.test(result))
                    throw new IllegalArgumentException();
                valid = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errorMessage, windowTitle, JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }
}
