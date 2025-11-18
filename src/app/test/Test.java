package app.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    void main() {
        // 1. Crear un objeto File que represente la ruta del archivo
        // NOTA: Asegúrate de que el directorio "files" exista antes
        // de ejecutar este código.
        File file = new File("files/sudokuText.txt");//<= ruta relativa
        // 2. Creamos un BufferedWriter para escribir en el archivo
        // Este recibirá un FileWriter que apunta al archivo mencionado
        // anteriormente. Es este FileWriter el que realmente crea el archivo.
        // NOTA: Si el archivo ya existe, se sobrescribirá. Pero si no existe, se creará.
        // De igual manera, si no existe el directorio o no se tienen permisos de escritura,
        // se lanzará una IOException.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Este es un archivo de prueba para el Sudoku.");
            writer.newLine();
            writer.write("Aquí se pueden escribir más líneas si es necesario.");
            System.out.println("Archivo creado y escrito exitosamente en " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al crear o escribir en el archivo: " + e.getMessage());
        }
    }
}