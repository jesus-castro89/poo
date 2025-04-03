package interfaz;

public interface Vendible {

    static final String nombre="";

    static void mostrar(){
        System.out.println("Nombre: " + nombre);
    }

    double getPrecio();

    void setPrecio(double precio);

    String getNombre();
}
