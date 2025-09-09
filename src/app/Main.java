package app;

import app.input.InputValidator;
import app.test.MiClase;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String s=JOptionPane.showInputDialog("Ingrese una cadena");
        if(s.isEmpty()){
            JOptionPane.showMessageDialog(null,"La cadena está vacía");
        }else{
            int length = s.length();
            JOptionPane.showMessageDialog(null,
                    "La cadena tiene "+length+" caracteres");
        }
    }
}
