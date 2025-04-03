package interfaz;

public class Fruta implements Vendible {

    private String nombre;
    private double precio;
    private int cantidad;

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
