package interfaz;

import herencia.abstracto.Rectangle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vendible> productos = new ArrayList<>();
        Rectangle r=new Rectangle("Rectangulo", true, "R1", 5, 10);
        productos.add(r);
    }
}
