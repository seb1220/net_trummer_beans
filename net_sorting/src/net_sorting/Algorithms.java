package net_sorting;

import java.util.Arrays;
import java.util.Random;

public class Algorithms {
    int[] array;
    Algorithms () {

    }

    int[] generateRandoms(int min, int max, int count, boolean duplicates) {
        Random rand = new Random();
        array = new int[count];
        if (max - min < count && !duplicates) {
            System.out.println("Count to low for selected bounds");
            return null;
        }
        for (int i = 0; i < array.length; ++i) {
            if (duplicates) {
                array[i] = rand.nextInt(max - min) + min;

            } else {
                boolean isDuplicate = true;
                while (isDuplicate) {
                    int rNumber = rand.nextInt(max - min) + min;
                    isDuplicate = Arrays.stream(array).anyMatch(n -> n == rNumber);

                    if (!isDuplicate)
                        array[i] = rNumber;
                }
            }
        }
        return array;
    }

    void print() {
        System.out.println("Array:");
        for (int i = 0; i < array.length; ++i)
            System.out.println(array[i]);
    }

    void setRandoms(int[] a) {
        array = new int[a.length];
        for (int i = 0; i < a.length; ++i)
            array[i] = a[i];
    }

    int[] getRandoms() {
        int [] a = new int[array.length];
        for (int i = 0; i < array.length; ++i)
            a[i] = array[i];
        return a;
    }

    void BubbleSort() {
        for (int i = 0; i < array.length; ++i) {
            System.out.println("Trummer du stinkefish");
        }
    }
}
