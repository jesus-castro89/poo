# ¿Qué son los diagramas de clases?

Los diagramas de clases son una herramienta visual que se utiliza en el diseño de software orientado a objetos para
representar la estructura de un sistema. Un diagrama de clases muestra las clases que componen el sistema, así como las
relaciones entre ellas.

En un diagrama de clases, las clases se representan como rectángulos con tres secciones. La sección superior contiene el
nombre de la clase, la sección central contiene los atributos de la clase y la sección inferior contiene los métodos de
la clase.

Para nuestro curso, utilizaremos PlantUML para crear diagramas de clases. PlantUML es una herramienta que permite
generar diagramas UML a partir de un lenguaje de descripción simple y legible. A continuación, se muestra un ejemplo de
cómo se representa una clase en PlantUML y su correspondiente diagrama de clases:

*    ```text
        @startuml
        skinparam class{
            AttributeFontSize 18
            FontStyle bold
        }
        class Persona {
            - nombre: String
            - edad: int
            + getNombre(): String
            + setNombre(nombre: String): void
            + getEdad(): int
            + setEdad(edad: int): void
        }
        @enduml
     ```
*    ```plantuml
        @startuml
        skinparam class{
            AttributeFontSize 18
            FontStyle bold
        }
        class Persona {
            - nombre: String
            - edad: int
            + getNombre(): String
            + setNombre(nombre: String): void
            + getEdad(): int
            + setEdad(edad: int): void
        }
        @enduml
     ```

En el ejemplo anterior, se muestra la representación de una clase `Persona` en un diagrama de clases. La clase tiene dos
atributos, `nombre` y `edad`, y cuatro métodos, `getNombre`, `setNombre`, `getEdad` y `setEdad`.

Para los niveles de acceso de los atributos y métodos, se utilizan los siguientes símbolos:

* `-`: Atributo o método privado
    * ```plantuml
        @startuml
        skinparam class{
        AttributeFontSize 18
        FontStyle bold
        }
        class Clase {
            - atributo: TipoDato
            - nombreFuncion(parametro: tipoDato): tipoDato
        }
        @enduml
      ```
    * En PlantUML, se representa visualmente como un cuadro de color rojo.
* `+`: Atributo o método público
    * ```plantuml
        @startuml
        skinparam class{
        AttributeFontSize 18
        FontStyle bold
        }
        class Clase {
            + atributo: TipoDato
            + nombreFuncion(parametro: tipoDato): tipoDato
        }
        @enduml
      ```
    * En PlantUML, se representa visualmente como un circulo de color verde.
* `#`: Atributo o método protegido
    * ```plantuml
        @startuml
        skinparam class{
        AttributeFontSize 18
        FontStyle bold
        }
        class Clase {
            # atributo: TipoDato
            # nombreFuncion(parametro: tipoDato): tipoDato
        }
        @enduml
      ```
    * En PlantUML, se representa visualmente como un rombo de color amarillo.
* `~`: Atributo o método de paquete (sin especificar)
    * ```plantuml
        @startuml
        skinparam class{
        AttributeFontSize 18
        FontStyle bold
        }
        class Clase {
            ~ atributo: TipoDato
            ~ nombreFuncion(parametro: tipoDato): tipoDato
        }
        @enduml
      ```
    * En PlantUML, se representa visualmente como un triangulo de color azul.

Por su parte, las relaciones entre las clases se representan mediante líneas que conectan las clases. Algunos tipos de
relaciones comunes en un diagrama de clases son:

* Asociación: Representa una relación entre dos clases donde una clase tiene una referencia a la otra.
    * ```plantuml
        @startuml
        skinparam class{
            AttributeFontSize 18
            FontStyle bold
        }
        skinparam arrow{
            FontSize 18
        }
        class Clase1 {
            - atributo: TipoDato
        }
        class Clase2 {
            - atributo: TipoDato
        }
        Clase1 "1" --- "1" Clase2
        @enduml
      ```
    * En PlantUML, se representa visualmente como una línea sólida. La multiplicidad se indica con un número o un
      asterisco en los extremos de la línea.
    * Mientras en forma textual se representa como `Clase1 "1" --- "1" Clase2`.
* Agregación: Representa una relación de "todo a parte" entre dos clases, donde una clase contiene una colección de
  objetos de la otra clase.
    * ```plantuml
        @startuml
        skinparam class{
            AttributeFontSize 18
            FontStyle bold
        }
        skinparam arrow{
            FontSize 18
        }
        class Clase1 {
            - atributo: TipoDato
        }
        class Clase2 {
            - atributo: TipoDato
        }
        Clase1 "1" o--- "0..*" Clase2
        @enduml
      ```
    * En PlantUML, se representa visualmente como una línea con un rombo en el extremo de la clase que contiene la
      colección de objetos.
    * Mientras en forma textual se representa como `Clase1 "1" o--- "0..*" Clase2`.
* Composición: Representa una relación de "todo a parte" más fuerte que la agregación, donde una clase es responsable
  de la creación y destrucción de los objetos de la otra clase.
    * ```plantuml
        @startuml
        skinparam class{
            AttributeFontSize 18
            FontStyle bold
        }
        skinparam arrow{
            FontSize 18
        }
        class Clase1 {
            - atributo: TipoDato
        }
        class Clase2 {
            - atributo: TipoDato
        }
        Clase1 "1" *--- "0..*" Clase2
        @enduml
      ```
        * En PlantUML, se representa visualmente como una línea con un rombo relleno en el extremo de la clase que
          contiene la
          colección de objetos.
        * Mientras en forma textual se representa como `Clase1 "1" *--- "0..*" Clase2`.
* Herencia: Representa una relación de "es un" entre dos clases, donde una clase hereda los atributos y métodos de la
  otra clase.
    * ```plantuml
        @startuml
        skinparam class{
            AttributeFontSize 18
            FontStyle bold
        }
        skinparam arrow{
            FontSize 18
        }
        class Clase1 {
            - atributo: TipoDato
        }
        class Clase2 {
            - atributo: TipoDato
        }
        Clase1 <|--- Clase2
        @enduml
      ```
    * En PlantUML, se representa visualmente como una línea con una flecha punteada que apunta a la clase base.
    * Mientras en forma textual se representa como `Clase1 <|--- Clase2`.

Los diagramas de clases son una herramienta útil para visualizar la estructura de un sistema y facilitar la comunicación
entre los miembros del equipo de desarrollo. Además, permiten identificar de manera clara las clases, atributos y
métodos que forman parte del sistema, lo que facilita la implementación y mantenimiento del software.

En resumen, los diagramas de clases son una parte fundamental del diseño de software orientado a objetos y nos ayudan a
representar de manera visual la estructura de un sistema, las relaciones entre las clases y la interacción entre los
objetos.