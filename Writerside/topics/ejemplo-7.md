# Ejemplo 7: La Agencia de Renta de Vehículos

## Descripción

Una pequeña empresa, RentQuick, alquila vehículos (cars, motorcycles, trucks). Necesitan un módulo que permita:

* Registrar vehículos y clientes.
* Crear alquileres validando datos del cliente y la disponibilidad del vehículo.
* Calcular el precio final según reglas específicas por tipo de vehículo (polimorfismo).
* Calcular costo de seguro por día (cada vehículo lo calcula de forma distinta).
* Manejar errores (cliente menor de edad, licencia vencida, matrícula inválida, vehículo no disponible, rangos de fecha
  inválidos).

Piensa en el sistema como la ventanilla de un local de renta: distintos vehículos comparten comportamiento básico (rent,
return, price calculation), pero cada tipo tiene su propia forma de calcular precio y requisitos.

> La herencia es como un menú base (Platillo base) y las subclases son variantes (con salsa picante, sin sal). El
> restaurante (aplicación) trata los platillos de forma genérica (polimorfismo) pero el cocinero aplica variaciones (
> sobrecarga).
> {style="note"}

## Diagrama de Clases

![e7_uml.png](e7_uml.png) {style="block"}

## Desarrollo

### Paso 1: Definir excepciones personalizadas

Cuando algo sale mal (edad inválida, vehículo ocupado, datos erróneos), queremos lanzar una excepción clara.
Creamos dos clases:

```java
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
```

```java
public class VehicleUnavailableException extends Exception {
    public VehicleUnavailableException(String message) {
        super(message);
    }
}
```

> En lugar de usar RuntimeException, usamos checked exceptions (heredan de Exception), obligando al programador a
> tratarlas con try...catch. Esto mejora la robustez del código.
> {style="note"}

### Paso 2: Crear la clase `Client`

Recuerda que de aquí en adelante haremos uso de nuestra clase `InputHandler` como librería para manejar entradas y
validaciones.

```java
import java.time.LocalDate;
import java.util.UUID;

public class Client {
    private final UUID id;
    private String name;
    private int age;
    private String licenseNumber;
    private LocalDate licenseExpiry;

    public Client() throws ValidationException {
        this.id = UUID.randomUUID();
        this.name = InputHandler.getInput("Ingresa el nombre del cliente:", "");
        // Validar que el nombre no esté vacío
        if (this.name.isEmpty()) {
            throw new ValidationException("El nombre no puede estar vacío.");
        }
        // Validar que el cliente sea mayor de edad
        this.age = InputHandler.getIntInput("Ingresa la edad del cliente (debe ser mayor de 18):", 0, 120);
        if (this.age < 18) {
            throw new ValidationException("El cliente debe ser mayor de edad.");
        }
        // Validar número de licencia
        this.licenseNumber = InputHandler.getInput("Ingresa el número de licencia del cliente:", "");
        if (this.licenseNumber.isEmpty()) {
            throw new ValidationException("El número de licencia no puede estar vacío.");
        }
        this.licenseExpiry = LocalDate.parse(InputHandler.getInput("Ingresa la fecha de expiración de la licencia (YYYY-MM-DD):", ""));
    }

    public boolean hasValidLicense(LocalDate date) {
        return licenseExpiry.isAfter(date);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

### Paso 3: Interfaces `Rentable` y `Insurable`

Definimos dos interfaces para los comportamientos comunes de los vehículos:

```java
public interface Rentable {
    Rental rentTo(Customer customer, LocalDate start, LocalDate end)
            throws ValidationException, VehicleUnavailableException;

    void returnVehicle();
}
```

```java
public interface Insurable {
    double getInsuranceCost(long days);
}
```

### Paso 4: Clase abstracta `Vehicle`

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.regex.Pattern;

public abstract class Vehicle implements Rentable, Insurable {
    protected final UUID id;
    protected final String licensePlate;
    protected final String brand;
    protected final String model;
    protected final int year;
    protected final double basePricePerDay;
    protected boolean available = true;

    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z0-9\\-]{6,8}$");

    public Vehicle(String licensePlate, String brand, String model, int year, double basePricePerDay)
            throws ValidationException {
        if (licensePlate == null || !PLATE_PATTERN.matcher(licensePlate).matches())
            throw new ValidationException("Invalid license plate format");
        if (year > LocalDate.now().getYear())
            throw new ValidationException("Invalid vehicle year");
        if (basePricePerDay <= 0)
            throw new ValidationException("Base price must be greater than 0");

        this.id = UUID.randomUUID();
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePricePerDay = basePricePerDay;
    }

    @Override
    public synchronized Rental rentTo(Customer customer, LocalDate start, LocalDate end)
            throws ValidationException, VehicleUnavailableException {
        if (!available) throw new VehicleUnavailableException("Vehicle not available");
        if (start == null || end == null || !start.isBefore(end))
            throw new ValidationException("Invalid rental dates");
        if (!customer.hasValidLicense(start))
            throw new ValidationException("License expired before rental date");

        long days = ChronoUnit.DAYS.between(start, end) + 1;
        double total = calculateRentalPrice(days, customer);

        available = false;
        return new Rental(this, customer, start, end, total);
    }

    @Override
    public synchronized void returnVehicle() {
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public abstract double calculateRentalPrice(long days, Customer customer) throws ValidationException;
}
```

