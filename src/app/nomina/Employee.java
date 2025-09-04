package app.nomina;

import javax.swing.*;

public class Employee {
    private String name;
    private int age;
    private double salary;

    static {
        JOptionPane.showMessageDialog(null,
                "¡Bienvenido al sistema de nómina!");
    }

    public Employee() {
        this.name = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        this.age = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingrese la edad del empleado:"));
        this.salary = Double.parseDouble(JOptionPane.showInputDialog(
                "Ingrese el salario del empleado:"));
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void updateDetails() {
        String newName = JOptionPane.showInputDialog(
                "Ingrese el nuevo nombre del empleado:", name);
        int newAge = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingrese la nueva edad del empleado:", age));
        double newSalary = Double.parseDouble(JOptionPane.showInputDialog(
                "Ingrese el nuevo salario del empleado:", salary));
        this.name = newName;
        this.age = newAge;
        this.salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "%s, %d años, Salario: %.2f".formatted(name, age, salary);
    }
}
