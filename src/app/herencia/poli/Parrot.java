package app.herencia.poli;

public class Parrot extends Animal {

    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Squawk ~ Soy un loro");
    }

    public void makeSound(String word) {
        System.out.printf("Soy un loro que dice %s%n", word);
    }
}
