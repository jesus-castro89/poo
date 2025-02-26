# Ejemplo 3: Gestión de Empleados

## Descripción

Se requiere un sistema que permita administrar empleados en una empresa. Cada empleado tiene un nombre, un ID único, un
salario base y un tipo de puesto (Junior, Mid, Senior). Dependiendo del puesto, el empleado recibe una bonificación
distinta:

* Junior: 0% del salario base.
* Mid: 10% del salario base.
* Senior: 15% del salario base.
* Manager: 20% del salario base.

## Requisitos

* Usar un arreglo estático para almacenar empleados. El tamaño del arreglo debe ser definido por el programador.
* Implementar sobrecarga de métodos para calcular el salario en función de si el empleado obtiene o no bonificación.
* Incluir variables de tipo `final` para valores constantes.
* Usar variables static para llevar el conteo de empleados.
* Definir un tipo enumerado JobType con atributos y funciones para calcular el bono según el puesto.
* Agregar un menú de interacción con los siguientes elementos:
    * Agregar empleado.
    * Mostrar empleados.
    * Calcular salario de empleado con bonificación.
    * Calcular salario de empleado sin bonificación.
    * Salir.

## Implementación

Al analizar el problema, se puede dividir en las siguientes clases y tipos enumerados:

* `Employee`: Clase que representa a un empleado con los atributos mencionados.
* `JobType`: Enumerado que define los tipos de puestos y sus bonificaciones.
* `MenuOption`: Enumerado que define las opciones del menú de interacción.
* `Company`: Clase que contiene el arreglo de empleados y las funciones para interactuar con ellos.
* `Main`: Clase principal que contiene el menú de interacción.

### JobType.java

```java
package empleados;

/**
 * Enumerado con los tipos de empleados.
 */
public enum JobType {

    JUNIOR(.0),
    MID(.1),
    SENIOR(.15),
    MANAGER(.2);

    /**
     * Porcentaje de bonificación.
     */
    final double bonus;

    /**
     * Constructor.
     *
     * @param bonus Porcentaje de bonificación.
     */
    JobType(double bonus) {

        this.bonus = bonus;
    }

    /**
     * Devuelve el nombre del tipo de empleado.
     *
     * @return Nombre del tipo de empleado.
     */
    @Override
    public String toString() {

        String name = name();
        double bonus = this.bonus * 100;
        return String.format("%s (%.0f%%)", name, bonus);
    }

    /**
     * Devuelve el porcentaje de bonificación.
     *
     * @return Porcentaje de bonificación.
     */
    public double getBonus() {

        return bonus;
    }
}
```

Como podemos notar, el enumerado `JobType` define los tipos de empleados con sus respectivas bonificaciones. Se incluye
un constructor para inicializar el porcentaje de bonificación y métodos para obtener el nombre del tipo de empleado y
el porcentaje de bonificación.

### MenuOption.java

```java
package empleados;

/**
 * Enumerado con las opciones del menú.
 */
public enum MenuOption {

    ADD_EMPLOYEE("Agregar empleado"),
    SHOW_EMPLOYEES("Mostrar empleados"),
    SHOW_EMPLOYEE("Mostrar empleado sin bonificaciones"),
    SHOW_EMPLOYEE_WITH_BONUS("Mostrar empleado con bonificaciones"),
    EXIT("Salir");

    /**
     * Nombre de la opción.
     */
    final String name;

    /**
     * Constructor.
     *
     * @param name Nombre de la opción.
     */
    MenuOption(String name) {
        this.name = name;
    }

    /**
     * Devuelve el nombre de la opción. Con el formato "n. Nombre".
     * Donde "n" es el ordinal + 1 de la opción.
     *
     * @return Nombre de la opción.
     */
    @Override
    public String toString() {

        return String.format("%d. %s", ordinal() + 1, name);
    }
}
```

El enumerado `MenuOption` define las opciones del menú de interacción con el programa. Se incluye un constructor para
inicializar el nombre de la opción y un método para obtener el nombre de la opción con el formato "n. Nombre". Donde "n"
es el ordinal + 1 de la opción.

### BadIdException.java

