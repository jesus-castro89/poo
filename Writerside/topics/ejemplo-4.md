# Ejemplo 4: Paso por valor y referencia con objetos y arrays

## Descripción

En Java, los tipos primitivos (como `int`, `char`, `boolean`, etc.) se pasan por valor, lo que significa que se crea una
copia del valor cuando se pasa a un método. Por otro lado, los objetos y arrays se pasan por referencia, lo que
significa que se pasa una referencia (o dirección) al objeto o array en lugar de una copia del mismo.

## Ejemplo de Código

![ejemplo-4.png](ejemplo-4.png){style="block"}

Al ejecutar el código anterior, la salida será:

![ejemplo-4-consola.png](ejemplo-4-consola.png){style="block"}

Como se puede observar en la salida, el valor del entero `num` no cambia después de llamar al método
`modificarPrimitivo`, lo que demuestra que los tipos primitivos se pasan por valor. Sin embargo, el valor del
atributo `valor` del objeto `obj` cambia después de llamar al método `modificarObjeto`, lo que demuestra que los
objetos se pasan por referencia. De manera similar, el contenido del array `arr` cambia después de llamar al
método `modificarArray`, lo que también demuestra que los arrays se pasan por referencia.

## Conclusión

En resumen, en Java, los tipos primitivos se pasan por valor, mientras que los objetos y arrays se pasan por
referencia. Esto es importante tenerlo en cuenta al diseñar métodos y trabajar con diferentes tipos de datos en
Java.