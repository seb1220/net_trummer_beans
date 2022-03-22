/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package geopoints;

/**
 *
 * @author sebas der grosse
 */
public class GeoPoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*        
        Point p1 = Point.getPoint("p1", 50, 100);
        Point p2 = Point.getPoint("p2", 40, 60);
        Point p3 = Point.getPoint("p3", -40, 60);
        
        PointManagement mngt = new PointManagement(3);
        
        mngt.add(p1);
        mngt.add("p2*", 10, 20);
        mngt.print();
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
        //Fly.PrinzRobert.Donaustadtlocoboy69 = 1;
        
        System.out.println("---------------");
        
        PointManagement pm = new PointManagement();
        
        System.out.println(pm.add("P1", 10, 10));
        System.out.println(pm.add("P1", -10, 10));
        System.out.println(pm.add("P2", 20, 20));
        System.out.println(pm.add(Point.getPoint("P3", -10, 10)));
        System.out.println(pm.add(Point.getPoint("P3", 10, 10)));
        
        pm.print();
        pm.delete("P1");
        
        System.out.println(pm.add("P4", 40, 40));
        pm.print();
        
        System.out.println("---------------");
        
        // ich kann wenig
        System.out.println(Math.hypot(Math.hypot((5 - 4), (4 - 5)), (3 - 6)));
        System.out.println(Math.sqrt((5 - 4) * (5 - 4) + (4 - 5) * (4 - 5) + (3 - 6) * (3 - 6)));
        
        System.out.println("---------------");
        */
        
        PointManagement mt = new PointManagement(3);
        
        if (args.length == 3) {
            
            mt.add(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else if (args.length == 4) {
            
            mt.add(Point3D.getPoint(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
        } else
            System.out.println("pass st valid");
        
        mt.print();
    }
}
