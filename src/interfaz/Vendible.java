package interfaz;

public interface Vendible {

    String nombre="";

    static void mostrar(){
        System.out.println("Nombre: " + nombre);
    }

    double getPrecio();

    void setPrecio(double precio);

    String getNombre();
}