Al analizar los datos de entrada, se puede notar que el ID de un empleado debe ser único. Por lo tanto, se puede definir
una excepción personalizada para manejar este caso.

```java
package empleados;

/**
 * Excepción lanzada cuando existe algún problema con el ID de un empleado.
 */
public class BadIdException extends Exception {

    /**
     * Constructor.
     *
     * @param message Mensaje de error.
     */
    public BadIdException(String message) {
        super(message);
    } 
}
```

La excepción `BadIdException` se lanza cuando existe algún problema con el ID de un empleado. Se incluye un constructor
para inicializar el mensaje de error.

### Employee.java

```java
package empleados;

import javax.swing.*;

/**
 * Clase que representa a un empleado.
 */
public class Employee {

    private final String name;
    private final int id;
    private JobType jobType;
    private double salary;

    /**
     * Constructor.
     *
     * @throws BadIdException Si el ID no es un número entero.
     */
    public Employee() throws BadIdException {

        this.name = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        try {
            this.id = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el ID del empleado"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El ID debe ser un número entero");
            throw new BadIdException("El ID debe ser un número entero");
        }
        setJobType();
        setSalary();
    }

    /**
     * Devuelve el nombre y el ID del empleado.
     *
     * @return Nombre y ID del empleado.
     */
    @Override
    public String toString() {

        return "Nombre: %s, ID: %d".formatted(name, id);
    }

    /**
     * Devuelve la información del empleado.
     *
     * @return Información del empleado.
     */
    public String getEmployeeInfo() {

        return """
                Nombre: %s
                ID: %d
                Tipo de empleado: %s
                Salario: %.2f
                -------------------------
                """.formatted(name, id, jobType, salary);
    }

    /**
     * Establece el tipo de empleado.
     */
    private void setJobType() {

        try {

            this.jobType = (JobType) JOptionPane.showInputDialog(null,
                    "Seleccione el tipo de empleado", "Tipos de empleados",
                    JOptionPane.QUESTION_MESSAGE, null, JobType.values(),
                    JobType.JUNIOR);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de empleado");
            setJobType();
        }
    }

    /**
     * Establece el salario del empleado.
     */
    private void setSalary() {

        try {
            this.salary = Double.parseDouble(JOptionPane.showInputDialog(
                    "Ingrese el salario del empleado"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El salario debe ser un número decimal");
            setSalary();
        }
    }

    /**
     * Devuelve el salario con bonificación.
     *
     * @return Salario con bonificación.
     */
    public double getSalaryWithBonus() {

        return salary * (1 + jobType.getBonus());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```

La clase `Employee` representa a un empleado con los atributos mencionados. Se incluye un constructor que solícita los
datos del empleado al usuario, métodos para obtener la información del empleado, establecer el tipo de empleado y el
salario, y calcular el salario con bonificación.

Se puede notar que en el caso de que el usuario no ingrese un valor válido para el ID, se lanza una excepción
personalizada. Además de manejar las excepciones en los casos en los que el usuario no ingrese un valor válido para el
tipo de empleado y el salario.

### Company.java

