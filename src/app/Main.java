package app;

import app.test.MiClase;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        MiClase mi = new MiClase();
        MiClase.showValue();
        mi.incrementar();
        MiClase mi2 = new MiClase();
        mi2.incrementar();
        mi2.incrementar();
        MiClase.showValue();
    }
}
