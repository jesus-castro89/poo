package app.nomina.comparators;

import app.nomina.entities.Employee;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {

        return Integer.compare(e1.getAge(), e2.getAge());
    }
}