```java
package empleados;

import javax.swing.*;

public class Company {

    private final Employee[] employees;
    private static final int MAX_EMPLOYEES = 5;

    public Company() {

        this.employees = new Employee[MAX_EMPLOYEES];
    }

    public void showMenu() {

        try {
            MenuOption option = (MenuOption) JOptionPane.showInputDialog(null,
                    "Seleccione una opción", "Menú",
                    JOptionPane.QUESTION_MESSAGE, null, MenuOption.values(),
                    MenuOption.ADD_EMPLOYEE);
            switch (option) {
                case ADD_EMPLOYEE -> addEmployee();
                case SHOW_EMPLOYEES -> showEmployees();
                case SHOW_EMPLOYEE -> getEmployeeSalary();
                case SHOW_EMPLOYEE_WITH_BONUS -> getEmployeeSalary(true);
                case EXIT -> System.exit(0);
                default -> {
                    JOptionPane.showMessageDialog(null,
                            "Opción no válida");
                    showMenu();
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Opción Invalida");
            showMenu();
        }
    }

    private void addEmployee() {

        boolean employeesFull = true;
        // Recorre el arreglo de empleados para agregar un empleado.
        for (int i = 0; i < employees.length; i++) {
            // Si encuentra un espacio vacío, agrega un empleado.
            if (employees[i] == null) {
                // Trtará de agregar un empleado, si el ID no es válido, se vuelve a llamar a la función.
                try {
                    employees[i] = new Employee();
                    employeesFull = false;
                    break;
                } catch (BadIdException e) {
                    addEmployee();
                }
            }
        }
        // Si el arreglo de empleados está lleno, muestra un mensaje al usuario.
        if (employeesFull)
            JOptionPane.showMessageDialog(null,
                    "No se pueden agregar más empleados");
        showMenu();
    }

    private void showEmployees() {

        StringBuilder employeesList = new StringBuilder();
        // Recorre el arreglo de empleados para mostrar la información de los empleados.
        // Y lo hacemos con el foreach
        for (Employee employee : employees) {
            // Si el empleado no es nulo, agrega la información del empleado a la lista.
            if (employee != null) {

                employeesList.append(employee.getEmployeeInfo()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, employeesList.toString());
        showMenu();
    }

    private Employee selectEmployee() {

        // Se tratará de seleccionar un empleado, si no se selecciona un empleado, se vuelve a llamar a la función.
        try {
            // Se nos muestra un cuadro de dialogo con los empleados de los cuales seleccionaremos uno
            return (Employee) JOptionPane.showInputDialog(null,
                    "Seleccione un empleado", "Empleados",
                    JOptionPane.QUESTION_MESSAGE, null, employees,
                    employees[0]);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar un empleado valido");
            return selectEmployee();
        }
    }

    private void getEmployeeSalary() {

        // Selecciona un empleado con la función selectEmployee.
        Employee employee = selectEmployee();
        // Muestra el salario del empleado seleccionado.
        JOptionPane.showMessageDialog(null,
                "El salario del empleado es: " + employee.getSalary());
        showMenu();
    }

    // Esta función hace lo mismo que la anterior y solo sirve como muestra de sobrecarga de métodos
    // Ya que esta función recibe un parámetro booleano y llama a la función getSalaryWithBonus
    private void getEmployeeSalary(boolean withBonus) {

        Employee employee = selectEmployee();
        JOptionPane.showMessageDialog(null,
                "El salario del empleado con bono es: " + employee.getSalaryWithBonus());
        showMenu();
    }
}
```

> El arreglo de empleados es final, ya que no se reasigna a otro arreglo, pero los elementos del arreglo pueden cambiar.
> Por lo tanto, se puede considerar que el arreglo es inmutable.

> La variable `MAX_EMPLOYEES` es static, ya que es compartida por todas las instancias de la clase `Company` y se
> utiliza para definir el tamaño del arreglo de empleados.

La clase `Company` contiene el arreglo de empleados y las funciones para interactuar con ellos. Se incluye un método
para mostrar el menú de interacción con el programa, agregar empleados, mostrar empleados, seleccionar un empleado y
calcular el salario de un empleado con o sin bonificación.

Podemos notar que en el caso de que el usuario no seleccione una opción válida, se lanza una excepción. Además, en el
caso de que el arreglo de empleados esté lleno, se muestra un mensaje al usuario.

### Main.java

```java
package empleados;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.BOLD, 24));
        UIManager.put("OptionPane.buttonFont",
                new Font("Arial", Font.BOLD, 24));
        UIManager.put("TextField.font",
                new Font("Arial", Font.PLAIN, 24));
        UIManager.put("ComboBox.font",
                new Font("Arial", Font.BOLD, 24));
        new Company().showMenu();
    }
}
```

## Conclusión

En este ejemplo, se ha implementado un sistema de gestión de empleados en una empresa. Se ha utilizado un arreglo
estático para almacenar empleados, sobrecarga de métodos para calcular el salario con o sin bonificación, variables de
tipo `final` para valores constantes, variables `static` para llevar el conteo de empleados, y un tipo enumerado para
definir los tipos de puestos y sus bonificaciones.