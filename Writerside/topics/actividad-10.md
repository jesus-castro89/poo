# Actividad 10: Gestionando la Nomina de Empleados

## Objetivo

El objetivo de la actividad consiste en implementar un sistema básico para gestionar la nómina de empleados en una
empresa. Este sistema debe permitir agregar, eliminar y listar empleados, así como calcular sus salarios mensuales
basados en las bonificaciones por departamento y retenciones por puestos.

Así mismo, se busca hacer uso de `ArrayList`, `Predicates`, `Comparators` y `Streams` para manejar y procesar la
información de los empleados de manera eficiente.

## Requisitos

1. **Estructura de Directorios**:
    - Crear un proyecto Java con la siguiente estructura de paquetes:
        - `com.empresa.nomina`
        - `com.empresa.nomina.model`
        - `com.empresa.nomina.service`
        - `com.empresa.nomina.util`
2. **Enums**:
    - Crear el enum `Department` con los siguientes valores:
        - `RRHH`
            - Con bonificación del 10% sobre el salario base.
        - `DESARROLLO`
            - Con bonificación del 15% sobre el salario base.
        - `VENTAS`
            - Con bonificación del 20% sobre el salario base.
        - `MARKETING`
            - Con bonificación del 12% sobre el salario base.
        - Implementar la interfaz `Comparable<Department>` para ordenar los departamentos por su bonificación de mayor a
          menor de forma natural.
        - Recuerda que debes colocar un atributo para la bonificación en el enum, así como un atributo para la
          descripción del departamento, y sus respectivos métodos `getters` y `toString()`.
    - Crear el enum `Position` con los siguientes valores:
        - `GERENTE`
            - Con bonificación del 25% sobre el salario base después de la bonificación por departamento.
            - Retención del 15% sobre el salario base.
        - `ANALISTA`
            - Con bonificación del 15% sobre el salario base después de la bonificación por departamento.
            - Retención del 10% sobre el salario base.
        - `DESARROLLADOR`
            - Con bonificación del 10% sobre el salario base después de la bonificación por departamento.
            - Retención del 8% sobre el salario base.
        - `ASISTENTE`
            - Con bonificación del 5% sobre el salario base después de la bonificación por departamento.
            - Retención del 5% sobre el salario base.
        - Implementar la interfaz `Comparable<Position>` para ordenar los puestos por su retención de menor a mayor de
          forma natural.
        - Recuerda que debes colocar un atributo para la bonificación y otro para la retención en el enum, así como un
          atributo para la descripción del puesto, y sus respectivos métodos `getters` y `toString()`.
3. **Clase Empleado**:
    - Crear la clase `Employee` en el paquete `model` con los siguientes atributos:
        - `String name`
        - `Department department`
        - `Position position`
        - `double baseSalary`
        - `int age`
    - Implementar un constructor que inicialice todos los atributos.
    - Crear un método `calculateMonthlySalary()` que calcule el salario mensual del empleado considerando las
      bonificaciones y retenciones según su departamento y puesto.
    - Crear metodos set que permitan actualizar el departamento y el puesto del empleado mediante el uso de `Predicates`
      para validar que el nuevo departamento o puesto sean diferentes a los actuales, así como de la clase
      `InputHandler` del paquete `util` que hemos creado con anterioridad para manejar la entrada del usuario.
    - Implementa la interfaz `Comparable<Employee>` para ordenar los empleados por nombre.
    - Implementar los métodos `getters`, `setters` y `toString()`.
4. **Comparators**:
    - Crear la clase `EmployeeComparators` en el paquete `util` que contenga los siguientes comparadores estáticos:
        - `BY_SALARY`: para ordenar empleados por salario mensual.
        - `BY_AGE`: para ordenar empleados por edad.
        - `BY_DEPARTMENT`: para ordenar empleados por departamento.
            - El orden debe ser según el orden definido en el enum `Department`.
        - `BY_POSITION`: para ordenar empleados por puesto.
            - El orden debe ser según el orden definido en el enum `Position`.
