/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geopoints;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 *
 * @author sebas
 */
public class PointManagement {
    private Point[] points;
    public static final int MAX = 10;
    public static final int NOT_FOUND = -1;

    public PointManagement(int size) {
        points = new Point[size];
    }
    
    public PointManagement() {
        this(MAX);
    }
    
    public boolean add(String desc, int x, int y) {
        return add(Point.getPoint(desc, x, y));
    }
    
    public boolean add(Point p) {
        if (p == null)
            return false;
        int index = freeID();
        if (index == NOT_FOUND)
            return false;
        points[index] = p;
        return true;
    }
    
    private int freeID() {
        for (int i = 0; i < points.length; ++i) 
            if (points[i] == null)
                return i;
        return NOT_FOUND;
    }
    
    public void print() {
        for (int i = 0; i < points.length; ++i)
            if (points[i] != null)
                System.out.println(points[i]);
    }
    
    public boolean delete(String desc) {        
        for (int i = 0; i < points.length; ++i) {
            if (points[i].getDesc().equals(desc)) {
                points[i] = null;
                return true;
            }
        }
        return false;
    }
    // return fortnite ? 3 :  187;
    public Point find(String desc) {
        for (int i = 0; i < points.length; ++i)
            if (points[i].getDesc().equals(desc))
                return points[i];
        return null;
    }
    
    public void clear() {
        clear(points.length);
    }
    
    public void clear(int size) {
        points = new Point[size];
    }
}
