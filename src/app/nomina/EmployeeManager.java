package app.nomina;

import javax.swing.*;

public class EmployeeManager {
    private final int MAX_EMPLOYEES = 20;
    private final Employee[] employees = new Employee[MAX_EMPLOYEES];

    public EmployeeManager() {
        displayMenu();
    }

    static {

    }

    public void displayMenu() {
        MenuOption[] options = MenuOption.values();
        MenuOption selectedOption;
        String menu = "Seleccione una opción del menú";
        do {
            selectedOption = (MenuOption) JOptionPane.showInputDialog(
                    null, menu,
                    "Menú de opciones", JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (selectedOption != null) {
                switch (selectedOption) {
                    case ADD_EMPLOYEE -> addEmployee();
                    case UPDATE_EMPLOYEE -> editEmployee();
                    case REMOVE_EMPLOYEE -> deleteEmployee();
                    case LIST_EMPLOYEES -> listEmployees();
                    case CALCULATE_PAYROLL -> calculatePayroll();
                    case EXIT -> JOptionPane.showMessageDialog(null,
                            "¡Hasta luego!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción");
            }
        } while (selectedOption != MenuOption.EXIT);
    }

    private void addEmployee() {
        String message = "El empleado no se ha podido agregar";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee();
                message = "El empleado se ha agregado correctamente";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private void editEmployee() {

        Employee selectedEmployee;
        String message = "No hay empleados para editar";
        if (hasEmployees()) {
            selectedEmployee = (Employee) JOptionPane.showInputDialog(
                    null, "Seleccione un empleado a editar",
                    "Editar empleado", JOptionPane.QUESTION_MESSAGE,
                    null, employees, employees[0]);
            if (selectedEmployee != null) {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de editar al empleado?\n%s"
                                .formatted(selectedEmployee),
                        "Confirmar edición",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    selectedEmployee.updateDetails();
                    message = "El empleado se ha editado correctamente";
                } else {
                    message = "No se ha editado el empleado";
                }
            }
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private void listEmployees() {
        StringBuilder message = new StringBuilder("No hay empleados para mostrar");
        if (hasEmployees()) {
            message = new StringBuilder("Lista de empleados:\n");
            for (Employee employee : employees) {
                if (employee != null) {
                    message.append(employee).append("\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private boolean hasEmployees() {
        boolean hasEmployees = false;
        for (Employee employee : employees) {
            if (employee != null) {
                hasEmployees = true;
                break;
            }
        }
        return hasEmployees;
    }

    private void deleteEmployee() {
        Employee selectedEmployee;
        String message = "No hay empleados para eliminar";
        if (hasEmployees()) {
            selectedEmployee = (Employee) JOptionPane.showInputDialog(
                    null, "Seleccione un empleado a eliminar",
                    "Eliminar empleado", JOptionPane.QUESTION_MESSAGE,
                    null, employees, employees[0]);
            if (selectedEmployee != null) {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de eliminar al empleado?\n%s"
                                .formatted(selectedEmployee),
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < employees.length; i++) {
                        if (employees[i] == selectedEmployee) {
                            employees[i] = null;
                            message = "El empleado se ha eliminado correctamente";
                            break;
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, message);

    }

    private void calculatePayroll() {
        double totalPayroll = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalPayroll += employee.getSalary();
            }
        }
        JOptionPane.showMessageDialog(null,
                "El total de la nómina es: %.2f".formatted(totalPayroll));
    }
}
