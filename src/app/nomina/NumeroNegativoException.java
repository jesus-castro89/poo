package app.nomina;

public class NumeroNegativoException extends  Exception {

    public NumeroNegativoException() {
        super("El numero no puede ser negativo");
    }
}
