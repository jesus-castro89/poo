package herencia.abstracto.zoologico;

public class ZooManager {

    private static final Animal[] ANIMALS = new Animal[10];

    public void growAnimals() {
        for (int i = 0; i < ANIMALS.length; i++) {
            if (ANIMALS[i] != null) {
                try {
                    ANIMALS[i].grow();
                } catch (OverLifeSpanException e) {
                    System.out.println("El animal %s ha superado su esperanza de vida".formatted(ANIMALS[i].getName()));
                    ANIMALS[i] = null;
                }
            }
        }
    }
}
