package app.herencia;

public class Main {

    private Item[] items;

    public Main() {
        items = new Item[4];
        items[0] = new Item("Coca-Cola",
                "Bebida gaseosa", 1.5);
        items[1] = new Item("Pepsi",
                "Bebida gaseosa", 1.4);
        items[2] = new Item("Fanta",
                "Bebida gaseosa", 1.3);
        items[3] = new Item("Sprite",
                "Bebida gaseosa", 1.2);
    }

    public void showItems() {
        for (Item item : items) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public Item getItem(int index) {
        if (index >= 0 && index < items.length) {
            return items[index].clone();
            //return items[index];
        }
        return null;
    }

    public static void main(String[] args) {

        Main m = new Main();
        m.showItems();
        Item item = m.getItem(1);
        System.out.println("Item obtenido: \n" + item);
        item.setPrice(2.0);
        System.out.println("Item modificado: \n" + item);
        m.showItems();
    }
}
