# El standard de documentación de Java

La documentación de Java es una parte importante del proceso de desarrollo de software en Java. La documentación de Java
es una descripción de cómo funciona un programa, qué hace y cómo se usa. La documentación de Java es fundamental porque
ayuda a los desarrolladores a entender el código y a los usuarios a entender cómo usar el programa.

La documentación de Java puede ser escrita en varios formatos, como comentarios en el código, archivos de texto o
documentos en línea. La documentación de Java puede incluir descripciones de las clases, métodos y variables del
programa, ejemplos de uso y explicaciones detalladas de cómo funciona el código.

La documentación de Java es una parte importante del proceso de desarrollo de software y puede ayudar a mejorar la
calidad y la mantenibilidad del código. Es relevante que la documentación de Java sea clara, concisa y fácil de entender
para que pueda ser útil para los desarrolladores y los usuarios.

La documentación de Java es una parte esencial de cualquier proyecto de software en Java y debe ser una prioridad para
los desarrolladores. Una buena documentación de Java puede hacer que un proyecto sea más fácil de mantener y mejorar a
lo largo del tiempo.

## ¿Cómo se hace la documentación de Java?

La documentación de Java se puede hacer mediante comentarios en el código. Los comentarios en el código son una forma
común de documentar el código en Java. Los comentarios pueden incluir descripciones de las clases, métodos y variables
del programa, ejemplos de uso y explicaciones detalladas de cómo funciona el código.

Para usar comentarios en el código de Java, se pueden utilizar los siguientes formatos:

- `//`: Comentario de una sola línea.
    - Por ejemplo:
      ```java
      // Este es un comentario de una sola línea.
      ```
    - Los comentarios de una sola línea se pueden utilizar para documentar una línea de código o para agregar
      comentarios
      breves al código. Sobre todo en lugares donde no es obvio lo que hace el código.
- `/* */`: Comentario de varias líneas.
    - Por ejemplo:
      ```java
      /*
       * Este es un comentario de varias líneas.
       */
      ```
    - Los comentarios de varias líneas se pueden utilizar para documentar bloques de código o para agregar comentarios
      más
      extensos al código.
- `/** */`: Comentario de varias líneas para documentación.
    - Por ejemplo:
      ```java
      /**
       * Este es un comentario de varias líneas para documentación.
       */
      ```
        - Los comentarios de varias líneas para documentación se utilizan para documentar clases, métodos y variables
          del programa. Estos comentarios se pueden utilizar para generar documentación en formato HTML utilizando la
          herramienta `javadoc`.

## ¿Qué es Javadoc?

Javadoc es una herramienta de documentación de Java que se utiliza para generar documentación en formato HTML a partir
de comentarios en el código fuente. Javadoc se utiliza para documentar clases, métodos y variables del programa y
generar documentación en línea para los desarrolladores y los usuarios.

Para usar Javadoc, se deben seguir las siguientes convenciones:

- Los comentarios de documentación deben comenzar con `/**` y terminar con `*/`.
- Los comentarios de documentación pueden incluir etiquetas especiales, como `@param`, `@return` y `@throws`, para
  describir los parámetros, el valor de retorno y las excepciones lanzadas por un método.
- Los comentarios de documentación pueden incluir etiquetas HTML para formatear el texto, como `<b>`, `<i>` y `<code>`.
- Los comentarios de documentación pueden incluir etiquetas de enlace, como `{@link}`, para enlazar a otras clases,
  métodos o variables.

Javadoc es una herramienta poderosa que puede ayudar a mejorar la calidad y la mantenibilidad del código en Java. Es
importante utilizar Javadoc para documentar el código de forma clara y concisa y para generar documentación en línea
para los desarrolladores y los usuarios.

## Etiquetas comunes de Javadoc

Algunas etiquetas comunes de Javadoc incluyen:

| Etiqueta      | Descripción                                                   |
|---------------|---------------------------------------------------------------|
| `@param`      | Describe un parámetro de un método.                           |
| `@return`     | Describe el valor de retorno de un método.                    |
| `@throws`     | Describe las excepciones lanzadas por un método.              |
| `@see`        | Enlaza a otra clase, método o variable.                       |
| `@since`      | Describe la versión en la que se introdujo un método o clase. |
| `@deprecated` | Marca un método o clase como obsoleto.                        |
| `@author`     | Describe el autor de un método o clase.                       |
| `@version`    | Describe la versión de un método o clase.                     |
| `@link`       | Enlaza a otra clase, método o variable.                       |
| `@code`       | Formatea el texto como código.                                |
| `@literal`    | Formatea el texto como literal.                               |
| `@inheritDoc` | Hereda la documentación de un método o clase padre.           |

## ¿Qué se debe documentar con Javadoc?

Algunas recomendaciones para documentar con Javadoc incluyen:

- **Antes de clases, atributos y métodos**: Se debe documentar la clase, los atributos y los métodos antes de su
  declaración.
- **Descripción clara y concisa**: La documentación debe ser clara y concisa para que sea fácil de entender para los
  desarrolladores y los usuarios.
- **Ejemplos de uso**: Es útil incluir ejemplos de uso en la documentación para mostrar cómo se usa la clase o el método
  en la práctica.
- **Explicación detallada**: La documentación debe explicar detalladamente cómo funciona la clase o el método y por qué
  se ha diseñado de esa manera.

> En el caso de las funciones `get` y `set`, se recomienda documentar solo en caso de que la función haga algo más que
> obtener o establecer un valor. Por ejemplo, si la función realiza alguna validación o cálculo adicional.
> {style="note"}

En resumen, Javadoc es una herramienta poderosa que puede ayudar a mejorar la calidad y la mantenibilidad del código en
Java. Es importante utilizar Javadoc para documentar el código de forma clara y concisa y para generar documentación en
línea para los desarrolladores y los usuarios.