# Los Modificadores de Acceso y No Acceso

## Modificadores de Acceso

Los modificadores de acceso son palabras clave que se utilizan para definir el alcance de las clases, métodos y
variables. En Java, hay cuatro tipos de modificadores de acceso:

| Modificador | Descripción                                                           |
|-------------|-----------------------------------------------------------------------|
| public      | Accesible desde cualquier clase.                                      |
| protected   | Accesible desde la misma clase, clases del mismo paquete y subclases. |
| default     | Accesible desde la misma clase y clases del mismo paquete.            |
| private     | Accesible solo desde la misma clase.                                  |

> Técnicamente, existe el nivel `package`, pero no es un modificador de acceso, sino el nivel por defecto.

## Modificadores de No Acceso

Los modificadores de no acceso son palabras clave que se utilizan para definir características especiales de las clases,
métodos y variables. En Java, hay cuatro tipos de modificadores de no acceso:

| Modificador  | Descripción                               |
|--------------|-------------------------------------------|
| static       | Se aplica a variables y métodos de clase. |
| final        | Se aplica a clases, métodos y variables.  |
| abstract     | Se aplica a clases y métodos.             |
| synchronized | Se aplica a métodos.                      |
| volatile     | Se aplica a variables.                    |

> Los modificadores de acceso y no acceso se pueden combinar en una misma declaración.

El caso de los modificadores de no acceso `synchonized` y `volatile` no son relevantes para el curso, por lo que no se
profundizará en ellos. Sin embargo, es importante tener en cuenta que existen.