package com.empresa.nomina;

import com.empresa.nomina.model.Department;
import com.empresa.nomina.model.Employee;
import com.empresa.nomina.model.Position;
import com.empresa.nomina.util.DepartmentComparator;
import com.empresa.nomina.util.EmployeeComparators;
import com.empresa.nomina.util.PositionComparator;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    void main() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ana", Department.RRHH,
                Position.GERENTE, 3500, 30));
        employees.add(new Employee("Luis", Department.MARKETING,
                Position.ANALISTA, 2200, 25));
        employees.add(new Employee("María", Department.VENTAS,
                Position.DESARROLLADOR, 5000, 40));
        employees.add(new Employee("Carlos", Department.DESARROLLO,
                Position.ASISTENTE, 1800, 22));
        employees.add(new Employee("Lucía", Department.RRHH,
                Position.DESARROLLADOR, 4000, 28));
        employees.add(new Employee("Jorge", Department.VENTAS,
                Position.GERENTE, 6000, 45));
        employees.add(new Employee("Sofía", Department.MARKETING,
                Position.ANALISTA, 2500, 32));
        employees.add(new Employee("Miguel", Department.DESARROLLO,
                Position.ASISTENTE, 1900, 24));
        employees.add(new Employee("Luis", Department.RRHH,
                Position.ASISTENTE, 1750, 21));
        IO.println("Listado de Empleados:");
        employees.forEach(IO::println);
        IO.println("+----------------------------+");
        // Filtrando empleados por nombre "Luis"
        IO.println("Empleados con nombre 'Luis':");
        Object[] filtered = employees.stream()
                .filter(e -> e.getName().equals("Luis"))
                .toArray();
        Arrays.stream(filtered).forEach(IO::println);
        IO.println("+----------------------------+");
        // Seleccionando el primer empleado del departamento de VENTAS
        IO.println("Primer empleado del departamento de VENTAS:");
        Employee selected = (Employee) filtered[0];
        // Eliminando el empleado seleccionado
        employees.remove(selected);
        // Mostrando la lista actualizada de empleados
        IO.println("Listado de Empleados actualizado:");
        employees.forEach(IO::println);
        // Ordenando empleados de forma natural (por nombre)
        IO.println("Empleados ordenados por nombre:");
        IO.println("+----------------------------+");
        employees.stream()
                .sorted()
                .forEach(IO::println);
        // Ordenando empleados por salario
        IO.println("Empleados ordenados por salario:");
        IO.println("+----------------------------+");
        employees.stream()
                .sorted(EmployeeComparators.BY_SALARY)
                .forEach(IO::println);
        // Ordenando empleados por edad
        IO.println("Empleados ordenados por edad:");
        IO.println("+----------------------------+");
        employees.stream()
                .sorted(EmployeeComparators.BY_AGE)
                .forEach(IO::println);
        // Ordenando empleados por departamento
        IO.println("Empleados ordenados por departamento:");
        IO.println("+----------------------------+");
        employees.stream()
                .sorted(EmployeeComparators.BY_DEPARTMENT)
                .forEach(IO::println);
        // Mostrando la lista original de empleados
        IO.println("Listado original de Empleados:");
        IO.println("+----------------------------+");
        employees.forEach(IO::println);
        // SUmando todos los salarios mensuales
        double totalSalaries = employees.stream()
                .mapToDouble(Employee::calculateMonthlySalary)
                .sum();
        // Promedio de salarios mensuales
        double averageSalary = employees.stream()
                .mapToDouble(Employee::calculateMonthlySalary)
                .average()
                .orElse(0);
        // Mostrando el salario menor y mayor
        double minSalary = employees.stream()
                .mapToDouble(Employee::calculateMonthlySalary)
                .min()
                .orElse(0);
        double maxSalary = employees.stream()
                .mapToDouble(Employee::calculateMonthlySalary)
                .max()
                .orElse(0);
        // Empleados del departamento de DESARROLLO
        IO.println("Empleados del departamento de DESARROLLO:");
        IO.println("+----------------------------+");
        employees.stream()
                .filter(e -> e.getDepartment() == Department.DESARROLLO)
                .forEach(IO::println);
        // Filtrar empleados por posición de GERENTE
        IO.println("Empleados con posición de GERENTE:");
        IO.println("+----------------------------+");
        employees.stream()
                .filter(e -> e.getPosition() == Position.GERENTE)
                .forEach(IO::println);
        // Filtrar empleados en un rango de salarios de 2000 a 4000
        IO.println("Empleados con salarios entre 2000 y 4000:");
        IO.println("+----------------------------+");
        employees.stream()
                .filter(e -> {
                    double salary = e.calculateMonthlySalary();
                    return salary >= 2000 && salary <= 4000;
                })
                .forEach(IO::println);
    }
}
