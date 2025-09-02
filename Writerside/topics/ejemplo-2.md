# Ejemplo 2: Leyendo y mostrando datos con JOptionPane

## Descripción

Se requiere un sistema que permite la gestión de empleados de una empresa. El sistema debe permitir ingresar los datos
de los empleados, como nombre, edad y salario. El sistema debe mostrar un menú con las siguientes opciones:

1. Ingresar datos de un empleado.
2. Editar datos de un empleado.
3. Eliminar un empleado.
4. Mostrar el gasto total en salarios.
5. Salir.

Toma en consideración que no debe de existir un límite en la cantidad de empleados en 20.

## Implementación

### Diagrama de Clases

```plantuml
@startuml
skinparam class{
    AttributeFontSize 18
    FontStyle bold
}
class Employee {
    - name: String
    - age: int
    - salary: double
    + Employee()
    + updateDetails(): void
    + getSalary(): double
    + toString(): String
}
class EmployeeManager {
    - employees: Employee[]
    + EmployeeManager()
    - addEmployee(): void
    - editEmployee(): void
    - deleteEmployee(): void
    - calculatePayroll(): double
    + displayMenu(): void
}
enum MenuOption {
    + ADD_EMPLOYEE("Agregar Empleado")
    + EDIT_EMPLOYEE("Editar Empleado")
    + DELETE_EMPLOYEE("Eliminar Empleado")
    + SHOW_TOTAL_SALARY("Calcular Nomina")
    + EXIT("Salir")
    - description: String
    - MenuOption(description: String)
}
EmployeeManager "1" -- "0...*" Employee : administra >
@enduml
```