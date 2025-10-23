package com.empresa.nomina.util;

import com.empresa.nomina.model.Department;
import com.empresa.nomina.model.Employee;

import java.util.Comparator;

public class EmployeeComparators {

    public static final Comparator<Employee> BY_SALARY =
            Comparator.comparingDouble(Employee::calculateMonthlySalary);

    public static final Comparator<Employee> BY_AGE =
            Comparator.comparingInt(Employee::getAge);

    public static final Comparator<Employee> BY_DEPARTMENT =
            Comparator.comparing(Employee::getDepartment, DepartmentComparator.BY_BONUS);

    public static final Comparator<Employee> BY_POSITION =
            Comparator.comparing(Employee::getPosition, PositionComparator.BY_RETENTION);
}
