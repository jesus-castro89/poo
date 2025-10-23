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
        Arrays.stream(Position.values())
                .sorted(PositionComparator.BY_RETENTION)
                .forEach(IO::println);
        IO.println("+-----------------------+");
        Arrays.stream(Department.values())
                .sorted(DepartmentComparator.BY_BONUS)
                .forEach(IO::println);
        IO.println("+-----------------------+");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ana", Department.RRHH,
                Position.GERENTE, 3500, 30));
        employees.add(new Employee("Luis", Department.MARKETING,
                Position.ANALISTA, 2200, 25));
        employees.add(new Employee("María", Department.VENTAS,
                Position.DESARROLLADOR, 5000, 40));

        employees.stream().sorted(EmployeeComparators.BY_DEPARTMENT).forEach(IO::println);
    }
}
