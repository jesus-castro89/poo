package app.herencia.poli;

public class Test {

    public static void main(String[] args) {

        Animal[] animals = new Animal[5];
        animals[0] = new Dog("Rex", 5);
        animals[1] = new Animal("Mittens", 3);
        animals[2] = new Caniche("Fifi", 2);
        animals[3] = new Cat("Whiskers", 4);
        animals[4] = new Parrot("Polly", 1);

        for (Animal animal : animals) {
//            if(animal instanceof Caniche) {
//                System.out.printf("El caniche %s tiene %d años.%n", animal.name, animal.age);
//                animal.makeSound();
//            }else if(animal instanceof Dog) {
//                System.out.printf("El perro %s tiene %d años.%n", animal.name, animal.age);
//                animal.makeSound();
//            } else if(animal instanceof Cat) {
//                System.out.printf("El gato %s tiene %d años.%n", animal.name, animal.age);
//                ((Cat) animal).makeSound(3);
//            } else if(animal instanceof Parrot) {
//                System.out.printf("El loro %s tiene %d años.%n", animal.name, animal.age);
//                animal.makeSound();
//            } else {
//                System.out.printf("El animal %s tiene %d años.%n", animal.name, animal.age);
//                animal.makeSound();
//            }
            switch (animal.getClass().getSimpleName()) {
                case "Caniche" -> {
                    System.out.printf("El caniche %s tiene %d años.%n", animal.name, animal.age);
                    animal.makeSound();
                }
                case "Dog" -> {
                    System.out.printf("El perro %s tiene %d años.%n", animal.name, animal.age);
                    animal.makeSound();
                }
                case "Cat" -> {
                    System.out.printf("El gato %s tiene %d años.%n", animal.name, animal.age);
                    ((Cat) animal).makeSound(3);
                }
                case "Parrot" -> {
                    System.out.printf("El loro %s tiene %d años.%n", animal.name, animal.age);
                    animal.makeSound();
                    ((Parrot) animal).makeSound("Hola");
                }
                default -> {
                    System.out.printf("El animal %s tiene %d años.%n", animal.name, animal.age);
                    animal.makeSound();
                }
            }
        }
    }
}
