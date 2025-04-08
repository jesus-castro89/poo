package juegos.ahorcado;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Clase HangedMan que representa el juego del ahorcado.
 * El objetivo del juego es adivinar una palabra secreta adivinando letras.
 * El jugador tiene un número limitado de intentos para adivinar la palabra.
 */
public class HangedMan {
    /**
     * Palabras a adivinar
     */
    private static final String[] WORDS = {
            "java",
            "programacion",
            "computadora",
            "desarrollo",
            "algoritmo",
            "software",
            "tecnologia",
            "internet",
            "redes",
            "sistema"
    };
    /**
     * Palabra a adivinar
     */
    private String wordToGuess;
    /**
     * Letras adivinadas
     */
    private char[] guessedLetters;
    /**
     * Letras incorrectas
     */
    private char[] incorrectLetters;
    /**
     * Intentos restantes
     */
    private int remainingAttempts;

    static {
        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.PLAIN, 20));
        UIManager.put("OptionPane.buttonFont",
                new Font("Arial", Font.BOLD, 20));
        UIManager.put("TextField.font",
                new Font("Arial", Font.PLAIN, 20));
    }

    /**
     * Constructor de la clase HangedMan que inicializa el juego.
     */
    public HangedMan() {

        // Obtenemos una palabra aleatoria de la lista de palabras.
        this.wordToGuess = getRandomWord();
        // Inicializamos las letras adivinadas haciendo el arreglo del tamaño de la palabra a adivinar.
        this.guessedLetters = new char[wordToGuess.length()];
        // Inicializamos las letras incorrectas con un arreglo de 26 letras (alfabeto).
        this.incorrectLetters = new char[26];
        // Inicializamos las letras adivinadas con guiones bajos.
        Arrays.fill(guessedLetters, '_');
        // Inicializamos las letras incorrectas con guiones bajos.
        Arrays.fill(incorrectLetters, '_');
        // Inicializamos los intentos restantes a 6.
        this.remainingAttempts = 6;
    }

    /**
     * Función para obtener una palabra aleatoria de la lista de palabras.
     *
     * @return Palabra aleatoria.
     */
    private String getRandomWord() {

        // Obtenemos una palabra aleatoria de la lista de palabras.
        return WORDS[(int) (Math.random() * WORDS.length)].toUpperCase();
    }

    /**
     * Función principal para iniciar el juego.
     */
    public void playGame() {

        // Mostramos un mensaje de bienvenida al usuario.
        JOptionPane.showMessageDialog(null,
                "¡Bienvenido al juego del ahorcado!",
                "¡Bienvenido!", JOptionPane.INFORMATION_MESSAGE);
        // Pedimos al usuario que ingrese una letra.
        askForLetter();
    }

    /**
     * Función para reiniciar el juego.
     */
    private void resetGame() {

        // Reiniciamos el juego.
        this.wordToGuess = getRandomWord();
        this.guessedLetters = new char[wordToGuess.length()];
        this.incorrectLetters = new char[26];
        Arrays.fill(guessedLetters, '_');
        Arrays.fill(incorrectLetters, '_');
        this.remainingAttempts = 6;
    }

    /**
     * Función para preguntar al usuario si quiere jugar de nuevo.
     */
    private void askForNewGame() {

        // Preguntamos al usuario si quiere jugar de nuevo.
        int response = JOptionPane.showConfirmDialog(null,
                "¿Quieres jugar de nuevo?",
                "Juego terminado", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            resetGame();
            askForLetter();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Gracias por jugar. ¡Hasta luego!",
                    "¡Adiós!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Función para pedir al usuario que ingrese una letra.
     */
    private void askForLetter() {

        try {
            // Pedimos al usuario que ingrese una letra.
            char letter = JOptionPane.showInputDialog(null,
                    displayGameStatus() +
                            "Ingrese una letra:").charAt(0);
            // Validamos que el caracter ingresado sea una letra.
            if (!Character.isLetter(letter))
                throw new Exception("No es una letra");
            // Verificamos si la letra es correcta o incorrecta.
            if (guessLetter(letter)) {

                JOptionPane.showMessageDialog(null,
                        "¡Correcto, la letra está en la palabra!",
                        "¡Correcto!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "¡Incorrecto, la letra no está en la palabra!",
                        "¡Incorrecto!", JOptionPane.ERROR_MESSAGE);
            }
            // Verificamos si el juego ha terminado.
            if (isGameOver()) {
                // Si el juego ha terminado, mostramos un mensaje de victoria o derrota.
                if (isWordGuessed()) {
                    JOptionPane.showMessageDialog(null,
                            "¡Ganaste! La palabra era: " + wordToGuess,
                            "¡Victoria!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Si el juego ha terminado y no se ha adivinado la palabra,
                    // mostramos un mensaje de derrota.
                    JOptionPane.showMessageDialog(null,
                            "Perdiste. La palabra era: " + wordToGuess,
                            "¡Derrota!", JOptionPane.ERROR_MESSAGE);
                }
                // Preguntamos al usuario si quiere jugar de nuevo.
                askForNewGame();
            } else {
                // Si el juego no ha terminado, pedimos al usuario que ingrese otra letra.
                askForLetter();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Debes ingresar una letra válida.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            askForLetter();
        }
    }

    /**
     * Función para mostrar el estado del juego.
     *
     * @return Estado del juego.
     */
    private String displayGameStatus() {

        return """
                --------------------
                Palabra a adivinar: %s
                Letras incorrectas: %s
                Intentos restantes: %d
                --------------------
                """.formatted(displayGuessedLetters(), displayIncorrectLetters(), remainingAttempts);
    }

    /**
     * Función para mostrar las letras incorrectas.
     */
    private String displayIncorrectLetters() {

        StringBuilder display = new StringBuilder();
        for (char letter : incorrectLetters)
            if (letter != '_')
                display.append(letter).append(" ");
        return display.toString().trim();
    }

    /**
     * Función para mostrar las letras adivinadas.
     */
    private String displayGuessedLetters() {

        StringBuilder display = new StringBuilder();
        for (char letter : guessedLetters)
            display.append(letter == '_' ? "_ " : letter + " ");
        return display.toString().trim();
    }

    /**
     * Función para adivinar una letra.
     *
     * @param letter Letra a adivinar.
     * @return true si la letra es correcta, false si es incorrecta.
     */
    public boolean guessLetter(char letter) {

        // Convertimos la letra a minúscula.
        letter = Character.toUpperCase(letter);
        // Verificamos si la letra ya ha sido adivinada.
        if (isLetterGuessed(letter))
            return false;
        // Verificamos si la letra está en la palabra a adivinar.
        if (wordToGuess.indexOf(letter) != -1) {
            // Si la letra es correcta, actualizamos las letras adivinadas.
            for (int i = 0; i < wordToGuess.length(); i++)
                if (wordToGuess.charAt(i) == letter)
                    guessedLetters[i] = letter;
            return true;
        } else {
            // Si la letra es incorrecta, actualizamos las letras incorrectas y los intentos restantes.
            incorrectLetters[26 - remainingAttempts] = letter;
            remainingAttempts--;
            return false;
        }
    }

    /**
     * Función para verificar si la letra ya ha sido adivinada.
     *
     * @param letter Letra a verificar.
     * @return true si la letra ya ha sido adivinada, false si no.
     */
    public boolean isLetterGuessed(char letter) {
        // Convertimos la letra a minúscula.
        letter = Character.toUpperCase(letter);
        // Verificamos si la letra está en las letras adivinadas.
        for (char guessedLetter : guessedLetters)
            if (guessedLetter == letter)
                return true;
        return false;
    }

    /**
     * Función para verificar si el juego ha terminado.
     *
     * @return true si el juego ha terminado, false si no.
     */
    public boolean isGameOver() {

        // Verificamos si se han agotado los intentos restantes o si se ha adivinado la palabra.
        return remainingAttempts == 0 || isWordGuessed();
    }

    /**
     * Función para verificar si la palabra ha sido adivinada.
     *
     * @return true si la palabra ha sido adivinada, false si no.
     */
    public boolean isWordGuessed() {

        // Verificamos si todas las letras de la palabra a adivinar han sido adivinadas.
        for (int i = 0; i < wordToGuess.length(); i++)
            if (guessedLetters[i] != wordToGuess.charAt(i))
                return false;
        return true;
    }
}
