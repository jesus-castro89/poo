# Actividad 5: Gestor de Biblioteca

## Descripción

Imagina que estás desarrollando un sistema para una biblioteca universitaria. Queremos que el programa maneje tanto
información de cada libro en particular como información global de la biblioteca.

## Requisitos

1. Crea una clase Book con los siguientes atributos:
    * title (String)
    * author (String)
    * isbn (String)
    * available (boolean) → indica si el libro está disponible o prestado.
2. Agrega un atributo de clase (estático) llamado totalBooks que cuente cuántos libros han sido registrados en la
   biblioteca.
3. Implementa los siguientes métodos de instancia:
    * displayInfo(): Muestra la información del libro (título, autor, isbn y si está disponible).
    * borrowBook(): Marca el libro como prestado (si está disponible).
    * returnBook(): Marca el libro como disponible nuevamente.
4. Implementa los siguientes métodos de clase (estáticos):
    * getTotalBooks(): Devuelve cuántos libros se han registrado en total.
5. Crea una clase LibraryApp con un método main que permita al usuario interactuar con el sistema a través de un menú
   utilizando JOptionPane. El menú debe ofrecer las siguientes opciones:
    * Registrar un nuevo libro.
    * Mostrar información de un libro específico que deberá seleccionarse de una lista.
    * Prestar un libro. Mostrando una lista de libros disponibles.
    * Devolver un libro. Seleccionando un libro prestado.
    * Mostrar la cantidad total de libros registrados.
    * Mostrar información general de la biblioteca.
    * Salir del programa.
6. El menú debe repetirse hasta que el usuario decida salir del programa.

## Diagrama de Clases

```d2
vars: {
  d2-config: {
    layout-engine: dagre
    sketch: true
  }
}
Book:{
    shape: "class"
    + title: String
    + author: String
    + isbn: String
    + available: boolean
    - totalBooks: int
    + Book()
    + displayInfo(): void
    + borrowBook(): void
    + returnBook(): void
    + getTotalBooks(): int
}
LibraryApp:{
    shape: "class"
    + main(args: String\[\]): void
}
LibraryApp --> Book: usa
```

Toma en consideración las buenas prácticas de programación orientada a objetos, manejo de excepciones y validación de
datos. Asegúrate de que el programa sea robusto y fácil de usar.

## Instrucciones

1. Implementa todas las clases y métodos descritos en los requisitos.
2. Asegúrate de manejar todas las excepciones adecuadamente y proporcionar mensajes de error claros al usuario.
3. Utiliza `JOptionPane` para todas las interacciones con el usuario.
4. Prueba tu programa para asegurarte de que todas las funcionalidades funcionan correctamente.
5. Documenta tu código con comentarios para explicar la funcionalidad de cada clase y método.

## Entregable

En un solo documento PDF, incluye lo siguiente:

* Portada con los siguientes datos:
    * Nombre del curso
    * Nombre de la actividad
    * Nombre de los integrantes del equipo
* Código fuente de todas las clases implementadas.
* Capturas de pantalla que muestren la ejecución del programa, incluyendo el uso de todas las funcionalidades del menú.
* Breve reflexión (máximo 200 palabras) sobre los desafíos encontrados durante la implementación y cómo lo superarón.

> Actividades entregadas posteriores a la fecha límite serán consideradas con una calificación máxima de 70/100.
> {style="warning"}

> Integrante que no aparezca en la portada no será considerado en la evaluación de la actividad.
> {style="warning"}

## Criterios de Evaluación

| Criterio              | Descripción                                                           | Peso     |
|-----------------------|-----------------------------------------------------------------------|----------|     
| Portada               | Incluye todos los datos requeridos en la portada.                     | 10%      |
| Código Fuente         | Implementación correcta de las clases y métodos según los requisitos. | 40%      |
| Funcionalidad         | Todas las funcionalidades del menú funcionan correctamente.           | 30%      |
| Manejo de Excepciones | El programa maneja errores y excepciones adecuadamente.               | 10%      |
| Documentación         | Código bien documentado y reflexión incluida.                         | 10%      |
| **Total**             |                                                                       | **100%** |

> Recuerda que el uso de la clase `JOptionPane` es obligatorio para la interacción con el usuario. De lo contrario se
> considerará que no se ha cumplido con los requisitos de la actividad. Así mismo deberás manejar excepciones y validar
> entradas, de lo contrario se considerará que no se ha cumplido con los requisitos de la actividad.
> {style="warning"}     