# ¿Qué son los principios SOLID?

Los principios SOLID son un conjunto de cinco principios de diseño de software que buscan mejorar la calidad y la
mantenibilidad del código. Estos principios fueron introducidos por Robert C. Martin (también conocido como Uncle Bob) y
son ampliamente utilizados en el desarrollo de software orientado a objetos. A continuación, se describen brevemente
cada uno de los principios SOLID:

1. **S** - **Single Responsibility Principle (SRP)**: Este principio establece que una clase debe tener una única razón
   para cambiar, lo que significa que debe tener una sola responsabilidad o función. Esto ayuda a mantener el código
   organizado y facilita su comprensión y mantenimiento.
2. **O** - **Open/Closed Principle (OCP)**: Este principio establece que las entidades de software (clases, módulos,
   funciones, etc.) deben estar abiertas para su extensión, pero cerradas para su modificación. Esto significa que se
   debe poder agregar nueva funcionalidad sin modificar el código existente, lo que reduce el riesgo de introducir
   errores.
3. **L** - **Liskov Substitution Principle (LSP)**: Este principio establece que los objetos de una clase derivada deben
   poder sustituir a los objetos de la clase base sin alterar el comportamiento del programa. Esto significa que las
   subclases deben ser intercambiables con sus superclases, lo que promueve la reutilización del código y el
   polimorfismo.
4. **I** - **Interface Segregation Principle (ISP)**: Este principio establece que los clientes no deben verse obligados
   a depender de interfaces que no utilizan. En otras palabras, es mejor tener varias interfaces específicas en lugar de
   una única interfaz general. Esto ayuda a evitar la creación de clases grandes y complejas que implementan métodos
   innecesarios.
5. **D** - **Dependency Inversion Principle (DIP)**: Este principio establece que las dependencias deben ser
   abstraídas. En lugar de depender de clases concretas, las clases deben depender de abstracciones (interfaces o
   clases abstractas). Esto promueve la flexibilidad y la reutilización del código, ya que permite cambiar las
   implementaciones sin afectar a las clases que dependen de ellas.

Estos principios son fundamentales para el desarrollo de software de calidad y ayudan a los desarrolladores a crear
código más limpio, modular y fácil de mantener. Al seguir los principios SOLID, se pueden reducir los costos de
mantenimiento, mejorar la legibilidad del código y facilitar la colaboración en equipos de desarrollo.
Además, los principios SOLID fomentan la creación de sistemas escalables y flexibles que pueden adaptarse a los
cambios en los requisitos del negocio y la tecnología. Al aplicar estos principios, los desarrolladores pueden
aumentar la calidad del software y reducir el riesgo de errores y problemas en el futuro.

## Ejemplo de los principios SOLID

A continuación, se presenta un ejemplo práctico de cómo aplicar los principios SOLID en el desarrollo de software.
Imaginemos que estamos desarrollando un sistema de gestión de pedidos para una tienda en línea. En este ejemplo,
crearemos una clase `Pedido` que representa un pedido y aplicaremos los principios SOLID para mejorar su diseño.

```java
// Ejemplo de clase Pedido que aplica los principios SOLID
public class Pedido {
    private String id;
    private List<Producto> productos;
    private double total;

    public Pedido(String id) {
        this.id = id;
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    // SRP: La clase Pedido tiene una única responsabilidad: gestionar un pedido
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    public double calcularTotal() {
        return total;
    }

    // OCP: La clase Pedido está abierta para su extensión (se pueden agregar nuevos métodos)
    public void aplicarDescuento(double porcentaje) {
        total -= total * (porcentaje / 100);
    }
}
```

```java
// Ejemplo de clase Producto que aplica los principios SOLID
public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // SRP: La clase Producto tiene una única responsabilidad: representar un producto
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
```

```java
// Ejemplo de interfaz de pago que aplica los principios SOLID
public interface MetodoPago {
    void procesarPago(double monto);
}
```

