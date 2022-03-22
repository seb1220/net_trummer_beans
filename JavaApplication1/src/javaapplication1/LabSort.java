/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.util.Arrays;

/**
 *
 * @author sebas
 */
public class LabSort {
    
    public static final int OK = -1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        printStatisticsString(args);
        
        int[] ints = convertToInt(args);
        for (int i=0; i < args.length; ++i) {
            System.out.println(ints[i]);
        }
        System.out.println(Arrays.toString(ints));
        /*System.out.println("Hello, World!");
        for (int i=0; i < args.length; ++i) {
            System.out.println(args[i]);
        }*/
        
        System.out.println(test(ints));
        sortBubble(ints);
        System.out.println(test(ints));
        System.out.println(Arrays.toString(ints));
        sortBubbleBetter(ints); //
        System.out.println(test(ints));
        System.out.println(Arrays.toString(ints));
    }
    
    private static void sortBubble(int[] ints) {
        for (int i=0; i < ints.length; ++i) { //(int i=ints.length-1; -1; i > 0; --i)
            for (int j=0; j < ints.length - i - 1; ++j) { //(int j=0; j < i; ++j) Viel Cooler
                if (ints[j] > ints[j+1]) {
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
    }
    
    private static void sortBubbleBetter(int[] ints) {
        int lastChangeIndex = ints.length - 2;
        for (int i=ints.length; i > 0; --i) {
            for (int j=0; j < lastChangeIndex; ++j) {
                if (ints[j] > ints[j+1]) {
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                    lastChangeIndex = j;
                }
            }
        }
    }
    
    private static int test(int[] ints) {
        for (int j=0; j < ints.length - 1; ++j) {
            if (ints[j] > ints[j+1]) {
                return j;
            }
        }
        return OK;
    }
    
    private static void printStatisticsString(String[] args) {
        for (int i=0; i < args.length; ++i) {
            System.out.println(args[i]);
        }
    }
    
    private static int[] convertToInt(String[] args) {
        int[] ints = new int[args.length];
        for (int i=0; i < args.length; ++i) {
            ints[i] = Integer.parseInt(args[i]);
        }
        return ints;
    }
    
}
