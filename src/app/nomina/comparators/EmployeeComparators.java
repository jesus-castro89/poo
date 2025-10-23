package app.nomina.comparators;

import app.nomina.entities.Employee;

import java.util.Comparator;

public class EmployeeComparators {

    public static Comparator<Employee> BY_SALARY = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o1.getSalary(), o2.getSalary());
        }
    };

    public static Comparator<Employee> BY_AGE = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    };
}