```java
// Ejemplo de clase de pago con tarjeta de crédito que aplica los principios SOLID
public class PagoConTarjeta implements MetodoPago {
    private String numeroTarjeta;

    public PagoConTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    // LSP: La clase PagoConTarjeta puede sustituir a la interfaz MetodoPago sin alterar el comportamiento
    @Override
    public void procesarPago(double monto) {
        // Lógica para procesar el pago con tarjeta de crédito
        System.out.println("Procesando pago de " + monto + " con tarjeta " + numeroTarjeta);
    }
}
```

```java
// Ejemplo de clase de pago con PayPal que aplica los principios SOLID
public class PagoConPayPal implements MetodoPago {
    private String email;

    public PagoConPayPal(String email) {
        this.email = email;
    }

    // LSP: La clase PagoConPayPal puede sustituir a la interfaz MetodoPago sin alterar el comportamiento
    @Override
    public void procesarPago(double monto) {
        // Lógica para procesar el pago con PayPal
        System.out.println("Procesando pago de " + monto + " con PayPal " + email);
    }
}
```

```java
// Ejemplo de clase de gestión de pagos que aplica los principios SOLID
public class GestorPagos {
    private MetodoPago metodoPago;

    // DIP: La clase GestorPagos depende de la abstracción MetodoPago en lugar de depender de clases concretas
    public GestorPagos(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void procesarPago(double monto) {
        metodoPago.procesarPago(monto);
    }
}
```

```java
// Ejemplo de uso de los principios SOLID
public class Main {
    public static void main(String[] args) {
        // Crear un pedido
        Pedido pedido = new Pedido("12345");
        Producto producto1 = new Producto("Camiseta", 19.99);
        Producto producto2 = new Producto("Pantalón", 39.99);

        // Agregar productos al pedido
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        // Calcular el total del pedido
        System.out.println("Total del pedido: " + pedido.calcularTotal());

        // Aplicar un descuento al pedido
        pedido.aplicarDescuento(10);
        System.out.println("Total del pedido después del descuento: " + pedido.calcularTotal());

        // Procesar el pago con tarjeta de crédito
        MetodoPago metodoPago = new PagoConTarjeta("1234-5678-9012-3456");
        GestorPagos gestorPagos = new GestorPagos(metodoPago);
        gestorPagos.procesarPago(pedido.calcularTotal());
    }
}
```   

En este ejemplo, hemos aplicado los principios SOLID de la siguiente manera:

- **SRP**: La clase `Pedido` tiene una única responsabilidad: gestionar un pedido. La clase `Producto` también tiene una
  única responsabilidad: representar un producto.
- **OCP**: La clase `Pedido` está abierta para su extensión, ya que se pueden agregar nuevos métodos sin modificar el
  código existente.
- **LSP**: Las clases `PagoConTarjeta` y `PagoConPayPal` pueden sustituir a la interfaz `MetodoPago` sin alterar el
  comportamiento del programa.
- **ISP**: La interfaz `MetodoPago` es específica y no obliga a las clases a implementar métodos innecesarios.
- **DIP**: La clase `GestorPagos` depende de la abstracción `MetodoPago` en lugar de depender de clases concretas,
  lo que permite cambiar la implementación del método de pago sin afectar a la clase `GestorPagos`.

## Conclusión

Los principios SOLID son fundamentales para el desarrollo de software de calidad y ayudan a los desarrolladores a
crear código más limpio, modular y fácil de mantener. Al aplicar estos principios, se pueden reducir los costos de
mantenimiento, mejorar la legibilidad del código y facilitar la colaboración en equipos de desarrollo. Además,
los principios SOLID fomentan la creación de sistemas escalables y flexibles que pueden adaptarse a los cambios en los
requisitos del negocio y la tecnología. Al seguir estos principios, los desarrolladores pueden aumentar la calidad
del software y reducir el riesgo de errores y problemas en el futuro.