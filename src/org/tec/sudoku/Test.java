package org.tec.sudoku;

import javax.swing.*;
import java.awt.*;

public class Test {

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
        SudokuApp.start();
    }
}
