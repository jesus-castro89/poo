package app.test;

import app.nomina.comparators.EmployeeAgeComparator;
import app.nomina.comparators.EmployeePositionComparator;
import app.nomina.comparators.EmployeeSalaryComparator;
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
        // Agregar empleados a la lista
        employees.add(new Employee("Juan", 30, 5000, Position.CASHIER));
        employees.add(new Employee("Ana", 25, 6000, Position.MANAGER));
        employees.add(new Employee("Luis", 35, 5500, Position.DIRECTOR));
        employees.add(new Employee("Maria", 28, 4200, Position.SECRETARY));
        employees.add(new Employee("Pedro", 22, 3500, Position.CASHIER));
        IO.println("Lista de empleados ordenados por edad:");
        employees.stream()
                .sorted(new EmployeeAgeComparator())
                .forEach(IO::println);
        //
        employees.get(2).giveVacation();// Dar vacaciones al tercer empleado
        employees.get(3).giveVacation();// Dar vacaciones al cuarto empleado
        IO.println("Lista de empleados original:");
        employees.forEach(IO::println);
        employees.add(new Employee("Miguel", 30, 5000, Position.MANAGER));
        employees.add(new Employee("José", 25, 3255, Position.SECRETARY));
        IO.println("Lista de empleados ordenados por puesto:");
        employees.stream()
                .filter(Employee::isActive)
                .sorted(new EmployeePositionComparator())
                .forEach(IO::println);
        IO.println("Lista de empleados de vacaciones ordenados por nombre:");
        employees.stream()
                .filter(e -> !e.isActive())
                .sorted(Comparator.naturalOrder())
                .reduce((e1, e2) -> {
                    return new Employee("Total", 0,
                            e1.getSalary() + e2.getSalary(), Position.SECRETARY);
                }).ifPresent(total ->
                        IO.println(("Suma de sueldos de " +
                                "empleados de vacaciones: %.2f")
                                .formatted(total.getSalary())));
    }
}