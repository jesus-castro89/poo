# Ejemplo 3: Gestión de Empleados

## Descripción

Se requiere un sistema que permita administrar empleados en una empresa. Cada empleado tiene un nombre, un ID único, un
salario base y un tipo de puesto (Junior, Mid, Senior). Dependiendo del puesto, el empleado recibe una bonificación
distinta:

* Junior: 0% del salario base.
* Mid: 10% del salario base.
* Senior: 15% del salario base.
* Manager: 20% del salario base.

## Requisitos

* Usar un arreglo estático para almacenar empleados. El tamaño del arreglo debe ser definido por el programador.
* Implementar sobrecarga de métodos para calcular el salario en función de si el empleado obtiene o no bonificación.
* Incluir variables de tipo `final` para valores constantes.
* Usar variables static para llevar el conteo de empleados.
* Definir un tipo enumerado JobType con atributos y funciones para calcular el bono según el puesto.
* Agregar un menú de interacción con los siguientes elementos:
    * Agregar empleado.
    * Mostrar empleados.
    * Calcular salario de empleado con bonificación.
    * Calcular salario de empleado sin bonificación.
    * Salir.

