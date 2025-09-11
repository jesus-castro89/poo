package app.input;

public class Main {

    public static void main(String[] args) {
        DataStore<Integer> intStore = new DataStore<>();
        intStore.addData(InputHandler.<Integer>getInput("Ingrese un número entero: ", Integer.class));
        intStore.displayData();

        DataStore<Double> doubleStore = new DataStore<>();
        doubleStore.addData(InputHandler.getInput("Ingrese un número decimal: ", Double.class));
        doubleStore.displayData();
    }
}
