package org.tec.utils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {

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


    public static void main(String[] args) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader("files/archivo.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                content.append(line).append("\n");
            bufferedReader.close();
            JOptionPane.showMessageDialog(null,
                    "Archivo leído: " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
