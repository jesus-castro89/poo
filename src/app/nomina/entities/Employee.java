package app.nomina.entities;

import javax.swing.*;

public class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private double salary;
    private boolean isVacationing;
    private Position position;

    public Employee(String name, int age, double salary, Position position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
        this.isVacationing = false;
    }

    /**
     * Función que convierte el objeto a cadena de texto.
     * Con el formato: Empleado: id - name
     *
     * @return Cadena de texto con el formato indicado.
     */
    @Override
    public String toString() {

        return "Empleado: %s - Edad: %d - Sueldo: %.2f - Puesto: %s".formatted(name, age, salary, position);
    }

    /**
     * Función que compara dos empleados por su nombre.
     * De forma natural, se ordenarán por su nombre alfabéticamente.
     *
     * @param o Empleado a comparar.
     * @return 0 si son iguales, -1 si this es menor, 1 si this es mayor.
     */
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    public boolean isActive() {
        return !isVacationing;
    }

    public void giveVacation() {
        this.isVacationing = true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Position getPosition() {
        return position;
    }
}
