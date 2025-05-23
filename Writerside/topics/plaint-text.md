# Guardando datos en archivos de texto plano

## Introducción

Los archivos de texto son una forma común de almacenar datos en un formato legible por humanos. En Java, se pueden
utilizar varias clases y métodos para trabajar con archivos de texto, como `File`, `FileOutputStream`, `FileReader`,
`FileWriter`, `FileInputStream`, `BufferedReader` y `BufferedWriter`. Estas clases permiten leer y escribir datos en
archivos de

## Guardando datos en archivos de texto

Para guardar datos en un archivo de texto en Java, podemos utilizar la clase `FileWriter` junto con `BufferedWriter`.
`FileWriter` se utiliza para escribir caracteres en un archivo, mientras que `BufferedWriter` proporciona un búfer
para mejorar el rendimiento de la escritura. A continuación, se muestra un ejemplo de cómo guardar datos en un archivo
de texto:

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class GuardarDatosEnArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "datos.txt";
        String datos = "Hola, este es un ejemplo de guardado de datos en un archivo de texto.";

        // Crear un objeto File para el archivo
        File archivo = new File(nombreArchivo);

        // Usar try-with-resources para asegurar el cierre del BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            // Escribir los datos en el archivo
            writer.write(datos);
            System.out.println("Datos guardados en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}
```

## Explicación del código

1. **Importación de clases**: Importamos las clases necesarias para trabajar con archivos y manejar excepciones.
2. **Definición de la clase y el método principal**: Creamos una clase llamada `GuardarDatosEnArchivo` y definimos el
   método `main`.
3. **Definición del nombre del archivo y los datos**: Especificamos el nombre del archivo y los datos que queremos
   guardar.
4. **Creación del objeto File**: Creamos un objeto `File` que representa el archivo donde se guardarán los datos.
5. **Uso de try-with-resources**: Utilizamos un bloque `try-with-resources` para crear un `BufferedWriter`, lo que
   garantiza que el recurso se cierre automáticamente al finalizar el bloque.
6. **Escritura de datos**: Usamos el método `write` del `BufferedWriter` para escribir los datos en el archivo.
7. **Manejo de excepciones**: Capturamos cualquier excepción `IOException` que pueda ocurrir durante el proceso de
   escritura y mostramos un mensaje de error.
8. **Cierre del BufferedWriter**: El `BufferedWriter` se cierra automáticamente al salir del bloque `try`, lo que
   asegura que los recursos se liberen correctamente.
9. **Mensaje de éxito**: Si los datos se guardan correctamente, se muestra un mensaje indicando que los datos se han
   guardado en el archivo.

## Leyendo datos de un archivo de texto

Para leer datos de un archivo de texto, podemos utilizar la clase `BufferedReader` junto con `FileReader`. A
continuación, se muestra un ejemplo de cómo leer datos de un archivo de texto:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class LeerDatosDeArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "datos.txt";

        // Crear un objeto File para el archivo
        File archivo = new File(nombreArchivo);

        // Usar try-with-resources para asegurar el cierre del BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leer cada línea del archivo
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer los datos del archivo: " + e.getMessage());
        }
    }
}
```

## Explicación del código de lectura

1. **Importación de clases**: Importamos las clases necesarias para trabajar con archivos y manejar excepciones.
2. **Definición de la clase y el método principal**: Creamos una clase llamada `LeerDatosDeArchivo` y definimos el
   método `main`.
3. **Definición del nombre del archivo**: Especificamos el nombre del archivo que queremos leer.
4. **Creación del objeto File**: Creamos un objeto `File` que representa el archivo que queremos leer.
5. **Uso de try-with-resources**: Utilizamos un bloque `try-with-resources` para crear un `BufferedReader`, lo que
   garantiza que el recurso se cierre automáticamente al finalizar el bloque.
6. **Lectura de datos**: Usamos el método `readLine` del `BufferedReader` para leer cada línea del archivo. El
   bucle continúa hasta que no hay más líneas para leer (es decir, `readLine` devuelve `null`).
7. **Manejo de excepciones**: Capturamos cualquier excepción `IOException` que pueda ocurrir durante el proceso de
   lectura y mostramos un mensaje de error.
8. **Cierre del BufferedReader**: El `BufferedReader` se cierra automáticamente al salir del bloque `try`, lo que
   asegura que los recursos se liberen correctamente.

## Conclusión del uso de archivos de texto

Guardar datos en archivos de texto es una tarea común en la programación. En Java, podemos utilizar las clases
`FileWriter` y `BufferedWriter` para facilitar este proceso. Al seguir las mejores prácticas, como el uso de
bloques `try-with-resources`, podemos asegurarnos de que los recursos se manejen de manera eficiente y evitar
filtraciones de memoria. Este enfoque es útil para almacenar datos de configuración, registros y cualquier otra
información que necesitemos guardar en un formato legible por humanos.