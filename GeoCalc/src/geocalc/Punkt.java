/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geocalc;

/**
 *
 * @author sebastian kawicher
 */
public class Punkt {
    private int[] coordinates;

    public Punkt(int[] k) {
        coordinates = k;
    }
    
    public void set(int d, int k) {
        if (coordinates.length >= d) {
            System.err.println("Index out of range!");
            return;
        }
        coordinates[d] = k;
    }
    
    public int getVal(int d) {
        return coordinates[d];
    }
    
    public int distance(Punkt p) {
        int c = 0;
        for (int i = 0; i < coordinates.length; ++i) {
            c += (coordinates[i] - p.coordinates[i]) * 
                    (coordinates[i] - p.coordinates[i]);
        }
        
        return (int) Math.sqrt(c);
    }
}
