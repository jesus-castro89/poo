package org.tec.utils;

import java.util.Random;

public class RandomManager {

    private static final Random RANDOM = new Random();

    public static int getRandom(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static double getRandom(double min, double max) {
        return RANDOM.nextDouble() * (max - min) + min;
    }

    public static void main(String[] args) {
        RandomManager rm = new RandomManager();
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomManager.getRandom(1.52, 1.680));
        }
    }
}
