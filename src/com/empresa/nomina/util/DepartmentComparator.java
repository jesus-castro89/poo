package com.empresa.nomina.util;

import com.empresa.nomina.model.Department;

import java.util.Comparator;

public class DepartmentComparator {

    public static Comparator<Department> BY_BONUS
            = Comparator.comparingDouble(
            Department::getBonusPercentage).reversed();
}
