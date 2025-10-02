# Ejemplo 6: La Agencia de Vehículos

## Descripción

Imaginemos un sistema para administrar vehículos en un taller mecánico.

Tenemos una clase base  `Vehiculo`, con atributos generales: marca, modelo, año.

Luego tenemos diferentes tipos de vehículos:

* 🚗 Auto (con número de puertas).
* 🏍 Moto (con tipo de motor).
* 🚚 Camion (con capacidad de carga).

Definimos un multinivel: VehiculoElectrico que hereda de Vehiculo y de ahí, AutoElectrico.

Se usará polimorfismo:

* Sobrecarga en el método buscarVehiculo() (por ID o por marca).
* Sobreescritura en el método mostrarInfo().
* Agregación en la clase `Taller<T>` que administra una lista de vehículos.

Con genéricos, el taller podrá administrar distintos tipos de vehículos. Con excepciones, evitaremos registrar un
vehículo null o duplicado. Usaremos un Enum MenuOpciones para las operaciones principales. La interacción será con
JOptionPane.

## Diagrama de Clases

```plantuml
@startuml   

package app{

package "entitites"{

abstract class Vehiculo {
    # marca: String
    # modelo: String
    # matricula: String
    # año: int
    + Vehiculo()
    + {abstract}mostrarInfo(): String
}

class Auto extends Vehiculo {
    # numPuertas: int
    + Auto()
    + mostrarInfo(): String
}

class Moto extends Vehiculo {
    # tipoMotor: String
    + Moto()
    + mostrarInfo(): String
}

class Camion extends Vehiculo {
    # capacidadCarga: double
    + Camion()
    + mostrarInfo(): String
}

abstract class VehiculoElectrico extends Vehiculo {
    # capacidadBateria: double
    + VehiculoElectrico()
    + mostrarInfo(): String
    + {abstract}cargarBateria(): void
}   

class AutoElectrico extends VehiculoElectrico {
    # numPuertas: int
    + AutoElectrico()
    + mostrarInfo(): String
}

}

class Taller<T extends Vehiculo> {
    - vehiculos: T[]
    + agregarVehiculo(vehiculo: T): void
    + buscarVehiculo(id: int): T
    + buscarVehiculo(marca: String): T[]
    + mostrarVehiculos(): String
}

package "exceptions"{

class VehiculoNullException extends Exception {
    + VehiculoNullException()
}

class VehiculoDuplicadoException extends Exception {
    + VehiculoDuplicadoException()
}
}

enum MenuOpciones {
    AGREGAR_VEHICULO("Agregar Vehículo")
    BUSCAR_VEHICULO("Buscar Vehículo")
    MOSTRAR_VEHICULOS("Mostrar Vehículos")
    SALIR("Salir")
    - descripcion: String
    + MenuOpciones(descripcion: String)
    + getDescripcion(): String
}
}
@enduml
```