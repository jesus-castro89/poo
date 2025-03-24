package herencia;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[10];
        AnimalType type;
        int random;
        for (int i = 0; i < animals.length; i++) {
            // Obtenemos un número aleatorio entre 0 y el número de elementos del enum
            random = (int) (Math.random() * AnimalType.values().length);
            // Obtenemos el tipo de animal
            type = AnimalType.values()[random];
            // Dependiendo del tipo de animal, creamos una instancia correspondiente
            switch (type) {
                case DOG -> animals[i] = new Perro("Perro" + i, i);
                case CAT -> animals[i] = new Gato("Gato" + i, i);
                case HAMSTER -> animals[i] = new Hamster("Hamster" + i, i);
            }
        }
        for (Animal animal : animals) {
            switch (animal.getClass().getSimpleName()){

                case "Perro" -> ((Perro) animal).ladrar();
                case "Gato" -> ((Gato) animal).maullar();
                case "Hamster" -> ((Hamster) animal).correr();
            }
            animal.dormir();
        }
    }
}
