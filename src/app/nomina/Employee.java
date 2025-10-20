package app.nomina;

import javax.swing.*;
import java.util.Comparator;

public class Employee{
    private String name;
    private int age;
    private double salary;

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

    public void discountSalary(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");
        }
        this.salary -= this.salary * (percentage / 100);
    }

    public static int compareBySalary(Employee e1, Employee e2) {
        return Comparator.comparingDouble(Employee::getSalary)
                .compare(e1, e2);
    }

    public static int compareBySalaryReverse(Employee e1, Employee e2) {
        return Comparator.comparingDouble(Employee::getSalary)
                .reversed()
                .compare(e2, e1);
    }

    @Override
    public String toString() {
        return "%s, %d años, Salario: %.2f".formatted(name, age, salary);
    }
}
