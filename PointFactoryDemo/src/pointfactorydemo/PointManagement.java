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
public class PointManagement {
    
    private Point[] points;
    public static final int SIZE = 10;
    public static final int NOT_FOUND = -1;
    
    public PointManagement() {
        this(SIZE);
    }
    
    public PointManagement(int size) {
        points = new Point[size];
    }
    
    public boolean add(Point p) {
        int freeID = getFreeID();
        
        if ((freeID != NOT_FOUND)) {        
            points[freeID] = p;
            return true;
        }
        
        return false;
    }

    public boolean add(String desc, int x, int y) {
        return add(Point.getPoint(desc, x, y));
        
    }
    
    public void print() {
        for (int i = 0; i < points.length; i++)
            if (points[i] != null)
                    System.out.println(i + " " + points[i]);
    }
    
    private int getFreeID() {
        for (int i = 0; i < points.length; i++)
            if (points[i] == null)
                    return i;
        
        return NOT_FOUND;
    }
    
    
    
}
