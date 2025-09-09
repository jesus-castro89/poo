package app.exceptions;

public class NotIntegerException extends Exception{

    public NotIntegerException(){
        super("El valor ingresado no es un número entero.");
    }
}
