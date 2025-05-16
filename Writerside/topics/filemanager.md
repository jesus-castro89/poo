# FileManager

Para efectos de nuestro Sudoku y el como librería para futuros proyectos, se ha decidido crear una clase que se encargue
de manejar la lectura y escritura de archivos. Esta clase se encargará de leer y escribir archivos en formato `.dat` y
`.txt`.

La clase `FileManager` se ve de la siguiente manera:

```java
package org.tec.utils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileManager {

    private static final String FILE_PATH = "files/";
    private static final String OBJECT_FILE_EXTENSION = ".dat";
    private static final String TEXT_FILE_EXTENSION = ".txt";

    public static void createFile(String fileName, String content, boolean append) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(FILE_PATH + fileName + TEXT_FILE_EXTENSION, append))) {
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.close();
            JOptionPane.showMessageDialog(null,
                    "Archivo creado: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader(FILE_PATH + fileName + TEXT_FILE_EXTENSION))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
            JOptionPane.showMessageDialog(null,
                    "Archivo leído: " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    public static <T> void writeObject(String fileName, T object) {
        try (FileOutputStream fos =
                     new FileOutputStream(FILE_PATH + fileName + OBJECT_FILE_EXTENSION);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            JOptionPane.showMessageDialog(null,
                    "Objeto guardado: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readObject(String fileName, Class<T> clazz) {
        T object;
        try (FileInputStream fis =
                     new FileInputStream(FILE_PATH + fileName + OBJECT_FILE_EXTENSION);
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            object = clazz.cast(ois.readObject());
            JOptionPane.showMessageDialog(null,
                    "Objeto leído");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
```

### Descripción de la clase

La clase `FileManager` se encarga de manejar la lectura y escritura de archivos. Esta clase tiene los siguientes
métodos:

* `createFile`: crea un archivo de texto con el nombre y contenido especificado. Si el archivo ya existe, se le puede
  agregar contenido al final del archivo.
* `readFile`: lee el contenido de un archivo de texto y lo devuelve como una cadena de texto.
* `writeObject`: guarda un objeto en un archivo binario. Este método utiliza la serialización para guardar el objeto en
  un archivo.
* `readObject`: lee un objeto de un archivo binario. Este método utiliza la deserialización para leer el objeto de un
  archivo.

### Ejemplo de uso

```java
import org.tec.utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        // Crear un archivo de texto
        FileManager.createFile("test", "Hola mundo", false);

        // Leer el contenido del archivo de texto
        String content = FileManager.readFile("test");
        System.out.println(content);

        // Crear un objeto y guardarlo en un archivo binario
        MyObject myObject = new MyObject("Hola mundo");
        FileManager.writeObject("myObject", myObject);

        // Leer el objeto del archivo binario
        MyObject readObject = FileManager.readObject("myObject", MyObject.class);
        System.out.println(readObject.getMessage());
    }
}

class MyObject implements Serializable {
    private String message;

    public MyObject(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
```

## Conclusión

La clase `FileManager` es una clase útil para manejar la lectura y escritura de archivos en Java. Esta clase se puede
utilizar para guardar y leer objetos de forma sencilla. Además, esta clase se puede utilizar en cualquier proyecto que
necesite manejar archivos de texto o binarios. La clase `FileManager` es una clase que se puede utilizar como una
librería para manejar archivos en Java. Esta clase se puede utilizar en cualquier proyecto que necesite manejar archivos
de texto o binarios. La clase `FileManager` es una clase que se puede utilizar como una librería para manejar archivos
en Java. Esta clase se puede utilizar en cualquier proyecto que necesite manejar archivos de texto o binarios.