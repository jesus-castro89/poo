package org.tec.utils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileManager {

    private static final String FILE_PATH = "files/";

    static {
        UIManager.put("OptionPane.messageFont",
                new Font("Consolas", Font.BOLD, 24));
        UIManager.put("OptionPane.buttonFont",
                new Font("Arial", Font.BOLD, 24));
        UIManager.put("TextField.font",
                new Font("Arial", Font.PLAIN, 24));
        UIManager.put("ComboBox.font",
                new Font("Arial", Font.BOLD, 24));
    }

    public static void createFile(String fileName, String content, boolean append) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(FILE_PATH + fileName, append))) {
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
                             new FileReader(FILE_PATH + fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                content.append(line).append("\n");
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
                     new FileOutputStream(FILE_PATH + fileName);
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
                     new FileInputStream(FILE_PATH + fileName);
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
