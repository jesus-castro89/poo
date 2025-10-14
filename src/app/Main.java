package app;

import app.rentquick.entities.Client;
import org.util.InputHandler;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    void main() {
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client());
        clients.add(new Client());
        clients.add(new Client());

        Client selectedClient = InputHandler.getInput(
                "Seleccione un cliente:",
                clients.toArray(new Client[0])
        );
        if (selectedClient != null) {
            InputHandler.showMessage(
                    "Cliente seleccionado: %s".formatted(selectedClient),
                    "Selección", JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            InputHandler.showMessage(
                    "No se seleccionó ningún cliente.",
                    "Selección", JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
