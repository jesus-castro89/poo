package app.input;

public class Main {

    public static void main(String[] args) {

        InputHandler.getInput("Ingrese un número entero", 0);
        String[] colors = {"Rojo", "Verde", "Azul", "Amarillo"};
        InputHandler.getInput("Seleccione un color", colors);
        InputHandler.showMessage("Operación completada con éxito", "Éxito", 1);
    }
}
