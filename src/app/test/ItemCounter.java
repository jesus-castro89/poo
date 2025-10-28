package app.test;

public class ItemCounter {

    private Item item;
    private int count;

    public ItemCounter(Item item) {
        this.item = item;
        count = 1;
    }

    @Override
    public String toString() {
        return "%s - %d".formatted(item.getName(), count);
    }

    public void increment(int quantity) {
        count += quantity;
    }

    public void decrement(int quantity) throws Exception {
        count -= quantity;
        if(count < 0) {
            count = 0;
            throw new Exception("Eliminado del carrito");
        }
    }
}
