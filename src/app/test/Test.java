package app.test;

import app.nomina.comparators.EmployeeAgeComparator;
import app.nomina.comparators.EmployeeComparators;
import app.nomina.comparators.EmployeePositionComparator;
import app.nomina.comparators.EmployeeSalaryComparator;
import app.nomina.entities.Department;
import app.nomina.entities.Employee;
import app.nomina.entities.Position;
import org.util.InputHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

    void main() {
        // Crear una lista de empleados
        ArrayList<Employee> employees = new ArrayList<>();
        // Agregamos empleados antiguos a la lista
        employees.add(new Employee("Ana", 30, 3000,
                Position.MANAGER, Department.FINANCE));
        employees.add(new Employee("Luis", 25, 2500,
                Position.CASHIER, Department.SALES));
        employees.add(new Employee("Marta", 28, 2800,
                Position.SECRETARY, Department.HR));
        employees.add(new Employee("Carlos", 35, 3500,
                Position.DIRECTOR, Department.IT));
        employees.add(new Employee("Sofia", 32, 3200,
                Position.MANAGER, Department.MARKETING));
        // Mostramos la lista original
        IO.println("Lista original de empleados:");
        employees.forEach(IO::println);
        // Ordenamos y mostramos la lista de forma natural (por nombre)
        employees.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(IO::println);
        // Ordenamos y mostramos la lista por edad
        IO.println("Empleados ordenados por edad:");
        employees.stream()
                .sorted(EmployeeComparators.BY_AGE.reversed())
                .forEach(IO::println);
    }
}