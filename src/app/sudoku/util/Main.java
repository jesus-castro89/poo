package app.sudoku.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    void main() {
        String fileName = "files/sudoku.txt";
        String info = "Sudoku Game";
        // Crear un objeto File para el archivo
        File archivo = new File(fileName);

        // Usar try-with-resources para asegurar el cierre del BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            // Escribir los datos en el archivo
            writer.write(info);
            System.out.println("Datos guardados en el archivo: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}
