/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package net_sorting;

/**
 *
 * @author sebas
 */
public class Net_sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Beans riechen nicht gut");

        Algorithms algie = new Algorithms();

        algie.generateRandoms(50, 80, 10, true);
        algie.print();

        algie.BubbleSort();
        algie.print();
    }
    
}
