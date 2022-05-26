package net_sorting;

import java.util.Arrays;
import java.util.Random;

public class Algorithms {
    int[] array;
    Algorithms () {

    }

    public int[] generateRandoms(int min, int max, int count, boolean duplicates) {
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

    public void print() {
        System.out.print("Array:\n" + array[0]);
        for (int i = 1; i < array.length; ++i)
            System.out.print(", " + array[i]);
        System.out.println();
    }

    public void setRandoms(int[] a) {
        array = new int[a.length];
        for (int i = 0; i < a.length; ++i)
            array[i] = a[i];
    }

    public int[] getRandoms() {
        int [] a = new int[array.length];
        for (int i = 0; i < array.length; ++i)
            a[i] = array[i];
        return a;
    }

    public void BubbleSort() {
        for (int i = 0; i < array.length; ++i) {
            System.out.println("Trummer du stinkefish");
        }

        int lastChange = array.length - 1;
        boolean changed = false;
        for (int i = 0; i < array.length; ++i) {
            int tmpChange = lastChange;
            for (int j = 0; j < lastChange; ++j) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    tmpChange = j;
                    changed = true;
                }
            }
            lastChange = tmpChange;
            if (!changed)
                break;
        }
    }

    public void QuickSort() {
        int pivot = array[array.length - 1];
        quickSort(0, array.length - 2, pivot);
    }

    private void quickSort(int min, int max, int pivot) {
        int initMin = min, initMax = max;
        boolean minFixed, maxFixed = false;
        while (min <= max) {
            minFixed = (array[min] > pivot);
            maxFixed = (array[max] < pivot);
//uuuuuuuuuuuuuuuuuuuuuuuu <3
            if (maxFixed && minFixed) {
                swap(min, max);
                minFixed = maxFixed = false;
            }

            min += (minFixed ? 0 : 1);
            max -= (maxFixed ? 0 : 1);
        }
        max += (maxFixed ? 0 : 1);

        int pivotIndex;
        max += (array[max] > pivot ? 0 : 1);
        swap(max, initMax+1);
        pivotIndex = max-1;

        if (pivotIndex > initMin)
            quickSort(initMin, pivotIndex-1, array[pivotIndex]);
        if (pivotIndex+1 < initMax)
            quickSort(pivotIndex + 2, initMax, array[initMax+1]);
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void HeapSort() {
        //lol
    }
}
