# Los Streams de Datos en Java

Los Streams de Datos en Java son una parte fundamental de la API de E/S (Entrada/Salida) que permite leer y escribir
datos de manera eficiente. Un Stream es una secuencia de datos que se puede procesar de forma continua, lo que facilita
la manipulación de grandes volúmenes de información sin necesidad de cargar todo en memoria.

## Tipos de Streams

En Java, los Streams de Datos se dividen en dos categorías principales:

1. **Streams de Bytes**: Estos streams manejan datos en forma de bytes y son ideales para trabajar con archivos
   binarios, como imágenes o archivos ejecutables. Las clases principales incluyen:
    - `InputStream`: Clase base para leer bytes.
    - `OutputStream`: Clase base para escribir bytes.
    - Subclases comunes: `FileInputStream`, `FileOutputStream`, `BufferedInputStream`, `BufferedOutputStream`.
2. **Streams de Caracteres**: Estos streams manejan datos en forma de caracteres y son adecuados para trabajar con
   archivos de texto. Las clases principales incluyen:
    - `Reader`: Clase base para leer caracteres.
    - `Writer`: Clase base para escribir caracteres.
    - Subclases comunes: `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`.

Sin embargo, los Streams de Datos en Java no se limitan solo a la lectura y escritura de archivos. También se utilizan
para la comunicación entre diferentes componentes de una aplicación, como en la transmisión de datos a través de
redes o la interacción con dispositivos de entrada/salida.

Por ejemplo, para persistir objetos en un archivo, Java proporciona las siguientes clases:

- `ObjectOutputStream`: Permite escribir objetos serializables en un stream de salida.
- `ObjectInputStream`: Permite leer objetos serializables desde un stream de entrada.

## Funciones Comunes

Algunas funciones comunes que se utilizan con los Streams de Datos en Java incluyen:

| Función        | Descripción                                                             |
|----------------|-------------------------------------------------------------------------|
| `read()`       | Lee un byte o carácter del stream.                                      |
| `write(int b)` | Escribe un byte o carácter en el stream.                                |
| `flush()`      | Vacía el buffer del stream, asegurando que todos los datos se escriban. |
| `close()`      | Cierra el stream y libera los recursos asociados.                       |

Es importante mencionar que los streams deben ser cerrados después de su uso para evitar fugas de recursos. Esto se
puede lograr utilizando bloques `try-with-resources` en Java, que garantizan el cierre automático de los streams.

## El bloque `try-with-resources`

El bloque `try-with-resources` es una característica introducida en Java 7 que facilita la gestión de recursos
como los Streams de Datos. Al utilizar este bloque, los recursos se cierran automáticamente al finalizar el bloque,
incluso si ocurre una excepción. Esto ayuda a prevenir fugas de recursos y simplifica el código.

A diferencia del bloque `try-catch-finally`, donde el cierre de recursos debe manejarse explícitamente en el bloque
`finally`, el bloque `try-with-resources` se encarga de cerrar los recursos automáticamente.

Para ello se sigue la siguiente sintaxis:

![try-resources_1.png](try-resources_1.png){style="block"}

Aquí hay un ejemplo de cómo usar el bloque `try-with-resources` para leer un archivo de texto:

![try-resources-2.png](try-resources-2.png){style="block"}

En este ejemplo, el `BufferedReader` se cierra automáticamente al finalizar el bloque `try`, sin necesidad de un
bloque `finally`. Esto hace que el código sea más limpio y menos propenso a errores relacionados con la gestión de
recursos.

En resumen, los Streams de Datos en Java son herramientas poderosas para manejar la entrada y salida de datos de manera
eficiente. Al utilizar el bloque `try-with-resources`, los desarrolladores pueden gestionar estos recursos de forma
segura y sencilla.