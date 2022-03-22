/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teltar;

/**
 *
 * @author Kawicher.Sebastian
 */
public class TelTar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Tarifliste tarife = new Tarifliste();
        
        tarife.ReadFromFile("t1.txt");
        
        tarife.PrintAufstellung();
        tarife.PrintAufstellung(500);
    }
    
}