5. **Clase NominaService**:
    - Crear la clase `NominaService` en el paquete `service` con los siguientes atributos y métodos:
        - Atributo `ArrayList<Employee> employees` para almacenar la lista de empleados.
        - Método `addEmployee(Employee employee)` para agregar un empleado a la lista.
        - Método `removeEmployee(String name)` para eliminar un empleado por su nombre.
        - Método `listEmployees()` para listar todos los empleados con sus detalles y salario mensual.
        - Método `listEmployeesSorted(Comparator<Employee> comparator)` para listar empleados ordenados según el
          comparador proporcionado.
        - Método `calculateTotalPayroll()` para calcular el total de la nómina mensual de todos los empleados.
        - Método `findEmployeesByDepartment(Department department)` que utilice Streams para filtrar y devolver una
          lista de empleados pertenecientes a un departamento específico.
        - Método `findEmployeesByPosition(Position position)` que utilice Streams para filtrar y devolver una lista de
          empleados con un puesto específico.
        - Método `findEmployeesBySalaryRange(double minSalary, double maxSalary)` que utilice Streams para filtrar y
          devolver una lista de empleados cuyo salario mensual esté dentro de un rango específico.
        - Método `updateEmployeeDepartment(String name, Department newDepartment)` para actualizar el departamento de un
          empleado.
        - Método `updateEmployeePosition(String name, Position newPosition)` para actualizar el puesto de un empleado.
        - Método `menu()` para mostrar un menú interactivo que permita al usuario seleccionar las diferentes opciones
          del sistema.
        - Implementar la lógica necesaria para manejar las opciones del menú y llamar a los métodos correspondientes.
          Recuerda que puedes hacer uso de la clase `InputHandler` del paquete `util` para manejar la entrada del
          usuario así como la generación de un `Enum` para las opciones del menú.
6. **Clase Principal**:
    - Crear la clase `Main` en el paquete `com.empresa.nomina` con el método `main` que instancie la clase
      `NominaService` y llame al método `menu()` para iniciar la aplicación.
7. **Documentación**:
    - Asegurarse de documentar adecuadamente todas las clases, métodos y atributos utilizando comentarios Javadoc.
    - Incluir ejemplos de uso en la documentación donde sea pertinente.

## Entregables

En un solo documento PDF, incluye lo siguiente:

* Portada con los siguientes datos:
    * Nombre del curso
    * Nombre de la actividad
    * Nombre de los integrantes del equipo
* Código fuente de todas las clases implementadas y su respectiva documentación Javadoc.
* Capturas de pantalla que muestren la estructura de directorios, la ejecución del programa mostrando las diferentes
  funcionalidades implementadas (y el menú interactivo), y la salida de algunos ejemplos de uso.

> Actividades entregadas posteriores a la fecha límite serán consideradas con una calificación máxima de 70/100.
> {style="warning"}

> Integrante que no aparezca en la portada no será considerado en la evaluación de la actividad.
> {style="warning"}

## Criterios de Evaluación

| Criterio                  | Descripción                                                               | Peso     |
|---------------------------|---------------------------------------------------------------------------|----------|
| Estructura de Directorios | Correcta creación y organización de los paquetes y clases                 | 10%      |
| Enums                     | Implementación correcta de los enums con sus atributos                    | 10%      |
| Clase Empleado            | Implementación correcta de la clase Employee                              | 20%      |
| Comparators               | Implementación correcta de los comparadores                               | 10%      |
| Clase NominaService       | Implementación correcta de la clase NominaService                         | 25%      |
| Clase Principal           | Correcta implementación del punto de entrada                              | 10%      |
| Documentación             | Adecuada documentación Javadoc de todas las clases, funciones y atributos | 15%      |
| Total                     |                                                                           | **100%** |