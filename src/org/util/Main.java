package org.util;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

public class Main {

    void main() {
        LocalDate today = LocalDate.now();
        IO.println(today.toString());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        IO.println(today.format(dtf));
    }
}
