package app.herencia.poli;

public class Caniche extends Dog {

    public Caniche(String name, int age) {
        super(name, age);
    }

    public void makeSound() {
        System.out.println("Woof Woof ~ Soy un Caniche");
    }
}