### Paso 5: Clases concretas de vehículos

```java
// File: Car.java
public class Car extends Vehicle {
    private final boolean isLuxury;

    public Car(String licensePlate, String brand, String model, int year,
               double basePricePerDay, boolean isLuxury) throws ValidationException {
        super(licensePlate, brand, model, year, basePricePerDay);
        this.isLuxury = isLuxury;
    }

    @Override
    public double calculateRentalPrice(long days, Customer customer) throws ValidationException {
        if (customer.getAge() < 21)
            throw new ValidationException("Customer must be at least 21 for cars");

        double price = basePricePerDay * days;
        if (isLuxury) price += 50 * days;  // surcharge for luxury
        if (customer.getAge() < 25) price += 20 * days;  // young driver fee
        price += getInsuranceCost(days);

        return price;
    }

    @Override
    public double getInsuranceCost(long days) {
        return 15 * days;
    }
}
```

```java
// File: Motorcycle.java
public class Motorcycle extends Vehicle {
    private final int engineCc;

    public Motorcycle(String licensePlate, String brand, String model, int year,
                      double basePricePerDay, int engineCc) throws ValidationException {
        super(licensePlate, brand, model, year, basePricePerDay);
        this.engineCc = engineCc;
    }

    @Override
    public double calculateRentalPrice(long days, Customer customer) throws ValidationException {
        if (customer.getAge() < 18)
            throw new ValidationException("Customer too young for motorcycles");
        double price = basePricePerDay * days;
        price += getInsuranceCost(days);
        return price;
    }

    @Override
    public double getInsuranceCost(long days) {
        return 8 * days;
    }
}
```

```java
// File: Truck.java
public class Truck extends Vehicle {
    private final double maxLoadKg;

    public Truck(String licensePlate, String brand, String model, int year,
                 double basePricePerDay, double maxLoadKg) throws ValidationException {
        super(licensePlate, brand, model, year, basePricePerDay);
        this.maxLoadKg = maxLoadKg;
    }

    @Override
    public double calculateRentalPrice(long days, Customer customer) throws ValidationException {
        if (customer.getAge() < 25)
            throw new ValidationException("Customer must be at least 25 for trucks");
        double price = basePricePerDay * days;
        price += (maxLoadKg / 1000.0) * 10.0 * days; // surcharge per ton
        price += getInsuranceCost(days);
        return price;
    }

    @Override
    public double getInsuranceCost(long days) {
        return 30 * days;
    }
}
```

> Cada subclase personaliza el cálculo del precio total.
> Esto es polimorfismo dinámico: el programa llama a calculateRentalPrice() sin saber qué tipo de vehículo es, pero se
> ejecuta el comportamiento adecuado.
> {style="note"}

### Paso 6: Clase `Rental`

```java
// File: Rental.java

import java.time.LocalDate;
import java.util.UUID;

public class Rental {
    private final UUID id;
    private final Vehicle vehicle;
    private final Customer customer;
    private final LocalDate start;
    private final LocalDate end;
    private final double totalPrice;

    public Rental(Vehicle vehicle, Customer customer, LocalDate start, LocalDate end, double totalPrice) {
        this.id = UUID.randomUUID();
        this.vehicle = vehicle;
        this.customer = customer;
        this.start = start;
        this.end = end;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return String.format("Rental[id=%s, vehicle=%s, customer=%s, from=%s to=%s, total=%.2f]",
                id, vehicle.licensePlate, customer.getName(), start, end, totalPrice);
    }
}
```

## Desafío Extra

1. Implementa una clase `RentalService` que maneje la lista de vehículos y clientes, y permita buscar vehículos
   disponibles.
2. Añade un menú interactivo usando `JOptionPane` para registrar clientes, vehículos y crear alquileres.
3. Implementa persistencia básica (guardar y cargar datos) usando archivos de texto o serialización.
4. Añade más tipos de vehículos (bicicletas, scooters) con sus propias reglas de alquiler.
5. Implementa descuentos por alquileres largos o clientes frecuentes.
6. Añade validaciones adicionales (por ejemplo, evitar que un cliente tenga más de 3 alquileres activos).
7. Crea reportes de ingresos mensuales y vehículos más alquilados.