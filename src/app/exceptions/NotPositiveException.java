package app.exceptions;

public class NotPositiveException extends Exception{

    public NotPositiveException(){
        super("El valor ingresado no es un número positivo.");
    }
}
