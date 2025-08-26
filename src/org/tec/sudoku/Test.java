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
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
