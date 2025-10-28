package app.test;

import app.nomina.comparators.EmployeeAgeComparator;
import app.nomina.comparators.EmployeeComparators;
import app.nomina.comparators.EmployeePositionComparator;
import app.nomina.comparators.EmployeeSalaryComparator;
import app.nomina.entities.Department;
import app.nomina.entities.Employee;
import app.nomina.entities.Position;
import org.util.InputHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Test {

    void main() {
        Item[] items = new Item[5];
        items[0] = new Item("Articulo A", 10.50);
        items[1] = new Item("Articulo B", 11.50);
        items[2] = new Item("Articulo C", 12.50);
        items[3] = new Item("Articulo D", 13.50);
        items[4] = new Item("Articulo E", 14.50);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(items[3]);
        cart.addItem(items[0]);
        cart.addItem(items[1]);

        cart.showCart();

        cart.addItem(items[3]);
        cart.addItem(items[3]);

        cart.showCart();

        cart.incrementQuantity(items[3], 5);
        cart.incrementQuantity(items[4], 5);

        cart.showCart();
    }
}