package interfaz;

public class Piso implements Vendible {

    private String name;
    private double precioM2;
    private double metrosCuadrados;

    public Piso(String name, double precioM2, double metrosCuadrados) {
        this.name = name;
        this.precioM2 = precioM2;
        this.metrosCuadrados = metrosCuadrados;
    }

    public Piso(String name, double metrosCuadrados) {

        this.name = name;
        this.metrosCuadrados = metrosCuadrados;
    }

    @Override
    public double getPrecio() {
        return precioM2 * metrosCuadrados;
    }

    @Override
    public void setPrecio(double precio) {

        this.precioM2 = precio / metrosCuadrados;
    }

    @Override
    public String getNombre() {
        return "";
    }
}
