package net_sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * A class containing an int array and three algorithms to sort it.
 * @author sebas
 * @version 1.8.7 b69
 * @since 04/20/1969
 */
public class Algorithms {

    private int[] array;

    Algorithms () {}

    /**
     * Generates an array with random numbers.\n One can choose, if there should be duplicates or not.
     * @param min the minimum size of any number in the array
     * @param max the maximum size of any number in the array
     * @param count the size of the array
     * @param duplicates if duplicate numbers are allowed to appear in the array
     * @return the generated int[] (it is also saved as the private array of the object)
     */
    public int[] generateRandoms(int min, int max, int count, boolean duplicates) {
        Random rand = new Random();
        array = new int[count];
        if (max - min < count && !duplicates) {
            System.out.println("Count to low for selected bounds");
            return null;
            // throw new Exception("Count to low for selected bounds");
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

    /**
     * Prints the contents of the current array into the console.
     */
    public void print() {
        System.out.print("Array:\n" + array[0]);
        for (int i = 1; i < array.length; ++i)
            System.out.print(", " + array[i]);
        System.out.println();
    }

    /**
     * Set the array manually by passing an int[].
     * @param a the passed array
     */
    public void setRandoms(int[] a) {
        array = new int[a.length];
        for (int i = 0; i < a.length; ++i)
            array[i] = a[i];
    }

    /**
     * Returns a copy of the current int[].
     * @return a copy of the current int[] in form af a int[]
     */
    public int[] getRandoms() {
        int [] a = new int[array.length];
        for (int i = 0; i < array.length; ++i)
            a[i] = array[i];
        return a;
    }

    /**
     * Sorts the array using a bubblesort algorithm.
     */
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

    /**
     * Sorts the array using a quicksort algorithm.
     */
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

    /**
     * Sorts the array using a heapsort algorithm.
     */
    public void HeapSort() {
        //lol
        for (int i = 0; i < array.length; ++i) {
            for (int j = array.length-1; j >= 0; --j)
                heapify(j, array.length-i);
            swap(0, array.length-1-i);
        }
    }

    private void heapify(int i, int length) {
        if (i * 2 + 1 > length - 1)
            return;

        if (array[i * 2 + 1] > array[i])
            swap(i * 2 + 1, i);
        heapify(i * 2 + 1, length);

        if (i * 2 + 2 > length - 1)
            return;

        if (array[i * 2 + 2] > array[i])
            swap(i * 2 + 2, i);
        heapify(i * 2 + 2, length);
    }
}
