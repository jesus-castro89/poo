package app.sudoku;

import app.sudoku.util.SudokuGenerator;
import app.sudoku.util.SudokuImporter;
import org.util.InputHandler;

public class Main {

    void main() {

        startProgram();
    }

    private static void startProgram() {
        String[] options = {"Generar Sudoku", "Importar Sudoku"};
        String choice;
        do {
            choice = InputHandler.getInput("Seleccione una opción:", options);
            switch (choice) {
                case "Generar Sudoku":
                    new SudokuGenerator();
                    break;
                case "Importar Sudoku":
                    new SudokuImporter();
                    break;
                default:
                    IO.println("Opción no válida.");
            }
        } while (!choice.equals("Generar Sudoku") && !choice.equals("Importar Sudoku"));
    }
}