# Single Responsibility Principle (SRP)

## ¿Qué es el Single Responsibility Principle?

El Principio de Responsabilidad Única (SRP) establece que una clase debe tener una única razón para cambiar, es decir,
debe estar enfocada en una sola tarea o responsabilidad dentro del sistema.

Este principio es el primero de los cinco principios SOLID (que son guías fundamentales para escribir código mantenible
y escalable en programación orientada a objetos).

### Metáfora para entenderlo:

Imagina que tienes un cuchillo suizo lleno de herramientas (navaja, tijeras, destapador, etc.). Si se rompe una de las
funciones, como las tijeras, tendrías que reparar todo el cuchillo, afectando incluso las herramientas que sí
funcionaban.
En cambio, si cada herramienta fuera independiente, solo tendrías que reparar la que falla.
¡Eso busca SRP en el código!

## Entendiendo el SRP

El SRP sugiere que cada clase debe tener una única responsabilidad, lo que significa que debe estar enfocada en una sola
tarea o función. Esto ayuda a mantener el código organizado y facilita su comprensión y mantenimiento.
Cuando una clase tiene múltiples responsabilidades, se vuelve más difícil de entender y mantener, ya que cualquier
cambio
puede afectar a otras partes del código. Además, si una clase tiene múltiples responsabilidades, es más probable que
se introduzcan errores al realizar cambios o agregar nuevas funcionalidades.

## Ejemplo de SRP

Supongamos que estamos desarrollando un pequeño sistema en Java para una empresa, donde manejamos información de los
empleados, generamos reportes y los guardamos en archivos.

### Lo primero que haríamos

Con lo que sabemos hasta el momento, es probable que pienses en la siguiente clase:

```java
public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + salary;
    }

    public void saveToFile() {
        // Código para guardar los detalles en un archivo
    }

    public void generateReport() {
        // Código para generar un reporte de empleado
    }
}
```

Sin embargo, esta clase tiene múltiples responsabilidades:

1. **Almacenar información del empleado**: La clase `Employee` almacena los detalles del empleado.
2. **Generar reportes**: La clase `Employee` tiene un método para generar reportes.
3. **Guardar en archivo**: La clase `Employee` tiene un método para guardar los detalles en un archivo.
4. **Imprimir detalles**: La clase `Employee` tiene un método para imprimir los detalles del empleado.

Cada una de estas responsabilidades puede cambiar por razones diferentes. Por ejemplo, si decidimos cambiar la forma en
que guardamos los detalles del empleado, tendríamos que modificar la clase `Employee`, lo que podría afectar otras
funcionalidades.

### Aplicando el SRP

Para aplicar el SRP, debemos identificar las responsabilidades y separarlas en diferentes clases. Por lo que las
responsabilidades deberían ser:

1. **Almacenar información del empleado**: La clase `Employee` se encargará solo de almacenar la información del
   empleado.
2. **Generar reportes**: Crearemos una clase `EmployeeReportGenerator` que se encargará de generar reportes.
3. **Guardar en archivo**: Crearemos una clase `EmployeeFileSaver` que se encargará de guardar los detalles en un
   archivo.

### Código refactorizado

Empezamos por la clase `Employee`:

```java
public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + salary;
    }
}
```

Como podemos ver, ahora la clase `Employee` solo se encarga de almacenar la información del empleado.

Ahora creamos la clase `EmployeeReportGenerator`:

```java
// Clase 3: Servicio para generar reportes
public class EmployeeReportGenerator {
    public void generateReport(Employee employee) {
        System.out.println("=== Employee Report ===");
        System.out.println(employee.getDetails());
        System.out.println("========================");
    }
}
```

En esta clase, el método `generateReport` se encarga de generar un reporte para un empleado específico.

Ahora creamos la clase `EmployeeFileSaver`:

```java
// Clase 2: Servicio para guardar archivos

import java.io.FileWriter;
import java.io.IOException;

public class EmployeeFileSaver {
    public void saveEmployeeToFile(Employee employee, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(employee.getDetails());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

En esta clase, el método `saveEmployeeToFile` se encarga de guardar la información del empleado en un archivo.

## Justificación de cada acción

| Acción                                    | Justificación                                                                                                            |
|-------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| Separar la gestión de datos en `Employee` | La entidad de negocio debe ser pura y enfocada. Solo almacena y expone información del empleado.                         |
| Crear `EmployeeReportGenerator`           | Se encarga de generar reportes, lo que permite cambiar la forma de generar reportes sin afectar a la entidad.            |
| Crear `EmployeeFileSaver`                 | Se encarga de guardar la información en un archivo, lo que permite cambiar la forma de guardar sin afectar a la entidad. |

## Conclusión

El SRP nos ayuda a construir software más limpio, mantenible y escalable.
En proyectos reales, donde el código crece y cambia constantemente, seguir el SRP hace que cada clase sea fácil de
entender, de probar y de modificar.

### Mi recomendación práctica

Aunque al principio parece "crear muchas clases", piensa en ello como construir piezas de **Lego**. Es más fácil
modificar una pieza que reconstruir todo el castillo si se rompe algo.

Además, si alguna de las clases crece demasiado, ¡es una señal de que también deberías aplicar SRP dentro de ella!

