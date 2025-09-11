package app.input;

public class DataStore<T> {

    private T[] dataList;
    private final int maxSize = 10;

    public DataStore() {
        this.dataList = (T[]) new Object[maxSize];
    }

    public void addData(T data) {

        boolean added = false;
        for (int i = 0; i < maxSize; i++) {
            if (dataList[i] == null) {
                dataList[i] = data;
                added = true;
                break;
            }
        }
        if (!added)
            System.out.println("Imposible agregar más datos, el almacenamiento está lleno.");
    }

    public void displayData() {

        for (T data : dataList) {
            if (data != null) {
                System.out.println(data);
            }
        }
    }
}
