# Actividad 8: Modulando un sistema de torneos de videojuegos

## Descripción del problema

Imagina que estás desarrollando un sistema para gestionar torneos de videojuegos. El sistema debe permitir a los
jugadores registrarse, crear equipos, inscribirse en torneos y llevar un seguimiento de los resultados. Para ello, debes
modular el sistema en diferentes paquetes y clases, siguiendo los principios de modularidad y reutilización de código.

## Actividades

1. **Crear un paquete `jugadores`**: En este paquete, define una clase `Jugador` que represente a un jugador. La clase
   debe tener atributos como `nombre`, `edad`, `nick`, y métodos para obtener y establecer estos atributos.
2. **Crear un paquete `equipos`**: En este paquete, define una clase `Equipo` que represente a un equipo de jugadores.
   La clase debe tener atributos como `nombre`, `jugadores` (una lista de objetos `Jugador`) y métodos para agregar y
   eliminar jugadores del equipo.
3. **Crear un paquete `torneos`**: En este paquete, define una clase `Torneo` que represente a un torneo de
   videojuegos. La clase debe tener atributos como `nombre`, `equipos` (una lista de objetos `Equipo`) y métodos para
   inscribir equipos en el torneo y llevar un seguimiento de los resultados.
4. **Crear un paquete `resultados`**: En este paquete, define una clase `Resultado` que represente los resultados de un
   torneo. La clase debe tener atributos como `torneo`, `equipoGanador`, y métodos para obtener y establecer estos
   atributos.
5. **Crear una clase `Main`**: En esta clase, crea un menú de opciones que permita a los usuarios registrar jugadores,
   generar equipos, inscribir equipos en torneos y mostrar los resultados. Utiliza las clases definidas en los paquetes
   anteriores para implementar la funcionalidad del sistema.
6. **Implementar la modularidad**: Asegúrate de que cada paquete y clase tenga una única responsabilidad y que el código
   esté organizado de manera lógica. Utiliza principios de modularidad y reutilización de código para facilitar el
   mantenimiento y la escalabilidad del sistema.

## Entregables

- Código fuente del sistema modularizado en paquetes y clases.
- Pruebas de funcionalidad del sistema, mostrando cómo se pueden registrar jugadores, crear equipos, inscribir equipos
  en torneos y mostrar resultados.
- Reflexión sobre la importancia de la modularidad en el desarrollo de software y cómo se aplicaron los principios
  aprendidos en esta actividad.

> **Nota**: Es indispensable que el código se encuentre en Java y que al entregar la actividad se incluya un archivo con
> todas las clases y paquetes creados, en caso contrario la actividad se considerará incompleta y se calificará con 0
> puntos.

## Criterios de evaluación

| Criterio    | Descripción                                                   | Puntuación |
|-------------|---------------------------------------------------------------|------------|
| Portada     | Presentación y datos de identificación del equipo de trabajo. | 10%        |
| Código      | Calidad del código, modularidad y uso de buenas prácticas.    | 20%        |
| Pruebas     | Cobertura de pruebas funcionales y casos de prueba.           | 30%        |
| Modularidad | Uso de paquetes y clases.                                     | 20%        |
| Interacción | Uso de JOptionPane para la interacción con el usuario.        | 20%        |
| Total       |                                                               | **100%**   | 

> **Miembro del equipo que no aparezca en la portada no será evaluado.**
> {style="warning"}

> **Cualquier entrega posterior a la fecha límite será evaluada sobre el 70% de la puntuación total.**
> {style="warning"}

> **Cualquier duda o consulta sobre la actividad debe ser atendida en las sesiones presenciales.**
> {style="warning"}

## Fecha de entrega

La actividad debe ser entregada en un archivo comprimido (zip) que contenga el código fuente y las pruebas. La fecha
de entrega es el 9 de mayo de 2025 a las 23:59 horas.