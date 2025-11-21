# Ejemplo 10: La Cafetería Universitaria - De la Confusión al Orden

Imagina que la Cafetería Universitaria tiene un solo empleado que hace TODO:

* Toma pedidos
* Cocina la comida
* Empaca la comida
* Limpia el área
* Cobra a los clientes

**¡¿Qué caos, verdad?!**

**Problema**: Si quieres agregar "pago con tarjeta", tienes que reentrenar a ESTA persona en TODO.

**Solución ideal**: Cada persona tiene UNA responsabilidad:

* Cajero: Solo cobra
* Cocineros: Solo cocinan
* Empacador: Solo empaca
* Limpieza: Solo limpia

¡Eso es el SRP! Y si llega un nuevo método de pago, solo entrenas al cajero - eso es el OCP!

## PASO 1: El Desastre Inicial (Violando Todo)

```java
// ❌ MAL HECHO - Como el empleado que hace todas las tareas
public class CafeteriaTodoEnUno {

    public void procesarPedido(Pedido pedido) {
        // 1. Validar (¿debería hacer esto?)
        if (pedido.getProductos().isEmpty()) {
            IO.println("❌ El pedido está vacío");
            return;
        }

        // 2. Calcular total (¿y esto?)
        double total = calcularTotal(pedido);

        // 3. Cocinar (¡¿un cajero cocinando?!)
        prepararComida(pedido);

        // 4. Cobrar (ok, esto sí)
        if (pedido.getMetodoPago().equals("EFECTIVO")) {
            cobrarEfectivo(total);
        } else if (pedido.getMetodoPago().equals("TARJETA")) {
            cobrarTarjeta(total);
        }
        // ¿Y si llega PayPal? ¡Tengo que MODIFICARME!

        // 5. Empacar (¡¿ahora soy empacador?!)
        empacarPedido(pedido);

        // 6. Limpiar (¡esto ya es demasiado!)
        limpiarMesa();
    }

    // ... todos los métodos aquí mezclados
}
```

> **Problemas**:
> - Difícil de entender y mantener.
> - Cada vez que agregas un método de pago, tienes que cambiar TODO el código.
> - Si quieres mejorar la cocina, ¡tienes que tocar el código del cajero!
> - Un desastre total.
> - Difícil de probar.
>
{style="warning"}

## PASO 2: Separando Responsabilidades (Aplicando SRP)

Antes de empezar, ubiquemos los actores principales de apoyo:

* El cliente.
* El pedido (con productos y cliente).
* Productos (con nombre y precio).

```java
public class Cliente {
    private String nombre;
    private String email;
    private boolean esEstudiante;

    public Cliente(String nombre, String email, boolean esEstudiante) {
        this.nombre = nombre;
        this.email = email;
        this.esEstudiante = esEstudiante;
    }

    public boolean esEstudiante() {
        return esEstudiante;
    }

    public String getNombre() {
        return nombre;
    }
}
```

```java
public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
```

```java
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    private String metodoPago;

    public Pedido(Cliente cliente, List<Producto> productos, String metodoPago) {
        this.cliente = cliente;
        this.productos = productos;
        this.metodoPago = metodoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
}
```

Ahora sí, vamos a crear especialistas para cada tarea:

### Especialista 1: El Validador

```java
// ✅ SOLO se dedica a validar pedidos
public class ValidadorPedidos {
    public boolean validar(Pedido pedido) {
        if (pedido.getProductos().isEmpty()) {
            IO.println("❌ Pedido vacío - rechazado");
            return false;
        }
        if (pedido.getCliente() == null) {
            IO.println("❌ No hay cliente - rechazado");
            return false;
        }
        IO.println("✅ Pedido validado correctamente");
        return true;
    }
}
```

### Especialista 2: El Calculador

```java
// ✅ SOLO se dedica a calcular precios
public class CalculadorPrecios {
    public double calcularTotal(Pedido pedido) {
        double total = 0;
        for (Producto producto : pedido.getProductos()) {
            total += producto.getPrecio();
        }

        // Descuento para estudiantes
        if (pedido.getCliente().esEstudiante()) {
            total *= 0.8; // 20% descuento
            IO.println("🎓 Descuento estudiante aplicado");
        }

        IO.println("💰 Total calculado: $" + total);
        return total;
    }
}
```

