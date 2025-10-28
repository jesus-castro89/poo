package com.empresa.nomina.model;

import java.util.function.Predicate;

/**
 * Clase que representa a un empleado en la empresa.
 * Cuyos atributos incluyen nombre, departamento, posición,
 * salario base y edad.
 * Además de permitir calcular el salario mensual
 * y comparar empleados por nombre de forma natural.
 */
public class Employee implements Comparable<Employee> {
    /**
     * Nombre del empleado.
     */
    private String name;
    private Department department;
    private Position position;
    private double baseSalary;
    private int age;

    /**
     * Constructor de la clase Employee.
     * {@snippet lang=java :
     * Employee emp = new Employee("Juan Pérez", Department.DESARROLLO,
     *                              Position.DESARROLLADOR, 3000.0, 30);
     * }
     *
     * @param name Nombre del empleado.
     * @param department Departamento del empleado.
     * @param position Posición del empleado.
     * @param baseSalary Salario base del empleado.
     * @param age Edad del empleado.
     */
    public Employee(String name, Department department,
                    Position position, double baseSalary, int age) {
        this.name = name;
        this.department = department;
        this.position = position;
        this.baseSalary = baseSalary;
        this.age = age;
    }

    /**
     * Representación en cadena del empleado.
     *
     * @return Cadena con el nombre, departamento y posición del empleado.
     */
    @Override
    public String toString() {
        return "%s - %s, %s".formatted(name, department.getDescription(),
                position.getDescription());
    }

    /**
     * Función para calcular el salario mensual del empleado.
     * Siguiendo la siguiente fórmula:
     * Salario Mensual = ((Salario Base + Bonificación por Departamento)
     * + Bonificación por Posición) - Retención por Posición
     *
     * @return Salario mensual del empleado.
     */
    public double calculateMonthlySalary() {
        return baseSalary;
    }

    /**
     * Establece el departamento del empleado empleando un predicado
     * para verificar si el nuevo departamento es diferente al actual.
     *
     * @param department Departamento a asignar al empleado.
     */
    public void setDepartment(Department department) {

        Predicate<Department> isDifferentDepartment =
                d -> this.department != d;
        if (isDifferentDepartment.test(department)) {
            this.department = department;
        }
    }

    /**
     * Establece la posición del empleado empleando un predicado
     * para verificar si la nueva posición es diferente a la actual.
     *
     * @param position Posición a asignar al empleado.
     */
    public void setPosition(Position position) {

        Predicate<Position> isDifferentPosition =
                p -> this.position != p;
        if (isDifferentPosition.test(position)) {
            this.position = position;
        }
    }

    /**
     * Compara dos empleados por su nombre.
     *
     * @param other Empleado a comparar.
     * @return Resultado de la comparación, similar a String.compareTo().
     */
    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public Position getPosition() {
        return position;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
