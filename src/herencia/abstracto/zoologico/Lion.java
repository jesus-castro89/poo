package herencia.abstracto.zoologico;

public class Lion extends Animal {

    public Lion(String name, int age, Species species, AnimalGender gender, double weight, double height, AnimalColor color) {
        super(name, age, species, gender, weight, height, color);
    }

    @Override
    public void talk() {

        System.out.println("¡El león esta rugiendo!");
    }
}