### Especialista 3: El Cocinero

```java
// ✅ SOLO se dedica a preparar comida
public class Cocinero {
    public void prepararPedido(Pedido pedido) {
        IO.println("👨‍🍳 Cocinero preparando:");
        for (Producto producto : pedido.getProductos()) {
            IO.println(" - Preparando: " + producto.getNombre());
        }
        IO.println("✅ Comida lista!");
    }
}
```

## PASO 3: Aplicando OCP - "Extiende sin Modificar"

### El Problema de los Pagos

Imagina que inicialmente solo tenemos efectivo y tarjeta. ¿Qué pasa si llega PayPal, Bitcoin, Transferencia?

**Solución OCP**: Crear una INTERFAZ (un "contrato") que todos los métodos de pago deben seguir:

```java
// 📜 EL CONTRATO: Todos los métodos de pago deben firmar esto
public interface MetodoPago {
    boolean procesarPago(double monto);

    String getNombre();
}
```

> **Beneficios**:
> - Puedes agregar nuevos métodos de pago sin tocar el código existente.
> - Cada método de pago es responsable de su propia lógica.
>
{style="note"}

### Implementaciones Concretas

```java
// 💵 Efectivo (implementa el contrato)
public class PagoEfectivo implements MetodoPago {
    @Override
    public boolean procesarPago(double monto) {
        IO.println("💵 Recibiendo $" + monto + " en efectivo");
        // Lógica específica para efectivo
        return true; // Pago exitoso
    }

    @Override
    public String getNombre() {
        return "EFECTIVO";
    }
}
```

```java
// 💳 Tarjeta (implementa el contrato)
public class PagoTarjeta implements MetodoPago {
    @Override
    public boolean procesarPago(double monto) {
        IO.println("💳 Procesando pago con tarjeta por $" + monto);
        // Lógica específica para tarjeta
        return true; // Pago exitoso
    }

    @Override
    public String getNombre() {
        return "TARJETA";
    }
}
```

Ahora, si queremos agregar PayPal, solo creamos una nueva clase:

```java
// 🅿️ PayPal (implementa el contrato)
public class PagoPayPal implements MetodoPago {
    @Override
    public boolean procesarPago(double monto) {
        IO.println("🅿️ Procesando pago con PayPal por $" + monto);
        // Lógica específica para PayPal
        return true; // Pago exitoso
    }

    @Override
    public String getNombre() {
        return "PAYPAL";
    }
}
```

Y si queremos agregar Bitcoin:

```java
// ₿ Bitcoin (implementa el contrato)
public class PagoBitcoin implements MetodoPago {
    @Override
    public boolean procesarPago(double monto) {
        IO.println("₿ Procesando pago con Bitcoin por $" + monto);
        // Lógica específica para Bitcoin
        return true; // Pago exitoso
    }

    @Override
    public String getNombre() {
        return "BITCOIN";
    }
}
```

## PASO 4: El Coordinador - "El Jefe de Turno"

```java
// 👔 El coordinador que delega (aplica SRP)
public class CoordinadorCafeteria {
    private ValidadorPedidos validador;
    private CalculadorPrecios calculador;
    private Cocinero cocinero;
    private List<MetodoPago> metodosPago;

    public CoordinadorCafeteria() {
        this.validador = new ValidadorPedidos();
        this.calculador = new CalculadorPrecios();
        this.cocinero = new Cocinero();

        // Inicializamos con los métodos de pago básicos
        this.metodosPago = new ArrayList<>();
        this.metodosPago.add(new PagoEfectivo());
        this.metodosPago.add(new PagoTarjeta());
    }

    // ✅ OCP: Podemos agregar nuevos métodos SIN modificar este método
    public void agregarMetodoPago(MetodoPago nuevoMetodo) {
        this.metodosPago.add(nuevoMetodo);
        IO.println("🆕 Nuevo método agregado: " + nuevoMetodo.getNombre());
    }

    public boolean procesarPedido(Pedido pedido) {
        IO.println("\n🎯 INICIANDO PROCESO DE PEDIDO");

        // 1. Validar (delega al validador)
        if (!validador.validar(pedido)) {
            return false;
        }

        // 2. Calcular (delega al calculador)
        double total = calculador.calcularTotal(pedido);

        // 3. Procesar pago (usa la interfaz - OCP en acción)
        MetodoPago metodo = encontrarMetodoPago(pedido.getMetodoPago());
        if (metodo == null) {
            IO.println("❌ Método de pago no soportado: " + pedido.getMetodoPago());
            return false;
        }

        if (!metodo.procesarPago(total)) {
            IO.println("❌ Pago fallido");
            return false;
        }

        // 4. Preparar (delega al cocinero)
        cocinero.prepararPedido(pedido);

        IO.println("✅ PEDIDO COMPLETADO EXITOSAMENTE!");
        return true;
    }

    private MetodoPago encontrarMetodoPago(String nombre) {
        return metodosPago.stream()
                .filter(m -> m.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}
```

