# Las interfaces de marcado

Las interfaces de marcado en Java son interfaces que no contienen ningún método o campo. Su propósito principal es
indicar que una clase que implementa dicha interfaz posee ciertas propiedades o comportamientos especiales. Estas
interfaces se utilizan comúnmente para proporcionar metadatos a las clases sin imponer la necesidad de implementar
métodos específicos.

## Ejemplos de Interfaces de Marcado

Algunos ejemplos comunes de interfaces de marcado en Java incluyen:

| Interface      | Descripción                                                                                                                      |
|----------------|----------------------------------------------------------------------------------------------------------------------------------|
| `Serializable` | Indica que una clase puede ser serializada, es decir, convertida en una secuencia de bytes para su almacenamiento o transmisión. |
| `Cloneable`    | Indica que una clase permite la clonación de sus objetos mediante el método `clone()`.                                           |
| `Remote`       | Indica que una clase puede ser utilizada en llamadas remotas en aplicaciones distribuidas.                                       |

## Uso de Interfaces de Marcado

El uso de interfaces de marcado es sencillo. Una clase simplemente implementa la interfaz de marcado para indicar que
posee la propiedad o comportamiento asociado. Por ejemplo, para hacer que una clase sea serializable, se implementa la
interfaz `Serializable`:

```java
import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;

    // Constructor, getters y setters
}
```

Es importante destacar que, aunque las interfaces de marcado no contienen métodos, su implementación puede tener un
impacto significativo en el comportamiento de la clase. Por ejemplo, al implementar `Serializable`, la clase `Persona`
puede ser convertida en una secuencia de bytes y almacenada o transmitida.

Además, las interfaces de marcado pueden ser utilizadas por bibliotecas y frameworks para aplicar comportamientos
específicos a las clases que las implementan. Por ejemplo, un framework de persistencia puede verificar si una clase es
`Serializable` antes de intentar guardar sus objetos en una base de datos.

## Consideraciones

Al utilizar interfaces de marcado, es importante tener en cuenta que no proporcionan ninguna funcionalidad por sí
mismas. Su propósito es meramente indicativo. Por lo tanto, es responsabilidad del desarrollador asegurarse de que la
clase cumple con las expectativas asociadas a la interfaz de marcado que implementa.

Así mismo, dentro de un arbol de herencia, una clase hija puede implementar una interfaz de marcado sin que la clase
padre la implemente, permitiendo así una mayor flexibilidad en el diseño de clases y sus comportamientos. Sin embargo,
si el objeto es referenciado por una variable del tipo de la clase padre, no se podrá acceder a la interfaz de marcado
a menos que se realice un casting adecuado o una implementación específica en la clase padre.

En otras palabras, en el caso de herencia es preferible que la clase padre implemente la interfaz de marcado si se
espera que todas las clases hijas compartan esa característica.