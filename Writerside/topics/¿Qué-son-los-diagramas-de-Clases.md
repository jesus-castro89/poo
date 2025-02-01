# ¿Qué son los diagramas de Clases?

Los diagramas de clases son una herramienta visual utilizada en el diseño de sistemas orientados a objetos para
representar la estructura y las relaciones entre las clases que componen un sistema. Estos diagramas muestran las
clases, sus atributos, métodos y las relaciones entre ellas, permitiendo visualizar de forma clara y concisa la
arquitectura de un sistema.

## Elementos de un diagrama de Clases

Los diagramas de clases constan de varios elementos que representan diferentes aspectos de las clases y sus
relaciones. Algunos de los elementos más comunes son:

- **Clase**: Representa una entidad del sistema y contiene atributos y métodos.
- **Atributo**: Representa una propiedad de la clase y describe el estado de un objeto.
- **Método**: Representa una operación que puede realizar la clase.
- **Relación**: Representa la conexión entre dos clases y puede ser de diferentes tipos, como asociación, herencia o
  dependencia.
- **Multiplicidad**: Índica cuántas instancias de una clase pueden estar relacionadas con una instancia de otra clase.

## Sintaxis

La sintaxis de un diagrama de clases puede variar dependiendo de la notación utilizada, pero generalmente sigue un
formato similar al siguiente:

```text
+---------------------+
|     NombreClase     |
+---------------------+
| - atributo1: Tipo   |
| - atributo2: Tipo   |
+---------------------+
| + método1(): Tipo   |
| + método2(): Tipo   |
+---------------------+
```

En este ejemplo, se muestra la estructura básica de una clase en un diagrama de clases. La parte superior de la clase
contiene el nombre de la clase, seguido de los atributos y métodos de la clase.

Así mismo, como podrás notar, antes de los atributos y métodos se utilizan los símbolos `+` y `-` para indicar si son
públicos o privados, respectivamente.

A continuación, se muestra una tabla con los niveles de acceso más comunes en un diagrama de clases:

| Símbolo | Nivel de Acceso | Descripción                                 |
|---------|-----------------|---------------------------------------------|
| `+`     | Público         | Accesible desde cualquier parte del sistema |
| `-`     | Privado         | Accesible solo desde la propia clase        |
| `#`     | Protegido       | Accesible desde clases hijas                |
| `~`     | Paquete         | Accesible solo desde el mismo paquete       |
