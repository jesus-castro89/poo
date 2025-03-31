package herencia.abstracto.zoologico;

public abstract class Animal {

    protected String name;
    protected int age;
    protected Species species;
    protected AnimalGender gender;
    protected double weight;
    protected double height;
    protected AnimalColor color;

    public Animal(String name, int age, Species species, AnimalGender gender, double weight, double height, AnimalColor color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.color = color;
    }

    public void eat(double foodWeight) {

        if (foodWeight <= species.getMaxFood() && weight + foodWeight <= species.getMaxWeight()) {
            weight += foodWeight;
            System.out.println("El animal ha comido " + foodWeight + " kg de comida.");
        } else {
            System.out.println("El animal no puede comer más de " + species.getMaxFood() + " kg de comida.");
        }
    }

    public void grow() throws OverLifeSpanException {

        age++;
        height += 0.1;
        System.out.println("El animal ha crecido un año.");
        if (age >= species.getExpectedLifeSpan())
            throw new OverLifeSpanException("El animal ha alcanzado su esperanza de vida.");
    }

    public void sleep() {
        weight -= 1;
        System.out.println("El animal ha dormido.");
    }

    public abstract void talk();

    public void showAnimalInfo() {
        System.out.println("""
                Nombre: %s
                Edad: %d años
                Especie: %s
                Género: %s
                Peso: %.2f kg
                Altura: %.2f m
                """.formatted(name, age, species, gender, weight, height));
    }

    public String getName() {
        return name;
    }
}
