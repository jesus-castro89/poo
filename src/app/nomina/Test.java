package app.nomina;

import javax.swing.*;
import java.awt.*;

public class Test {

    static {
        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.PLAIN, 20));
        UIManager.put("OptionPane.buttonFont",
                new Font("Arial", Font.BOLD, 20));
        UIManager.put("TextField.font",
                new Font("Arial", Font.PLAIN, 20));
        UIManager.put("ComboBox.font",
                new Font("Arial", Font.BOLD, 20));

    }

    public static void main(String[] args) {
        new EmployeeManager();
    }
}
