/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointfactorydemo;

/**
 *
 * @author tb
 */
public class PointFactoryDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PointManagement pm = new PointManagement();
        pm.add(null);
        pm.add("P1", 10, 20);
        pm.add("P2", 100, 200);
        pm.add("P3", -100, 200);
        
        pm.print();
        
        
        
    }
    
}

