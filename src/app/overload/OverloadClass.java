package app.overload;

public class OverloadClass {

    public void overloadedMethod(int a) {
        IO.println("Método con parámetro int: " + a);
    }

    public void overloadedMethod(String s) {
        IO.println("Método con parámetro String: " + s);
    }

    public void overloadedMethod(int a, String s) {
        IO.println("Método con parámetros int y String: " + a + ", " + s);
    }
}
