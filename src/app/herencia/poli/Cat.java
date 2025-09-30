package app.herencia.poli;

public class Cat extends  Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void makeSound(int times) {
        for (int i = 0; i < times; i++) {
            System.out.print("Meow ");
        }
        System.out.println();
    }
}
