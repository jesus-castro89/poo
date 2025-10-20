package app.test;

import app.nomina.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    void main() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pedro", 25, 5000));
        employees.add(new Employee("Maria", 25, 12000));
        employees.add(new Employee("Ana", 28, 4500));
        employees.add(new Employee("Luis", 35, 5500));
        employees.add(new Employee("Marta", 30, 6000));
        employees.add(new Employee("Carlos", 40, 7000));
        employees.add(new Employee("Juan", 40, 9000));
        IO.println("+----------------------------+");
        IO.println("Lista Original:");
        employees.forEach(IO::println);
        IO.println("+----------------------------+");
        List<Employee> filtered = employees.stream()
                .filter(e -> e.getSalary() >= 6000)
                .peek(e -> e.discountSalary(10))
                .toList();
        IO.println("Lista Filtrada y Descontada:");
        filtered.forEach(IO::println);
        IO.println("+----------------------------+");
        IO.println("Lista Original Después del Descuento:");
        employees.forEach(IO::println);
        IO.println("+----------------------------+");
        IO.println("Empleado con Mayor Salario en la Lista:");
        employees.stream().max(Employee::compareBySalary).ifPresent(IO::println);
        IO.println("+----------------------------+");
        IO.println("Empleado con Menor Salario en la Lista:");
        employees.stream().min(Employee::compareBySalaryReverse).ifPresent(IO::println);
        IO.println("+----------------------------+");
    }
}