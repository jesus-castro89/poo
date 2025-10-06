package app.overload;

public class Main {

    void main() {

        Main app = new Main();
        app.askForData();
    }

    public void askForData() {
        int num = Integer.parseInt(
                IO.readln("Ingrese un número entero:"));
        String text = IO.readln("Ingrese un texto:");
        OverloadClass oc = new OverloadClass();
        oc.overloadedMethod(num);
        oc.overloadedMethod(text);
        oc.overloadedMethod(num, text);
    }
}