## PASO 5: Probando Todo Junto

```java
public class DemoCafeteriaUniversitaria {
    void main() {
        // Configuramos nuestra cafetería
        CoordinadorCafeteria cafeteria = new CoordinadorCafeteria();

        // Creamos algunos clientes
        Cliente juan = new Cliente("Juan Pérez", "juan@universidad.edu", true); // es estudiante
        Cliente maria = new Cliente("Maria García", "maria@universidad.edu", false);

        // Creamos productos
        Producto cafe = new Producto("Café Latte", 3.50);
        Producto sandwich = new Producto("Sandwich Pavo", 5.00);
        Producto jugo = new Producto("Jugo Natural", 2.50);

        IO.println("🏁 INICIANDO DEMOSTRACIÓN CAFETERÍA UNIVERSITARIA");

        // Pedido 1: Juan (estudiante) paga con efectivo
        IO.println("\n=== PEDIDO 1: Juan (Estudiante) ===");
        Pedido pedido1 = new Pedido(juan, Arrays.asList(cafe, sandwich));
        pedido1.setMetodoPago("EFECTIVO");
        cafeteria.procesarPedido(pedido1);

        // Pedido 2: Maria paga con tarjeta  
        IO.println("\n=== PEDIDO 2: Maria ===");
        Pedido pedido2 = new Pedido(maria, Arrays.asList(jugo, sandwich));
        pedido2.setMetodoPago("TARJETA");
        cafeteria.procesarPedido(pedido2);

        // 🎉 ¡MAGIA OCP! Agregamos PayPal SIN MODIFICAR código existente
        IO.println("\n=== ACTUALIZACIÓN: Agregando PayPal ===");
        cafeteria.agregarMetodoPago(new PagoPayPal());

        // Pedido 3: Ahora podemos usar PayPal
        IO.println("\n=== PEDIDO 3: Con PayPal (NUEVO) ===");
        Pedido pedido3 = new Pedido(juan, Arrays.asList(cafe, cafe, jugo)); // Doble café
        pedido3.setMetodoPago("PAYPAL");
        cafeteria.procesarPedido(pedido3);

        // 🚀 ¡Más magia! Agregamos Cripto
        IO.println("\n=== ACTUALIZACIÓN: Agregando Cripto ===");
        cafeteria.agregarMetodoPago(new PagoCripto());

        IO.println("\n=== PEDIDO 4: Con Cripto (NUEVO) ===");
        Pedido pedido4 = new Pedido(maria, Arrays.asList(sandwich));
        pedido4.setMetodoPago("CRIPTO");
        cafeteria.procesarPedido(pedido4);

        IO.println("\n🎊 DEMOSTRACIÓN COMPLETADA!");
        IO.println("✅ SRP: Cada clase tiene UNA responsabilidad");
        IO.println("✅ OCP: Agregamos métodos sin modificar código existente");
    }
}
```

## RESUMEN FINAL - Lo que Aprendimos

✅ SRP (Single Responsibility Principle)

* Cada clase tiene UNA sola razón para cambiar
* Como en la cafetería: cajero solo cobra, cocinero solo cocina
* Beneficios: Más fácil de entender, mantener y testear

✅ OCP (Open/Closed Principle)

* Abierto para extensión, cerrado para modificación
* Como agregar PayPal: nuevo método sin cambiar código existente
* Beneficios: Sistema crece sin romper lo que ya funciona

📈 Resultado Final

* Código organizado como una cafetería bien administrada
* Fácil de extender con nuevas funcionalidades
* Menos errores porque cada parte hace solo una cosa
* Mejor para trabajar en equipo - cada quien puede especializarse