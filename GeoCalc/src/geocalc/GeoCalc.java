/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package geocalc;

/**
 *
 * @author sebastian kawicher
 */
public class GeoCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeoArray geos = new GeoArray();

        Punkt[] a = new Punkt[2];
        int[] b = new int[]{0, 0};
        a[0] = new Punkt(new int[]{0, 0});
        a[1] = new Punkt(new int[]{0, 10});
        //Punkt[] a1 = new Punkt[]{new Punkt(new int[]{0, 0}), new Punkt(new int[]{10, 10})};
        
        geos.insert(1, "Dreieck1", new Punkt[]{new Punkt(new int[]{0, 0}), new Punkt(new int[]{0, 10})});
        geos.insert(2, "Quadrat1", a);
        geos.insert(3, "Kreis1", a);
        geos.insert(4, "Pyramide1", a, 40);
        geos.insert(5, "Quader1", a, 40);
        geos.insert(6, "Zylinder1", a, 40);
        geos.insert(7, "Prsima1", a, 40);

        geos.println();
        
        geos.delete("");
    
    }
    
}
