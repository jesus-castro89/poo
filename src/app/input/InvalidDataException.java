package app.input;

public class InvalidDataException extends Exception {

    public InvalidDataException() {
        super("Dato inválido");
    }
}