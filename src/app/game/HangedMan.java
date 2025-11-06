package app.game;

import org.util.InputHandler;

import java.util.ArrayList;
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
    private final String[] words;

    /**
     * Lista de palabras completadas en sesiones anteriores.
     */
    private final ArrayList<String> playedWords;

    /**
     * Letras adivinadas por el jugador.
     */
    private ArrayList<String> guessedLetters;

    /**
     * Número máximo de intentos permitidos.
     */
    private final int maxAttempts = 6;

    /**
     * Palabra actual que el jugador debe adivinar.
     */
    private String currentWord;

    /**
     * Representación de la palabra incompleta con letras adivinadas.
     */
    private String incompleteWord;

    /**
     * Número de intentos restantes.
     */
    private int attemptsLeft;

    /**
     * Constructor de la clase HangedMan.
     * Inicializa la lista de palabras y las palabras jugadas.
     */
    public HangedMan() {

        this.words = new String[]{
                "programador", "java", "sistemas", "lógica", "teclado",
                "monitor", "administración", "software", "hardware", "aplicativo",
                "programación"
        };
        this.playedWords = new ArrayList<>();
    }

    /**
     * Obtiene una palabra aleatoria de la lista de palabras.
     *
     * @return Una palabra aleatoria.
     */
    public String getRandomWord() {
        // Creamos una instancia de Random
        Random rand = new Random();
        // Obtenemos un índice entre 0 y
        // la longitud del arreglo de palabras - 1
        int index = rand.nextInt(words.length);
        if (playedWords.contains(words[index])) {
            return getRandomWord();
        } else {
            playedWords.add(words[index]);
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
        for (int i = 0; i < incompleteWord.length(); i++) {
            displayWord.append(incompleteWord.charAt(i)).append(" ");
        }
        IO.println("Palabra: " + displayWord);
    }

    private void fillAndDisplayWord(String[] letters) {
        for (String letter : letters) {
            fillIncompleteWord(letter);
        }
        IO.println("¡Letra correcta!");
        showIncompleteWord();
    }

    public void playTurn() {
        Predicate<String> letterValidator =
                p -> p.matches("[a-zA-ZñÑ]");
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
                        fillAndDisplayWord(new String[]{"A", "Á"});
                    }
                }
                case "E" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("É")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillAndDisplayWord(new String[]{"E", "É"});
                    }
                }
                case "I" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("Í")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillAndDisplayWord(new String[]{"I", "Í"});
                    }
                }
                case "O" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("Ó")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillAndDisplayWord(new String[]{"O", "Ó"});
                    }
                }
                case "U" -> {
                    if (!currentWord.contains(letter) &&
                            !currentWord.contains("Ú") &&
                            !currentWord.contains("Ü")) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillAndDisplayWord(new String[]{"U", "Ú", "Ü"});
                    }
                }
                default -> {
                    if (!currentWord.contains(letter)) {
                        attemptsLeft--;
                        IO.println("Letra incorrecta. Te quedan " + attemptsLeft + " intentos.");
                    } else {
                        fillAndDisplayWord(new String[]{letter});
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
