# Ejemplo 5: Tipos de Herencia y Polimorfismo en Java

En Java, la herencia es un mecanismo que permite a una clase (subclase) heredar propiedades y comportamientos (métodos)
de otra clase (superclase). Existen varios tipos de herencia en Java, y el polimorfismo es un concepto relacionado que
permite a los objetos de diferentes clases ser tratados como objetos de una clase común. A continuación, se describen
los tipos de herencia y el polimorfismo mediante un ejemplo práctico.

## Descripción del Ejemplo

Supongamos que estamos desarrollando una aplicación para gestionar diferentes tipos de vehículos. Tenemos una clase
base llamada `Vehiculo`, y varias subclases como `Coche`, `Moto` y `Camion`. Cada tipo de vehículo tiene sus propias
propiedades y métodos, pero todos comparten algunas características comunes definidas en la clase base.

```java
// Clase base
public class Vehiculo {
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo);
    }
}
```

```java
// Subclase Coche
public class Coche extends Vehiculo {
    private int numPuertas;

    public Coche(String marca, String modelo, int numPuertas) {
        super(marca, modelo);
        this.numPuertas = numPuertas;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de puertas: " + numPuertas);
    }
}
```

```java
// Subclase Moto
public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, String modelo, boolean tieneSidecar) {
        super(marca, modelo);
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tiene sidecar: " + (tieneSidecar ? "Sí" : "No"));
    }
}
```

```java
// Subclase Camion
public class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String marca, String modelo, double capacidadCarga) {
        super(marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Capacidad de carga: " + capacidadCarga + " toneladas");
    }
}
```

```java
// Clase principal para probar la herencia y el polimorfismo
public class Main {
    void main() {
        Vehiculo miCoche = new Coche("Toyota", "Corolla", 4);
        Vehiculo miMoto = new Moto("Harley-Davidson", "Street 750", false);
        Vehiculo miCamion = new Camion("Volvo", "FH16", 20);

        // Usando polimorfismo para llamar al método mostrarInfo
        miCoche.mostrarInfo();
        miMoto.mostrarInfo();
        miCamion.mostrarInfo();
    }
}
```