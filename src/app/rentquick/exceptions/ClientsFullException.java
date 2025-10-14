package app.rentquick.exceptions;

public class ClientsFullException extends RuntimeException {
    public ClientsFullException(String message) {
        super(message);
    }
}
