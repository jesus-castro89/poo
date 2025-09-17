# ¿Qué es un método en el paradigma orientado a objetos?

Un método es una función que se define dentro de una clase y que se utiliza para realizar operaciones sobre los
atributos de un objeto. En el paradigma orientado a objetos, los métodos son una forma de encapsular la lógica y el
comportamiento de un objeto, permitiendo que este interactúe con otros objetos de manera controlada y coherente.

Los métodos pueden ser públicos, privados o protegidos, lo que determina su visibilidad y accesibilidad desde fuera de
la clase. Los métodos públicos son accesibles desde cualquier parte del programa, los métodos privados solo pueden ser
accedidos desde dentro de la clase en la que se definen, y los métodos protegidos pueden ser accedidos desde la clase
en la que se definen y desde las clases que heredan de ella.

En resumen, un método en el paradigma orientado a objetos es una función que se define dentro de una clase y que se
utiliza para realizar operaciones sobre los atributos de un objeto, permitiendo encapsular la lógica y el comportamiento
de dicho objeto de manera controlada y coherente.

## Métodos en Java

En Java, un método es una función que se define dentro de una clase y que se utiliza para realizar operaciones sobre
los atributos de un objeto. Los métodos en Java pueden ser públicos, privados o protegidos, lo que determina su
visibilidad y accesibilidad desde fuera de la clase.

Para definir un método en Java, se utiliza la siguiente sintaxis:

![metodos_1](metodos_1.png){style="block"}

Donde:

* `nivel_de_acceso` es la visibilidad del método (public, private, protected).
* `modificador` es un modificador opcional (static, final, abstract).
* `tipo_de_retorno` es el tipo de dato que devuelve el método (void si no devuelve nada).
* `nombre_del_metodo` es el nombre que se le da al método.
* `parametros` son los parámetros que recibe el método (pueden ser opcionales).
* `cuerpo_del_metodo` es el código que se ejecuta al llamar al método.

Por ejemplo, el siguiente código define un método llamado `saludar` que imprime un mensaje por pantalla:

![metodos_2.png](metodos_2.png)

Este método es público (puede ser accedido desde cualquier parte del programa), no devuelve ningún valor (void) y no
recibe ningún parámetro. Al llamar al método `saludar`, se imprimirá por pantalla el mensaje "¡Hola, mundo!".

En resumen, los métodos en Java son funciones que se definen dentro de una clase y que se utilizan para realizar
operaciones sobre los atributos de un objeto. Los métodos pueden ser públicos, privados o protegidos, y se definen
mediante la sintaxis `nivel_de_acceso tipo_de_retorno nombre_del_metodo(parametros) { ... }`.

### Ejemplo de métodos en Java

A continuación, se muestra un ejemplo de cómo se definen y utilizan métodos en Java:

![metodos_3.png](metodos_3.png)

En este ejemplo, se define una clase `MiClase` con dos métodos: `saludar` y `despedir`. Al crear una instancia de la
clase `MiClase` y llamar a los métodos `saludar` y `despedir`, se imprimirán por pantalla los mensajes "¡Hola, mundo!"
y "¡Hasta luego!", respectivamente.

Los métodos en Java son una forma de encapsular la lógica y el comportamiento de un objeto, permitiendo que este
interactúe con otros objetos de manera controlada y coherente.

## Conclusión

En este artículo, hemos explorado qué es un método en el paradigma orientado a objetos y cómo se definen y utilizan los
métodos en Java. Los métodos son una parte fundamental de la programación orientada a objetos, ya que permiten
encapsular la lógica y el comportamiento de un objeto de manera controlada y coherente.