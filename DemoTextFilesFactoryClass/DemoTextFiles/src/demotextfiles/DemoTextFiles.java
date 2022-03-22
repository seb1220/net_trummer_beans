/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotextfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author tb
 */
public class DemoTextFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "demo.txt";
        String line;
        String[] parts;
        
        try {

            Point p;            
            
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            
            line = br.readLine();
            while (line != null) {
                parts = line.split(";");

                p = Point.getPoint(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                System.out.println(p);
                
                System.out.println();
                line = br.readLine();
            }
            
            br.close();
            
        }
        catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        
    }
    
}
