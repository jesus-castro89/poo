package app.game;

import org.util.InputHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Clase que representa el juego del Ahorcado.
 * Proporciona la lógica básica para jugar al juego del Ahorcado.
 */
public class HangedMan {
    /**
     * Lista de palabras disponibles para el juego.
     */
    private String[] words;
    /**
     * Número máximo de intentos permitidos.
     */
    private final int maxAttempts = 6;
    /**
     * Palabra actual que el jugador debe adivinar.
     */
    private String currentWord;
    /**
     * Letras adivinadas por el jugador.
     */
    private ArrayList<String> guessedLetters;
    /**
     * Representación de la palabra incompleta con letras adivinadas.
     */
    private String incompleteWord;
    /**
     * Número de intentos restantes.
     */
    private int attemptsLeft;
    /**
     * Lista de palabras completadas en sesiones anteriores.
     */
    private ArrayList<String> completedWords;

    public HangedMan() {
        this.words = new String[]{
                "programador", "java", "sistemas", "lógica", "teclado",
                "monitor", "administración", "software", "hardware", "aplicativo",
                "programación"
        };
        this.completedWords = new ArrayList<>();
    }

    public String getRandomWord() {
        Random rand = new Random();
        // Obtenemos un índice entre 0 y
        // la longitud del arreglo de palabras - 1
        int index = rand.nextInt(words.length);
        if (completedWords.contains(words[index])) {
            return getRandomWord();
        } else {
            completedWords.add(words[index]);
            return words[index];
        }
    }

    public void startNewGame() {
        this.currentWord = getRandomWord().toUpperCase();
        IO.println("Palabra a adivinar: " + currentWord); // Para pruebas
        this.guessedLetters = new ArrayList<>();
        this.incompleteWord = "_".repeat(currentWord.length());
        this.attemptsLeft = maxAttempts;
    }

    public void showIncompleteWord() {
        StringBuilder displayWord = new StringBuilder();
        for (char c : currentWord.toCharArray()) {
            switch (c) {
                case 'Á' -> c = 'A';
                case 'É' -> c = 'E';
                case 'Í' -> c = 'I';
                case 'Ó' -> c = 'O';
                case 'Ú', 'Ü' -> c = 'U';
            }
            if (guessedLetters.toString().contains(String.valueOf(c))) {
                displayWord.append(c).append(" ");
            } else {
                displayWord.append("_ ");
            }
        }
        IO.println("Palabra: " + displayWord.toString().trim());
    }

    public void playTurn() {
        Predicate<String> letterValidator =
                p -> p.matches("^[a-zA-ZñÑ]$");
        String letter = InputHandler.getInput("Ingresa una letra: ",
                letterValidator,
                "Por favor, ingresa una sola letra.",
                "").toUpperCase();
        if (guessedLetters.contains(letter)) {
            IO.println("Ya has adivinado esa letra. Intenta con otra.");
            playTurn();
        } else {
            guessedLetters.add(letter);
            switch (letter) {
                case "A" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("Á")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillIncompleteWord(letter);
                        fillIncompleteWord("Á");
                        IO.println("¡Letra correcta!");
                        showIncompleteWord();
                    }
                }
                case "E" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("É")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillIncompleteWord(letter);
                        fillIncompleteWord("É");
                        IO.println("¡Letra correcta!");
                        showIncompleteWord();
                    }
                }
                case "I" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("Í")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillIncompleteWord(letter);
                        fillIncompleteWord("Í");
                        IO.println("¡Letra correcta!");
                        showIncompleteWord();
                    }
                }
                case "O" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("Ó")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillIncompleteWord(letter);
                        fillIncompleteWord("Ó");
                        IO.println("¡Letra correcta!");
                        showIncompleteWord();
                    }
                }
                case "U" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("Ú") &&
                            !currentWord.contains("Ü")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillIncompleteWord(letter);
                        fillIncompleteWord("Ú");
                        fillIncompleteWord("Ü");
                        IO.println("¡Letra correcta!");
                        showIncompleteWord();
                    }
                }
                default -> {
                    if (!currentWord.contains(letter)) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillIncompleteWord(letter);
                        IO.println("¡Letra correcta!");
                        showIncompleteWord();
                    }
                }
            }
        }
        if (incompleteWord.equals(currentWord)) {
            IO.println("¡Felicidades! Has adivinado la palabra: " + currentWord);
        } else if (attemptsLeft <= 0) {
            IO.println("Has perdido. La palabra era: " + currentWord);
        } else {
            playTurn();
        }
    }

    public void fillIncompleteWord(String letter) {
        StringBuilder newIncompleteWord = new StringBuilder(incompleteWord);
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == letter.charAt(0)) {
                newIncompleteWord.setCharAt(i, letter.charAt(0));
            }
        }
        incompleteWord = newIncompleteWord.toString();
    }
}
